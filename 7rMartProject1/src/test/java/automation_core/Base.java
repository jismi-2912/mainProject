package automation_core;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constants.Constants;
import utilities.ScreenShotUtility;
import utilities.WaitUtility;

public class Base {
	Properties prop;
	FileInputStream fs;
	public WebDriver driver;

	@BeforeMethod(alwaysRun=true)
	@Parameters("browser")
	public void initializeBrowser(String browser) throws Exception {
		prop=new Properties();
		fs=new FileInputStream(Constants.CONFIGFILE);
		prop.load(fs);
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();

		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();

		} else {
			throw new Exception("Invalid Browser");

		}

		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		WaitUtility wait=new WaitUtility();
		wait.implicitWait(driver);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@AfterMethod(alwaysRun=true)
	// This method handles quitting the WebDriver after the test execution
	// It also captures a screenshot if the test fails
	// ITestResult-->interface in TestNG that manages lifecycle of a testcase result
	public void driverQuit(ITestResult iTestResult) throws IOException// iTestResult is a interface

	{
		// Check if the test case has failed
		if (iTestResult.getStatus() == ITestResult.FAILURE)

		{
			// If the test fails, take a screenshot
			// Create an instance of ScreenshotUtility
			ScreenShotUtility screenShot = new ScreenShotUtility();

			// Capture a screenshot with the test name
			screenShot.getScreenshot(driver, iTestResult.getName());

		}

		
	// Quit the WebDriver session
		driver.quit();

	}
}
