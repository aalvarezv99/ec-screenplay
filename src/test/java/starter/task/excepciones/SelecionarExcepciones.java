package starter.task.excepciones;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import starter.task.datosSolicitud.DatosCreditosComprasCarteras;
import starter.ui.commons.CommonsLocators;
import starter.ui.dashboard.DashboardForm;
import starter.ui.excepciones.ExcepcionesForm;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;

public class SelecionarExcepciones implements Task {
    private final List<Map<String, String>> data;

    public SelecionarExcepciones(List<Map<String, String>> data) {
        this.data = data;
    }

    public static Performable withDatosSelecionarExcepciones(List<Map<String, String>> data){
        return instrumented(SelecionarExcepciones.class, data);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        for (Map<String, String> objectTablaFeature : data) {
            System.out.println("***** " + objectTablaFeature.get("tipoExcepcion"));
            System.out.println("***** " + objectTablaFeature.get("detalleExcepcion"));
            actor.attemptsTo(
                    Click.on(ExcepcionesForm.tipoExcepciones.of(objectTablaFeature.get("tipoExcepcion"))),
                    Click.on(ExcepcionesForm.detalleExcepciones.of(objectTablaFeature.get("detalleExcepcion"))),
                    WaitUntil.the(DashboardForm.loading, isNotVisible()).forNoMoreThan(10).seconds()
            );
        }
        actor.attemptsTo(
                Click.on(CommonsLocators.botonSiguiente),
                WaitUntil.the(DashboardForm.loading, isNotVisible()).forNoMoreThan(10).seconds()
        );
    }
}
