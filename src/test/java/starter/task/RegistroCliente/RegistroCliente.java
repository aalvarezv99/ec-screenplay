package starter.task.RegistroCliente;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.questions.Visibility;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;
import starter.ui.RegistroDeCliente.RegistroClienteForm;
import starter.ui.dashboard.DashboardForm;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class RegistroCliente implements Task {

    private final String numeroDocumento;
    private final String primerNombre;
    private final String segundoNombre;
    private final String primerApellido;
    private final String segundoApellido;
    private final String fechaNacimiento;
    private final String fechaExpedicion;
    private final String departamentoExpedicionCC;
    private final String ciudadExpedicionCC;
    private final String genero;

    public RegistroCliente(String numeroDocumento,String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, String fechaNacimiento, String fechaExpedicion, String departamentoExpedicionCC, String ciudadExpedicionCC, String genero) {
        this.numeroDocumento = numeroDocumento;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaExpedicion = fechaExpedicion;
        this.departamentoExpedicionCC = departamentoExpedicionCC;
        this.ciudadExpedicionCC = ciudadExpedicionCC;
        this.genero = genero;
    }

    public static Performable whithRegistroCliente(String numeroDocumento, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, String fechaNacimiento, String fechaExpedicion, String departamentoExpedicionCC, String ciudadExpedicionCC, String genero){
        return instrumented(RegistroCliente.class,numeroDocumento,primerNombre,segundoNombre,primerApellido,segundoApellido,fechaNacimiento,fechaExpedicion,departamentoExpedicionCC,ciudadExpedicionCC,genero);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Boolean modalValidacionDatos = Visibility.of(RegistroClienteForm.iconClosed).viewedBy(actor).value();
        actor.attemptsTo(
                Check.whether(modalValidacionDatos)
                        .andIfSo(Click.on(RegistroClienteForm.iconClosed))
        );
        actor.attemptsTo(
                WaitUntil.the(RegistroClienteForm.tipoDocumento, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(RegistroClienteForm.tipoDocumento),
                Enter.theValue(primerNombre).into(RegistroClienteForm.primernombre),
                Enter.theValue(primerApellido).into(RegistroClienteForm.primerApellido),
                Enter.theValue(fechaNacimiento).into(RegistroClienteForm.fechaNacimiento),
                Scroll.to(RegistroClienteForm.Genero),
                Click.on(RegistroClienteForm.Genero),
                Enter.theValue(numeroDocumento).into(RegistroClienteForm.identificacion),
                Enter.theValue(segundoNombre).into(RegistroClienteForm.segundoNombre),
                Enter.theValue(segundoApellido).into(RegistroClienteForm.segundoApellido),
                Enter.theValue(fechaExpedicion).into(RegistroClienteForm.fechaExpedicionDoc),
                Enter.theValue(departamentoExpedicionCC).into(RegistroClienteForm.Departamento),
                Click.on(RegistroClienteForm.listResidencia.of(departamentoExpedicionCC)),
                Hit.the(Keys.ENTER).keyIn(RegistroClienteForm.Departamento),
                WaitUntil.the(DashboardForm.loading, isNotVisible()).forNoMoreThan(20).seconds(),
                Enter.theValue(ciudadExpedicionCC).into(RegistroClienteForm.ciudadExpedicionDoc),
                Click.on(RegistroClienteForm.listResidencia.of(ciudadExpedicionCC)),
                Scroll.to(RegistroClienteForm.botonSiguiente),
                Click.on(RegistroClienteForm.botonSiguiente)
        );

    }
}
