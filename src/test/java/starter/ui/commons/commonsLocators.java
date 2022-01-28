package starter.ui.commons;

import net.serenitybdd.screenplay.targets.Target;

public class commonsLocators {
    public static final Target locatorByText = Target.the("Localizador de elemento por texto").locatedBy("//*[text()='{0}']");
}
