package starter.task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.waits.WaitUntil;
import starter.ui.dashboard.DashboardForm;

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
                WaitUntil.the(DashboardForm.loading,isNotVisible()).forNoMoreThan(10).seconds(),
                WaitUntil.the(DashboardForm.saltarIntro,isVisible()).forNoMoreThan(10).seconds(),
                Click.on(DashboardForm.saltarIntro),
                WaitUntil.the(DashboardForm.loading,isNotVisible()).forNoMoreThan(10).seconds(),
                Click.on(DashboardForm.menuSimulador),
                Click.on(DashboardForm.oficinaAsesor),
                Click.on(DashboardForm.selectsDatoFormulario.of(oficinaAsesor)),
                Click.on(DashboardForm.nombresApellidos),
                Enter.theValue(nombresApellidos).into(DashboardForm.nombresApellidos),
                Click.on(DashboardForm.numeroDocumento),
                Enter.theValue(numeroDocumento).into(DashboardForm.numeroDocumento),
                Click.on(DashboardForm.fechaNacimiento),
                Enter.theValue(fechaNacimiento).into(DashboardForm.fechaNacimiento),
                Click.on(DashboardForm.numeroCelular),
                Enter.theValue(celular).into(DashboardForm.numeroCelular),
                Click.on(DashboardForm.correo),
                Enter.theValue(correoElectronico).into(DashboardForm.correo),
                Click.on(DashboardForm.actividadCliente),
                Click.on(DashboardForm.selectsDatoFormulario.of(actividad)),
                Click.on(DashboardForm.pagaduria),
                Enter.theValue(pagaduria).into(DashboardForm.pagaduria),
                Click.on(DashboardForm.selectsDatoFormulario.of(pagaduria)),
                WaitUntil.the(DashboardForm.comoSeEnteroExcelCredit,isVisible()).forNoMoreThan(10).seconds(),
                Click.on(DashboardForm.comoSeEnteroExcelCredit),
                Click.on(DashboardForm.selectsDatoFormulario.of(Contacto)),
                Click.on(DashboardForm.botonSiguiente)
                );
        System.out.println(" error ");

    }
}
