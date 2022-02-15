package starter.stepdefinitions.registroCliente;

import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import starter.task.registroCliente.DatosAdicionales;
import starter.task.registroCliente.FotoCedula;
import starter.task.registroCliente.FotoCliente;
import starter.task.registroCliente.RegistroCliente;
import starter.task.propeccionCliente.Prospeccion;
import starter.task.propeccionCliente.ProspeccionBackground;

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

    @Y("se cargar la foto de perfil del cliente {string}")
    public void se_cargar_la_foto_de_perfil_del_cliente(String RutaPDF) {
        theActorInTheSpotlight().attemptsTo(
                FotoCliente.whithFotoCliente(RutaPDF)
        );

    }

    @Entonces("se realiza el proceso de Prospeccion del cliente {string}")
    public void se_realiza_el_proceso_de_Prospeccion_del_cliente(String numeroDocumento) {
        theActorInTheSpotlight().attemptsTo(
                Prospeccion.whithProspeccion(numeroDocumento)
        );

    }

    @Y("recorre las paginas de la consulta de propeccion")
    public void recorre_las_paginas_de_la_consulta_de_propeccion() {
        theActorInTheSpotlight().attemptsTo(
                ProspeccionBackground.whithProspeccionBackground()
        );

    }
}
