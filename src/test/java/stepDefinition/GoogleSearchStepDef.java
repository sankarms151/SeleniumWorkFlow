package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;

import commonMethods.Base;

public class GoogleSearchStepDef extends Base {

    @Given("^User opens Google homepage$")
    public void openGoogleHomepage() {
        test = extent.createTest("Google Search Test");
        driver.get("https://www.google.com");
        test.info("Google homepage opened.");
    }

    @When("^User searches for AWS$")
    public void searchForAWS() {
        driver.findElement(By.name("q")).sendKeys("AWS");
        driver.findElement(By.name("q")).submit();
        test.info("Search for AWS performed.");
        takeScreenshot("AWS_Search_Result");
    }

    @Then("^Results are displayed$")
    public void resultsAreDisplayed() {
        if (driver.getTitle().contains("AWS")) {
            test.pass("AWS search results displayed.");
        } else {
            test.fail("AWS search results not displayed.");
        }
        takeScreenshot("AWS_Search_Results_Page");
    }
}