package starter.task.firmaDocumentos;

import lombok.SneakyThrows;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import starter.ui.commons.CommonsLocators;
import starter.ui.dashboard.DashboardForm;
import starter.ui.firmaDocumentos.FirmaDocumentosForm;
import starter.util.consultas.FuncionesCreditoQuery;

import java.sql.ResultSet;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;

public class ConsultarOTP implements Task {
    private final String cedula;

    public ConsultarOTP(String cedula) {
        this.cedula = cedula;
    }

    public static Performable withConsultarOTP(String cedula) {
        return instrumented(ConsultarOTP.class, cedula);
    }

    @SneakyThrows
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(CommonsLocators.botonSiguiente),
                WaitUntil.the(DashboardForm.loading, isNotVisible()).forNoMoreThan(10).seconds()
        );
        FuncionesCreditoQuery query = new FuncionesCreditoQuery();
        String idCliente = "", token = "";
        ResultSet result;

        result = query.consultarIdCliente(cedula);
        while (result.next()) {
            idCliente = result.getString(1);
        }

        result = query.consultarTokenCliente(idCliente);
        while (result.next()) {
            token = result.getString(1);
        }
        actor.attemptsTo(
                Enter.theValue(token).into(FirmaDocumentosForm.inputOTP),
                WaitUntil.the(DashboardForm.loading, isNotVisible()).forNoMoreThan(10).seconds(),
                Click.on(FirmaDocumentosForm.btnConfirmar)
        );
        System.out.println(" punto de interrupción ");
    }
}
