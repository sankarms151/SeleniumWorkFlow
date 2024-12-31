package testRunner;



import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/Features",
		glue = {"stepDefinition","hooks"},
		tags = "@DEV or @SIT",
		plugin = {
				"pretty",
				"html:target/cucumber-reports/cucumber-report.html",
				"json:target/cucumber-reports/Cucumber.json"
		},
		publish = true,
		monochrome = true
		)
public class Runner {
}