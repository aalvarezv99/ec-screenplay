package starter.stepdefinitions.firmaDocumentos;

import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import starter.task.firmaDocumentos.CargaDocumentos;
import starter.task.firmaDocumentos.ConsultarOTP;
import starter.task.firmaDocumentos.DescargarDocumentos;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class FirmaDocumentosStepDefinitions {

    @Y("consulta el codigo OTP {string}")
    public void consultar_codigo_otp(String cedula) {
        theActorInTheSpotlight().attemptsTo(
                ConsultarOTP.withConsultarOTP(cedula)
        );
    }

    @Y("descarga los documentos a firmar")
    public void descarga_documentos() {
        theActorInTheSpotlight().attemptsTo(
                DescargarDocumentos.withDescargarDocumentos()
        );
    }

    @Entonces("diligencia el tipo de documento y adjunta el archivo {string}")
    public void dligencia_tipo_documento_y_archivo(String rutaPdf) {
        theActorInTheSpotlight().attemptsTo(
                CargaDocumentos.withCargaDocumentos(rutaPdf)
        );
    }
}
