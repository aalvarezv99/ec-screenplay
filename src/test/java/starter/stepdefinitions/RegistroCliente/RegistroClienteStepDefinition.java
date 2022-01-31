package starter.stepdefinitions.RegistroCliente;

import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import starter.task.RegistroCliente.DatosAdicionales;
import starter.task.RegistroCliente.FotoCedula;
import starter.task.RegistroCliente.RegistroCliente;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class RegistroClienteStepDefinition {
    @Entonces("El usuario carga los archivos imagen de la cedula del cliente {string}")
    public void el_usuario_carga_los_archivos_imagen_de_la_cedula_del_cliente(String RutaPDF) {
        theActorInTheSpotlight().attemptsTo(
                FotoCedula.whithFotoCedula(RutaPDF)
        );

    }

    @Y("realiza el registro del cliente paso 2 de 4 {string}{string}{string}{string}{string}{string}{string}{string}{string}{string}")
    public void realiza_el_registro_del_cliente_paso_2_de_4(String numeroDocumento,String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, String fechaNacimiento, String fechaExpedicion, String departamentoExpedicionCC, String ciudadExpedicionCC, String genero) {
        theActorInTheSpotlight().attemptsTo(
                RegistroCliente.whithRegistroCliente(numeroDocumento,primerNombre,segundoNombre,primerApellido,segundoApellido,fechaNacimiento,fechaExpedicion,departamentoExpedicionCC,ciudadExpedicionCC,genero)
        );

    }
    @Y("se llenan los datos adicionales {string}{string}")
    public void se_llenan_los_datos_adicionales(String departamentoExpedicionCC,String ciudadExpedicionCC) {
        theActorInTheSpotlight().attemptsTo(
                DatosAdicionales.whithDatosAdicionales(departamentoExpedicionCC,ciudadExpedicionCC)
        );

    }
}
