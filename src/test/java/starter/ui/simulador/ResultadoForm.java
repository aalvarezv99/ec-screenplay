package starter.ui.simulador;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ResultadoForm {
    public static final Target montoSolicitar = Target.the("Valor del monto a solicitar ").locatedBy("//h6[text()='Monto a solicitar']/following-sibling::h6");
    public static final Target montoMaximoSugerido = Target.the("Valor del monto maximo sugerido ").locatedBy("//h6[starts-with(text(),'Monto m')]/following-sibling::h6");
    public static final Target cuotaCorriente = Target.the("Valor de la cuota corriente ").locatedBy("//h6[text()='Cuota corriente']/following-sibling::h6");
    public static final Target remanteEstimado = Target.the("Valor del remante estimado ").locatedBy("//h6[text()='Remanente estimado']/following-sibling::h6");
    public static final Target estudioCreditoIVA = Target.the("Valor del estudio de Credito ").locatedBy("//span[starts-with(text(),'Estudios cr')]/following-sibling::span");
    public static final Target valoresInteresesIniciales = Target.the("Valor de intereses iniciales ").locatedBy("//span[starts-with(text(),'Valor inter')]/following-sibling::span");
    public static final Target valoresFianza = Target.the("Valor fianza ").locatedBy("//span[text()='Valor de la fianza']/following-sibling::span");
    public static final Target primaAnticipadaSeguro = Target.the("Valor prima anticipada seguro ").locatedBy("//span[text()='Prima anticipada de seguro']/following-sibling::span");
    public static final Target iniciarSolicitud = Target.the("Boton iniciar solicitud ").located(By.id("init-solicitation"));

}
