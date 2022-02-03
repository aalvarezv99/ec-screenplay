package starter.runner.originacion;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/originacion/simuladorLibreInversion.feature",
        glue="starter",
        tags = "@seguroAP",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class originacion {
}