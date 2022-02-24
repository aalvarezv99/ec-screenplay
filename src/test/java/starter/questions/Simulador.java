package starter.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.TextContent;
import starter.ui.simulador.DatosFinancierosForm;
import starter.ui.simulador.ResultadoForm;

import java.util.List;

public class Simulador {


    public static Question<String> montoSolicitadoCal(){
        return actor -> TextContent.of(ResultadoForm.montoSolicitar).viewedBy(actor).asString().replace("$","").replace(".","").replace(" ","");
    }
    public static Question<String> cuotaCorrienteCal(){
        return actor -> TextContent.of(ResultadoForm.cuotaCorriente).viewedBy(actor).asString().replace("$","").replace(".","").replace(" ","");
    }
    public static Question<String> estudioCreditoCal(){
        return actor -> TextContent.of(ResultadoForm.estudioCreditoIVA).viewedBy(actor).asString().replace("$","").replace(".","").replace(" ","");
    }
    public static Question<String> valorFianzaCal(){
        return actor -> TextContent.of(ResultadoForm.valoresFianza).viewedBy(actor).asString().replace("$","").replace(".","").replace(" ","");
    }
    public static Question<String> primaAnticipadaSeguro(){
        return actor -> TextContent.of(ResultadoForm.primaAnticipadaSeguro).viewedBy(actor).asString().replace("$","").replace(".","").replace(" ","");
    }
    public static Question<String> interesesIniciales(){
        return actor -> TextContent.of(ResultadoForm.valoresInteresesIniciales).viewedBy(actor).asString().replace("$","").replace(".","").replace(" ","");
    }

    public static Question<String> vlrCompras(){
        return actor -> TextContent.of(ResultadoForm.vlrCompras).viewedBy(actor).asString().replace("$","").replace(".","").replace(" ","");
    }

    public static Question<String> vlr4X1000(){
        return actor -> TextContent.of(ResultadoForm.vlr4X1000).viewedBy(actor).asString().replace("$","").replace(".","").replace(" ","");
    }

    public static Question<String> remanenteEstimado(){
        return actor -> TextContent.of(ResultadoForm.remanteEstimado).viewedBy(actor).asString().replace("$","").replace(".","").replace(" ","");
    }

    /*Quetion Retanqueo Multiple*/
    public static Question<List<String>> listSaldosAlDia(String pagaduria){
        return actor -> TextContent.of(DatosFinancierosForm.listSaldoDia.of(pagaduria)).viewedBy(actor).asList();
    }

    /*Quetion saldo a recoger*/
    public static Question<String> saldoRecoger(){
        return actor -> TextContent.of(DatosFinancierosForm.saldoTotalRecoger).viewedBy(actor).asString().replace("$","").replace(".","").replace(" ","");
    }
}
