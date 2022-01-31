package starter.stepdefinitions.desembolso;

import io.cucumber.java.es.Y;
import starter.task.desembolso.Desembolso;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class DesembolsoStepDefinitions {

    @Y("se selecciona la modalidad de desembolso y tipo de cliente {string}{string}")
    public void busca_el_credito_para_retomar_el_estado_actual(String modalidadDesembolso, String tipoCliente) {
        theActorInTheSpotlight().attemptsTo(
                Desembolso.withDesembolsoCredito(modalidadDesembolso, tipoCliente)
        );
    }
}
