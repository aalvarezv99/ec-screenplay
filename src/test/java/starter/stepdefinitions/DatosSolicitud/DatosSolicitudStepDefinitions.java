package starter.stepdefinitions.DatosSolicitud;

import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import starter.task.DatosSolicitud.*;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;


public class DatosSolicitudStepDefinitions {

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

    @Y("diligencia los datos calculo credito {string}{string}{string}{string}")
    public void diligenciaLosDatosCalculoCredito(String montoSolicitado, String tasa, String plazo, String diasInteresesIniciales) {
        theActorInTheSpotlight().attemptsTo(
                CalculoCreditoDA.withCalculoCreditoDA(montoSolicitado, tasa, plazo, diasInteresesIniciales)
        );
    }

    @Entonces("se registran los datos para el credito Retanqueo {string}{string}{string}{string}{string}")
    public void seRegistranLosDatosParaElCreditoRetanqueo(String ingresosMensuales, String totalDescuentos, String totalDescuentosLey, String lineaDeCredito, String creditoPadre) {
        theActorInTheSpotlight().attemptsTo(
                DatosCreditoRetanqueo.withDatosCreditoRetanqueo(ingresosMensuales, totalDescuentos, totalDescuentosLey, lineaDeCredito, creditoPadre)
        );
    }
}
