package starter.runner.retanqueo;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/retanqueo/libreInversion.feature",
        glue="starter",
        tags = "@datosSolicitudCredito",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class retanqueo {
}