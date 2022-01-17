package starter.stepdefinitions;

import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import starter.navigation.NavigateTo;
import starter.questions.DashboardPresente;
import starter.task.Tasklogin;
import starter.ui.dashboard.DashboardForm;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.hamcrest.core.IsEqual.equalTo;

public class LoginStepDefinitions {


    @Y("^ingresa su usuario (.*) y contrasena (.*)")
    public void ingresa_su_usuario_y_contrasena(String usuario,String contrasena) {

        theActorInTheSpotlight().attemptsTo(
                NavigateTo.theDigicreditoGoHomePage(),
                Tasklogin.whithCredential(usuario,contrasena)
        );
    }

    @Entonces("ingresa a Digicredito")
    public void ingresa_a_digicredito() {
       System.out.println("*********** "+ DashboardPresente.botonradicado().answeredBy(theActorInTheSpotlight()));
//       theActorInTheSpotlight().should(
//           seeThat("El boton Solicitudes Radicadas esta presente", DashboardPresente.botonradicado(),equalTo("Solicitudes Radicadas"))
//       );
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(DashboardForm.loading,isVisible()).forNoMoreThan(10).seconds(),
                Ensure.that(DashboardForm.loading).isDisplayed()
                );
    }
}
