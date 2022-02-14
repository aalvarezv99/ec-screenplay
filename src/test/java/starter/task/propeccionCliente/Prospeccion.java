package starter.task.propeccionCliente;

import lombok.SneakyThrows;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.waits.WaitUntil;
import starter.task.commonTask.TokenDev;
import starter.ui.RegistroDeCliente.RegistroClienteForm;
import starter.ui.dashboard.DashboardForm;
import starter.ui.prospeccion.ProspeccionUI;
import starter.util.consultas.FuncionesCreditoQuery;

import java.sql.ResultSet;
import java.sql.SQLException;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class Prospeccion implements Task {

    private final String numeroDocumento;

    public Prospeccion(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public static Performable whithProspeccion(String numeroDocumento){
        return instrumented(Prospeccion.class,numeroDocumento);
    }

    @SneakyThrows
    @Override
    public <T extends Actor> void performAs(T actor) {
        FuncionesCreditoQuery query = new FuncionesCreditoQuery();
        String idCliente = "", token = "";
        ResultSet result;

        result = query.consultarIdCliente(numeroDocumento);
        while (result.next()) {
            idCliente = result.getString(1);
        }

        result = query.consultarTokenCliente(idCliente);
        while (result.next()) {
            token = result.getString(1);
        }

        System.out.println(" ********* codigo_OTP ************ "+ token);

        actor.attemptsTo(
          WaitUntil.the(ProspeccionUI.tituloProspeccion, isVisible()).forNoMoreThan(10).seconds(),
          Enter.theValue(token).into(ProspeccionUI.cajaTextoOTP)/*,
          WaitUntil.the(DashboardForm.loading, isNotVisible()).forNoMoreThan(120).seconds(),
          Click.on(ProspeccionUI.botonConfirmar),
          WaitUntil.the(ProspeccionUI.botonConfirmarDos, isVisible()).forNoMoreThan(10).seconds(),
          Click.on(ProspeccionUI.botonConfirmarDos),
          WaitUntil.the(ProspeccionUI.procesoValidacion, isVisible()).forNoMoreThan(10).seconds(),
          Click.on(ProspeccionUI.MisSimulaciones),
          WaitUntil.the(DashboardForm.loading, isNotVisible()).forNoMoreThan(120).seconds()*/
        );
    }
}
