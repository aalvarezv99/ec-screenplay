package starter.task.referencias;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.waits.WaitUntil;
import starter.ui.commons.CommonsLocators;
import starter.ui.dashboard.DashboardForm;
import starter.ui.referencias.referenciasForm;
import starter.ui.seguroAP.SeguroApForm;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ReferenciasPersonales implements Task {

    private final String pNombreRef;
    private final String sNombreRef;
    private final String pApellidoRef;
    private final String sApellidoRef;
    private final String relacionRef;
    private final String celRef;
    private final String deptoRef;
    private final String ciudadRef;

    public ReferenciasPersonales(String pNombreRef, String sNombreRef, String pApellidoRef, String sApellidoRef, String relacionRef, String celRef, String deptoRef, String ciudadRef) {
        this.pNombreRef = pNombreRef;
        this.sNombreRef = sNombreRef;
        this.pApellidoRef = pApellidoRef;
        this.sApellidoRef = sApellidoRef;
        this.relacionRef = relacionRef;
        this.celRef = celRef;
        this.deptoRef = deptoRef;
        this.ciudadRef = ciudadRef;
    }

    public static Performable whithReferenciasPersonales(String pNombreRef, String sNombreRef, String pApellidoRef, String sApellidoRef, String relacionRef, String celRef, String deptoRef, String ciudadRef) {
        return instrumented(ReferenciasPersonales.class, pNombreRef, sNombreRef, pApellidoRef, sApellidoRef, relacionRef, celRef, deptoRef, ciudadRef);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(DashboardForm.loading, isNotVisible()).forNoMoreThan(20).seconds(),
                WaitUntil.the(referenciasForm.formReferencias.of("1"), isVisible()).forNoMoreThan(10).seconds(),
                Click.on(referenciasForm.formReferencias.of("1")),
                Scroll.to(referenciasForm.formReferencias.of("2")),
                Click.on(referenciasForm.formReferencias.of("2")),
                Scroll.to(referenciasForm.formReferencias.of("1"))
        );
        List<String> referencias = Arrays.asList("first","second");
        for(int i=0;i<2;i++){
            actor.attemptsTo(
                    Enter.theValue(pNombreRef).into(referenciasForm.primerNombreRef.of(referencias.get(i))),
                    Enter.theValue(sNombreRef).into(referenciasForm.segundoNombreRef.of(referencias.get(i))),
                    Enter.theValue(pApellidoRef).into(referenciasForm.primerApellidoRef.of(referencias.get(i))),
                    Enter.theValue(sApellidoRef).into(referenciasForm.segundoApellidoRef.of(referencias.get(i))),
                    Click.on(referenciasForm.relacionRef.of(referencias.get(i))),
                    Click.on(CommonsLocators.locatorByText.of(relacionRef)),
                    Enter.theValue(celRef).into(referenciasForm.celularRef.of(referencias.get(i)))
                   // Enter.theValue(deptoRef).into(referenciasForm.departamentoRef.of(String.valueOf(i))),
                   // Enter.theValue(ciudadRef).into(referenciasForm.ciudadRef.of(String.valueOf(i)))
            );
            System.out.println(referencias.get(i));
        }
    }
}
