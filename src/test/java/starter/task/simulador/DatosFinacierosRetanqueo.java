package starter.task.simulador;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.waits.WaitUntil;
import starter.ui.dashboard.DashboardForm;
import starter.ui.simulador.DatosClienteForm;
import starter.ui.simulador.DatosFinancierosForm;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class DatosFinacierosRetanqueo implements Task {
    private final String ingresos;
    private final String descNomina;
    private final String descLey;
    private final String lineaCredito;
    private final String credito;
    private final String vlrCompras;

    public DatosFinacierosRetanqueo(String ingresos, String descNomina, String descLey, String lineaCredito, String credito, String vlrCompras) {
        this.ingresos = ingresos;
        this.descNomina = descNomina;
        this.descLey = descLey;
        this.lineaCredito = lineaCredito;
        this.credito = credito;
        this.vlrCompras = vlrCompras;
    }

    public static Performable withDatosFinancierosRetanqueo(String ingresos, String descLey, String descNomina, String lineaCredito,String Credito, String vlrCompras) {
        return instrumented(DatosFinacierosRetanqueo.class, ingresos, descLey, descNomina, lineaCredito, Credito, vlrCompras);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(DatosFinancierosForm.ingresos,isVisible()).forNoMoreThan(10).seconds(),
                Click.on(DatosFinancierosForm.ingresos),
                Enter.theValue(ingresos).into(DatosFinancierosForm.ingresos),
                Click.on(DatosFinancierosForm.descuentosNomina),
                Enter.theValue(descNomina).into(DatosFinancierosForm.descuentosNomina),
                Click.on(DatosFinancierosForm.descuentosLey),
                Enter.theValue(descLey).into(DatosFinancierosForm.descuentosLey),
                Click.on(DatosFinancierosForm.lineaCredito),
                Click.on(DatosFinancierosForm.selectLinea.of(lineaCredito)),
                WaitUntil.the(DashboardForm.loading,isNotVisible()).forNoMoreThan(60).seconds(),
                Click.on(DatosFinancierosForm.selectCredito.of(credito)),
                WaitUntil.the(DashboardForm.loading, isNotVisible()).forNoMoreThan(10).seconds()
        );
        //Se crea la accion para que valide el tipo de credito y puedan agregarse las carteras
        actor.attemptsTo(
                Click.on(DatosFinancierosForm.vlrCompras.of("1")),
                Check.whether(!lineaCredito.equals("Libre inversion")|| !lineaCredito.equals("Retanqueo libre inversión"))
                        .andIfSo(
                                WaitUntil.the(DatosFinancierosForm.vlrCompras.of("1"), isVisible()).forNoMoreThan(20).seconds(),
                                Scroll.to(DatosFinancierosForm.vlrCompras.of("1")),
                                Click.on(DatosFinancierosForm.vlrCompras.of("1")),
                                Enter.theValue(vlrCompras).into(DatosFinancierosForm.vlrCompras.of("1"))
                        ),
                Click.on(DatosFinancierosForm.btnCalcular),
                WaitUntil.the(DashboardForm.loading,isNotVisible()).forNoMoreThan(10).seconds(),
                Click.on(DatosClienteForm.botonSiguiente)
        );
    }
}
