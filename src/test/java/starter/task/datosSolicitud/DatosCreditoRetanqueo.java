package starter.task.datosSolicitud;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.waits.WaitUntil;
import starter.ui.datosSolicitud.DatosSolicitudForm;
import starter.ui.commons.CommonsFuntions;
import starter.ui.commons.CommonsLocators;
import starter.ui.dashboard.DashboardForm;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class DatosCreditoRetanqueo implements Task {
    private final String ingresosMensuales;
    private final String totalDescuentos;
    private final String totalDescuentosLey;
    private final String lineaDeCredito;
    private final String creditoPadre;

    public DatosCreditoRetanqueo(String ingresosMensuales, String totalDescuentos, String totalDescuentosLey, String lineaDeCredito, String creditoPadre) {
        this.ingresosMensuales = ingresosMensuales;
        this.totalDescuentos = totalDescuentos;
        this.totalDescuentosLey = totalDescuentosLey;
        this.lineaDeCredito = lineaDeCredito;
        this.creditoPadre = creditoPadre;
    }

    public static Performable withDatosCreditoRetanqueo(String ingresosMensuales, String totalDescuentos, String totalDescuentosLey, String lineaDeCredito, String creditoPadre) {
        return instrumented(DatosCreditoRetanqueo.class, ingresosMensuales, totalDescuentos, totalDescuentosLey, lineaDeCredito, creditoPadre);
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(DatosSolicitudForm.pageDatosAdicionales.of("5"), isPresent()).forNoMoreThan(10).seconds(),
                Enter.theValue(ingresosMensuales).into(DatosSolicitudForm.ingresosMensuales),
                Enter.theValue(totalDescuentos).into(DatosSolicitudForm.totalDescuentos),
                Enter.theValue(totalDescuentosLey).into(DatosSolicitudForm.totalDescuentosLey),
                //
                Click.on(DatosSolicitudForm.lineaDeCredito),
                WaitUntil.the(DashboardForm.loading, isNotVisible()).forNoMoreThan(60).seconds(),
                Click.on(CommonsLocators.locatorByText.of(lineaDeCredito)),
                WaitUntil.the(DashboardForm.loading, isNotVisible()).forNoMoreThan(60).seconds()

        );
        // Se crea la accion para que valide la linea de credito libre inversion para retanqueo
        actor.attemptsTo(
                Check.whether(lineaDeCredito.contains("Retanqueo"))
                        .andIfSo(
                                WaitUntil.the(DatosSolicitudForm.creditosActivosChekBox.of(creditoPadre), isVisible()).forNoMoreThan(20).seconds(),
                                Scroll.to(DatosSolicitudForm.creditosActivosChekBox.of(creditoPadre)),
                                Click.on(DatosSolicitudForm.creditosActivosChekBox.of(creditoPadre))
                        )
        );

        if(CommonsFuntions.limpiarCadena(lineaDeCredito).equals("Retanqueo libre inversion")
                || CommonsFuntions.limpiarCadena(lineaDeCredito).equals("Libre inversion")){
            actor.attemptsTo(
                    Click.on(CommonsLocators.botonSiguiente)
            );
        }
        System.out.println("Fin Pagina 5/6 Datos Adicionales Credito");
    }
}
