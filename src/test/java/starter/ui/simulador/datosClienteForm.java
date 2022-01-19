package starter.ui.simulador;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class datosClienteForm {

    public static final Target oficinaAsesor   = Target.the("Lista desplegable para ingresar la oficina del asesor").locatedBy("//span[text()='Oficina Asesor']/following-sibling::div/child::span[text()='Seleccionar...']");
    public static final Target selectsDatoFormulario   = Target.the("Seleccionar el dato en el formulario").locatedBy("//div[text()='{0}']");
    public static final Target nombresApellidos  = Target.the("Caja de texto de los nombres y apellidos").located(By.id("nombres"));
    public static final Target numeroDocumento   = Target.the("Caja de texto para ingresar el numero de documento de identidad").located(By.id("identificacion"));
    public static final Target fechaNacimiento   = Target.the("Caja de texto para ingresar la fecha de nacimiento").located(By.id("fechaNacimiento"));
    public static final Target numeroCelular   = Target.the("Caja de texto para ingresar el numero de celular").located(By.id("celular"));
    public static final Target correo   = Target.the("Caja de texto para ingresar el correo electronico").located(By.id("email"));
    public static final Target actividadCliente   = Target.the("Lista desplegable para ingresar la actividad del cliente").locatedBy("//label[text()='Actividad']/following-sibling::div/child::div[text()='Seleccionar...']");
    public static final Target pagaduria   = Target.the("Caja de texto para ingresar la pagaduria del cliente").located(By.id("pagaduria"));
    public static final Target comoSeEnteroExcelCredit   = Target.the("Lista desplegable para ingresar Cómo se enteró de ExcelCredit").locatedBy("//label[contains(text(),'de ExcelCredit')]/following-sibling::div/child::div[text()='Seleccionar...']");
    public static final Target botonSiguiente   = Target.the("Boton de siguiente").located(By.id("submit"));

}
