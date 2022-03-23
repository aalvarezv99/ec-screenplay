package starter.stepdefinitions.operacionesIntPEPS;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Y;
import starter.task.excepciones.SelecionarExcepciones;
import starter.task.operacionesIntPEPS.FamiliarExsPoliticamente;
import starter.task.operacionesIntPEPS.OperacionesIntPEPSTask;
import starter.task.operacionesIntPEPS.PersonaExsPoliticamente;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class OperacionesIntPEPSetpDefinition {

    @Y("llena el formulario de operaciones internacionales {string}{string}{string}{string}{string}{string}{string}{string}{string}{string}")
    public void llena_el_formulario_de_operaciones_internacionales(String monedaExtranjera,String tipoTransanccion,String productoBancario,String banco,String numProducto,String tipoProducto,String pais,String ciudad,String monto,String moneda) {
        theActorInTheSpotlight().attemptsTo(
                OperacionesIntPEPSTask.whithoperacionesIntPEPSTask(monedaExtranjera,tipoTransanccion,productoBancario,banco,numProducto,tipoProducto,pais,ciudad,monto,moneda)
        );
    }

    @Y("llena el formulario de persona expuesta politicamente {string}{string}{string}{string}")
    public void llena_el_formulario_de_persona_expuesta_politicamente(String funcionarioPublico,String recursosPublicos,String expuestoPoliticamente,String fechaExpuesto) {
        theActorInTheSpotlight().attemptsTo(
                PersonaExsPoliticamente.whithpersonaExsPoliticamente(funcionarioPublico,recursosPublicos,expuestoPoliticamente,fechaExpuesto)
                        );
    }

    @Y("llena el formulario de familares del cliente {string}")
    public void llena_el_formulario_de_familares_del_cliente(String expuestoPoliticamente,DataTable dataTable) {

        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        theActorInTheSpotlight().attemptsTo(
                FamiliarExsPoliticamente.withFamiliarExsPoliticamente(expuestoPoliticamente,data)
        );
    }
}
