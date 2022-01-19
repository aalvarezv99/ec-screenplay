package starter.stepdefinitions;

import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import starter.navigation.NavigateTo;
import starter.questions.DashboardPresente;
import starter.task.LoginTask;
import starter.ui.dashboard.DashboardForm;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class LoginStepDefinitions {


    @Y("^ingresa su usuario (.*) y contrasena (.*)")
    public void ingresa_su_usuario_y_contrasena(String usuario,String contrasena) {

        theActorInTheSpotlight().attemptsTo(
                NavigateTo.theDigicreditoGoHomePage(),
                LoginTask.whithCredential(usuario,contrasena)
        );
    }
}
