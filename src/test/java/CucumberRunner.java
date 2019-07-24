import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/features/"},
        glue = {"steps"},
        plugin = {"util.AllureReporter",
        }
)
public class CucumberRunner {
}
