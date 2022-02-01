package starter.task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.questions.Visibility;
import starter.ui.dashboard.DashboardForm;
import starter.ui.login.LoginForm;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class LoginTask implements Task {

    private final String username;
    private final String password;

    public LoginTask(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static Performable whithCredential(String username, String password) {
        return instrumented(LoginTask.class, username, password);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(LoginForm.boton_ingreso_portal, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(LoginForm.boton_ingreso_portal),
                Enter.theValue(username).into(LoginForm.caja_de_text_username),
                Enter.theValue(password).into(LoginForm.caja_de_text_password),
                Click.on(LoginForm.boton_ingreso_login),
                WaitUntil.the(DashboardForm.loading, isNotVisible()).forNoMoreThan(20).seconds()

        );
        Boolean clearCompleteButtonIsVisible = Visibility.of(DashboardForm.saltarIntro).viewedBy(actor).value();
        actor.attemptsTo(
                Check.whether(clearCompleteButtonIsVisible)
                        .andIfSo(
                                WaitUntil.the(DashboardForm.saltarIntro, isVisible()).forNoMoreThan(10).seconds(),
                                Click.on(DashboardForm.saltarIntro)
                        )
        );

    }
}
