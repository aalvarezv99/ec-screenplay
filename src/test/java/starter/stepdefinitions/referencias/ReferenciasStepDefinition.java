package starter.stepdefinitions.Referencias;

import io.cucumber.java.es.Y;
import starter.task.referencias.ReferenciasFamiliares;
import starter.task.referencias.ReferenciasPersonales;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ReferenciasStepDefinition {


    @Y("Se ingresa la informacion de las referencias personales {string}{string}{string}{string}{string}{string}{string}{string}")
    public void Se_ingresa_la_informacion_de_las_referencias_personales(String pNombreRefP, String sNombreRefP, String pApellidoRefP, String sApellidoRefP, String relacionRefP, String celRefP, String deptoRefP, String ciudadRefP) {
        theActorInTheSpotlight().attemptsTo(
                ReferenciasPersonales.whithReferenciasPersonales(pNombreRefP, sNombreRefP, pApellidoRefP, sApellidoRefP, relacionRefP, celRefP, deptoRefP, ciudadRefP)
        );
    }

    @Y("Se ingresa la informacion de las referencias familiares {string}{string}{string}{string}{string}{string}{string}{string}")
    public void Se_ingresa_la_informacion_de_las_referencias_familiares(String pNombreRefF, String sNombreRefF, String pApellidoRefF, String sApellidoRefF, String relacionRefF, String celRefF, String deptoRefF, String ciudadRefF) {
        theActorInTheSpotlight().attemptsTo(
                ReferenciasFamiliares.whithReferenciasFamiliares(pNombreRefF, sNombreRefF, pApellidoRefF, sApellidoRefF, relacionRefF, celRefF, deptoRefF, ciudadRefF)
        );
    }
}
