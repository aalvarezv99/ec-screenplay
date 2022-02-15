package starter.task.seguroAP;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.waits.WaitUntil;
import starter.ui.commons.CommonsLocators;
import starter.ui.dashboard.DashboardForm;
import starter.ui.seguroAP.SeguroApForm;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;

public class VinculoClienteSeguroAP implements Task {

    private final String vinculo;
    private final String plan;
    private final String tomarSeguroAP;

    public VinculoClienteSeguroAP(String vinculo, String plan, String tomarSeguroAP) {
        this.vinculo = vinculo;
        this.plan = plan;
        this.tomarSeguroAP = tomarSeguroAP;
    }

    public static Performable whithVinculoClienteSeguroAP(String vinculo, String plan,String tomarSeguroAP) {
        return instrumented(VinculoClienteSeguroAP.class, vinculo, plan,tomarSeguroAP);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Check.whether(tomarSeguroAP.equals("No"))
                        .andIfSo(
                                Click.on(SeguroApForm.noTomarSeguro),
                                WaitUntil.the(DashboardForm.loading, isNotVisible()).forNoMoreThan(10).seconds()
                        ),
                Check.whether(vinculo.equals("Vinculado"))
                        .andIfSo(
                                Click.on(SeguroApForm.tomadorCreditoVinculado)
                        )
                        .otherwise(
                                Click.on(SeguroApForm.tomadorCreditoNoVinculado)
                        ),
                Click.on(SeguroApForm.tomarSeguroAP),
                Check.whether(plan.equals("Plan 1"))
                        .andIfSo(
                                Click.on(SeguroApForm.planUno)
                        )
                        .otherwise(
                                Click.on(SeguroApForm.planDos)
                        ),
                Click.on(CommonsLocators.botonSiguiente),
                WaitUntil.the(DashboardForm.loading, isNotVisible()).forNoMoreThan(10).seconds()
        );
    }
}
