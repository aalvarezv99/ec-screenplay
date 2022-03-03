package starter.ui.RegistroDeCliente;


import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class RegistroClienteForm {
    public static final Target inputCedulaCliente = Target.the("Pulsa el boton cargar").located(By.id("file"));
    public static final Target tituloFormulario = Target.the("Titulo del formulario").locatedBy("//h4[contains(text(),'Registro de Cliente')]");
    public static final Target inputCargaDocumentos = Target.the("input para carga de documentos").locatedBy("//*[@id='form']");
    public static final Target botonSiguiente   = Target.the("Boton de siguiente").locatedBy("//button[contains(text(),'Siguiente')]");
    public static final Target tipoDocumento   = Target.the("Tipo de documento").locatedBy("//div[@id='radio0']/div");
    public static final Target primernombre   = Target.the("caja de texto primer nombre").located(By.id("primerNombre"));
    public static final Target primerApellido   = Target.the("caja de texto primer apellido").located(By.id("primerApellido"));
    public static final Target fechaNacimiento   = Target.the("fecha de nacimiento").located(By.id("fechaNacimiento"));
    public static final Target Departamento   = Target.the("caja de texto departamento").located(By.id("state"));
    public static final Target Genero   = Target.the("Genero o sexo").locatedBy("//input[@id='genero0']//preceding-sibling::div");
    public static final Target identificacion  = Target.the("Caja de numero de documento de identificacion").located(By.id("identificacion"));
    public static final Target segundoNombre  = Target.the("Caja de texto de segundo nombre").located(By.id("segundoNombre"));
    public static final Target segundoApellido  = Target.the("Caja de texto de segundo apellido").located(By.id("segundoApellido"));
    public static final Target fechaExpedicionDoc  = Target.the("Caja de texto para fecha de expedicion de documento").located(By.id("fechaExpedicionDoc"));
    public static final Target ciudadExpedicionDoc  = Target.the("Caja de texto para ciudad de expedicion de documento").located(By.id("city"));
    public static final Target departamentoResidencia  = Target.the("Caja de texto para el departamento de residencia").located(By.id("state"));
    public static final Target ciudadResidencia  = Target.the("Caja de texto para el departamento de residencia").located(By.id("city"));
    public static final Target listResidencia  = Target.the("Lista departamento residencia").locatedBy("//div[text()='{0}']");
    public static final Target iconClosed = Target.the("icono cerrar").locatedBy("//div[@class='sc-hYAvag bNEMmX']/div[1]/div[1]/*");
    public static final Target iconClosedEndeudamiento = Target.the("icono cerrar endeudamiento").locatedBy("//div[@id='ContainerModalInfoErrors']/div[1]/div[1]/*");
    public static final Target buttonContinuar = Target.the("boton continuar").locatedBy("//button[text()='Continuar' and @id='bottom-action-button']");
    public static final Target buttonAceptarTerminos = Target.the("boton Aceptar Terminos").locatedBy("//button[text()='Aceptar' and @id='accept-terms']");

}
