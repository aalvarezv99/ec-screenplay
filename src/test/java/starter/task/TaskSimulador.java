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

    private final String nombresApellidos;
    private final String numeroDocumento;
    private final String fechaNacimiento;
    private final String celular;
    private final String correoElectronico;
    private final String actividad;
    private final String pagaduria;
    private final String Contacto;

    public TaskSimulador(String nombresApellidos, String numeroDocumento, String fechaNacimiento, String celular, String correoElectronico, String actividad, String pagaduria, String contacto){

        this.nombresApellidos = nombresApellidos;
        this.numeroDocumento = numeroDocumento;
        this.fechaNacimiento = fechaNacimiento;
        this.celular = celular;
        this.correoElectronico = correoElectronico;
        this.actividad = actividad;
        this.pagaduria = pagaduria;
        this.Contacto = contacto;
    }

    public static Performable whithSimulador(String nombresApellidos, String numeroDocumento, String fechaNacimiento, String celular, String correoElectronico, String actividad, String pagaduria, String Contacto){
        return instrumented(TaskSimulador.class,nombresApellidos,numeroDocumento,fechaNacimiento,celular,correoElectronico,actividad,pagaduria,Contacto);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(DashboardForm.loading,isNotVisible()).forNoMoreThan(10).seconds(),
                WaitUntil.the(DashboardForm.saltar_intro,isVisible()).forNoMoreThan(10).seconds(),
                Click.on(DashboardForm.saltar_intro),
                WaitUntil.the(DashboardForm.loading,isNotVisible()).forNoMoreThan(10).seconds(),
                Click.on(DashboardForm.menu_simulador),
                Click.on(DashboardForm.nombres_apellidos),
                Enter.theValue(nombresApellidos).into(DashboardForm.nombres_apellidos),
                Click.on(DashboardForm.numero_documento),
                Enter.theValue(numeroDocumento).into(DashboardForm.numero_documento),
                Click.on(DashboardForm.fecha_nacimiento),
                Enter.theValue(fechaNacimiento).into(DashboardForm.fecha_nacimiento),
                Click.on(DashboardForm.numero_celular),
                Enter.theValue(celular).into(DashboardForm.numero_celular),
                Click.on(DashboardForm.correo),
                Enter.theValue(correoElectronico).into(DashboardForm.correo),
                Click.on(DashboardForm.actividad_cliente),
                Click.on(DashboardForm.actividad_cliente_select.of(actividad)),
                Click.on(DashboardForm.pagaduria),
                Enter.theValue(pagaduria).into(DashboardForm.pagaduria),
                Click.on(DashboardForm.pagaduria_select.of(pagaduria)),
                WaitUntil.the(DashboardForm.como_se_entero_de_ExcelCredit,isVisible()).forNoMoreThan(10).seconds(),
                Click.on(DashboardForm.como_se_entero_de_ExcelCredit),
                Click.on(DashboardForm.como_se_entero_de_ExcelCredit_select.of(Contacto))

                );
        System.out.println(" error ");

    }
}
