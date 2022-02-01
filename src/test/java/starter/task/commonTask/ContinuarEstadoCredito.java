package starter.task.commonTask;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.waits.WaitUntil;
import starter.ui.commons.CommonsLocators;
import starter.ui.dashboard.DashboardForm;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ContinuarEstadoCredito implements Task {

    private final String cedula;
    private final String estadoActual;
    private final String page;

    public ContinuarEstadoCredito(String cedula, String estadoActual, String page) {
        this.cedula = cedula;
        this.estadoActual = estadoActual;
        this.page = page;
    }

    public static Performable withContinuarEstadoCredito(String cedula, String estadoActual, String page) {
        return instrumented(ContinuarEstadoCredito.class, cedula, estadoActual, page);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        // condición para saber si redirecciona a otra pestaña
        boolean redirect = !this.page.equals("");
        // indice del credito a recoger (1 es por defecto el primero)
        String index = "1";
        actor.attemptsTo(
                Check.whether(redirect)
                        .andIfSo(
                                Click.on(CommonsLocators.locatorByText.of(page)),
                                WaitUntil.the(DashboardForm.loading, isNotVisible()).forNoMoreThan(10).seconds()
                        ),
                Check.whether(!this.estadoActual.equals(""))
                        .andIfSo(
                                WaitUntil.the(DashboardForm.selectEstados, isVisible()).forNoMoreThan(10).seconds(),
                                Click.on(DashboardForm.selectEstados),
                                Click.on(CommonsLocators.locatorByText.of(estadoActual))
                        ),

                Enter.theValue(cedula).into(DashboardForm.inputCedula),
                Click.on(DashboardForm.botonSelectCredito.of(index)),
                WaitUntil.the(DashboardForm.loading, isNotVisible()).forNoMoreThan(10).seconds()

        );
        System.out.println(" punto de interrupción");
    }
}
