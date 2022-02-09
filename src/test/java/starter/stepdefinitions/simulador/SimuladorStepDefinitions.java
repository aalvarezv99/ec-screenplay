package starter.stepdefinitions.simulador;

import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.screenplay.ensure.Ensure;
import starter.conf.SessionVariables;
import starter.models.SimuladorModels;
import starter.questions.Simulador;
import starter.task.simulador.*;

import java.sql.SQLException;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;


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

    @Y("se validan los campos del simulador {string}{string}{string}{string}{string}{string}{string}{string}{string}{string}")
    public void se_validan_los_campos_del_simulador(String tasa, String plazo, String ingresos, String descLey, String descNomina, String pagaduria, String diasIntereses, String creditoPadre, String vlrCompras, String lineaCredito) throws SQLException {
        theActorInTheSpotlight().remember(SessionVariables.montoSolicitado.toString(), Simulador.montoSolicitadoCal());
        SimuladorModels calculosSimulador = new SimuladorModels();
        String valueMontoSolicitado = theActorInTheSpotlight().recall(SessionVariables.montoSolicitado.toString());
        valueMontoSolicitado = valueMontoSolicitado.replace("$", "").replace(".", "").replace(" ", "");

        if (lineaCredito.contains("Retanqueo")) {
            calculosSimulador = ResultadoTask.consultarCalculosSimuladorRetanqueo(creditoPadre, tasa, plazo, diasIntereses, valueMontoSolicitado, vlrCompras);

            theActorInTheSpotlight().attemptsTo(
                    Ensure.that(Integer.parseInt(Simulador.cuotaCorrienteCal().answeredBy(theActorInTheSpotlight()))).isBetween(calculosSimulador.getCuotaCorriente() - 1, calculosSimulador.getCuotaCorriente() + 1),
                    Ensure.that(Integer.parseInt(Simulador.estudioCreditoCal().answeredBy(theActorInTheSpotlight()))).isBetween(calculosSimulador.getEstudioCredito() - 1, calculosSimulador.getEstudioCredito() + 1),
                    Ensure.that(Integer.parseInt(Simulador.valorFianzaCal().answeredBy(theActorInTheSpotlight()))).isBetween(calculosSimulador.getFianzaNeta() - 1, calculosSimulador.getFianzaNeta() + 1),
                    Ensure.that(Integer.parseInt(Simulador.vlrCompras().answeredBy(theActorInTheSpotlight()))).isBetween(Integer.parseInt(vlrCompras) - 1, Integer.parseInt(vlrCompras) + 1),
                    Ensure.that(Integer.parseInt(Simulador.vlr4X1000().answeredBy(theActorInTheSpotlight()))).isBetween(calculosSimulador.getGmf4X100() - 1, calculosSimulador.getGmf4X100() + 1),
                    Ensure.that(Integer.parseInt(Simulador.primaAnticipadaSeguro().answeredBy(theActorInTheSpotlight()))).isBetween(calculosSimulador.getPrimaSeguroAnticipada() - 1, calculosSimulador.getPrimaSeguroAnticipada() + 1),
                    Ensure.that(Integer.parseInt(Simulador.remanenteEstimado().answeredBy(theActorInTheSpotlight()))).isBetween(calculosSimulador.getRemanenteEstimado() - 1, calculosSimulador.getRemanenteEstimado() + 1)
            );
        } else {
            calculosSimulador = ResultadoTask.consultarCalculosSimulador(valueMontoSolicitado, tasa, plazo, diasIntereses, vlrCompras, ingresos, descLey, descNomina, pagaduria);

            theActorInTheSpotlight().attemptsTo(
                    Ensure.that(Integer.parseInt(Simulador.montoSolicitadoCal().answeredBy(theActorInTheSpotlight()))).isBetween(calculosSimulador.getMontoSolicitar() - 1, calculosSimulador.getMontoSolicitar() + 1),
                    Ensure.that(Integer.parseInt(Simulador.cuotaCorrienteCal().answeredBy(theActorInTheSpotlight()))).isBetween(calculosSimulador.getCuotaCorriente() - 1, calculosSimulador.getCuotaCorriente() + 1),
                    Ensure.that(Integer.parseInt(Simulador.estudioCreditoCal().answeredBy(theActorInTheSpotlight()))).isBetween(calculosSimulador.getEstudioCredito() - 1, calculosSimulador.getEstudioCredito() + 1),
                    Ensure.that(Integer.parseInt(Simulador.interesesIniciales().answeredBy(theActorInTheSpotlight()))).isBetween(calculosSimulador.getInteresesIniciales() - 1, calculosSimulador.getInteresesIniciales() + 1),
                    Ensure.that(Integer.parseInt(Simulador.valorFianzaCal().answeredBy(theActorInTheSpotlight()))).isBetween(calculosSimulador.getFianzaNeta() - 1, calculosSimulador.getFianzaNeta() + 1),
                    Ensure.that(Integer.parseInt(Simulador.primaAnticipadaSeguro().answeredBy(theActorInTheSpotlight()))).isBetween(calculosSimulador.getPrimaSeguroAnticipada() - 1, calculosSimulador.getPrimaSeguroAnticipada() + 1)
            );
        }
        System.out.println(" punto de interrupción ");
    }

    @Y("diligencia los datos financieros {string}{string}{string}{string}{string}{string}")
    public void diligencia_los_datos_financieros(String ingresos, String descLey, String descNomina, String lineaCredito, String credito, String vlrCompras) {
        theActorInTheSpotlight().attemptsTo(
                DatosFinacieros.withDatosFinancieros(ingresos, descLey, descNomina, lineaCredito, credito, vlrCompras)
        );
    }


    @Y("se inicia la solicitud del credito")
    public void se_inicia_la_solicitud_del_credito() {
        theActorInTheSpotlight().attemptsTo(
                IniciarCredito.withDatosIniciarCredito()
        );
    }
}

