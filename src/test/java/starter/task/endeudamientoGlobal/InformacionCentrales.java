package starter.task.endeudamientoGlobal;

import lombok.SneakyThrows;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Upload;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.questions.Visibility;
import net.serenitybdd.screenplay.waits.WaitUntil;
import starter.questions.EndeudamientoGlobalQuestion;
import starter.ui.commons.CommonsLocators;
import starter.ui.dashboard.DashboardForm;
import starter.ui.endeudamientoGlobal.EndeudamientoGlobalForm;

import java.nio.file.Path;
import java.nio.file.Paths;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class InformacionCentrales implements Task {
    private final String cuotaHipotecaria;
    private final String tipoDocNomina;
    private final String rutaPdf;
    private final String otrosIngresos;

    public InformacionCentrales(String cuotaHipotecaria, String tipoDocNomina, String rutaPdf, String otrosIngresos) {
        this.cuotaHipotecaria = cuotaHipotecaria;
        this.tipoDocNomina = tipoDocNomina;
        this.rutaPdf = rutaPdf;
        this.otrosIngresos = otrosIngresos;
    }

    public static Performable withInformacionCentrales(String cuotaHipotecaria, String tipoDocNomina, String rutaPdf, String otrosIngresos) {
        return instrumented(InformacionCentrales.class, cuotaHipotecaria, tipoDocNomina, rutaPdf, otrosIngresos);
    }

    @SneakyThrows
    @Override
    public <T extends Actor> void performAs(T actor) {
        Path doc = Paths.get(rutaPdf).toAbsolutePath();
        String maximoSugerido = "";
        int valueOtrosIngresos = 0;
        actor.attemptsTo(
                Enter.theValue(cuotaHipotecaria).into(EndeudamientoGlobalForm.cuotasHipotecarias),
                Click.on(EndeudamientoGlobalForm.tipoDocumento),
                Click.on(CommonsLocators.locatorByText.of(tipoDocNomina)),
                Upload.theFile(doc).to(CommonsLocators.inputFile),
                Click.on(CommonsLocators.botonSiguiente),
                WaitUntil.the(DashboardForm.loading, isNotVisible()).forNoMoreThan(10).seconds()
        );
        boolean debeIngresarOtrosIngresos = Visibility.of(EndeudamientoGlobalForm.otrosIngresosCertificados).viewedBy(actor).value();
        if (debeIngresarOtrosIngresos) {
            String text = String.valueOf(EndeudamientoGlobalQuestion.getOtrosIngresos().answeredBy(actor));
            maximoSugerido = text.replaceAll("[a-zA-Z.$/\\s]", "");
            valueOtrosIngresos = Math.min(Integer.parseInt(maximoSugerido), Integer.parseInt(otrosIngresos));
        }
        actor.attemptsTo(
                Check.whether(debeIngresarOtrosIngresos)
                        .andIfSo(
                                Enter.theValue(String.valueOf(valueOtrosIngresos)).into(EndeudamientoGlobalForm.inputOtrosIngresos),
                                Upload.theFile(doc).to(CommonsLocators.inputFile)
                        ),
                WaitUntil.the(CommonsLocators.botonSiguiente, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(CommonsLocators.botonSiguiente),
                WaitUntil.the(DashboardForm.loading, isNotVisible()).forNoMoreThan(10).seconds()
        );
        System.out.println(" punto de interrupción ");
    }
}
