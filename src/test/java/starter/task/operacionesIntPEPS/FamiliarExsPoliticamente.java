package starter.task.operacionesIntPEPS;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.questions.Visibility;
import net.serenitybdd.screenplay.waits.WaitUntil;
import starter.ui.commons.CommonsLocators;
import starter.ui.dashboard.DashboardForm;
import starter.ui.operacionesIntPEPS.OperacionesIntPEPSForm;
import starter.ui.seguroAP.SeguroApForm;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class FamiliarExsPoliticamente implements Task {
    private final String expuestoPoliticamente;
    private final List<Map<String, String>> data;


    public FamiliarExsPoliticamente(String expuestoPoliticamente,List<Map<String, String>> data) {
        this.expuestoPoliticamente = expuestoPoliticamente;
        this.data = data;

    }


    public static Performable withFamiliarExsPoliticamente(String expuestoPoliticamente,List<Map<String, String>> data){
        return instrumented(FamiliarExsPoliticamente.class,expuestoPoliticamente, data);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        int contador =0;
        actor.attemptsTo(
                Click.on(OperacionesIntPEPSForm.familiarExpuestoPoliticamente.of(expuestoPoliticamente))
        );

      //  if(expuestoPoliticamente.equals("Si")){
        for (Map<String, String> objectTablaFeature : data) {
            if(contador!=0){
                actor.attemptsTo(
                  Click.on(OperacionesIntPEPSForm.botonFamiliarExpPoliti)
                );
            }
            actor.attemptsTo(
               Enter.theValue(objectTablaFeature.get("parentesco")).into(OperacionesIntPEPSForm.familiarExpPolitiParentesco.of(String.valueOf(contador))),
               Click.on(CommonsLocators.locatorByText.of(objectTablaFeature.get("parentesco"))),
               Enter.theValue(objectTablaFeature.get("nombres")).into(OperacionesIntPEPSForm.familiarExpPolitiNombres.of(String.valueOf(contador))),
               Enter.theValue(objectTablaFeature.get("apellidos")).into(OperacionesIntPEPSForm.familiarExpPolitiApellidos.of(String.valueOf(contador)))
            );
            contador++;
        }
     //   }

       actor.attemptsTo(
                Click.on(CommonsLocators.botonSiguiente),
                WaitUntil.the(DashboardForm.loading, isNotVisible()).forNoMoreThan(20).seconds(),
                WaitUntil.the(SeguroApForm.continuar, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(SeguroApForm.continuar)
        );
    }
}
