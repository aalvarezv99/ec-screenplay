package starter.task.RegistroCliente;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Upload;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.remote.server.commandhandler.UploadFile;
import starter.task.LoginTask;
import starter.ui.RegistroDeCliente.RegistroClienteForm;

import java.io.File;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class FotoCedula implements Task {

    public static final String RutaPDF = "src/test/resources/Data/PDFPRUEBA.pdf";
    public static final Path cedulaPath = Paths.get(RutaPDF).toAbsolutePath();

    /*public FotoCedula(String RutaPDF) {
        this.RutaPDF = RutaPDF;
    }*/

    public static Performable
    whithFotoCedula(String RutaPDF){
        return instrumented(FotoCedula.class,RutaPDF);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        System.out.println("Entro al Metodo");

        actor.attemptsTo(
                WaitUntil.the(RegistroClienteForm.inputCedulaCliente, isVisible()).forNoMoreThan(10).seconds(),
                Upload.theFile(cedulaPath).to(RegistroClienteForm.inputCedulaCliente)
        );

        System.out.println("Hola esta bien");
    }
}
