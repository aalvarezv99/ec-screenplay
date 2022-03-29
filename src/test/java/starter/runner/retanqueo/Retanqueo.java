package starter.runner.retanqueo;


import io.cucumber.junit.CucumberOptions;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.runner.RunWith;
import starter.runner.RunnerPersonalizado;
import starter.util.commons.BeforeSuite;
import starter.util.commons.DataToFeature;

import java.io.IOException;

//@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/retanqueo/SimuladorRetanqueo.feature",
        glue = "starter",
        tags = "@Simulador",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
//@Simulador or @endeudamientoGlobal or @desembolso or @datosSolicitud or @datosSolicitudCredito
@RunWith(RunnerPersonalizado.class)
public class Retanqueo {
    @BeforeSuite
    public static void test() throws InvalidFormatException, IOException {
        DataToFeature.overrideFeatureFiles("src/test/resources/features/retanqueo/SimuladorRetanqueo.feature");
    }
}

//@Simulador or @endeudamientoGlobal or @desembolso or @datosSolicitud or @datosSolicitudCredito or @Excepciones or @seguroAP or @referencias or @seguroVida or @OperInternacionalesPEPS or @firmaDocumentos