package starter.stepdefinitions;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import starter.task.commonTask.ContinuarEstadoCredito;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class CommonStepDefinitions {

    @Cuando("^se asigna el (.*)")
    public void se_asigna_el(String name) {
       theActorCalled(name);
    }

    @Entonces("busca el credito para retomar el estado actual {string}{string}{string}")
    public void busca_el_credito_para_retomar_el_estado_actual(String cedula, String estadoActual, String page) {
        theActorInTheSpotlight().attemptsTo(
                ContinuarEstadoCredito.withContinuarEstadoCredito(cedula, estadoActual, page)
        );
    }
}
