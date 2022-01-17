package starter.ui.login;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginForm {

    public static final Target boton_ingreso_portal  = Target.the("Boton para el primer ingreso al portal").located(By.id("login-button"));
    public static final Target caja_de_text_username = Target.the("Caja de texto para usuario de sesion").located(By.id("username"));
    public static final Target caja_de_text_password = Target.the("Caja de texto para el password").located(By.id("password"));
    public static final Target boton_ingreso_login   = Target.the("Boton para iniciar sesion").located(By.id("kc-login"));




}
