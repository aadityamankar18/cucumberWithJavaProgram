package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)   //✅
@CucumberOptions(
        features = "src/test/java/feature/home.feature",
        glue = "steps",
        plugin = {"pretty", "html:target/report.html"}
)
public class TestRunner {
}
