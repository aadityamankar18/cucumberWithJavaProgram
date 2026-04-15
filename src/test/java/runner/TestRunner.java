package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)   //✅
@CucumberOptions(
        features = "src/test/java/feature/home.feature",
        glue = "steps",
        plugin = {"pretty", "html:target/report.html"},
        monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
