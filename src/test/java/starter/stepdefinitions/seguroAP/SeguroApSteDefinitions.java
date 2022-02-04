package starter.stepdefinitions.seguroAP;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Y;
import starter.task.commonTask.ContinuarEstadoCredito;
import starter.task.seguroAP.BeneficiariosSeguroAP;
import starter.task.seguroAP.BeneficiosSeguroAP;
import starter.task.seguroAP.VinculoClienteSeguroAP;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class SeguroApSteDefinitions {

    @Cuando("Se visualizan los beneficios del seguro")
    public void Se_visualizan_los_beneficios_del_seguro() {
        theActorInTheSpotlight().attemptsTo(
                BeneficiosSeguroAP.whithBeneficiosSeguroAP()
        );
    }

    @Y("Se selecciona el vinculo del seguro y el plan {string}{string}")
    public void Se_selecciona_el_vinculo_del_seguro_y_el_plan(String vinculo, String plan){
        theActorInTheSpotlight().attemptsTo(
          VinculoClienteSeguroAP.whithVinculoClienteSeguroAP(vinculo,plan)
        );
    }

    @Y("Se registran los beneficiarios {string}{string}")
    public void Se_registran_los_beneficiarios(String nombresSeguroAP, String parentescoSeguroAP){
        theActorInTheSpotlight().attemptsTo(
                BeneficiariosSeguroAP.whithBeneficiariosSeguroAP(nombresSeguroAP,parentescoSeguroAP)
        );
    }
}
