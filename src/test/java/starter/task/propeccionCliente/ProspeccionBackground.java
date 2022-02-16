package starter.task.propeccionCliente;

import lombok.SneakyThrows;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;
import starter.ui.dashboard.DashboardForm;
import starter.ui.endeudamientoGlobal.EndeudamientoGlobalForm;
import starter.ui.prospeccion.ProspeccionUI;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ProspeccionBackground implements Task {

    public static Performable whithProspeccionBackground() {
        return instrumented(ProspeccionBackground.class);
    }

    @SneakyThrows
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(DashboardForm.loading, isNotVisible()).forNoMoreThan(120).seconds(),
                WaitUntil.the(ProspeccionUI.paginasConsulta, isVisible()).forNoMoreThan(10).seconds()
        );

        String textPage = Text.of(ProspeccionUI.paginasConsulta).viewedBy(actor).asString().replace(" ", "");
        int paginas = Integer.parseInt(textPage.split("/")[1]);
        actor.attemptsTo(WaitUntil.the(ProspeccionUI.botonSiguiente, isVisible()).forNoMoreThan(10).seconds());
        for (int i = 1; i < paginas; i++) {
            actor.attemptsTo(Click.on(ProspeccionUI.botonSiguiente));
            Thread.currentThread().sleep(1000);
        }
        actor.attemptsTo(
                Scroll.to(ProspeccionUI.botonContinuar),
                Click.on(ProspeccionUI.botonContinuar),
                WaitUntil.the(DashboardForm.loading, isNotVisible()).forNoMoreThan(120).seconds(),
                Click.on(ProspeccionUI.seguirflujoContinuar),
                WaitUntil.the(DashboardForm.loading, isNotVisible()).forNoMoreThan(120).seconds(),
                WaitUntil.the(EndeudamientoGlobalForm.codigoAdo, isVisible()).forNoMoreThan(10).seconds()
        );

    }
}
