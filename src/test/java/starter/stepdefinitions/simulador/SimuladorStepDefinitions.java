package starter.stepdefinitions.simulador;

import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import starter.conf.SessionVariables;
import starter.models.SimuladorModels;
import starter.questions.Simulador;
import starter.task.simulador.*;
import starter.ui.simulador.DatosClienteForm;
import starter.ui.simulador.DatosFinancierosForm;

import java.sql.SQLException;
import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;


public class SimuladorStepDefinitions {
    int multiple = 0;

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

    @Y("se validan los campos del simulador {string}{string}{string}{string}{string}{string}{string}{string}{string}{string}{string}")
    public void se_validan_los_campos_del_simulador(String tasa, String plazo, String ingresos, String descLey, String descNomina, String pagaduria, String diasIntereses, String creditoPadre, String vlrCompras, String lineaCredito, String cedula) throws SQLException {
        theActorInTheSpotlight().remember(SessionVariables.montoSolicitado.toString(), Simulador.montoSolicitadoCal());
        SimuladorModels calculosSimulador = new SimuladorModels();
        String valueMontoSolicitado = theActorInTheSpotlight().recall(SessionVariables.montoSolicitado.toString());
        valueMontoSolicitado = valueMontoSolicitado.replace("$", "").replace(".", "").replace(" ", "");

        if (lineaCredito.contains("Retanqueo")) {
            if(this.multiple>1){
                calculosSimulador = ResultadoTask.consultarCalculosSimuladorRetanqueoMultiple(cedula,pagaduria,tasa,plazo,diasIntereses,Integer.parseInt(valueMontoSolicitado), vlrCompras);
                System.out.println("Tipo Calculos : " + calculosSimulador.getTipoCalculos());
                System.out.println("Prima Seguro Anticipada : " + calculosSimulador.getPrimaSeguroAnticipada());
                System.out.println("Cuota Corriente : " + calculosSimulador.getCuotaCorriente());
                System.out.println("Gmf4X1000 : " + calculosSimulador.getGmf4X100());
                System.out.println("Prima No Devengada : " + calculosSimulador.getPrimaNoDevengada());
                System.out.println("Prima Neta : " + calculosSimulador.getPrimaNeta());
                System.out.println("Suma Fianzas : " + calculosSimulador.getSumaFianzas());
                System.out.println("Fianza Padre : " + calculosSimulador.getFianzaPadre());
                System.out.println("fianza neta : " + calculosSimulador.getFianzaNeta());
                System.out.println("Estudio Credito : " + calculosSimulador.getEstudioCredito());
                System.out.println("Saldo al Dia : " + calculosSimulador.getSaldoAlDia());
                System.out.println("Remanente Estimado : " + calculosSimulador.getRemanenteEstimado());
            }else{
                calculosSimulador = ResultadoTask.consultarCalculosSimuladorRetanqueo(creditoPadre, tasa, plazo, diasIntereses, valueMontoSolicitado, vlrCompras);
            }
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
                    Ensure.that(Integer.parseInt(Simulador.vlrCompras().answeredBy(theActorInTheSpotlight()))).isBetween(Integer.parseInt(vlrCompras) - 1, Integer.parseInt(vlrCompras) + 1),
                    Ensure.that(Integer.parseInt(Simulador.vlr4X1000().answeredBy(theActorInTheSpotlight()))).isBetween(calculosSimulador.getGmf4X100() - 1, calculosSimulador.getGmf4X100() + 1),
                    Ensure.that(Integer.parseInt(Simulador.interesesIniciales().answeredBy(theActorInTheSpotlight()))).isBetween(calculosSimulador.getInteresesIniciales() - 1, calculosSimulador.getInteresesIniciales() + 1),
                    Ensure.that(Integer.parseInt(Simulador.valorFianzaCal().answeredBy(theActorInTheSpotlight()))).isBetween(calculosSimulador.getFianzaNeta() - 1, calculosSimulador.getFianzaNeta() + 1),
                    Ensure.that(Integer.parseInt(Simulador.primaAnticipadaSeguro().answeredBy(theActorInTheSpotlight()))).isBetween(calculosSimulador.getPrimaSeguroAnticipada() - 1, calculosSimulador.getPrimaSeguroAnticipada() + 1)
            );
        }
        System.out.println(" punto de interrupción ");
    }

    @Y("diligencia los datos financieros {string}{string}{string}{string}{string}{string}{string}")
    public void diligencia_los_datos_financieros(String ingresos, String descLey, String descNomina, String lineaCredito, String credito, String vlrCompras, String pagaduria) {
        theActorInTheSpotlight().attemptsTo(
                DatosFinacieros.withDatosFinancieros(ingresos, descLey, descNomina, lineaCredito, credito, vlrCompras,pagaduria)
        );

        /*Se toma la lista de los creditos de los saldos al dia */
        List<String> listElementos = Simulador.listSaldosAlDia(pagaduria).answeredBy(theActorInTheSpotlight());

        this.multiple = listElementos.size();
        int sumaValores = 0;
        if(this.multiple>1){
            for (String obj : listElementos) {
                sumaValores = sumaValores + Integer.parseInt(obj.toString().replace("$", "").replace(".", "").replace(" ", ""));
            }
            theActorInTheSpotlight().attemptsTo(
                    Ensure.that(Integer.parseInt(Simulador.saldoRecoger().answeredBy(theActorInTheSpotlight()).toString())).isBetween(sumaValores - 1, sumaValores + 1)
            );
        }

        theActorInTheSpotlight().attemptsTo(
            Click.on(DatosClienteForm.botonSiguiente)
        );

    }


    @Y("se inicia la solicitud del credito")
    public void se_inicia_la_solicitud_del_credito() {
        theActorInTheSpotlight().attemptsTo(
                IniciarCredito.withDatosIniciarCredito()
        );
    }
}

