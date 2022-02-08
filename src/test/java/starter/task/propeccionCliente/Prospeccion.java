package starter.task.propeccionCliente;

import lombok.SneakyThrows;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
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
        String token_bearer = TokenDev.obtenerTokenDevelopmentExcelCredit();
        ResultSet resultado;
        String idCliente="";
        String creditoHijo="";

        FuncionesCreditoQuery query = new FuncionesCreditoQuery();
        resultado = query.consultarIdCliente(numeroDocumento);
        resultado = query.consultarCreditoHijo(idCliente);
        try {
			while (resultado.next()) {
			    idCliente = resultado.getString(1);
			}
			while (resultado.next()) {
	            creditoHijo = resultado.getString(1);
	        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

     
        String codigo_OTP = TokenDev.obtenerTokenAPI_notificacion_OPT(token_bearer,creditoHijo,idCliente,"2895");

        System.out.println(" ********* codigo_OTP ************ "+ codigo_OTP);

        actor.attemptsTo(
          WaitUntil.the(ProspeccionUI.tituloProspeccion, isVisible()).forNoMoreThan(10).seconds(),
          Enter.theValue(codigo_OTP).into(ProspeccionUI.cajaTextoOTP),
          WaitUntil.the(DashboardForm.loading, isNotVisible()).forNoMoreThan(120).seconds(),
          Click.on(ProspeccionUI.botonConfirmar),
          WaitUntil.the(ProspeccionUI.botonConfirmarDos, isVisible()).forNoMoreThan(10).seconds(),
          Click.on(ProspeccionUI.botonConfirmarDos),
          WaitUntil.the(ProspeccionUI.procesoValidacion, isVisible()).forNoMoreThan(10).seconds(),
          Click.on(ProspeccionUI.MisSimulaciones),
          WaitUntil.the(DashboardForm.loading, isNotVisible()).forNoMoreThan(120).seconds()
        );
    }
}
