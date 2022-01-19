package starter.ui.dashboard;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class DashboardForm {
    public static final Target solicitudesRadicadas   = Target.the("Boton solicitud radicada").located(By.id("applications-filed"));
    public static final Target loading = Target.the("Elemento de cargar en la pagina").locatedBy("//h6[text()='Cargando']");
    public static final Target saltarIntro = Target.the("Saltar intro dashboar").locatedBy("//span[text()='Saltar']");
    public static final Target menuSimulador   = Target.the("menu simulador").locatedBy("//p[text()='Simulador']");

}
