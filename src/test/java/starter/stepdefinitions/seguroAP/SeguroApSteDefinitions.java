package starter.stepdefinitions.seguroAP;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Y;
import starter.task.commonTask.ContinuarEstadoCredito;
import starter.task.seguroAP.BeneficiariosSeguroAP;
import starter.task.seguroAP.BeneficiosSeguroAP;
import starter.task.seguroAP.TomadorSeguroAP;
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

    @Y("Se llenan los campos de tomador del seguro {string}{string}{string}{string}{string}{string}{string}{string}")
    public void Se_llenan_los_campos_de_tomador_del_seguro(String nombresTomador, String documentoTomador ,String celularTomador ,String correoTomador,String fechaNacimientoTomador ,String departamentoTomador,String ciudadTomador,String direccionResidenciaTomador){
        theActorInTheSpotlight().attemptsTo(
                TomadorSeguroAP.whithTomadorSeguro(nombresTomador,documentoTomador,celularTomador,correoTomador,fechaNacimientoTomador,departamentoTomador,ciudadTomador,direccionResidenciaTomador)
        );
    }
}
