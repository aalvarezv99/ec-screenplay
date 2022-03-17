package starter.task.firmaDocumentos;

import lombok.SneakyThrows;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.ScrollToWebElement;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.waits.WaitUntil;
import starter.ui.RegistroDeCliente.RegistroClienteForm;
import starter.ui.commons.CommonsLocators;
import starter.ui.dashboard.DashboardForm;
import starter.ui.firmaDocumentos.FirmaDocumentosForm;
import starter.util.consultas.FuncionesCreditoQuery;

import java.sql.ResultSet;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

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
                WaitUntil.the(DashboardForm.loading, isNotVisible()).forNoMoreThan(60).seconds(),
                //inicio codigo temporal para el tema de ADO
                WaitUntil.the(FirmaDocumentosForm.btnClose, isVisible()).forNoMoreThan(20).seconds(),
                Click.on(FirmaDocumentosForm.btnClose),
                WaitUntil.the(FirmaDocumentosForm.inputCodigoADO, isVisible()).forNoMoreThan(20).seconds(),
                Click.on(FirmaDocumentosForm.origenValidacionIdentidad.of("Who is Who")),
                Enter.keyValues("123456").into(FirmaDocumentosForm.inputCodigoADO),
                Scroll.to(CommonsLocators.botonSiguiente),
                Click.on(CommonsLocators.botonSiguiente),
                Click.on(FirmaDocumentosForm.btnContinuar),
                //fin codigo temporal para el tema de ADO
                WaitUntil.the(DashboardForm.loading, isNotVisible()).forNoMoreThan(60).seconds()
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
                WaitUntil.the(FirmaDocumentosForm.inputOTP, isVisible()).forNoMoreThan(20).seconds(),
                Enter.keyValues(token).into(FirmaDocumentosForm.inputOTP),
                WaitUntil.the(DashboardForm.loading, isNotVisible()).forNoMoreThan(120).seconds(),
                Click.on(FirmaDocumentosForm.btnConfirmar),
                WaitUntil.the(DashboardForm.loading, isNotVisible()).forNoMoreThan(60).seconds()
        );
        System.out.println(" punto de interrupción ");
    }
}
