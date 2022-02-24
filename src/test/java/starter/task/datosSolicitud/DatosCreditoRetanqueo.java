package starter.task.datosSolicitud;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.waits.WaitUntil;
import starter.ui.commons.CommonsFuntions;
import starter.ui.commons.CommonsLocators;
import starter.ui.dashboard.DashboardForm;
import starter.ui.datosSolicitud.DatosSolicitudForm;
import starter.ui.simulador.DatosFinancierosForm;

import java.util.List;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class DatosCreditoRetanqueo implements Task {
    private final String ingresosMensuales;
    private final String totalDescuentos;
    private final String totalDescuentosLey;
    private final String lineaDeCredito;
    private final String creditoPadre;
    private final String pagaduria;

    public DatosCreditoRetanqueo(String ingresosMensuales, String totalDescuentos, String totalDescuentosLey, String lineaDeCredito, String creditoPadre, String pagaduria) {
        this.ingresosMensuales = ingresosMensuales;
        this.totalDescuentos = totalDescuentos;
        this.totalDescuentosLey = totalDescuentosLey;
        this.lineaDeCredito = lineaDeCredito;
        this.creditoPadre = creditoPadre;
        this.pagaduria = pagaduria;
    }

    public static Performable withDatosCreditoRetanqueo(String ingresosMensuales, String totalDescuentos, String totalDescuentosLey, String lineaDeCredito, String creditoPadre, String pagaduria) {
        return instrumented(DatosCreditoRetanqueo.class, ingresosMensuales, totalDescuentos, totalDescuentosLey, lineaDeCredito, creditoPadre, pagaduria);
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        boolean seleccionarCreditoPadre = lineaDeCredito.contains("Retanqueo");
        actor.attemptsTo(
                WaitUntil.the(DatosSolicitudForm.pageDatosAdicionales.of("5"), isPresent()).forNoMoreThan(10).seconds(),
                Enter.theValue(ingresosMensuales).into(DatosSolicitudForm.ingresosMensuales),
                Enter.theValue(totalDescuentos).into(DatosSolicitudForm.totalDescuentos),
                Enter.theValue(totalDescuentosLey).into(DatosSolicitudForm.totalDescuentosLey),
                //
                Click.on(DatosSolicitudForm.lineaDeCredito),
                WaitUntil.the(DashboardForm.loading, isNotVisible()).forNoMoreThan(60).seconds(),
                Click.on(CommonsLocators.locatorByText.of(lineaDeCredito)),
                WaitUntil.the(DashboardForm.loading, isNotVisible()).forNoMoreThan(60).seconds()

        );

        List<WebElementFacade> listElementos = DatosFinancierosForm.selectCreditoMultiple.of(pagaduria).resolveAllFor(actor);
        if (listElementos.size() > 1) {
            listElementos.forEach(indexChebox -> actor.attemptsTo(Click.on(indexChebox)));
        } else {
            actor.attemptsTo(Check.whether(seleccionarCreditoPadre).andIfSo(Click.on(DatosFinancierosForm.selectCredito.of(creditoPadre))));
        }
        WaitUntil.the(DashboardForm.loading, isNotVisible()).forNoMoreThan(60).seconds();

        if (CommonsFuntions.limpiarCadena(lineaDeCredito).equals("Retanqueo libre inversion")
                || CommonsFuntions.limpiarCadena(lineaDeCredito).equals("Libre inversion")) {
            actor.attemptsTo(
                    Click.on(CommonsLocators.botonSiguiente)
            );
        }
        System.out.println("Fin Pagina 5/6 Datos Adicionales Credito");
    }
}
