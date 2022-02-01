package starter.ui.DatosSolicitud;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class DatosSolicitudForm {
    public static final Target paisNacimiento = Target.the("input para ingresar el pais de nacimiento").locatedBy("//input[@id='paisNacimiento']");
    public static final Target lugarDeNacimiento = Target.the("input para ingresar el lugar de nacimiento").locatedBy("//input[@id='lugarNacimiento']");
    public static final Target nacionalidad = Target.the("input para ingresar nacionalidad").locatedBy("//input[@id='nacionalidad']");
    public static final Target profesion = Target.the("input para ingresar profesion").locatedBy("//input[@id='profesion']");
    public static final Target estadoCivil = Target.the("input para ingresar profesion").locatedBy("//label[text()='Estado civil']//ancestor::div[@id='select']");

}
