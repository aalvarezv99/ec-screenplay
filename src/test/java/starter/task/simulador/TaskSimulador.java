package starter.task.simulador;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.waits.WaitUntil;
import starter.ui.dashboard.DashboardForm;
import starter.ui.simulador.DatosClienteForm;
import starter.ui.commons.CommonsLocators;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class TaskSimulador implements Task {

    private final String oficinaAsesor;
    private final String nombresApellidos;
    private final String numeroDocumento;
    private final String fechaNacimiento;
    private final String celular;
    private final String correoElectronico;
    private final String actividad;
    private final String pagaduria;
    private final String Contacto;

    public TaskSimulador(String oficinaAsesor, String nombresApellidos, String numeroDocumento, String fechaNacimiento, String celular, String correoElectronico, String actividad, String pagaduria, String contacto){

        this.oficinaAsesor = oficinaAsesor;
        this.nombresApellidos = nombresApellidos;
        this.numeroDocumento = numeroDocumento;
        this.fechaNacimiento = fechaNacimiento;
        this.celular = celular;
        this.correoElectronico = correoElectronico;
        this.actividad = actividad;
        this.pagaduria = pagaduria;
        this.Contacto = contacto;
    }

    public static Performable whithSimulador(String oficinaAsesor, String nombresApellidos, String numeroDocumento, String fechaNacimiento, String celular, String correoElectronico, String actividad, String pagaduria, String Contacto){
        return instrumented(TaskSimulador.class,oficinaAsesor,nombresApellidos,numeroDocumento,fechaNacimiento,celular,correoElectronico,actividad,pagaduria,Contacto);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(DashboardForm.loading,isNotVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(DashboardForm.menuSimulador,isVisible()).forNoMoreThan(60).seconds(),
                Click.on(DashboardForm.menuSimulador),
                Click.on(DatosClienteForm.oficinaAsesor),
                Click.on(CommonsLocators.locatorByText.of(oficinaAsesor)),
                Click.on(DatosClienteForm.nombresApellidos),
                Enter.theValue(nombresApellidos).into(DatosClienteForm.nombresApellidos),
                Click.on(DatosClienteForm.numeroDocumento),
                Enter.theValue(numeroDocumento).into(DatosClienteForm.numeroDocumento),
                Click.on(DatosClienteForm.fechaNacimiento),
                Enter.theValue(fechaNacimiento).into(DatosClienteForm.fechaNacimiento),
                Click.on(DatosClienteForm.numeroCelular),
                Enter.theValue(celular).into(DatosClienteForm.numeroCelular),
                Click.on(DatosClienteForm.correo),
                Enter.theValue(correoElectronico).into(DatosClienteForm.correo),
                Click.on(DatosClienteForm.actividadCliente),
                Click.on(CommonsLocators.locatorByText.of(actividad)),
                Click.on(DatosClienteForm.pagaduria),
                Enter.theValue(pagaduria).into(DatosClienteForm.pagaduria),
                Click.on(CommonsLocators.locatorByText.of(pagaduria)),
                WaitUntil.the(DatosClienteForm.comoSeEnteroExcelCredit,isVisible()).forNoMoreThan(10).seconds(),
                Click.on(DatosClienteForm.comoSeEnteroExcelCredit),
                Click.on(CommonsLocators.locatorByText.of(Contacto)),
                Click.on(DatosClienteForm.botonSiguiente)
                );
    }
}
