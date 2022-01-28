package starter.task.endeudamientoGlobal;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import starter.ui.commons.CommonsLocators;
import starter.ui.endeudamientoGlobal.EndeudamientoGlobalForm;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class InformacionCentrales implements Task {
    private final String cuotaHipotecaria;
    private final String tipoDocNomina;

    public InformacionCentrales(String cuotaHipotecaria, String tipoDocNomina) {
        this.cuotaHipotecaria = cuotaHipotecaria;
        this.tipoDocNomina = tipoDocNomina;
    }

    public static Performable withInformacionCentrales(String cuotaHipotecaria, String tipoDocNomina) {
        return instrumented(InformacionCentrales.class, cuotaHipotecaria, tipoDocNomina);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(cuotaHipotecaria).into(EndeudamientoGlobalForm.cuotasHipotecarias),
                Click.on(EndeudamientoGlobalForm.tipoDocumento),
                Click.on(CommonsLocators.locatorByText.of(tipoDocNomina))
        );
        System.out.println(" punto de interrupción ");
    }
}
