package starter.ui.RegistroDeCliente;


import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class RegistroClienteForm {
    public static final Target inputCedulaCliente = Target.the("Pulsa el boton cargar").located(By.id("file"));
    public static final Target tituloFormulario = Target.the("Titulo del formulario").locatedBy("//h4[contains(text(),'Registro de Cliente')]");
    public static final Target inputCargaDocumentos = Target.the("input para carga de documentos").locatedBy("//*[@id='form']");
    public static final Target botonSiguiente   = Target.the("Boton de siguiente").located(By.id("submit"));
    

}
