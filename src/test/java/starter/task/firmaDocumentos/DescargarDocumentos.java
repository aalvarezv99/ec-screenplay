package starter.task.firmaDocumentos;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import starter.ui.commons.CommonsLocators;
import starter.ui.dashboard.DashboardForm;
import starter.ui.firmaDocumentos.FirmaDocumentosForm;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;

public class DescargarDocumentos implements Task {

    public static Performable withDescargarDocumentos() {
        return instrumented(DescargarDocumentos.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(DashboardForm.loading, isNotVisible()).forNoMoreThan(60).seconds(),
                Click.on(FirmaDocumentosForm.btnContinuar),
                Click.on(FirmaDocumentosForm.btnDescargaDoc),
                Click.on(CommonsLocators.botonSiguiente),
                WaitUntil.the(DashboardForm.loading, isNotVisible()).forNoMoreThan(60).seconds()
        );
        System.out.println(" punto de interrupción ");
    }
}
