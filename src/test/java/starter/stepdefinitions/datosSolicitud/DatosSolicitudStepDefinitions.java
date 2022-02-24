package starter.stepdefinitions.datosSolicitud;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.screenplay.ensure.Ensure;
import starter.conf.SessionVariables;
import starter.models.SimuladorModels;
import starter.questions.ResultadoCalculoCredito;
import starter.questions.Simulador;
import starter.task.datosSolicitud.*;
import starter.task.simulador.ResultadoTask;
import starter.ui.commons.CommonsFuntions;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;


public class DatosSolicitudStepDefinitions {
    int multiple = 0;

    @Y("registra los datos adicionales del cliente en Pagina 1 {string}{string}{string}{string}{string}")
    public void registraLosDatosAdicionalesDelClienteenPagina1(String paisNacimiento, String lugarDeNacimiento, String nacionalidad, String estadoCivil, String profesion) {
        theActorInTheSpotlight().attemptsTo(
                DatosSolicitudP1.withDatosSolicitudP1(paisNacimiento, lugarDeNacimiento, nacionalidad, estadoCivil, profesion)
        );
    }

    @Y("registra los datos adicionales del cliente en Pagina 2 {string}{string}{string}{string}{string}{string}{string}{string}")
    public void registraLosDatosAdicionalesDelClienteEnPagina2(String departamentoResidencia, String ciudadResidencia, String direccionResidencia, String mesesResidencia, String numeroHijos, String personasACargo, String departamentoCorrespondencia, String ciudadCorrespondencia) {
        theActorInTheSpotlight().attemptsTo(
                DatosSolicitudP2.withDatosSolicitudP2(departamentoResidencia, ciudadResidencia, direccionResidencia, mesesResidencia, numeroHijos, personasACargo, departamentoCorrespondencia, ciudadCorrespondencia)
        );
    }

    @Y("registra los datos adicionales del cliente en Pagina 4 {string}{string}{string}{string}{string}{string}{string}{string}")
    public void registraLosDatosAdicionalesDelClienteEnPagina4(String tipoPension, String codigoProgramaNomina, String fechaIngreso, String fechaTerminacion, String nitAfiliacion, String tipoDocumento, String rutaPdf, String cargo) {
        theActorInTheSpotlight().attemptsTo(
                DatosSolicitudP4.withDatosSolicitudP4(tipoPension, codigoProgramaNomina, fechaIngreso, fechaTerminacion, nitAfiliacion, tipoDocumento, rutaPdf, cargo)
        );
    }

    @Entonces("se registran los datos para el credito Originacion {string}{string}{string}{string}")
    public void seRegistranLosDatosParaElCredito(String ingresosMensuales, String totalDescuentos, String totalDescuentosLey, String lineaDeCredito) {
        theActorInTheSpotlight().attemptsTo(
                DatosCredito.withDatosCredito(ingresosMensuales, totalDescuentos, totalDescuentosLey, lineaDeCredito)
        );
    }

    @Y("^se crean los tipos de cartera o saneamiento a recoger con la linea de \"([^\"]*)\"$")
    public void seCreanLosTiposDeCarteraOSaneamientoARecogerConLaLineaDeCredito(String lineaCredito, DataTable dataTable) {
        System.out.println("IMPRIMIENTO linea Credito " + CommonsFuntions.limpiarCadena(lineaCredito));
        if (!CommonsFuntions.limpiarCadena(lineaCredito).equals("Retanqueo libre inversion") && !CommonsFuntions.limpiarCadena(lineaCredito).equals("Libre inversion")) {
            System.out.println("INGRESO A LAS CARTERAS");
            List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
            theActorInTheSpotlight().attemptsTo(
                    DatosCreditosComprasCarteras.withDatosCreditosComprasCarteras(data));
        }
        System.out.println("NO INGRESO A LAS CARTERAS");
    }

    @Y("diligencia los datos calculo credito {string}{string}{string}{string}")
    public void diligenciaLosDatosCalculoCredito(String montoSolicitado, String tasa, String plazo, String diasInteresesIniciales) {
        theActorInTheSpotlight().attemptsTo(
                CalculoCreditoDA.withCalculoCreditoDA(montoSolicitado, tasa, plazo, diasInteresesIniciales)
        );
    }

    @Entonces("se registran los datos para el credito Retanqueo {string}{string}{string}{string}{string}{string}")
    public void seRegistranLosDatosParaElCreditoRetanqueo(String ingresosMensuales, String totalDescuentos, String totalDescuentosLey, String lineaDeCredito, String creditoPadre, String pagaduria) {
        theActorInTheSpotlight().attemptsTo(
                DatosCreditoRetanqueo.withDatosCreditoRetanqueo(ingresosMensuales, totalDescuentos, totalDescuentosLey, lineaDeCredito, creditoPadre, pagaduria)
        );

        /*Se toma la lista de los creditos de los saldos al dia */
        List<String> listElementos = Simulador.listSaldosAlDia(pagaduria).answeredBy(theActorInTheSpotlight());

        this.multiple = listElementos.size();
        int sumaValores = 0;
        if (this.multiple > 1) {
            for (String obj : listElementos) {
                sumaValores = sumaValores + Integer.parseInt(obj.replace("$", "").replace(".", "").replace(" ", ""));
            }
            theActorInTheSpotlight().attemptsTo(
                    Ensure.that(Integer.parseInt(Simulador.saldoRecoger().answeredBy(theActorInTheSpotlight()))).isBetween(sumaValores - 1, sumaValores + 1)
            );
        }
    }

    @Y("se validan los datos del simulador datos solicitud {string}{string}{string}{string}{string}{string}{string}{string}{string}{string}{string}")
    public void se_validan_los_datos_del_simulador_datos_solicitud(String tasa, String plazo, String ingresos, String descLey, String descNomina, String pagaduria, String diasIntereses, String creditoPadre, String vlrCompras, String lineaCredito, String cedula) throws SQLException, SQLException {

        theActorInTheSpotlight().remember(SessionVariables.montoSolicitado.toString(), ResultadoCalculoCredito.montoSolicitadoCal());
        SimuladorModels calculosSimulador = new SimuladorModels();
        String valueMontoSolicitado = theActorInTheSpotlight().recall(SessionVariables.montoSolicitado.toString());
        valueMontoSolicitado = valueMontoSolicitado.replace("$", "").replace(".", "").replace(" ", "");

        if (lineaCredito.contains("Retanqueo")) {
            if (this.multiple > 1) {
                calculosSimulador = ResultadoTask.consultarCalculosSimuladorRetanqueoMultiple(cedula, pagaduria, tasa, plazo, diasIntereses, Integer.parseInt(valueMontoSolicitado), vlrCompras);
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
                System.out.println(" ya muestra todos los valores ");
            } else {
                calculosSimulador = ResultadoTask.consultarCalculosSimuladorRetanqueo(creditoPadre, tasa, plazo, diasIntereses, valueMontoSolicitado, vlrCompras);
            }

            theActorInTheSpotlight().attemptsTo(
                    Ensure.that(Integer.parseInt(ResultadoCalculoCredito.cuotaCorrienteCal().answeredBy(theActorInTheSpotlight()))).isBetween(calculosSimulador.getCuotaCorriente() - 1, calculosSimulador.getCuotaCorriente() + 1),
                    Ensure.that(Integer.parseInt(ResultadoCalculoCredito.estudioCreditoCal().answeredBy(theActorInTheSpotlight()))).isBetween(calculosSimulador.getEstudioCredito() - 1, calculosSimulador.getEstudioCredito() + 1),
                    Ensure.that(Integer.parseInt(ResultadoCalculoCredito.valorFianzaCal().answeredBy(theActorInTheSpotlight()))).isBetween(calculosSimulador.getFianzaNeta() - 1, calculosSimulador.getFianzaNeta() + 1),
                    Ensure.that(Integer.parseInt(ResultadoCalculoCredito.vlrCompras().answeredBy(theActorInTheSpotlight()))).isBetween(Integer.parseInt(vlrCompras) - 1, Integer.parseInt(vlrCompras) + 1),
                    Ensure.that(Integer.parseInt(ResultadoCalculoCredito.vlr4X1000().answeredBy(theActorInTheSpotlight()))).isBetween(calculosSimulador.getGmf4X100() - 1, calculosSimulador.getGmf4X100() + 1),
                    Ensure.that(Integer.parseInt(ResultadoCalculoCredito.primaAnticipadaSeguro().answeredBy(theActorInTheSpotlight()))).isBetween(calculosSimulador.getPrimaSeguroAnticipada() - 1, calculosSimulador.getPrimaSeguroAnticipada() + 1),
                    Ensure.that(Integer.parseInt(ResultadoCalculoCredito.remanenteEstimado().answeredBy(theActorInTheSpotlight()))).isBetween(calculosSimulador.getRemanenteEstimado() - 1, calculosSimulador.getRemanenteEstimado() + 1)
            );
        } else {
            calculosSimulador = ResultadoTask.consultarCalculosSimulador(valueMontoSolicitado, tasa, plazo, diasIntereses, vlrCompras, ingresos, descLey, descNomina, pagaduria);

            theActorInTheSpotlight().attemptsTo(
                    Ensure.that(Integer.parseInt(ResultadoCalculoCredito.vlrCompras().answeredBy(theActorInTheSpotlight()))).isBetween(Integer.parseInt(vlrCompras) - 1, Integer.parseInt(vlrCompras) + 1),
                    Ensure.that(Integer.parseInt(ResultadoCalculoCredito.vlr4X1000().answeredBy(theActorInTheSpotlight()))).isBetween(calculosSimulador.getGmf4X100() - 1, calculosSimulador.getGmf4X100() + 1),
                    Ensure.that(Integer.parseInt(ResultadoCalculoCredito.montoSolicitadoCal().answeredBy(theActorInTheSpotlight()))).isBetween(calculosSimulador.getMontoSolicitar() - 1, calculosSimulador.getMontoSolicitar() + 1),
                    Ensure.that(Integer.parseInt(ResultadoCalculoCredito.cuotaCorrienteCal().answeredBy(theActorInTheSpotlight()))).isBetween(calculosSimulador.getCuotaCorriente() - 1, calculosSimulador.getCuotaCorriente() + 1),
                    Ensure.that(Integer.parseInt(ResultadoCalculoCredito.estudioCreditoCal().answeredBy(theActorInTheSpotlight()))).isBetween(calculosSimulador.getEstudioCredito() - 1, calculosSimulador.getEstudioCredito() + 1),
                    Ensure.that(Integer.parseInt(ResultadoCalculoCredito.interesesIniciales().answeredBy(theActorInTheSpotlight()))).isBetween(calculosSimulador.getInteresesIniciales() - 1, calculosSimulador.getInteresesIniciales() + 1),
                    Ensure.that(Integer.parseInt(ResultadoCalculoCredito.valorFianzaCal().answeredBy(theActorInTheSpotlight()))).isBetween(calculosSimulador.getFianzaNeta() - 1, calculosSimulador.getFianzaNeta() + 1),
                    Ensure.that(Integer.parseInt(ResultadoCalculoCredito.primaAnticipadaSeguro().answeredBy(theActorInTheSpotlight()))).isBetween(calculosSimulador.getPrimaSeguroAnticipada() - 1, calculosSimulador.getPrimaSeguroAnticipada() + 1),
                    Ensure.that(Integer.parseInt(ResultadoCalculoCredito.remanenteEstimado().answeredBy(theActorInTheSpotlight()))).isBetween(calculosSimulador.getRemanenteEstimado() - 1, calculosSimulador.getRemanenteEstimado() + 1)

            );
        }
        theActorInTheSpotlight().attemptsTo(
                SimuladorDatosSolicitud.withSimuladorDatosSolicitud()
        );
    }
}
