package starter.ui.dashboard;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class DashboardForm {
    public static final Target Solicitudes_radicadas   = Target.the("Boton solicitud radicada").located(By.id("applications-filed"));
    public static final Target loading = Target.the("Elemento de cargar en la pagina").locatedBy("//h6[text()='Cargando']");
    public static final Target saltar_intro = Target.the("Saltar intro dashboar").locatedBy("//span[text()='Saltar']");
    public static final Target menu_simulador   = Target.the("menu simulador").locatedBy("//p[text()='Simulador']");
    public static final Target nombres_apellidos  = Target.the("caja de texto de los nombres y apellidos").located(By.id("nombres"));
    public static final Target numero_documento   = Target.the("Caja de texto para ingresar el numero de documento de identidad").located(By.id("identificacion"));
    public static final Target fecha_nacimiento   = Target.the("Caja de texto para ingresar la fecha de nacimiento").located(By.id("fechaNacimiento"));
    public static final Target numero_celular   = Target.the("Caja de texto para ingresar el numero de celular").located(By.id("celular"));
    public static final Target correo   = Target.the("Caja de texto para ingresar el correo electronico").located(By.id("email"));
    public static final Target actividad_cliente   = Target.the("Lista desplegable para ingresar la actividad del cliente").locatedBy("//label[text()='Actividad']/following-sibling::div/child::div[text()='Seleccionar...']");
    public static final Target actividad_cliente_select   = Target.the("Seleccionar en lista desplegable de actividad del cliente").locatedBy("//div[text()='{0}']");
    public static final Target pagaduria   = Target.the("Caja de texto para ingresar la pagaduria del cliente").located(By.id("pagaduria"));
    public static final Target pagaduria_select   = Target.the("Seleccionar en lista desplegable de la pagaduria del cliente").locatedBy("//div[text()='{0}']");
    public static final Target como_se_entero_de_ExcelCredit   = Target.the("Lista desplegable para ingresar Cómo se enteró de ExcelCredit").locatedBy("//label[contains(text(),'de ExcelCredit')]/following-sibling::div/child::div[text()='Seleccionar...']");
    public static final Target como_se_entero_de_ExcelCredit_select   = Target.the("Seleccionar en lista desplegable de Cómo se enteró de ExcelCredit").locatedBy("//div[text()='{0}']");
    public static final Target boton_siguiente   = Target.the("Boton de siguiente").located(By.id("submit"));
}
