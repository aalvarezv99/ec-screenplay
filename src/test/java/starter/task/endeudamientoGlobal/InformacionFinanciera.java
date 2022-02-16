package starter.task.endeudamientoGlobal;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import starter.ui.commons.CommonsLocators;
import starter.ui.dashboard.DashboardForm;
import starter.ui.endeudamientoGlobal.EndeudamientoGlobalForm;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;

public class InformacionFinanciera implements Task {
    private final String descLey;
    private final String descNomina;

    public InformacionFinanciera(String descLey, String descNomina) {
        this.descLey = descLey;
        this.descNomina = descNomina;
    }

    public static Performable withDatosFinancieros(String descLey, String descNomina) {
        return instrumented(InformacionFinanciera.class, descLey, descNomina);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(descLey).into(EndeudamientoGlobalForm.descPrestacionales),
                Enter.theValue(descNomina).into(EndeudamientoGlobalForm.descNomina),
                Click.on(CommonsLocators.botonSiguiente),
                WaitUntil.the(DashboardForm.loading, isNotVisible()).forNoMoreThan(10).seconds(),
                Click.on(CommonsLocators.botonSiguiente),
                WaitUntil.the(DashboardForm.loading, isNotVisible()).forNoMoreThan(120).seconds()
        );
        System.out.println(" punto de interrupción ");
    }
}
