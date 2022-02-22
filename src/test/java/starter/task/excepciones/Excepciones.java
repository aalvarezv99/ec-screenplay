package starter.task.excepciones;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.waits.WaitUntil;
import starter.task.seguroAP.BeneficiariosSeguroAP;
import starter.ui.commons.CommonsLocators;
import starter.ui.dashboard.DashboardForm;
import starter.ui.excepciones.ExcepcionesForm;
import starter.ui.seguroAP.SeguroApForm;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;

public class Excepciones implements Task {
    private final String decisionExcepcion;

    public Excepciones(String decisionExcepcion) {
        this.decisionExcepcion = decisionExcepcion;
    }

    public static Performable whithExcepciones(String decisionExcepcion) {
        return instrumented(Excepciones.class, decisionExcepcion);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Check.whether(decisionExcepcion.equals("Si"))
                        .andIfSo(
                                Click.on(ExcepcionesForm.tramitarExcepcion),
                                WaitUntil.the(DashboardForm.loading, isNotVisible()).forNoMoreThan(10).seconds()
                        ).otherwise(
                        Click.on(ExcepcionesForm.continuarSinExcepcion),
                        WaitUntil.the(DashboardForm.loading, isNotVisible()).forNoMoreThan(10).seconds()
                )
        );
    }
}
