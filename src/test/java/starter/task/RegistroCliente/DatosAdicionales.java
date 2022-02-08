package starter.task.RegistroCliente;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;
import starter.ui.RegistroDeCliente.RegistroClienteForm;
import starter.ui.dashboard.DashboardForm;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class DatosAdicionales implements Task {

    private final String departamentoExpedicionCC;
    private final String ciudadExpedicionCC;

    public DatosAdicionales(String departamentoExpedicionCC, String ciudadExpedicionCC) {
        this.departamentoExpedicionCC = departamentoExpedicionCC;
        this.ciudadExpedicionCC = ciudadExpedicionCC;
    }

    public static Performable whithDatosAdicionales(String departamentoExpedicionCC, String ciudadExpedicionCC){
        return instrumented(DatosAdicionales.class,departamentoExpedicionCC,ciudadExpedicionCC);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(RegistroClienteForm.departamentoResidencia, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(departamentoExpedicionCC).into(RegistroClienteForm.departamentoResidencia),
                Hit.the(Keys.ENTER).keyIn(RegistroClienteForm.departamentoResidencia),
                Click.on(RegistroClienteForm.listResidencia.of(departamentoExpedicionCC)),
                WaitUntil.the(DashboardForm.loading, isNotVisible()).forNoMoreThan(20).seconds(),
                Enter.theValue(ciudadExpedicionCC).into(RegistroClienteForm.ciudadResidencia),
                Click.on(RegistroClienteForm.listResidencia.of(ciudadExpedicionCC)),
                Click.on(RegistroClienteForm.botonSiguiente),
                WaitUntil.the(DashboardForm.loading, isNotVisible()).forNoMoreThan(190).seconds(),
                WaitUntil.the(RegistroClienteForm.buttonContinuar, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(RegistroClienteForm.buttonContinuar),
                WaitUntil.the(DashboardForm.loading, isNotVisible()).forNoMoreThan(20).seconds(),
                WaitUntil.the(RegistroClienteForm.buttonAceptarTerminos, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(RegistroClienteForm.buttonAceptarTerminos),
                WaitUntil.the(DashboardForm.loading, isNotVisible()).forNoMoreThan(20).seconds()

        );

    }
}
