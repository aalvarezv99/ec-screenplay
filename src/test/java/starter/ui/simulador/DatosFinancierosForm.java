package starter.ui.simulador;

import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.core.annotations.findby.By;

public class DatosFinancierosForm {
    public static final Target ingresos = Target.the("Campo ingresos paso datos financieros simulador").locatedBy("//div[@id='input-amount']/child::input[1]");
    public static final Target descuentosNomina = Target.the("Campo descuento de nomina paso datos financieros simulador").locatedBy("//label[text() = 'Total descuentos']/following-sibling::input[1]");
    public static final Target descuentosLey = Target.the("Campo ingresos paso datos financieros simulador").locatedBy("//label[text() = 'Total descuentos de ley']/following-sibling::input[1]");
    public static final Target lineaCredito = Target.the("Campo línea de credito paso datos financieros simulador").locatedBy("//div[@id='select']/child::div");
    public static final Target selectLinea = Target.the("Seleccionar la linea de credito a diligenciar").locatedBy("//div[text() = '{0}']");
    public static final Target btnCalcular = Target.the("botón calcular capacidad").located(By.id("calculate"));
    public static final Target selectCredito = Target.the("Seleccionar el credito").locatedBy("//h6[text()='{0}']//preceding-sibling::div");
    public static final Target vlrCompras = Target.the("Campo para ingresar los valores de la cartera").locatedBy("//label[text() = '{0}']/parent::div/following-sibling::div/child::input[1]");

}
