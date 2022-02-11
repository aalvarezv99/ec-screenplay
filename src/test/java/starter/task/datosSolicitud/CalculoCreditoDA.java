package starter.task.datosSolicitud;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import starter.ui.datosSolicitud.DatosSolicitudForm;
import starter.ui.commons.CommonsLocators;
import starter.ui.dashboard.DashboardForm;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class CalculoCreditoDA implements Task {
    private final String montoSolicitado;
    private final String tasa;
    private final String plazo;
    private final String diasInteresesIniciales;

    public CalculoCreditoDA(String montoSolicitado, String tasa, String plazo, String diasInteresesIniciales) {
        this.montoSolicitado = montoSolicitado;
        this.tasa = tasa;
        this.plazo = plazo;
        this.diasInteresesIniciales = diasInteresesIniciales;
    }

    public static Performable withCalculoCreditoDA(String montoSolicitado, String tasa, String plazo, String diasInteresesIniciales){
        return instrumented(CalculoCreditoDA.class, montoSolicitado, tasa, plazo, diasInteresesIniciales);
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        String tasaFront = tasa + " %";
        actor.attemptsTo(
                WaitUntil.the(DatosSolicitudForm.pageDatosAdicionales.of("6"), isPresent()).forNoMoreThan(10).seconds(),
                Enter.theValue(montoSolicitado).into(DatosSolicitudForm.montoSolicitado),
                Enter.theValue(plazo).into(DatosSolicitudForm.plazoFront),
                Enter.theValue(diasInteresesIniciales).into(DatosSolicitudForm.diasInteresesIniciales),
                Click.on(DatosSolicitudForm.tasaFront),
                Click.on(CommonsLocators.locatorByText.of(tasaFront)),
                Click.on(DatosSolicitudForm.botonCalcular),
                WaitUntil.the(DashboardForm.loading, isNotVisible()).forNoMoreThan(20).seconds(),
                WaitUntil.the(DatosSolicitudForm.montoSolicitar, isVisible()).forNoMoreThan(20).seconds()
                );
        System.out.println("Fin Pagina 6/6 Datos Calculo Credito");
    }
}
