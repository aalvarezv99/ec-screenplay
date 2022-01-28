package starter.stepdefinitions.RegistroCliente;

import io.cucumber.java.es.Entonces;
import starter.task.RegistroCliente.FotoCedula;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class RegistroClienteStepDefinition {
    @Entonces("El usuario carga los archivos imagen de la cedula del cliente {string}")
    public void el_usuario_carga_los_archivos_imagen_de_la_cedula_del_cliente(String RutaPDF) {
        theActorInTheSpotlight().attemptsTo(
                FotoCedula.whithFotoCedula(RutaPDF)
        );

    }
}
