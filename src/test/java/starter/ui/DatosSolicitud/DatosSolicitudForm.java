package starter.ui.DatosSolicitud;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class DatosSolicitudForm {
    public static final Target paisNacimiento = Target.the("input para ingresar el pais de nacimiento").locatedBy("//input[@id='paisNacimiento']");
    public static final Target lugarDeNacimiento = Target.the("input para ingresar el lugar de nacimiento").locatedBy("//input[@id='lugarNacimiento']");
    public static final Target nacionalidad = Target.the("input para ingresar nacionalidad").locatedBy("//input[@id='nacionalidad']");
    public static final Target profesion = Target.the("input para ingresar profesion").locatedBy("//input[@id='profesion']");
    public static final Target estadoCivil = Target.the("input para ingresar profesion").locatedBy("//label[text()='Estado civil']//ancestor::div[@id='select']");
    public static final Target pageDatosAdicionales = Target.the("Titulo pagina Datos Adicionales").locatedBy("//div//span[text()='{0}/6']");
    //Pagina 2
    public static final Target departamentoResidencia = Target.the("departamento Residencia cliente").locatedBy("//input[@id='departamento']");
    public static final Target ciudadResidencia = Target.the("ciudad Residencia cliente").locatedBy("//input[@id='ciudad']");
    public static final Target direccionResidencia = Target.the("ciudad Residencia cliente").locatedBy("//input[@id='direccion']");
    public static final Target barrio = Target.the("Barrio cliente").locatedBy("//input[@id='barrio']");
    public static final Target mesesResidencia = Target.the("meses Residencia cliente").locatedBy("//input[@id='mesesResidenciaActual']");
    public static final Target numeroHijos = Target.the("numeros de hijos del cliente").locatedBy("//input[@id='numeroHijos']");
    public static final Target personasACargo = Target.the("Personas a cargo por parte del cliente").locatedBy("//input[@id='personasACargo']");
    public static final Target departamentoCorrespondencia = Target.the("Departamento de correspondencia").locatedBy("//div//child::input[@id='extraDepartamento']");
    public static final Target ciudadCorrespondencia = Target.the("Ciudad de correspondencia").locatedBy("//div//child::input[@id='extraCiudad']");
    //Pagina 4
    public static final Target tipoPension = Target.the("numeros de hijos del cliente").locatedBy("//input[@id='tipoPension']");
    public static final Target codigoProgramaNomina = Target.the("numeros de hijos del cliente").locatedBy("//input[@id='codigoProgramaNomina']");
    public static final Target cargoFront = Target.the("numeros de hijos del cliente").locatedBy("//input[@id='cargo']");
    public static final Target fechaIngreso = Target.the("numeros de hijos del cliente").locatedBy("//input[@id='fechaIngreso']");
    public static final Target fechaFinalizacion = Target.the("numeros de hijos del cliente").locatedBy("//input[@id='fechaTerminacion']");
    public static final Target nitAfiliacion = Target.the("numeros de hijos del cliente").locatedBy("//input[@id='nitAfiliacion']");
    public static final Target tipoDocumento = Target.the("ciudad Residencia cliente").locatedBy("//div[@class='sc-httYMd bzHUut']");
    public static final Target subirPDF = Target.the("ciudad Residencia cliente").locatedBy("//input[@id='file']");
    //Pagina Datos Credito
    public static final Target ingresosMensuales = Target.the("ciudad Residencia cliente").locatedBy("//label[text()='Total ingresos mensuales']//following-sibling::input[1]");
    public static final Target totalDescuentos = Target.the("ciudad Residencia cliente").locatedBy("//label[text()='Total descuentos']//following-sibling::input[1]");
    public static final Target totalDescuentosLey = Target.the("ciudad Residencia cliente").locatedBy("//label[text()='Total descuentos de ley']//following-sibling::input[1]");
    public static final Target lineaDeCredito = Target.the("ciudad Residencia cliente").locatedBy("//label[contains(text(),'nea de ')]//ancestor::div[@id='select']");
    //Pagina Calculo Credito
    public static final Target montoSolicitado = Target.the("ciudad Residencia cliente").locatedBy("//label[text()='Monto solicitado']//following-sibling::input[1]");
    public static final Target plazoFront = Target.the("ciudad Residencia cliente").locatedBy("//label[text()='Plazo en meses']//following-sibling::input[1]");
    public static final Target diasInteresesIniciales = Target.the("ciudad Residencia cliente").locatedBy("//label[contains(text(),'intereses Iniciales')]//following-sibling::input[1]");
    public static final Target tasaFront = Target.the("ciudad Residencia cliente").locatedBy("//label[contains(text(),'Tasa')]//ancestor::div[@id='select']");
    public static final Target botonCalcular = Target.the("Boton de Calcular").locatedBy("//button[contains(text(), 'Calcular')]");

}
