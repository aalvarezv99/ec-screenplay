package starter.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.TextContent;
import starter.ui.endeudamientoGlobal.EndeudamientoGlobalForm;

public class EndeudamientoGlobalQuestion {
    public static Question<String> getOtrosIngresos() {
        return actor -> TextContent.of(EndeudamientoGlobalForm.otrosIngresosCertificados).viewedBy(actor).asString();
    }
}
