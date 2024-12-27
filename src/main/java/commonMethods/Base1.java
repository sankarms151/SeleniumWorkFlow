package commonMethods;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class Base1 {
	
	public WebDriver driver;
	public ExtentReports extent;
	public ExtentTest test;

	public void setUp() {
		//System.setProperty("webdriver.chrome.driver", "path_to_chromedriver");
		
		driver = new ChromeDriver();
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("reports/extentReport.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	}

	public void takeScreenshot(String fileName) {
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile, new File("reports/screenshots/" + fileName + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
		if (extent != null) {
			extent.flush();
		}
	}
}

