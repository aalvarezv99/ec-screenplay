package starter.task.seguroAP;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Hit;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;
import starter.ui.RegistroDeCliente.RegistroClienteForm;
import starter.ui.commons.CommonsLocators;
import starter.ui.dashboard.DashboardForm;
import starter.ui.seguroAP.SeguroApForm;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class TomadorSeguroAP implements Task {
    private final String nombresTomador;
    private final String documentoTomador;
    private final String celularTomador;
    private final String correoTomador;
    private final String fechaNacimientoTomador;
    private final String departamentoTomador;
    private final String ciudadTomador;
    private final String direccionResidenciaTomador;


    public TomadorSeguroAP(String nombresTomador, String documentoTomador, String celularTomador, String correoTomador, String fechaNacimientoTomador, String departamentoTomador, String ciudadTomador, String direccionResidenciaTomador) {
        this.nombresTomador = nombresTomador;
        this.documentoTomador = documentoTomador;
        this.celularTomador = celularTomador;
        this.correoTomador = correoTomador;
        this.fechaNacimientoTomador = fechaNacimientoTomador;
        this.departamentoTomador = departamentoTomador;
        this.ciudadTomador = ciudadTomador;
        this.direccionResidenciaTomador = direccionResidenciaTomador;
    }

    public static Performable whithTomadorSeguro(String nombresTomador, String documentoTomador, String celularTomador, String correoTomador, String fechaNacimientoTomador, String departamentoTomador, String ciudadTomador, String direccionResidenciaTomador) {
        return instrumented(TomadorSeguroAP.class, nombresTomador, documentoTomador, celularTomador, correoTomador, fechaNacimientoTomador, departamentoTomador, ciudadTomador, direccionResidenciaTomador);
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(DashboardForm.loading, isNotVisible()).forNoMoreThan(20).seconds(),
                WaitUntil.the(SeguroApForm.nombresTomador, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(nombresTomador).into(SeguroApForm.nombresTomador),
                Enter.theValue(documentoTomador).into(SeguroApForm.documentoTomador),
                Enter.theValue(celularTomador).into(SeguroApForm.celularTomador),
                Enter.theValue(correoTomador).into(SeguroApForm.correoTomador),
                Enter.theValue(fechaNacimientoTomador).into(SeguroApForm.fechaNacimientoTomador),
                Enter.theValue(departamentoTomador).into(SeguroApForm.departamentoTomador),
                Click.on(CommonsLocators.locatorByText.of(departamentoTomador)),
                WaitUntil.the(DashboardForm.loading, isNotVisible()).forNoMoreThan(20).seconds(),
                Enter.theValue(ciudadTomador).into(SeguroApForm.ciudadTomador),
                Click.on(CommonsLocators.locatorByText.of(ciudadTomador)),
                Enter.theValue(direccionResidenciaTomador).into(SeguroApForm.direccionResidenciaTomador),
                Click.on(CommonsLocators.botonSiguiente)
                );
    }
}
