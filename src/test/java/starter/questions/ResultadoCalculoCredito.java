package starter.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.TextContent;
import starter.ui.datosSolicitud.DatosSolicitudForm;


public class ResultadoCalculoCredito {

    public static Question<String> montoSolicitadoCal(){
        return actor -> TextContent.of(DatosSolicitudForm.montoSolicitar).viewedBy(actor).asString().replace("$","").replace(".","").replace(" ","");
    }
    public static Question<String> cuotaCorrienteCal(){
        return actor -> TextContent.of(DatosSolicitudForm.cuotaCorriente).viewedBy(actor).asString().replace("$","").replace(".","").replace(" ","");
    }
    public static Question<String> estudioCreditoCal(){
        return actor -> TextContent.of(DatosSolicitudForm.estudiosCreditoIva).viewedBy(actor).asString().replace("$","").replace(".","").replace(" ","");
    }
    public static Question<String> valorFianzaCal(){
        return actor -> TextContent.of(DatosSolicitudForm.valorFianza).viewedBy(actor).asString().replace("$","").replace(".","").replace(" ","");
    }
    public static Question<String> primaAnticipadaSeguro(){
        return actor -> TextContent.of(DatosSolicitudForm.primaAnticipadaSeguro).viewedBy(actor).asString().replace("$","").replace(".","").replace(" ","");
    }
    public static Question<String> interesesIniciales(){
        return actor -> TextContent.of(DatosSolicitudForm.valorInteresesIniciales).viewedBy(actor).asString().replace("$","").replace(".","").replace(" ","");
    }

    public static Question<String> vlrCompras(){
        return actor -> TextContent.of(DatosSolicitudForm.valorComprasGirar).viewedBy(actor).asString().replace("$","").replace(".","").replace(" ","");
    }

    public static Question<String> vlr4X1000(){
        return actor -> TextContent.of(DatosSolicitudForm.gmf4X1000).viewedBy(actor).asString().replace("$","").replace(".","").replace(" ","");
    }

    public static Question<String> remanenteEstimado(){
        return actor -> TextContent.of(DatosSolicitudForm.remanenteEstimado).viewedBy(actor).asString().replace("$","").replace(".","").replace(" ","");
    }
}
