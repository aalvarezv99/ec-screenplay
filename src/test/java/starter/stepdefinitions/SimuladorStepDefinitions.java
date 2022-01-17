package starter.stepdefinitions;

import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import starter.navigation.NavigateTo;
import starter.task.TaskSimulador;
import starter.task.Tasklogin;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class SimuladorStepDefinitions {

    @Entonces("el usuario diligencias los campos del formulario {string}{string}{string}{string}{string}{string}{string}{string}")
    public void el_usuario_diligencias_los_campos_del_formulario(String nombresApellidos, String numeroDocumento, String fechaNacimiento, String celular, String correoElectronico, String actividad, String pagaduria, String Contacto) {
        theActorInTheSpotlight().attemptsTo(
                TaskSimulador.whithSimulador(nombresApellidos,numeroDocumento,fechaNacimiento,celular,correoElectronico,actividad,pagaduria,Contacto)
        );
    }
    @Y("continua el flujo")
    public void continua_el_flujo() {

    }
}
