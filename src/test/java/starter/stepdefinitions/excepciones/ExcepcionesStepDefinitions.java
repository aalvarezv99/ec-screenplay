package starter.stepdefinitions.excepciones;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import starter.task.datosSolicitud.DatosCreditosComprasCarteras;
import starter.task.excepciones.Excepciones;
import starter.task.excepciones.SelecionarExcepciones;
import starter.task.firmaDocumentos.CargaDocumentos;
import starter.ui.commons.CommonsFuntions;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ExcepcionesStepDefinitions {

    @Entonces("se selecciona si se solicita las excepciones {string}")
    public void se_selecciona_si_se_solicita_las_excepciones(String decisionExcepcion) {
        theActorInTheSpotlight().attemptsTo(
                Excepciones.whithExcepciones(decisionExcepcion)
        );
    }

    @Y("se registran las excepciones")
    public void se_registran_las_excepciones(DataTable dataTable) {

            List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
            theActorInTheSpotlight().attemptsTo(
                    SelecionarExcepciones.withDatosSelecionarExcepciones(data)
            );
        }

}
