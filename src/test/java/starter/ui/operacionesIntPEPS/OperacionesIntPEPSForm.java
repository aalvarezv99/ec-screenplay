package starter.ui.operacionesIntPEPS;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class OperacionesIntPEPSForm {
    public static final Target transaccionMonedaExtrajera = Target.the("Ingresar primer formulario de referencias personales").locatedBy("//input[starts-with(@id,'monedaExtranjera')]/following-sibling::label[text()='{0}']/preceding-sibling::div");
    public static final Target tipoTransaccion = Target.the("Tipo de transaccion").locatedBy("//h6[text()='{0}']/preceding-sibling::div");
    public static final Target productoBancario = Target.the("Productos bancarios en moneda extranjera").locatedBy("//input[starts-with(@id,'productMonedaExtranjera')]/following-sibling::label[text()='{0}']/preceding-sibling::div");
    public static final Target banco = Target.the("Banco moneda extranjera").located(By.id("banco"));
    public static final Target numProducto = Target.the("numero producto moneda extranjera").located(By.id("numProducto"));
    public static final Target tipoProducto = Target.the("tipo de producto moneda extranjera").located(By.id("tipoProducto"));
    public static final Target pais = Target.the("Pais banco moneda extranjera").located(By.id("pais"));
    public static final Target ciudad = Target.the("Ciudad banco moneda extranjera").located(By.id("ciudad"));
    public static final Target montoOperacional = Target.the("monto operacional moneda extranjera").locatedBy("//input[@id='montoOperacional']/preceding-sibling::input");
    public static final Target moneda = Target.the("moneda extranjera").located(By.id("moneda"));
    public static final Target funcionarioPublico = Target.the("Funcionario publico").locatedBy("//input[starts-with(@id,'publicStaff')]/following-sibling::label[text()='{0}']/preceding-sibling::div");
    public static final Target recursosPublicos = Target.the("Recursos publicos").locatedBy("//input[starts-with(@id,'managePublicResources')]/following-sibling::label[text()='{0}']/preceding-sibling::div");
    public static final Target expuestoPoliticamente = Target.the("Expuesto politicamente").locatedBy("//input[starts-with(@id,'politicallyExposed')]/following-sibling::label[text()='{0}']/preceding-sibling::div");
    public static final Target fechapoliticamente = Target.the("Fecha expuesto politicamente").located(By.id("fecha"));
    public static final Target familiarExpuestoPoliticamente = Target.the("Familiar Expuesto politicamente").locatedBy("//input[starts-with(@id,'politicallyExposedRe')]/following-sibling::label[text()='{0}']/preceding-sibling::div");

}
