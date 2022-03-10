package starter.stepdefinitions;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Y;
import net.serenitybdd.screenplay.ensure.Ensure;
import starter.task.commonTask.ContinuarEstadoCredito;
import starter.util.consultas.FuncionesCreditoQuery;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

import java.sql.ResultSet;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class CommonStepDefinitions {

    @Cuando("^se asigna el (.*)")
    public void se_asigna_el(String name) {
       theActorCalled(name);
    }

    @Cuando("busca el credito para retomar el estado actual {string}{string}{string}")
    public void busca_el_credito_para_retomar_el_estado_actual(String cedula, String estadoActual, String page) {
        theActorInTheSpotlight().attemptsTo(
                ContinuarEstadoCredito.withContinuarEstadoCredito(cedula, estadoActual, page)
        );
    }

    @Y("^valida el cambio de estado del credito \"([^\"]*)\" con estado \"([^\"]*)\"$")
    public void validaElCambioDeEstadoDelCreditoConEstado(String numeroDocumento, String estadoCreditoEsperado) {

        FuncionesCreditoQuery query = new FuncionesCreditoQuery();
        String estadoCreditoDB = "";
        String validacion = "estado credito db No igual";
        ResultSet result;

        long start_time = System.currentTimeMillis();
        long wait_time = 10000;
        long end_time = start_time + wait_time;

        while (System.currentTimeMillis() < end_time && (estadoCreditoDB != estadoCreditoEsperado)) {
            result = query.consultarEstadoUltimoCredito(numeroDocumento);
            try {
                while (result.next()){
                    estadoCreditoDB = result.getString(1);
                }

            }catch (Exception e){
                System.out.println(" ******** consultarEstadoUltimoCredito() ******** ");
                System.out.println(e.getMessage());
            }
            if(estadoCreditoDB.equals(estadoCreditoEsperado)){
                validacion = "estado credito db igual";
            }
        }

        theActorInTheSpotlight().attemptsTo(
                Ensure.that(validacion).isEqualTo("estado credito db igual")
        );
        //System.out.println(" punto de interrupción ");
    }
}
