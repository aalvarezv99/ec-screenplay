package starter.task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import starter.ui.dashboard.DashboardForm;
import starter.ui.simulador.ValoresCreditoForm;
import starter.ui.simulador.datosClienteForm;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ValoresCreditoTask implements Task {
    private final String montoSolicitado;
    private final String tasa;
    private final String plazo;
    private final String diasIntereses;

    public ValoresCreditoTask(String montoSolicitado, String tasa, String plazo, String diasIntereses) {
        this.montoSolicitado = montoSolicitado;
        this.tasa = tasa;
        this.plazo = plazo;
        this.diasIntereses = diasIntereses;
    }
    public static Performable withValoresCredito(String montoSolicitado, String tasa, String plazo, String diasIntereses){
        return instrumented(ValoresCreditoTask.class,montoSolicitado,tasa,plazo,diasIntereses);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(ValoresCreditoForm.montoSolicitado,isVisible()).forNoMoreThan(10).seconds(),
                Click.on(ValoresCreditoForm.montoSolicitado),
                Enter.theValue(montoSolicitado).into(ValoresCreditoForm.montoSolicitado),
                Click.on(ValoresCreditoForm.tasa),
                Click.on(ValoresCreditoForm.selectTasa.of(tasa)),
                Enter.theValue(plazo).into(ValoresCreditoForm.plazo),
                Enter.theValue(diasIntereses).into(ValoresCreditoForm.diasInteresesIniciales),
                Click.on(datosClienteForm.botonSiguiente)
        );
        System.out.println("Prueba");
    }
}
