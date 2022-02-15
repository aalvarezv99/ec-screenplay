package starter.ui.prospeccion;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ProspeccionUI {
    public static final Target tituloProspeccion  = Target.the("Titulo menu prospeccion ").locatedBy("//*[contains(text(),'Confirmaci')]");
    public static final Target cajaTextoOTP = Target.the("Caja de texto codigo OTP").locatedBy("//*[@id='input{0}']");
    public static final Target botonConfirmar = Target.the("Boton confirmar").locatedBy("/html/body/div/main/div[2]/div[2]/div[4]/div/div[3]/button[1]");
    public static final Target botonConfirmarDos = Target.the("Boton confirmar").locatedBy("/html/body/div/main/div[2]/div[2]/div[5]/div/div[3]/button");
    public static final Target procesoValidacion = Target.the("Iniciamos proceso de validación").locatedBy("//*[contains(text(),'Iniciamos proceso de validaci')]");
    public static final Target MisSimulaciones = Target.the("Ir a mis simulaciones").locatedBy("//button[contains(text(),'Ir a Mis solicitudes')]");
    public static final Target paginasConsulta = Target.the("Cantidad de paginas consulta Truora").locatedBy("//p[contains(text(),'1') and text()=' / ']");
    public static final Target botonSiguiente = Target.the("Boton siguiente paginas").locatedBy("//p[text()=' / ']/following-sibling::*");
    public static final Target botonContinuar = Target.the("Boton continuar").locatedBy("/html/body/div/main/div[2]/div[2]/div[1]/div[2]/div/div[4]/button");
    public static final Target seguirflujoContinuar = Target.the("seguir flujo boton continuar").locatedBy("//button[text()='Continuar' and @id='top-action-button' and @class='sc-ljRboo eFBfDe']");




}

