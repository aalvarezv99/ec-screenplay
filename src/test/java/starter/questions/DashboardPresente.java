package starter.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.TextContent;
import starter.ui.dashboard.DashboardForm;

public class DashboardPresente {

    public static Question<String> botonradicado(){
        return actor -> TextContent.of(DashboardForm.Solicitudes_radicadas).viewedBy(actor).asString();
    }
}
