package starter.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.TextContent;
import starter.ui.dashboard.DashboardForm;
import starter.ui.simulador.ResultadoForm;

public class DashboardPresente {

    public static Question<String> botonradicado(){
        return actor -> TextContent.of(ResultadoForm.montoSolicitar).viewedBy(actor).asString();
    }
}
