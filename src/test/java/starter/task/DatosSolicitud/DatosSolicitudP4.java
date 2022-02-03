package starter.task.DatosSolicitud;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.Upload;
import net.serenitybdd.screenplay.waits.WaitUntil;
import starter.ui.DatosSolicitud.DatosSolicitudForm;
import starter.ui.RegistroDeCliente.RegistroClienteForm;
import starter.ui.commons.CommonsLocators;

import java.nio.file.Path;
import java.nio.file.Paths;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

public class DatosSolicitudP4 implements Task {
    private final String tipoPension;
    private final String codigoProgramaNomina;
    private final String fechaIngreso;
    private final String nitAfiliacion;
    private final String tipoDocumento;
    private final String rutaPdf;

    public DatosSolicitudP4(String tipoPension, String codigoProgramaNomina, String fechaIngreso, String nitAfiliacion, String tipoDocumento, String rutaPdf) {
        this.tipoPension = tipoPension;
        this.codigoProgramaNomina = codigoProgramaNomina;
        this.fechaIngreso = fechaIngreso;
        this.nitAfiliacion = nitAfiliacion;
        this.tipoDocumento = tipoDocumento;
        this.rutaPdf = rutaPdf;
    }


    public static Performable withDatosSolicitudP4(String tipoPension, String codigoProgramaNomina, String fechaIngreso, String nitAfiliacion, String tipoDocumento, String rutaPdf) {
        return instrumented(DatosSolicitudP4.class,  tipoPension,  codigoProgramaNomina,  fechaIngreso,  nitAfiliacion, tipoDocumento, rutaPdf);
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        Path fotoPath = Paths.get(rutaPdf).toAbsolutePath();
        actor.attemptsTo(
                WaitUntil.the(DatosSolicitudForm.pageDatosAdicionales.of("4"), isPresent()).forNoMoreThan(10).seconds(),
                Scroll.to(CommonsLocators.botonSiguiente),
                Click.on(DatosSolicitudForm.tipoDocumento),
                Click.on(CommonsLocators.locatorByText.of(tipoDocumento)),
                //
                Enter.theValue(tipoPension).into(DatosSolicitudForm.tipoPension),
                Enter.theValue(codigoProgramaNomina).into(DatosSolicitudForm.codigoProgramaNomina),
                Enter.theValue(fechaIngreso).into(DatosSolicitudForm.fechaIngreso),
                Enter.theValue(nitAfiliacion).into(DatosSolicitudForm.nitAfiliacion),
                //
                Scroll.to(CommonsLocators.botonSiguiente),
                Upload.theFile(fotoPath).to(DatosSolicitudForm.subirPDF),
                Click.on(CommonsLocators.botonSiguiente)
                );
        System.out.println("Fin Pagina 4/6 Datos Adicionales Clente");
    }
}
