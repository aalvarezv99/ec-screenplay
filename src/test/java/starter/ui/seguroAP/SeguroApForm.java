package starter.ui.seguroAP;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SeguroApForm {
    public static final Target verBeneficios = Target.the("Boton Ver Beneficios").locatedBy("//button[text()='Ver beneficios']");
    public static final Target saltarBeneficios = Target.the("Saltar Ver Beneficios").locatedBy("//span[text()='Saltar']");
    public static final Target tomadorCreditoVinculado = Target.the("Vinculado (tomador del crédito)").locatedBy("//h6[contains(text(),'Vinculado (tomador del cr')]/preceding-sibling::*");
    public static final Target tomadorCreditoNoVinculado = Target.the("No vinculado (diferente al tomador)").locatedBy("//h6[text()='No vinculado (diferente al tomador)']/preceding-sibling::*");
    public static final Target tomarSeguroAP = Target.the("Tomar Seguro AP").locatedBy("//button[text()='Tomar Seguro AP']");
    public static final Target planUno = Target.the("Plan uno").locatedBy("//label[contains(text(),'Plan 1')]/preceding-sibling::div");
    public static final Target planDos = Target.the("Plan dos").locatedBy("//label[contains(text(),'Plan 2')]/preceding-sibling::div");
    public static final Target agregarBeneficiario = Target.the("Agregar Beneficiario").locatedBy("//button[text()='+ Agregar otro beneficiario']");
    public static final Target nombreApellido = Target.the("Nombres y apellidos Beneficiario").locatedBy("//input[@id='nombres_apellidos{0}']");
    public static final Target parentesco = Target.the("parentesco Beneficiario").locatedBy("//input[@id='posicionHogar{0}']");
    public static final Target porcentaje = Target.the("porcentaje Beneficiario").locatedBy("//input[@id='tasa{0}']");
    public static final Target continuar = Target.the("Boton continuar a referencias").locatedBy("//button[text()='Continuar']");
    public static final Target nombresTomador = Target.the("Nombres y apellidos tomador del seguro AP").located(By.id("nombres_apellidos"));
    public static final Target documentoTomador = Target.the("documento tomador del seguro AP").located(By.id("documento"));
    public static final Target celularTomador = Target.the("celular tomador del seguro AP").located(By.id("celular"));
    public static final Target correoTomador = Target.the("correo tomador del seguro AP").located(By.id("email"));
    public static final Target fechaNacimientoTomador = Target.the("fechaNacimiento tomador del seguro AP").located(By.id("fechaNacimiento"));
    public static final Target departamentoTomador = Target.the("departamento tomador del seguro AP").located(By.id("state"));
    public static final Target ciudadTomador = Target.the("ciudad tomador del seguro AP").located(By.id("city"));
    public static final Target direccionResidenciaTomador = Target.the("direccion tomador del seguro AP").located(By.id("direccionResidencia"));
    public static final Target noTomarSeguro = Target.the("No tomar seguro AP").locatedBy("//button[text()='No tomar Seguro AP']");

}
