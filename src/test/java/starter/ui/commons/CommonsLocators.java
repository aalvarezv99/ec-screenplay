package starter.ui.commons;

import net.serenitybdd.screenplay.targets.Target;

public class CommonsLocators {
    public static final Target locatorByText = Target.the("Localizador de elemento por texto").locatedBy("//*[text()='{0}']");
    public static final Target botonSiguiente = Target.the("Boton de siguiente").locatedBy("//button[text() = 'Siguiente ']");
}
