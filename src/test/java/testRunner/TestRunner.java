package testRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/Features",
		glue = {"stepDefinition"},
		tags = "@DEV or @SIT",
		plugin = {
				"pretty",
				"html:target/cucumber-reports/cucumber-html-report",
				"json:target/cucumber-reports/Cucumber.json"
		},
		monochrome = true
		)
public class TestRunner {
}