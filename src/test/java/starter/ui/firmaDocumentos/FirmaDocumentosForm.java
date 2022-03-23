package starter.ui.firmaDocumentos;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class FirmaDocumentosForm {
    public static final Target inputOTP = Target.the("input para ingresar el código otp").located(By.id("input0"));
    public static final Target btnConfirmar = Target.the("botón para confirmar opt").located(By.id("top-action-button"));
    public static final Target btnContinuar = Target.the("botón para continuar proceso").locatedBy("//button[contains(text(), 'Continuar')]");
    public static final Target btnDescargaDoc = Target.the("botón para descargar los documentos a firmar").locatedBy("//button[contains(text(), 'Descargar documentos')]");
    public static final Target tipoDocumentoSelect = Target.the("Elemento select para opciones de tipo documento").locatedBy("//label[text() = 'Tipo documento']/following-sibling::div");
    public static final Target inputDescripcionDoc = Target.the("input para agregar descripción del documento").located(By.id("descripcion"));
    public static final Target divFile = Target.the("div que contiene el input file").located(By.id("input-file"));
    public static final Target btnRadicarCredito = Target.the("botón para radicar credito").locatedBy("//button[contains(text(), 'Radicar cr')]");
    public static final Target btnClose = Target.the("botón cerrar").locatedBy("//div[@id='ContainerModalInfoErrors']/div/div/*[@id='close-icon']");
    public static final Target inputCodigoADO = Target.the("imput codigo ADO").locatedBy("//input[@id='adoSegmentCode']");
    public static final Target origenValidacionIdentidad = Target.the("origen validacion identidad").locatedBy("//label[contains(text(),'{0}')]/preceding-sibling::div");

}
