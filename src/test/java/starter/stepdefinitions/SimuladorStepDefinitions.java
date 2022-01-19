package starter.stepdefinitions;

import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import starter.task.TaskSimulador;
import starter.task.ValoresCreditoTask;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class SimuladorStepDefinitions {

    @Entonces("el usuario diligencias los campos del formulario {string}{string}{string}{string}{string}{string}{string}{string}{string}")
    public void el_usuario_diligencias_los_campos_del_formulario(String oficinaAsesor, String nombresApellidos, String numeroDocumento, String fechaNacimiento, String celular, String correoElectronico, String actividad, String pagaduria, String Contacto) {
        theActorInTheSpotlight().attemptsTo(
                TaskSimulador.whithSimulador(oficinaAsesor,nombresApellidos,numeroDocumento,fechaNacimiento,celular,correoElectronico,actividad,pagaduria,Contacto)
        );
    }
    @Y("ingresa la informacion de los valores credito a solicitar {string}{string}{string}{string}")
    public void ingresa_la_informacion_de_los_valores_credito_a_solicitar(String montoSolicitado, String tasa, String plazo, String diasIntereses) {
        theActorInTheSpotlight().attemptsTo(
                ValoresCreditoTask.withValoresCredito(montoSolicitado,tasa,plazo,diasIntereses)
        );
    }
}
