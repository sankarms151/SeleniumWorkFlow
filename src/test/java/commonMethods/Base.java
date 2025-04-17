package commonMethods;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class Base {

	public static WebDriver driver;
	public static ExtentReports extent;
	public static ExtentTest test;


	public static void report() {

		if (extent == null) {
			extent = new ExtentReports();
			ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("./reports/extent-report.html");
			extent.attachReporter(htmlReporter);
		}


	}

	public static void initializeDriver() {
	    try {
	        if (driver == null) {
	            ChromeOptions options = new ChromeOptions();

	            // Spoof User-Agent to avoid bot detection
	            options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36");

	            // Disable automation flags
	            options.addArguments("--disable-blink-features=AutomationControlled");

	            // Start browser with these options
	            driver = new ChromeDriver(options);
	            driver.manage().window().maximize();

	            // Introduce a wait time to reduce automated detection
	            Thread.sleep(3000);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        throw new RuntimeException("Failed to initialize WebDriver: " + e.getMessage());
	    }
	}


	public static void takeScreenshot(String testName) {
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile, new File("reports/screenshots/" + testName + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public static void close() {
		if (driver != null) {
			driver.quit();
		}
		if (extent != null) {
			extent.flush();
		}
	}

	public static void createTest(String testName) {
		if (extent != null) {
			test = extent.createTest(testName);
		}
	}

	/*
	 * public ExtentTest getTest() { return test; }
	 */

}

