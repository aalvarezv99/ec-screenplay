package starter.task.operacionesIntPEPS;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import starter.ui.commons.CommonsLocators;
import starter.ui.dashboard.DashboardForm;
import starter.ui.operacionesIntPEPS.OperacionesIntPEPSForm;
import starter.ui.seguroAP.SeguroApForm;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class PersonaExsPoliticamente implements Task {
    private final String funcionarioPublico;
    private final String recursosPublicos;
    private final String expuestoPoliticamente;
    private final String fechaExpuesto;

    public PersonaExsPoliticamente(String funcionarioPublico, String recursosPublicos, String expuestoPoliticamente, String fechaExpuesto) {
        this.funcionarioPublico = funcionarioPublico;
        this.recursosPublicos = recursosPublicos;
        this.expuestoPoliticamente = expuestoPoliticamente;
        this.fechaExpuesto = fechaExpuesto;
    }

    public static Performable whithpersonaExsPoliticamente(String funcionarioPublico, String recursosPublicos, String expuestoPoliticamente, String fechaExpuesto) {
        return instrumented(PersonaExsPoliticamente.class, funcionarioPublico, recursosPublicos, expuestoPoliticamente, fechaExpuesto);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(OperacionesIntPEPSForm.funcionarioPublico.of(funcionarioPublico)),
                Click.on(OperacionesIntPEPSForm.recursosPublicos.of(recursosPublicos)),
                Click.on(OperacionesIntPEPSForm.expuestoPoliticamente.of(expuestoPoliticamente)),
                Enter.theValue(fechaExpuesto).into(OperacionesIntPEPSForm.fechapoliticamente),
                Click.on(CommonsLocators.botonSiguiente),
                WaitUntil.the(DashboardForm.loading, isNotVisible()).forNoMoreThan(20).seconds(),
                WaitUntil.the(SeguroApForm.continuar, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(SeguroApForm.continuar)
        );
    }
}