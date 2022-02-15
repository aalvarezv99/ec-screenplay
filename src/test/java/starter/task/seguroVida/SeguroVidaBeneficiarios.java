package starter.task.seguroVida;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;
import starter.ui.commons.CommonsLocators;
import starter.ui.dashboard.DashboardForm;
import starter.ui.seguroAP.SeguroApForm;
import starter.ui.seguroVida.SeguroVidaForm;

import java.util.Arrays;
import java.util.List;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SeguroVidaBeneficiarios implements Task {
    private final String nombreBeneficiario;
    private final String documentoBeneficiario;
    private final String celularBeneficiario;
    private final String departamento;
    private final String ciudad;

    public SeguroVidaBeneficiarios(String nombreBeneficiario, String documentoBeneficiario, String celularBeneficiario, String departamento, String ciudad) {
        this.nombreBeneficiario = nombreBeneficiario;
        this.documentoBeneficiario = documentoBeneficiario;
        this.celularBeneficiario = celularBeneficiario;
        this.departamento = departamento;
        this.ciudad = ciudad;
    }

    public static Performable withSeguroVidaBeneficiarios(String nombreBeneficiario, String documentoBeneficiario, String celularBeneficiario, String departamento, String ciudad) {
        return instrumented(SeguroVidaBeneficiarios.class, nombreBeneficiario, documentoBeneficiario, celularBeneficiario, departamento, ciudad);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        int agregarBeneficiarios = 2;
        int totalBeneficiarios = 3;
        List<String> porcentajes = Arrays.asList("35", "35", "30");
        // primero se deben agregar los beneficiarios
        for (int i = 0; i < agregarBeneficiarios; i++) {
            actor.attemptsTo(
                    WaitUntil.the(SeguroVidaForm.botonAgreagarBeneficiarios, isVisible()).forNoMoreThan(10).seconds(),
                    Scroll.to(SeguroVidaForm.botonAgreagarBeneficiarios),
                    Click.on(SeguroVidaForm.botonAgreagarBeneficiarios)
            );
        }
        for (int j = 0; j < totalBeneficiarios; j++) {
            actor.attemptsTo(
                    Scroll.to(SeguroVidaForm.inputNombreDelBeneficiario.of(String.valueOf(j))),
                    Enter.theValue(nombreBeneficiario).into(SeguroVidaForm.inputNombreDelBeneficiario.of(String.valueOf(j))),
                    Enter.theValue(documentoBeneficiario).into(SeguroVidaForm.inputDocumentoDelBeneficiario.of(String.valueOf(j))),
                    Enter.theValue(celularBeneficiario).into(SeguroVidaForm.inputCelularDelBeneficiario.of(String.valueOf(j))),
                    Enter.theValue(celularBeneficiario).into(SeguroVidaForm.inputCelularDelBeneficiario.of(String.valueOf(j))),
                    Enter.theValue(departamento).into(SeguroVidaForm.inputDepartamentoDelBeneficiario.of(String.valueOf(j))),
                    Click.on(SeguroVidaForm.optionDepartamento.of(String.valueOf(j))),
                    Enter.theValue(ciudad).into(SeguroVidaForm.inputCiudadDelBeneficiario.of(String.valueOf(j))),
                    Click.on(SeguroVidaForm.optionCiudad.of(String.valueOf(j))),
                    Enter.theValue(porcentajes.get(j)).into(SeguroVidaForm.inputPorcentajeDelBeneficiario.of(String.valueOf(j)))
            );
        }
        actor.attemptsTo(
                Click.on(CommonsLocators.botonSiguiente),
                WaitUntil.the(DashboardForm.loading, isNotVisible()).forNoMoreThan(20).seconds()

        );
        System.out.println(" punto de interrupción ");
    }
}
