package starter.runner.originacion;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/originacion/SimuladorOriginacion.feature",
        glue="starter",
        tags = "@endeudamientoGlobal",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
//@Simulador or @endeudamientoGlobal,@desembolso,@datosSolicitud,@datosSolicitudCredito,@seguroAP,@referencias,@seguroVida,@OperInternacionalesPEPS,@firmaDocumentos
public class Originacion {
}