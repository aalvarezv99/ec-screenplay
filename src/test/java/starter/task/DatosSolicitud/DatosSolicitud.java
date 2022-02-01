package starter.task.DatosSolicitud;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import starter.task.desembolso.Desembolso;
import starter.ui.DatosSolicitud.DatosSolicitudForm;
import starter.ui.commons.CommonsLocators;
import starter.ui.endeudamientoGlobal.EndeudamientoGlobalForm;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class DatosSolicitud implements Task {
    private final String paisNacimiento;
    private final String lugarDeNacimiento;
    private final String nacionalidad;
    private final String estadoCivil;
    private final String profesion;


    public DatosSolicitud(String paisNacimiento, String lugarDeNacimiento, String nacionalidad, String estadoCivil, String profesion) {
        this.paisNacimiento = paisNacimiento;
        this.lugarDeNacimiento = lugarDeNacimiento;
        this.nacionalidad = nacionalidad;
        this.estadoCivil = estadoCivil;
        this.profesion = profesion;
    }

    public static Performable withDatosSolicitud(String paisNacimiento,String lugarDeNacimiento,String nacionalidad,String estadoCivil,String profesion) {
        return instrumented(DatosSolicitud.class, paisNacimiento,lugarDeNacimiento,nacionalidad,estadoCivil,profesion);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
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
