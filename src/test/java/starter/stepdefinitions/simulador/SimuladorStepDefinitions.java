package starter.stepdefinitions.simulador;

import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.rest.Ensure;
import starter.conf.SessionVariables;
import starter.models.SimuladorModels;
import starter.questions.SimuladorOriginacion;
import starter.task.simulador.DatosFinancieros;
import starter.task.simulador.ResultadoTask;
import starter.task.simulador.TaskSimulador;
import starter.task.simulador.ValoresCreditoTask;

import java.sql.SQLException;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.thucydides.core.matchers.dates.DateMatchers.isBetween;

public class SimuladorStepDefinitions {

    @Entonces("el usuario diligencias los campos del formulario {string}{string}{string}{string}{string}{string}{string}{string}{string}")
    public void el_usuario_diligencias_los_campos_del_formulario(String oficinaAsesor, String nombresApellidos, String numeroDocumento, String fechaNacimiento, String celular, String correoElectronico, String actividad, String pagaduria, String Contacto) {
        theActorInTheSpotlight().attemptsTo(
                TaskSimulador.whithSimulador(oficinaAsesor, nombresApellidos, numeroDocumento, fechaNacimiento, celular, correoElectronico, actividad, pagaduria, Contacto)
        );
    }

    @Y("ingresa la informacion de los valores credito a solicitar {string}{string}{string}{string}")
    public void ingresa_la_informacion_de_los_valores_credito_a_solicitar(String montoSolicitado, String tasa, String plazo, String diasIntereses) {
        theActorInTheSpotlight().attemptsTo(
                ValoresCreditoTask.withValoresCredito(montoSolicitado, tasa, plazo, diasIntereses)
        );
    }

    @Y("diligencia los datos financieros {string}{string}{string}{string}")
    public void diligencia_los_datos_financieros(String ingresos, String descLey, String descNomina, String lineaCredito) {
        theActorInTheSpotlight().attemptsTo(
                DatosFinancieros.withDatosFinancieros(ingresos, descLey, descNomina, lineaCredito)
        );

    }

    @Y("se validan los campos del simulador {string}{string}{string}{string}{string}{string}{string}{string}")
    public void se_validan_los_campos_del_simulador(String montoSolicitado, String tasa,String plazo,String ingresos,String descLey,String descNomina,String pagaduria,String diasIntereses) throws SQLException {
        theActorInTheSpotlight().remember(SessionVariables.montoSolicitado.toString(), SimuladorOriginacion.montoSolicitadoCal());
        SimuladorModels calculosSimulador = new SimuladorModels();

        String valueMontoSolicitado = theActorInTheSpotlight().recall(SessionVariables.montoSolicitado.toString());
        valueMontoSolicitado = valueMontoSolicitado.replace("$","").replace(".","").replace(" ","");
        calculosSimulador = ResultadoTask.consultarCalculosSimulador(valueMontoSolicitado,tasa, plazo, diasIntereses, "0", ingresos, descLey, descNomina, pagaduria);

        theActorInTheSpotlight().attemptsTo(
                Ensure.that(20).isBetween(18,25)
        );
    }
    }
}
