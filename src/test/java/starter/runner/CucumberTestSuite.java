package starter.runner;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/login/login.feature",
        glue="starter",
        tags = "@login",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class CucumberTestSuite {
}