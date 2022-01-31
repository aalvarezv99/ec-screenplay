package starter.task.RegistroCliente;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Hit;
import net.serenitybdd.screenplay.actions.Upload;
import net.serenitybdd.screenplay.waits.Wait;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.server.commandhandler.UploadFile;
import starter.task.LoginTask;
import starter.ui.RegistroDeCliente.RegistroClienteForm;
import starter.ui.dashboard.DashboardForm;
import starter.ui.simulador.datosFinancierosForm;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class FotoCedula implements Task {

    private final String RutaPDF;

    public FotoCedula(String RutaPDF) {
        this.RutaPDF = RutaPDF;
    }

    public static Performable
    whithFotoCedula(String RutaPDF){
        return instrumented(FotoCedula.class,RutaPDF);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Path cedulaPath = Paths.get(RutaPDF).toAbsolutePath();

        actor.attemptsTo(
                WaitUntil.the(RegistroClienteForm.tituloFormulario, isVisible()).forNoMoreThan(10).seconds(),
                Upload.theFile(cedulaPath).to(RegistroClienteForm.inputCedulaCliente),
                Click.on(RegistroClienteForm.inputCargaDocumentos)
        );

        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_ESCAPE);
            robot.keyRelease(KeyEvent.VK_ESCAPE);
            robot.delay(200);
        } catch (AWTException e) {
            e.printStackTrace();
        }

        actor.attemptsTo(
                Upload.theFile(cedulaPath).to(RegistroClienteForm.inputCedulaCliente),
                Click.on(RegistroClienteForm.botonSiguiente),
                WaitUntil.the(DashboardForm.loading, isNotVisible()).forNoMoreThan(20).seconds()
        );


    }

}
