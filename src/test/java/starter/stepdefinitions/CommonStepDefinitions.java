package starter.stepdefinitions;

import io.cucumber.java.es.Cuando;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class CommonStepDefinitions {

    @Cuando("^se asigna el (.*)")
    public void se_asigna_el(String name) {
       theActorCalled(name);
    }
}
