package starter.stepdefinitions.DatosSolicitud;

import io.cucumber.java.es.Y;
import starter.task.DatosSolicitud.DatosSolicitud;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;


public class DatosSolicitudStepDefinitions {

    @Y("registra los datos adicionales del cliente {string}{string}{string}{string}{string}")
    public void registraLosDatosAdicionalesDelClientePaisNacimientoLugarDeNacimientoNacionalidadEstadoCivilProfesion(String paisNacimiento,String lugarDeNacimiento,String nacionalidad,String estadoCivil,String profesion) {
        theActorInTheSpotlight().attemptsTo(
                DatosSolicitud.withDatosSolicitud(paisNacimiento,lugarDeNacimiento,nacionalidad,estadoCivil,profesion)
        );
    }
}
