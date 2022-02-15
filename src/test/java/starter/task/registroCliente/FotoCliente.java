package starter.task.registroCliente;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Upload;
import net.serenitybdd.screenplay.waits.WaitUntil;
import starter.ui.RegistroDeCliente.RegistroClienteForm;
import starter.ui.dashboard.DashboardForm;

import java.nio.file.Path;
import java.nio.file.Paths;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class FotoCliente implements Task {
    private final String RutaPDF;

    public FotoCliente(String rutaPDF) {
        RutaPDF = rutaPDF;
    }

    public static Performable whithFotoCliente(String RutaPDF){
        return instrumented(FotoCliente.class,RutaPDF);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        Path fotoPath = Paths.get(RutaPDF).toAbsolutePath();
        actor.attemptsTo(
                Upload.theFile(fotoPath).to(RegistroClienteForm.inputCedulaCliente),
                Click.on(RegistroClienteForm.botonSiguiente),
                WaitUntil.the(RegistroClienteForm.buttonContinuar, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(RegistroClienteForm.buttonContinuar),
                WaitUntil.the(DashboardForm.loading, isNotVisible()).forNoMoreThan(20).seconds(),
                WaitUntil.the(RegistroClienteForm.buttonAceptarTerminos, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(RegistroClienteForm.buttonAceptarTerminos),
                WaitUntil.the(DashboardForm.loading, isNotVisible()).forNoMoreThan(20).seconds()
        );

    }
}
