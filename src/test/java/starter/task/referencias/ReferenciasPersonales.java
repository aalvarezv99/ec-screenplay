package starter.task.referencias;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.waits.WaitUntil;
import starter.ui.commons.CommonsLocators;
import starter.ui.dashboard.DashboardForm;
import starter.ui.referencias.ReferenciasForm;

import java.util.Arrays;
import java.util.List;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ReferenciasPersonales implements Task {

    private final String pNombreRefP;
    private final String sNombreRefP;
    private final String pApellidoRefP;
    private final String sApellidoRefP;
    private final String relacionRefP;
    private final String celRefP;
    private final String deptoRefP;
    private final String ciudadRefP;

    public ReferenciasPersonales(String pNombreRefP, String sNombreRefP, String pApellidoRefP, String sApellidoRefP, String relacionRefP, String celRefP, String deptoRefP, String ciudadRefP) {
        this.pNombreRefP = pNombreRefP;
        this.sNombreRefP = sNombreRefP;
        this.pApellidoRefP = pApellidoRefP;
        this.sApellidoRefP = sApellidoRefP;
        this.relacionRefP = relacionRefP;
        this.celRefP = celRefP;
        this.deptoRefP = deptoRefP;
        this.ciudadRefP = ciudadRefP;
    }

    public static Performable whithReferenciasPersonales(String pNombreRefP, String sNombreRefP, String pApellidoRefP, String sApellidoRefP, String relacionRefP, String celRefP, String deptoRefP, String ciudadRefP) {
        return instrumented(ReferenciasPersonales.class, pNombreRefP, sNombreRefP, pApellidoRefP, sApellidoRefP, relacionRefP, celRefP, deptoRefP, ciudadRefP);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(DashboardForm.loading, isNotVisible()).forNoMoreThan(20).seconds(),
                WaitUntil.the(ReferenciasForm.formReferenciasP.of("1"), isVisible()).forNoMoreThan(10).seconds(),
                Click.on(ReferenciasForm.formReferenciasP.of("1")),
                Scroll.to(ReferenciasForm.formReferenciasP.of("2")),
                Click.on(ReferenciasForm.formReferenciasP.of("2")),
                Scroll.to(ReferenciasForm.formReferenciasP.of("1"))
        );
        List<String> referencias = Arrays.asList("first","second");
        for(int i=0;i<2;i++){
            actor.attemptsTo(
                    Enter.theValue(pNombreRefP).into(ReferenciasForm.primerNombreRef.of(referencias.get(i))),
                    Enter.theValue(sNombreRefP).into(ReferenciasForm.segundoNombreRef.of(referencias.get(i))),
                    Enter.theValue(pApellidoRefP).into(ReferenciasForm.primerApellidoRef.of(referencias.get(i))),
                    Enter.theValue(sApellidoRefP).into(ReferenciasForm.segundoApellidoRef.of(referencias.get(i))),
                    Click.on(ReferenciasForm.relacionRef.of(referencias.get(i))),
                    Click.on(ReferenciasForm.listaRelacionRef.of(referencias.get(i),relacionRefP)),
                    Enter.theValue(celRefP).into(ReferenciasForm.celularRef.of(referencias.get(i))),
                    Enter.theValue(deptoRefP).into(ReferenciasForm.departamentoRef.of(referencias.get(i))),
                    WaitUntil.the(DashboardForm.loading, isNotVisible()).forNoMoreThan(20).seconds(),
                    Click.on(ReferenciasForm.optionDepartamentoRef.of(referencias.get(i))),
                    Enter.theValue(ciudadRefP).into(ReferenciasForm.ciudadRef.of(referencias.get(i))),
                    Click.on(ReferenciasForm.optionCiudadRef.of(referencias.get(i)))
            );
        }
        actor.attemptsTo(
                Click.on(CommonsLocators.botonSiguiente),
                WaitUntil.the(DashboardForm.loading, isNotVisible()).forNoMoreThan(20).seconds()
        );
    }
}
