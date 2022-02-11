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

public class DatosFinacieros implements Task {
    private final String ingresos;
    private final String descNomina;
    private final String descLey;
    private final String lineaCredito;
    private final String credito;
    private final String vlrCompras;

    public DatosFinacieros(String ingresos, String descNomina, String descLey, String lineaCredito, String credito, String vlrCompras) {
        this.ingresos = ingresos;
        this.descNomina = descNomina;
        this.descLey = descLey;
        this.lineaCredito = lineaCredito;
        this.credito = credito;
        this.vlrCompras = vlrCompras;
    }

    public static Performable withDatosFinancieros(String ingresos, String descLey, String descNomina, String lineaCredito, String Credito, String vlrCompras) {
        return instrumented(DatosFinacieros.class, ingresos, descLey, descNomina, lineaCredito, Credito, vlrCompras);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        boolean seleccionarCreditoPadre = lineaCredito.contains("Retanqueo");
        boolean seleccionarValor = lineaCredito.contains("cartera") || lineaCredito.contains("saneamiento");
        actor.attemptsTo(
<<<<<<< HEAD:src/test/java/starter/task/simulador/DatosFinacierosRetanqueo.java
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
=======
                WaitUntil.the(datosFinancierosForm.ingresos, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(datosFinancierosForm.ingresos),
                Enter.theValue(ingresos).into(datosFinancierosForm.ingresos),
                Click.on(datosFinancierosForm.descuentosNomina),
                Enter.theValue(descNomina).into(datosFinancierosForm.descuentosNomina),
                Click.on(datosFinancierosForm.descuentosLey),
                Enter.theValue(descLey).into(datosFinancierosForm.descuentosLey),
                Click.on(datosFinancierosForm.lineaCredito),
                Click.on(datosFinancierosForm.selectLinea.of(lineaCredito)),
                WaitUntil.the(DashboardForm.loading, isNotVisible()).forNoMoreThan(60).seconds(),
                Check.whether(seleccionarCreditoPadre)
                        .andIfSo(
                                Click.on(datosFinancierosForm.selectCredito.of(credito)),
                                WaitUntil.the(DashboardForm.loading, isNotVisible()).forNoMoreThan(10).seconds()
                        ),
                Check.whether(seleccionarValor)
                        .andIfSo(
                                WaitUntil.the(datosFinancierosForm.vlrCompras.of("1"), isVisible()).forNoMoreThan(20).seconds(),
                                Scroll.to(datosFinancierosForm.vlrCompras.of("1")),
                                Enter.theValue(vlrCompras).into(datosFinancierosForm.vlrCompras.of("1"))
                        ),
                Click.on(datosFinancierosForm.btnCalcular),
                WaitUntil.the(DashboardForm.loading, isNotVisible()).forNoMoreThan(10).seconds(),
                Click.on(datosClienteForm.botonSiguiente)
>>>>>>> eea10548a3ce4f5f3ba2830d2b69e69faf01f460:src/test/java/starter/task/simulador/DatosFinacieros.java
        );
        System.out.println(" punto de interrupción ");
    }
}
