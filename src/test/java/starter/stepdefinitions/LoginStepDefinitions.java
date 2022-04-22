package starter.stepdefinitions;

import io.cucumber.java.es.Y;
import starter.navigation.NavigateTo;
import starter.task.LoginTask;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class LoginStepDefinitions {


    @Y("^ingresa su usuario (.*) y contrasena (.*)")
    public void ingresa_su_usuario_y_contrasena(String usuario,String contrasena) {

        theActorInTheSpotlight().attemptsTo(
                NavigateTo.theDigicreditoGoHomePage(),
                LoginTask.whithCredential(usuario,contrasena)
        );

    }
}
