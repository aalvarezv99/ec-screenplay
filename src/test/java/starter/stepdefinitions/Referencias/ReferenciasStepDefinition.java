package starter.stepdefinitions.Referencias;

import io.cucumber.java.es.Y;
import starter.task.referencias.ReferenciasPersonales;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ReferenciasStepDefinition {


    @Y("Se ingresa la informacion de las referencias personales {string}{string}{string}{string}{string}{string}{string}{string}")
    public void Se_ingresa_la_informacion_de_las_referencias_personales(String pNombreRef, String sNombreRef, String pApellidoRef, String sApellidoRef, String relacionRef, String celRef, String deptoRef, String ciudadRef) {
        theActorInTheSpotlight().attemptsTo(
                ReferenciasPersonales.whithReferenciasPersonales(pNombreRef, sNombreRef, pApellidoRef, sApellidoRef, relacionRef, celRef, deptoRef, ciudadRef)
        );
    }

}
