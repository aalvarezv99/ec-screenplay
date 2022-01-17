package starter.navigation;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class NavigateTo {
    public static Performable theDigicreditoGoHomePage() {
        return Task.where("{0} abre pagina de home Digicredito",
                Open.browserOn().the(DigiCreditoGoHomePage.class));
    }
}
