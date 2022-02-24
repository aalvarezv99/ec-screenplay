package starter.ui.excepciones;

import net.serenitybdd.screenplay.targets.Target;

public class ExcepcionesForm {
    public static final Target continuarSinExcepcion = Target.the("continuar sin excepcion").locatedBy("//*[@id='button' and contains(text(),'Continuar sin excepci')]");
    public static final Target tramitarExcepcion = Target.the("tramitar excepcion").locatedBy("//*[@id='button' and contains(text(),'Tramitar excepci')]");
    public static final Target tipoExcepciones = Target.the("tipo excepcion").locatedBy("//p[text()='{0}']");
    public static final Target detalleExcepciones = Target.the("detalle excepcion").locatedBy("//h6[text()='{0}']/preceding-sibling::*");


}
