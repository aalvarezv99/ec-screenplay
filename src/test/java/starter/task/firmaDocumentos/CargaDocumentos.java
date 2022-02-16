package starter.task.firmaDocumentos;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.Upload;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.waits.WaitUntil;
import starter.ui.commons.CommonsLocators;
import starter.ui.dashboard.DashboardForm;
import starter.ui.firmaDocumentos.FirmaDocumentosForm;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class CargaDocumentos implements Task {
    private final String rutaPdf;

    public CargaDocumentos(String rutaPdf) {
        this.rutaPdf = rutaPdf;
    }

    public static Performable withCargaDocumentos(String rutaPdf) {
        return instrumented(CargaDocumentos.class, rutaPdf);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Path doc = Paths.get(rutaPdf).toAbsolutePath();
        List<String> files = Arrays.asList("Autorizacion de Descuento", "Documento adicional");
        String defaultDescription = "pdf documento adicional";
        for (String file : files) {
            actor.attemptsTo(
                    WaitUntil.the(DashboardForm.loading, isNotVisible()).forNoMoreThan(60).seconds(),
                    Click.on(FirmaDocumentosForm.tipoDocumentoSelect),
                    WaitUntil.the(DashboardForm.loading, isNotVisible()).forNoMoreThan(60).seconds(),
                    Click.on(CommonsLocators.locatorByText.of(file)),
                    Check.whether(file.equals("Documento adicional"))
                            .andIfSo(
                                    Enter.theValue(defaultDescription).into(FirmaDocumentosForm.inputDescripcionDoc)
                            ),
                    Upload.theFile(doc).to(CommonsLocators.inputFile),
                    WaitUntil.the(DashboardForm.loading, isNotVisible()).forNoMoreThan(60).seconds(),
                    Click.on(FirmaDocumentosForm.divFile),
                    WaitUntil.the(DashboardForm.loading, isNotVisible()).forNoMoreThan(60).seconds()
            );
        }
        actor.attemptsTo(
                Scroll.to(FirmaDocumentosForm.btnContinuar),
                Click.on(FirmaDocumentosForm.btnContinuar),
                WaitUntil.the(DashboardForm.loading, isNotVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(FirmaDocumentosForm.btnRadicarCredito, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(FirmaDocumentosForm.btnRadicarCredito),
                WaitUntil.the(DashboardForm.loading, isNotVisible()).forNoMoreThan(60).seconds()
        );
        System.out.println(" punto de interrupción ");
    }
}
