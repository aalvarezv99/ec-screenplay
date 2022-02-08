package starter.task.DatosSolicitud;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import starter.ui.DatosSolicitud.DatosSolicitudForm;
import starter.ui.commons.CommonsLocators;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

public class DatosSolicitudP1 implements Task {
    private final String paisNacimiento;
    private final String lugarDeNacimiento;
    private final String nacionalidad;
    private final String estadoCivil;
    private final String profesion;


    public DatosSolicitudP1(String paisNacimiento, String lugarDeNacimiento, String nacionalidad, String estadoCivil, String profesion) {
        this.paisNacimiento = paisNacimiento;
        this.lugarDeNacimiento = lugarDeNacimiento;
        this.nacionalidad = nacionalidad;
        this.estadoCivil = estadoCivil;
        this.profesion = profesion;
    }

    public static Performable withDatosSolicitudP1(String paisNacimiento,String lugarDeNacimiento,String nacionalidad,String estadoCivil,String profesion) {
        return instrumented(DatosSolicitudP1.class, paisNacimiento,lugarDeNacimiento,nacionalidad,estadoCivil,profesion);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(DatosSolicitudForm.pageDatosAdicionales.of("1"), isPresent()).forNoMoreThan(10).seconds(),
                Enter.theValue(paisNacimiento).into(DatosSolicitudForm.paisNacimiento),
                Enter.theValue(lugarDeNacimiento).into(DatosSolicitudForm.lugarDeNacimiento),
                Enter.theValue(nacionalidad).into(DatosSolicitudForm.nacionalidad),
                Enter.theValue(profesion).into(DatosSolicitudForm.profesion),
                Click.on(DatosSolicitudForm.estadoCivil),
                Click.on(CommonsLocators.locatorByText.of(estadoCivil)),
                Click.on(CommonsLocators.botonSiguiente)

        );
        System.out.println("Fin Pagina 1/6 Datos Adicionales Clente");
    }
}
