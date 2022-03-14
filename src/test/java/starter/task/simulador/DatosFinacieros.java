package starter.task.simulador;

import net.serenitybdd.core.pages.WebElementFacade;
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
import java.util.List;

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
    private final String pagaduria;


    public DatosFinacieros(String ingresos, String descNomina, String descLey, String lineaCredito, String credito, String vlrCompras, String pagaduria) {
        this.ingresos = ingresos;
        this.descNomina = descNomina;
        this.descLey = descLey;
        this.lineaCredito = lineaCredito;
        this.credito = credito;
        this.vlrCompras = vlrCompras;
        this.pagaduria = pagaduria;
    }

    public static Performable withDatosFinancieros(String ingresos, String descLey, String descNomina, String lineaCredito, String Credito, String vlrCompras, String pagaduria) {
        return instrumented(DatosFinacieros.class, ingresos, descLey, descNomina, lineaCredito, Credito, vlrCompras, pagaduria);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        boolean seleccionarCreditoPadre = lineaCredito.contains("Retanqueo");
        boolean seleccionarValor = lineaCredito.contains("cartera") || lineaCredito.contains("saneamiento");


        actor.attemptsTo(
                WaitUntil.the(DatosFinancierosForm.ingresos, isVisible()).forNoMoreThan(240).seconds(),
                Click.on(DatosFinancierosForm.ingresos),
                Enter.theValue(ingresos).into(DatosFinancierosForm.ingresos),
                Click.on(DatosFinancierosForm.descuentosNomina),
                Enter.theValue(descNomina).into(DatosFinancierosForm.descuentosNomina),
                Click.on(DatosFinancierosForm.descuentosLey),
                Enter.theValue(descLey).into(DatosFinancierosForm.descuentosLey),
                Click.on(DatosFinancierosForm.lineaCredito),
                Click.on(DatosFinancierosForm.selectLinea.of(lineaCredito)),
                WaitUntil.the(DashboardForm.loading, isNotVisible()).forNoMoreThan(60).seconds()
        );

        List<WebElementFacade> listElementos = DatosFinancierosForm.selectCreditoMultiple.of(pagaduria).resolveAllFor(actor);
        if(listElementos.size()>1){
            listElementos.forEach(indexChebox -> actor.attemptsTo(Click.on(indexChebox)));
            WaitUntil.the(DashboardForm.loading, isNotVisible()).forNoMoreThan(60).seconds();
        } else {
            actor.attemptsTo(Check.whether(seleccionarCreditoPadre).andIfSo(Click.on(DatosFinancierosForm.selectCredito.of(credito))));
            WaitUntil.the(DashboardForm.loading, isNotVisible()).forNoMoreThan(60).seconds();
        }
        actor.attemptsTo(
                Check.whether(seleccionarValor)
                        .andIfSo(
                                WaitUntil.the(DatosFinancierosForm.vlrCompras.of("1"), isVisible()).forNoMoreThan(20).seconds(),
                                Scroll.to(DatosFinancierosForm.vlrCompras.of("1")),
                                Enter.theValue(vlrCompras).into(DatosFinancierosForm.vlrCompras.of("1"))
                        ),
                Click.on(DatosFinancierosForm.btnCalcular),
                WaitUntil.the(DashboardForm.loading, isNotVisible()).forNoMoreThan(60).seconds()
               // Click.on(DatosClienteForm.botonSiguiente)
        );
        System.out.println(" punto de interrupción ");
    }
}