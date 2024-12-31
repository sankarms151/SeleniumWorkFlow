package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;

import commonMethods.Base;


public class GoogleSearchStepDef {

	@Given("^User opens Google homepage$")
	public void openGoogleHomepage() {
		Base.createTest("Google Search Test");
		Base.driver.get("https://www.google.com");
		Base.test.info("Google homepage opened.");
	}

	@When("^User searches for AWS$")
	public void searchForAWS() {
		Base.driver.findElement(By.name("q")).sendKeys("AWS");
		Base.driver.findElement(By.name("q")).submit();
		Base.test.info("Search for AWS performed.");
		Base.takeScreenshot("AWS_Search_Result");
	}

	@Then("^Results are displayed$")
	public void resultsAreDisplayed() {
		if (Base.driver.getTitle().contains("AWS")) {
			Base.test.pass("AWS search results displayed.");
		} else {
			Base.test.fail("AWS search results not displayed.");
		}
		Base.takeScreenshot("AWS_Search_Results_Page");
	}
}