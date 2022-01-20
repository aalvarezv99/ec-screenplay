package starter.task.simulador;

import lombok.SneakyThrows;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import starter.ui.dashboard.DashboardForm;
import starter.ui.simulador.datosFinancierosForm;
import starter.ui.simulador.datosClienteForm;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class DatosFinancieros implements Task {
    private final String ingresos;
    private final String descNomina;
    private final String descLey;
    private final String lineaCredito;

    public DatosFinancieros(String ingresos, String descNomina, String descLey, String lineaCredito) {
        this.ingresos = ingresos;
        this.descNomina = descNomina;
        this.descLey = descLey;
        this.lineaCredito = lineaCredito;
    }

    public static Performable withDatosFinancieros(String ingresos, String descLey, String descNomina, String lineaCredito) {
        return instrumented(DatosFinancieros.class, ingresos, descLey, descNomina, lineaCredito);
    }

    @SneakyThrows
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(datosFinancierosForm.ingresos,isVisible()).forNoMoreThan(10).seconds(),
                Click.on(datosFinancierosForm.ingresos),
                Enter.theValue(ingresos).into(datosFinancierosForm.ingresos),
                Click.on(datosFinancierosForm.descuentosNomina),
                Enter.theValue(descNomina).into(datosFinancierosForm.descuentosNomina),
                Click.on(datosFinancierosForm.descuentosLey),
                Enter.theValue(descLey).into(datosFinancierosForm.descuentosLey),
                Click.on(datosFinancierosForm.lineaCredito),
                Click.on(datosFinancierosForm.selectLinea.of(lineaCredito)),
                Click.on(datosFinancierosForm.btnCalcular),
                WaitUntil.the(DashboardForm.loading,isNotVisible()).forNoMoreThan(10).seconds(),
                Click.on(datosClienteForm.botonSiguiente)
        );

    }
}
