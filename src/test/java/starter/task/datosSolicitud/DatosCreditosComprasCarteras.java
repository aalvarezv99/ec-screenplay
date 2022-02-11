package starter.task.DatosSolicitud;

import io.cucumber.datatable.DataTable;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;
import starter.ui.DatosSolicitud.DatosSolicitudForm;
import starter.ui.commons.CommonsLocators;
import starter.ui.dashboard.DashboardForm;
import starter.ui.simulador.datosFinancierosForm;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

/*
ThainerPerez 09/Feb/2022 V1.0,  1. Se crea la clase para que se trabajen las carteras y saneamientos
                                2. Esta clase recibe un mapa y lo recorre para ingresar las carteras y saneamientos
* */
public class DatosCreditosComprasCarteras implements Task {


    private final List<Map<String, String>> data;

    public DatosCreditosComprasCarteras(List<Map<String, String>> data) {
        this.data = data;
    }

    public static Performable withDatosCreditosComprasCarteras(List<Map<String, String>> data){
        return instrumented(DatosCreditosComprasCarteras.class, data);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        if(data.size()>0){
            for(int i=1; i<data.size();i++){
                actor.attemptsTo(
                        Scroll.to(DatosSolicitudForm.botonAnadirCompras),
                        Click.on(DatosSolicitudForm.botonAnadirCompras)
                );
            }
        }
        int count = 0;
        for (Map<String, String> objectTablaFeature : data) {
            System.out.println("***** Se Procede a ingresar la siguiente cartera o saneamiento ******");
            System.out.println("***** " + objectTablaFeature.get("Contador"));
            System.out.println("***** " + objectTablaFeature.get("Entidad"));
            System.out.println("***** " + objectTablaFeature.get("Monto"));
            System.out.println("***** " + objectTablaFeature.get("VlrCuota"));
            System.out.println("***** " + objectTablaFeature.get("FechaVencimiento"));
            System.out.println("***** " + objectTablaFeature.get("NumObligacion"));
            actor.attemptsTo(
                    WaitUntil.the(DashboardForm.loading, isNotVisible()).forNoMoreThan(60).seconds(),
                    Scroll.to(DatosSolicitudForm.campoEntidadCompra.of(String.valueOf(count))),
                    Enter.theValue(objectTablaFeature.get("Entidad")).into(DatosSolicitudForm.campoEntidadCompra.of(String.valueOf(count))),
                    Enter.theValue(objectTablaFeature.get("Monto")).into(DatosSolicitudForm.campoMontoCompra.of(String.valueOf(count))),
                    Enter.theValue(objectTablaFeature.get("VlrCuota")).into(DatosSolicitudForm.campoVlrCuotaCompra.of(String.valueOf(count))),
                    Enter.theValue(objectTablaFeature.get("FechaVencimiento")).into(DatosSolicitudForm.campoFechaVencimientoCompra.of(String.valueOf(count))),
                    Enter.theValue(objectTablaFeature.get("NumObligacion")).into(DatosSolicitudForm.campoNumObligacionCompra.of(String.valueOf(count)))

            );
            count++;
        }
        actor.attemptsTo(
                Click.on(CommonsLocators.botonSiguiente)
        );
    }
}
