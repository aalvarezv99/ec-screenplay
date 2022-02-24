package starter.ui.endeudamientoGlobal;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class EndeudamientoGlobalForm {
    public static final Target codigoAdo = Target.the("input para ingresar el código ado").located(By.id("adoSegmentCode"));
    public static final Target estrato = Target.the("Div para desplegar valores del select estrato").locatedBy("//label[text() = 'Estrato']/following-sibling::div");
    public static final Target tipoVivienda = Target.the("Div para desplegar valores del select Tipo de vivienda").locatedBy("//label[text() = 'Tipo de vivienda']/following-sibling::div");
    public static final Target claseVivienda = Target.the("Div para desplegar valores del select Clase de vivienda").locatedBy("//label[text() = 'Clase de vivienda']/following-sibling::div");
    public static final Target posicionHogar = Target.the("Div para desplegar valores del select Posición en el hogar").locatedBy("//label[contains(text(), 'en el hogar')]/following-sibling::div");
    public static final Target nivelEscolaridad = Target.the("Div para desplegar valores del select Nível de escolaridad").locatedBy("//label[contains(text(), 'de escolaridad')]/following-sibling::div");
    public static final Target descPrestacionales = Target.the("input descuentos prestancionales").locatedBy("//label[@for = 'descuentosPrestacionales']/following-sibling::input");
    public static final Target descNomina = Target.the("input descuentos de nómina").locatedBy("//label[@for = 'descuentosNomina']/following-sibling::input");
    public static final Target cuotasHipotecarias = Target.the("input cuotas hipotecarios centrales").locatedBy("//label[@for = 'cuotasHipotecarias']/following-sibling::input");
    public static final Target tipoDocumento = Target.the("Div para desplegar valores del select Tipo documento").locatedBy("//label[text() = 'Tipo documento']/following-sibling::div");
    public static final Target otrosIngresosCertificados = Target.the("div para saber si aparece nueva pantalla de certificados").locatedBy("//div[contains(text(), 'Endeudamiento global negativo')]");
    public static final Target inputOtrosIngresos = Target.the("Input para colocar ingresos adicionales").locatedBy("//label[text() = 'Ingresos adicionales certificados']/following-sibling::input");
}
