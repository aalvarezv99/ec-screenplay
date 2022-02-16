package starter.task.referencias;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Hit;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;
import starter.ui.commons.CommonsLocators;
import starter.ui.dashboard.DashboardForm;
import starter.ui.referencias.ReferenciasForm;


import java.util.Arrays;
import java.util.List;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ReferenciasFamiliares implements Task {

    private final String pNombreRefF;
    private final String sNombreRefF;
    private final String pApellidoRefF;
    private final String sApellidoRefF;
    private final String relacionRefF;
    private final String celRefF;
    private final String deptoRefF;
    private final String ciudadRefF;

    public ReferenciasFamiliares(String pNombreRefF, String sNombreRefF, String pApellidoRefF, String sApellidoRefF, String relacionRefF, String celRefF, String deptoRefF, String ciudadRefF) {
        this.pNombreRefF = pNombreRefF;
        this.sNombreRefF = sNombreRefF;
        this.pApellidoRefF = pApellidoRefF;
        this.sApellidoRefF = sApellidoRefF;
        this.relacionRefF = relacionRefF;
        this.celRefF = celRefF;
        this.deptoRefF = deptoRefF;
        this.ciudadRefF = ciudadRefF;
    }

    public static Performable whithReferenciasFamiliares(String pNombreRefF, String sNombreRefF, String pApellidoRefF, String sApellidoRefF, String relacionRefF, String celRefF, String deptoRefF, String ciudadRefF) {
        return instrumented(ReferenciasFamiliares.class, pNombreRefF, sNombreRefF, pApellidoRefF, sApellidoRefF, relacionRefF, celRefF, deptoRefF, ciudadRefF);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                //WaitUntil.the(DashboardForm.loading, isNotVisible()).forNoMoreThan(20).seconds(),
                WaitUntil.the(ReferenciasForm.formReferenciasF.of("1"), isVisible()).forNoMoreThan(10).seconds(),
                Click.on(ReferenciasForm.formReferenciasF.of("1")),
                Scroll.to(ReferenciasForm.formReferenciasF.of("2")),
                Click.on(ReferenciasForm.formReferenciasF.of("2")),
                Scroll.to(ReferenciasForm.formReferenciasF.of("1"))
        );
        List<String> referencias = Arrays.asList("first","second");
        for(int i=0;i<2;i++){
            actor.attemptsTo(
                    Enter.theValue(pNombreRefF).into(ReferenciasForm.primerNombreRef.of(referencias.get(i))),
                    //Hit.the(Keys.CLEAR).into(ReferenciasForm.segundoNombreRef.of(referencias.get(i))),
                    //Enter.theValue(sNombreRefF).into(ReferenciasForm.segundoNombreRef.of(referencias.get(i))),
                    Enter.theValue(pApellidoRefF).into(ReferenciasForm.primerApellidoRef.of(referencias.get(i))),
                    Enter.theValue(sApellidoRefF).into(ReferenciasForm.segundoApellidoRef.of(referencias.get(i))),
                    Click.on(ReferenciasForm.relacionRefFami.of(String.valueOf(i+1))),
                    Click.on(ReferenciasForm.listaRelacionRefFam.of(String.valueOf(i+1),relacionRefF)),
                    Enter.theValue(celRefF).into(ReferenciasForm.celularRef.of(referencias.get(i))),
                    Enter.theValue(deptoRefF).into(ReferenciasForm.departamentoRef.of(referencias.get(i))),
                    WaitUntil.the(DashboardForm.loading, isNotVisible()).forNoMoreThan(20).seconds(),
                    Click.on(ReferenciasForm.optionDepartamentoRef.of(referencias.get(i))),
                    Enter.theValue(ciudadRefF).into(ReferenciasForm.ciudadRef.of(referencias.get(i))),
                    Click.on(ReferenciasForm.optionCiudadRef.of(referencias.get(i)))
            );
        }
        actor.attemptsTo(
                Click.on(CommonsLocators.botonSiguiente),
                WaitUntil.the(DashboardForm.loading, isNotVisible()).forNoMoreThan(20).seconds()
        );
        System.out.println("prueba");
    }
}
