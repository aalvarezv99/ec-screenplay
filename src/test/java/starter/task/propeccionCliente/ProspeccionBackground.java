package starter.task.propeccionCliente;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;
import starter.ui.dashboard.DashboardForm;
import starter.ui.prospeccion.ProspeccionUI;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ProspeccionBackground implements Task {

    public static Performable whithProspeccionBackground(){
        return instrumented(ProspeccionBackground.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(DashboardForm.loading, isNotVisible()).forNoMoreThan(120).seconds(),
                WaitUntil.the(ProspeccionUI.paginasConsulta, isVisible()).forNoMoreThan(60).seconds()
        );

        String value = Text.of(ProspeccionUI.paginasConsulta).viewedBy(actor).asString()
                .replace("1","").replace("/","").replace(" ","");
        int paginas = Integer.parseInt(value);
        actor.attemptsTo(WaitUntil.the(ProspeccionUI.botonSiguiente, isVisible()).forNoMoreThan(60).seconds());
        for(int i=1;i<paginas;i++){
            actor.attemptsTo(  Click.on(ProspeccionUI.botonSiguiente));
        }
        actor.attemptsTo(
                Click.on(ProspeccionUI.botonContinuar),
                WaitUntil.the(DashboardForm.loading, isNotVisible()).forNoMoreThan(120).seconds(),
                Click.on(ProspeccionUI.seguirflujoContinuar),
                WaitUntil.the(DashboardForm.loading, isNotVisible()).forNoMoreThan(120).seconds()
        );

    }
}
