package starter.stepdefinitions.EndeudamientoGlobal;

import io.cucumber.java.an.Y;
import io.cucumber.java.es.Entonces;
import starter.task.endeudamientoGlobal.InformacionBasica;
import starter.task.endeudamientoGlobal.InformacionCentrales;
import starter.task.endeudamientoGlobal.InformacionFinanciera;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class EndeudamientoStepDefinitions {

    @Y("registra la informacion basica solicitante {string}{string}{string}{string}{string}{string}")
    public void registra_la_informacion_basica(String codigoAdo, String estrato, String tipoVivienda, String claseVivienda, String posicionHogar, String nivelEscolaridad) {
        theActorInTheSpotlight().attemptsTo(
                InformacionBasica.withInformacionBasica(codigoAdo, estrato, tipoVivienda, claseVivienda, posicionHogar, nivelEscolaridad)
        );
    }

    @Y("registra la informacion financiera {string}{string}")
    public void registra_la_informacion_basica(String descLey, String descNomina) {
        theActorInTheSpotlight().attemptsTo(
                InformacionFinanciera.withDatosFinancieros(descLey, descNomina)
        );
    }

    @Entonces("finaliza registrando la informacion a centrales {string}{string}{string}{string}")
    public void finaliza_endeudamiento_global(String cuotaHipotecaria, String tipoDocNomina, String rutaPdf, String otrosIngresos) {
        theActorInTheSpotlight().attemptsTo(
                InformacionCentrales.withInformacionCentrales(cuotaHipotecaria, tipoDocNomina, rutaPdf, otrosIngresos)
        );
    }
}
