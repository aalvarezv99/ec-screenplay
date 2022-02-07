package starter.task.DatosSolicitud;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import starter.ui.DatosSolicitud.DatosSolicitudForm;
import starter.ui.commons.CommonsLocators;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

public class DatosCredito implements Task {
    private final String ingresosMensuales;
    private final String totalDescuentos;
    private final String totalDescuentosLey;
    private final String lineaDeCredito;

    public DatosCredito(String ingresosMensuales, String totalDescuentos, String totalDescuentosLey, String lineaDeCredito) {
        this.ingresosMensuales = ingresosMensuales;
        this.totalDescuentos = totalDescuentos;
        this.totalDescuentosLey = totalDescuentosLey;
        this.lineaDeCredito = lineaDeCredito;
    }

    public static Performable withDatosCredito(String ingresosMensuales, String totalDescuentos, String totalDescuentosLey, String lineaDeCredito){
        return instrumented(DatosCredito.class, ingresosMensuales, totalDescuentos, totalDescuentosLey, lineaDeCredito);
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
                Click.on(CommonsLocators.locatorByText.of(lineaDeCredito)),
                //
                Click.on(CommonsLocators.botonSiguiente)
                );
        System.out.println("Fin Pagina 5/6 Datos Adicionales Credito");
    }
}
