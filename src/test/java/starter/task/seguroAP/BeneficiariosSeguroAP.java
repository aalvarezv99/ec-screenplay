package starter.task.seguroAP;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import starter.ui.RegistroDeCliente.RegistroClienteForm;
import starter.ui.commons.CommonsLocators;
import starter.ui.dashboard.DashboardForm;
import starter.ui.seguroAP.SeguroApForm;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class BeneficiariosSeguroAP implements Task {
    private final String nombresSeguroAP;
    private final String parentescoSeguroAP;

    public BeneficiariosSeguroAP(String nombresSeguroAP, String parentescoSeguroAP) {
        this.nombresSeguroAP = nombresSeguroAP;
        this.parentescoSeguroAP = parentescoSeguroAP;
    }

    public static Performable whithBeneficiariosSeguroAP(String nombresSeguroAP, String parentescoSeguroAP) {
        return instrumented(BeneficiariosSeguroAP.class, nombresSeguroAP, parentescoSeguroAP);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(SeguroApForm.agregarBeneficiario, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(SeguroApForm.agregarBeneficiario),
                Click.on(SeguroApForm.agregarBeneficiario)
        );
        List<String> porcentajes = Arrays.asList("35","35","30");
        for(int i=0;i<3;i++){
            actor.attemptsTo(
                Enter.theValue(nombresSeguroAP).into(SeguroApForm.nombreApellido.of(String.valueOf(i))),
                Enter.theValue(parentescoSeguroAP).into(SeguroApForm.parentesco.of(String.valueOf(i))),
                Enter.theValue(porcentajes.get(i)).into(SeguroApForm.porcentaje.of(String.valueOf(i)))
            );
        }
        actor.attemptsTo(
                Click.on(CommonsLocators.botonSiguiente),
                WaitUntil.the(DashboardForm.loading, isNotVisible()).forNoMoreThan(20).seconds(),
                WaitUntil.the(SeguroApForm.continuar, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(SeguroApForm.continuar)
        );
    }
}
