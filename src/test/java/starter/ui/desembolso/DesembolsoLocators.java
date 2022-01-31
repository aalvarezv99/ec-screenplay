package starter.ui.desembolso;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class DesembolsoLocators {
    public static final Target modalidadDesembolso = Target.the("radio button modalidad desembolso").locatedBy("//h6[text() = '{0}']/preceding-sibling::div");
    public static final Target tipoCliente = Target.the("Div para desplegar valores del select Tipo cliente").locatedBy("//label[text() = 'Tipo de cliente']/following-sibling::div");
}
