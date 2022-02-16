package starter.runner.originacion;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/originacion/SimuladorOriginacion.feature",
        glue="starter",
        tags = "@Simulador or @endeudamientoGlobal or @desembolso",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
//@Simulador,@endeudamientoGlobal,@desembolso,@datosSolicitud,@datosSolicitudCredito,@seguroAP,@referencias,@seguroVida,@OperInternacionalesPEPS,@firmaDocumentos
public class Originacion {
}