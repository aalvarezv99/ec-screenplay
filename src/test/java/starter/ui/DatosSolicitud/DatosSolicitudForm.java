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
    public static final Target ingresosMensuales = Target.the("Ingresos mensuales cliente").locatedBy("//label[text()='Total ingresos mensuales']//following-sibling::input[1]");
    public static final Target totalDescuentos = Target.the("Total Descuentos cliente").locatedBy("//label[text()='Total descuentos']//following-sibling::input[1]");
    public static final Target totalDescuentosLey = Target.the("Total descuentos ley cliente").locatedBy("//label[text()='Total descuentos de ley']//following-sibling::input[1]");
    public static final Target lineaDeCredito = Target.the("Linea de Credito").locatedBy("//label[contains(text(),'nea de ')]//ancestor::div[@id='select']");
    //Pagina Datos Credito - Compra de carteras
    public static final Target botonAnadirCompras = Target.the("Boton añadir compras").locatedBy("//span[contains(text(),'adir valor')]");
    public static final Target campoEntidadCompra = Target.the("campo de entidad en carteras").locatedBy("//input[@id='entidad{0}']");
    public static final Target campoMontoCompra = Target.the("Campo entidad en carteras").locatedBy("//input[@id='monto{0}']//preceding-sibling::input");
    public static final Target campoVlrCuotaCompra = Target.the("Campo vlr Cuora").locatedBy("//input[@id='valorCuota{0}']//preceding-sibling::input");
    public static final Target campoFechaVencimientoCompra = Target.the("campo Fecha Vencimiento").locatedBy("//input[@id='fechaVencimiento{0}']");
    public static final Target campoNumObligacionCompra = Target.the("campo Numero de Obligacion ").locatedBy("//input[@id='noObligacion{0}']");;

    //Pagina Calculo Credito
    public static final Target montoSolicitado = Target.the("ciudad Residencia cliente").locatedBy("//label[text()='Monto solicitado']//following-sibling::input[1]");
    public static final Target plazoFront = Target.the("ciudad Residencia cliente").locatedBy("//label[text()='Plazo en meses']//following-sibling::input[1]");
    public static final Target diasInteresesIniciales = Target.the("ciudad Residencia cliente").locatedBy("//label[contains(text(),'intereses Iniciales')]//following-sibling::input[1]");
    public static final Target tasaFront = Target.the("ciudad Residencia cliente").locatedBy("//label[contains(text(),'Tasa')]//ancestor::div[@id='select']");
    public static final Target botonCalcular = Target.the("Boton de Calcular").locatedBy("//button[contains(text(), 'Calcular')]");
    //Pagina Calculo Credito Retanqueo
    public static final Target creditosActivosChekBox = Target.the("check box creditos Activos").locatedBy("//h6[text()='{0}']//preceding::div[@id='checkbox']");
    //Simulador
    public static final Target montoSolicitar = Target.the("caja de texto que contiene el monto a solicitar").locatedBy("//h6[text()='Monto a solicitar']/following-sibling::h6");
    public static final Target montoMaximoSugerido = Target.the("caja de texto que contiene el Monto máximo sugerido").locatedBy("//h6[text()='Monto máximo sugerido']/following-sibling::h6");
    public static final Target cuotaCorriente = Target.the("caja de texto que contiene el Cuota corriente").locatedBy("//h6[text()='Cuota corriente']/following-sibling::h6");
    public static final Target remanenteEstimado = Target.the("caja de texto que contiene el Remanente estimado").locatedBy("//h6[text()='Remanente estimado']/following-sibling::h6");
    public static final Target estudiosCreditoIva = Target.the("Estudio credito mas IVA").locatedBy("//span[contains(text(),'Estudios cr')]/following-sibling::span");
    public static final Target valorInteresesIniciales = Target.the("Valor de intereses iniciales").locatedBy("//span[contains(text(),'Valor inter')]/following-sibling::span");
    public static final Target valorFianza = Target.the("Valor de la fianza").locatedBy("//span[contains(text(),'Valor de la fianza')]/following-sibling::span");
    public static final Target gmf4X1000 = Target.the("GMF (4 X 1.000)").locatedBy("//span[contains(text(),'GMF (4 X 1.000)')]/following-sibling::span");
    public static final Target valorComprasGirar = Target.the("Valor compras a girar").locatedBy("//span[contains(text(),'Valor compras a girar')]/following-sibling::span");
    public static final Target primaAnticipadaSeguro = Target.the("caja de texto que contiene la Prima anticipada de seguro").locatedBy("//span[contains(text(),'Prima anticipada de seguro')]/following-sibling::span");




}
