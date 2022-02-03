package starter.stepdefinitions.seguroVida;

import io.cucumber.java.es.Entonces;
import starter.task.seguroVida.SeguroVidaBeneficiarios;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class SeguroVidaStepDefinition {

    @Entonces("diligencia minimo tres beneficiaros para el seguro de vida {string}{string}{string}{string}{string}")
    public void diligencia_los_beneficiarios_seguro_vida(String nombreBeneficario, String documentoBeneficiario, String celularBeneficiario, String departamento, String ciudad) {
        theActorInTheSpotlight().attemptsTo(
                SeguroVidaBeneficiarios.withSeguroVidaBeneficiarios(nombreBeneficario, documentoBeneficiario, celularBeneficiario, departamento, ciudad)
        );
    }
}
