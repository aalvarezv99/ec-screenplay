package starter.task.desembolso;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import starter.ui.dashboard.DashboardForm;
import starter.ui.desembolso.DesembolsoLocators;
import starter.ui.commons.commonsLocators;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;

public class Desembolso implements Task {

    private final String modalidadDesembolso;
    private final String tipoCliente;

    public Desembolso(String modalidadDesembolso, String tipoCliente) {
        this.modalidadDesembolso = modalidadDesembolso;
        this.tipoCliente = tipoCliente;
    }

    public static Performable withDesembolsoCredito(String modalidadDesembolso, String tipoCliente) {
        return instrumented(Desembolso.class, modalidadDesembolso, tipoCliente);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(DesembolsoLocators.modalidadDesembolso.of(modalidadDesembolso)),
                WaitUntil.the(DashboardForm.loading, isNotVisible()).forNoMoreThan(10).seconds(),
                Click.on(commonsLocators.botonSiguiente),
                // WaitUntil.the(DashboardForm.loading, isNotVisible()).forNoMoreThan(10).seconds(),
                Click.on(DesembolsoLocators.tipoCliente),
                Click.on(commonsLocators.locatorByText.of(tipoCliente)),
                Click.on(commonsLocators.botonSiguiente)
        );
        System.out.println(" punto de interrupción ");
    }
}
