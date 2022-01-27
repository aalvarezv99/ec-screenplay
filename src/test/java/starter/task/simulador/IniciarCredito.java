package starter.task.simulador;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import starter.ui.dashboard.DashboardForm;
import starter.ui.simulador.ResultadoForm;
import starter.ui.simulador.datosClienteForm;
import starter.ui.simulador.datosFinancierosForm;

import java.sql.SQLOutput;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class IniciarCredito implements Task {

    public static Performable withDatosIniciarCredito() {
        return instrumented(IniciarCredito.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        System.out.println(" pausa ");
        actor.attemptsTo(
                WaitUntil.the(ResultadoForm.iniciarSolicitud,isVisible()).forNoMoreThan(10).seconds(),
                Click.on(ResultadoForm.iniciarSolicitud),
                WaitUntil.the(DashboardForm.loading,isNotVisible()).forNoMoreThan(60).seconds()

        );
    }
}
