package starter.task.operacionesIntPEPS;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.conditions.Check;
import starter.ui.commons.CommonsLocators;
import starter.ui.operacionesIntPEPS.operacionesIntPEPSForm;
import starter.ui.seguroAP.SeguroApForm;


import static net.serenitybdd.screenplay.Tasks.instrumented;

public class operacionesIntPEPSTask implements Task {
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

    public operacionesIntPEPSTask(String monedaExtranjera, String tipoTransanccion, String productoBancario, String banco, String numProducto, String tipoProducto, String pais, String ciudad, String monto, String moneda) {
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
        return instrumented(operacionesIntPEPSTask.class, monedaExtranjera, tipoTransanccion, productoBancario, banco, numProducto, tipoProducto, pais, ciudad, monto, moneda);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Click.on(operacionesIntPEPSForm.transaccionMonedaExtrajera.of(monedaExtranjera)),
                Check.whether(monedaExtranjera.equals("Si"))
                        .andIfSo(
                                Click.on(operacionesIntPEPSForm.tipoTransaccion.of(tipoTransanccion))
                        ),
                Click.on(operacionesIntPEPSForm.productoBancario.of(productoBancario)),
                Check.whether(productoBancario.equals("Si"))
                        .andIfSo(
                                Enter.theValue(banco).into(operacionesIntPEPSForm.banco),
                                Enter.theValue(numProducto).into(operacionesIntPEPSForm.numProducto),
                                Enter.theValue(tipoProducto).into(operacionesIntPEPSForm.tipoProducto),
                                Enter.theValue(pais).into(operacionesIntPEPSForm.pais),
                                Enter.theValue(ciudad).into(operacionesIntPEPSForm.ciudad),
                                Enter.theValue(monto).into(operacionesIntPEPSForm.montoOperacional),
                                Enter.theValue(moneda).into(operacionesIntPEPSForm.moneda)
                        ),
                Click.on(CommonsLocators.botonSiguiente)


        );

    }
}
