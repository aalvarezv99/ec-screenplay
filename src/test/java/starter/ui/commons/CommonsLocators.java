package starter.ui.commons;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CommonsLocators {
    public static final Target locatorByText = Target.the("Localizador de elemento por texto").locatedBy("//*[text()='{0}']");
    public static final Target botonSiguiente = Target.the("Boton de siguiente").located(By.id("submit"));
}
