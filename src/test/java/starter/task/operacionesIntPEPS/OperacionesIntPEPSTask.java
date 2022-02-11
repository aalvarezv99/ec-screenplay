package starter.task.operacionesIntPEPS;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.conditions.Check;
import starter.ui.commons.CommonsLocators;
import starter.ui.operacionesIntPEPS.OperacionesIntPEPSForm;


import static net.serenitybdd.screenplay.Tasks.instrumented;

public class OperacionesIntPEPSTask implements Task {
    private final String monedaExtranjera;
    private final String tipoTransanccion;
    private final String productoBancario;
    private final String banco;
    private final String numProducto;
    private final String tipoProducto;
    private final String pais;
    private final String ciudad;
    private final String monto;
    private final String moneda;

    public OperacionesIntPEPSTask(String monedaExtranjera, String tipoTransanccion, String productoBancario, String banco, String numProducto, String tipoProducto, String pais, String ciudad, String monto, String moneda) {
        this.monedaExtranjera = monedaExtranjera;
        this.tipoTransanccion = tipoTransanccion;
        this.productoBancario = productoBancario;
        this.banco = banco;
        this.numProducto = numProducto;
        this.tipoProducto = tipoProducto;
        this.pais = pais;
        this.ciudad = ciudad;
        this.monto = monto;
        this.moneda = moneda;
    }

    public static Performable whithoperacionesIntPEPSTask(String monedaExtranjera, String tipoTransanccion, String productoBancario, String banco, String numProducto, String tipoProducto, String pais, String ciudad, String monto, String moneda) {
        return instrumented(OperacionesIntPEPSTask.class, monedaExtranjera, tipoTransanccion, productoBancario, banco, numProducto, tipoProducto, pais, ciudad, monto, moneda);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Click.on(OperacionesIntPEPSForm.transaccionMonedaExtrajera.of(monedaExtranjera)),
                Check.whether(monedaExtranjera.equals("Si"))
                        .andIfSo(
                                Click.on(OperacionesIntPEPSForm.tipoTransaccion.of(tipoTransanccion))
                        ),
                Click.on(OperacionesIntPEPSForm.productoBancario.of(productoBancario)),
                Check.whether(productoBancario.equals("Si"))
                        .andIfSo(
                                Enter.theValue(banco).into(OperacionesIntPEPSForm.banco),
                                Enter.theValue(numProducto).into(OperacionesIntPEPSForm.numProducto),
                                Enter.theValue(tipoProducto).into(OperacionesIntPEPSForm.tipoProducto),
                                Enter.theValue(pais).into(OperacionesIntPEPSForm.pais),
                                Enter.theValue(ciudad).into(OperacionesIntPEPSForm.ciudad),
                                Enter.theValue(monto).into(OperacionesIntPEPSForm.montoOperacional),
                                Enter.theValue(moneda).into(OperacionesIntPEPSForm.moneda)
                        ),
                Click.on(CommonsLocators.botonSiguiente)


        );

    }
}
