package starter.stepdefinitions.DatosSolicitud;

import io.cucumber.java.es.Y;
import starter.task.DatosSolicitud.DatosSolicitudP1;
import starter.task.DatosSolicitud.DatosSolicitudP2;
import starter.task.DatosSolicitud.DatosSolicitudP4;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;


public class DatosSolicitudStepDefinitions {

    @Y("registra los datos adicionales del cliente en Pagina 1 {string}{string}{string}{string}{string}")
    public void registraLosDatosAdicionalesDelClienteenPagina1(String paisNacimiento,String lugarDeNacimiento,String nacionalidad,String estadoCivil,String profesion) {
        theActorInTheSpotlight().attemptsTo(
                DatosSolicitudP1.withDatosSolicitudP1(paisNacimiento,lugarDeNacimiento,nacionalidad,estadoCivil,profesion)
        );
    }

    @Y("registra los datos adicionales del cliente en Pagina 2 {string}{string}{string}{string}{string}{string}{string}{string}")
    public void registraLosDatosAdicionalesDelClienteEnPagina2(String departamentoResidencia,String ciudadResidencia,String direccionResidencia,String mesesResidencia,String numeroHijos,String personasACargo, String departamentoCorrespondencia, String ciudadCorrespondencia) {
        theActorInTheSpotlight().attemptsTo(
                DatosSolicitudP2.withDatosSolicitudP2(departamentoResidencia,ciudadResidencia,direccionResidencia,mesesResidencia,numeroHijos,personasACargo, departamentoCorrespondencia,ciudadCorrespondencia)
        );
    }

    @Y("registra los datos adicionales del cliente en Pagina 4 {string}{string}{string}{string}{string}{string}")
    public void registraLosDatosAdicionalesDelClienteEnPagina4(String tipoPension, String codigoProgramaNomina, String fechaIngreso, String nitAfiliacion, String tipoDocumento, String rutaPdf) {
        theActorInTheSpotlight().attemptsTo(
                DatosSolicitudP4.withDatosSolicitudP4(tipoPension,  codigoProgramaNomina,  fechaIngreso,  nitAfiliacion, tipoDocumento, rutaPdf)
        );
    }
}
