package starter.ui.RegistroDeCliente;


import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class RegistroClienteForm {
    public static final Target inputCedulaCliente = Target.the("Pulsa el boton cargar").locatedBy("//input[@type='file']");
}
