package starter.task.endeudamientoGlobal;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.questions.Visibility;
import net.serenitybdd.screenplay.waits.WaitUntil;
import starter.ui.RegistroDeCliente.RegistroClienteForm;
import starter.ui.commons.CommonsLocators;
import starter.ui.dashboard.DashboardForm;
import starter.ui.endeudamientoGlobal.EndeudamientoGlobalForm;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;

public class InformacionBasica implements Task {
    private final String codigoAdo;
    private final String estrato;
    private final String tipoVivienda;
    private final String claseVivienda;
    private final String posicionHogar;
    private final String nivelEscolaridad;

    public InformacionBasica(String codigoAdo, String estrato, String tipoVivienda, String claseVivienda, String posicionHogar, String nivelEscolaridad) {
        this.codigoAdo = codigoAdo;
        this.estrato = estrato;
        this.tipoVivienda = tipoVivienda;
        this.claseVivienda = claseVivienda;
        this.posicionHogar = posicionHogar;
        this.nivelEscolaridad = nivelEscolaridad;
    }

    public static Performable withInformacionBasica(String codigoAdo, String estrato, String tipoVivienda, String claseVivienda, String posicionHogar, String nivelEscolaridad) {
        return instrumented(InformacionBasica.class, codigoAdo, estrato, tipoVivienda, claseVivienda, posicionHogar, nivelEscolaridad);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Boolean modalValidacionDatos = Visibility.of(RegistroClienteForm.iconClosedEndeudamiento).viewedBy(actor).value();
        actor.attemptsTo(
                WaitUntil.the(DashboardForm.loading, isNotVisible()).forNoMoreThan(120).seconds(),
                Check.whether(modalValidacionDatos)
                        .andIfSo(Click.on(RegistroClienteForm.iconClosedEndeudamiento))
        );

        actor.attemptsTo(
                 //Enter.theValue(codigoAdo).into(EndeudamientoGlobalForm.codigoAdo),
                Click.on(EndeudamientoGlobalForm.estrato),
                Click.on(CommonsLocators.locatorByText.of(estrato)),
                Click.on(EndeudamientoGlobalForm.tipoVivienda),
                Click.on(CommonsLocators.locatorByText.of(tipoVivienda)),
                Click.on(EndeudamientoGlobalForm.claseVivienda),
                Click.on(CommonsLocators.locatorByText.of(claseVivienda)),
                Click.on(EndeudamientoGlobalForm.posicionHogar),
                Click.on(CommonsLocators.locatorByText.of(posicionHogar)),
                Click.on(EndeudamientoGlobalForm.nivelEscolaridad),
                Click.on(CommonsLocators.locatorByText.of(nivelEscolaridad)),
                Click.on(CommonsLocators.botonSiguiente),
                WaitUntil.the(DashboardForm.loading, isNotVisible()).forNoMoreThan(120).seconds()
        );
        System.out.println(" punto de interrupción ");
    }
}
