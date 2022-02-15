package starter.task.datosSolicitud;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;
import starter.ui.commons.CommonsLocators;
import starter.ui.dashboard.DashboardForm;
import starter.ui.datosSolicitud.DatosSolicitudForm;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class DatosSolicitudP2 implements Task {
    private final String departamentoResidencia;
    private final String ciudadResidencia;
    private final String direccionResidencia;
    private final String mesesResidencia;
    private final String numeroHijos;
    private final String personasACargo;
    private final String departamentoCorrespondencia;
    private final String ciudadCorrespondencia;

    public DatosSolicitudP2(String departamentoResidencia, String ciudadResidencia, String direccionResidencia, String mesesResidencia, String numeroHijos, String personasACargo, String departamentoCorrespondencia, String ciudadCorrespondencia) {
        this.departamentoResidencia = departamentoResidencia;
        this.ciudadResidencia = ciudadResidencia;
        this.direccionResidencia = direccionResidencia;
        this.mesesResidencia = mesesResidencia;
        this.numeroHijos = numeroHijos;
        this.personasACargo = personasACargo;
        this.departamentoCorrespondencia = departamentoCorrespondencia;
        this.ciudadCorrespondencia = ciudadCorrespondencia;
    }

    public static Performable withDatosSolicitudP2(String departamentoResidencia, String ciudadResidencia, String direccionResidencia, String mesesResidencia, String numeroHijos, String personasACargo, String departamentoCorrespondencia, String ciudadCorrespondencia) {
        return instrumented(DatosSolicitudP2.class, departamentoResidencia, ciudadResidencia, direccionResidencia, mesesResidencia, numeroHijos, personasACargo, departamentoCorrespondencia, ciudadCorrespondencia);
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(DashboardForm.loading, isNotVisible()).forNoMoreThan(10).seconds(),
                WaitUntil.the(DatosSolicitudForm.pageDatosAdicionales.of("2"), isPresent()).forNoMoreThan(10).seconds(),
                //
                WaitUntil.the(DatosSolicitudForm.departamentoCorrespondencia, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(DatosSolicitudForm.departamentoCorrespondencia),
                Click.on(CommonsLocators.locatorByText.of(departamentoCorrespondencia)),
                //
                WaitUntil.the(DatosSolicitudForm.ciudadCorrespondencia, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(DatosSolicitudForm.ciudadCorrespondencia),
                Click.on(CommonsLocators.locatorByText.of(ciudadCorrespondencia)),
                //
                WaitUntil.the(DatosSolicitudForm.ciudadResidencia, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(DatosSolicitudForm.departamentoResidencia),
                Click.on(CommonsLocators.locatorByText.of(departamentoResidencia)),
                //
                WaitUntil.the(DatosSolicitudForm.ciudadResidencia, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(DatosSolicitudForm.ciudadResidencia),
                Click.on(CommonsLocators.locatorByText.of(ciudadResidencia)),
                //
                Enter.theValue(direccionResidencia).into(DatosSolicitudForm.direccionResidencia),
                Enter.theValue(ciudadResidencia).into(DatosSolicitudForm.barrio),
                Enter.theValue(mesesResidencia).into(DatosSolicitudForm.mesesResidencia),
                Enter.theValue(numeroHijos).into(DatosSolicitudForm.numeroHijos),
                Enter.theValue(personasACargo).into(DatosSolicitudForm.personasACargo),
                Scroll.to(CommonsLocators.botonSiguiente),
                Click.on(CommonsLocators.botonSiguiente)
        );
        System.out.println("Fin Pagina 2/6 Datos Adicionales Cliente");
    }
}
