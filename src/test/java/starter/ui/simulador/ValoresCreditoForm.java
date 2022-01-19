package starter.ui.simulador;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class ValoresCreditoForm {

    public static final Target montoSolicitado = Target.the("Caja de texto para ingresar el monto solicitado").locatedBy("//div[@id='input-amount']/child::input[1]");
    public static final Target tasa = Target.the("Lista desplegable para ingresar la tasa").locatedBy("//div[@id='select']/child::div");
    public static final Target selectTasa   = Target.the("Seleccionar el dato de la tasa en el formulario").locatedBy("//div[contains(text(),'{0}')]");
    public static final Target plazo   = Target.the("Caja de texto para ingresar el plazo en meses").located(By.id("plazo"));
    public static final Target diasInteresesIniciales   = Target.the("Caja de texto para ingresar los dias de intereses iniciales").located(By.id("diasInteresesIniciales"));


}
