package tests;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseTest {
	protected static ThreadLocal<WebDriver> threadLocalDriver=new ThreadLocal<WebDriver>();
	public static	ExtentReports extent=null;

	
	
	
	@BeforeMethod
	public void setDriver() {
		WebDriver driver=BaseTest.getBrowserType("chrome", false);
		threadLocalDriver.set(driver);
		
	}
	
	
	public static WebDriver getDriver() {
		return threadLocalDriver.get();
	}
	
	@AfterMethod
	public void removeDriver() {
		getDriver().quit();
		threadLocalDriver.remove();
	}
	
	public static void configureExtentReport() {
		String dateFormat=new SimpleDateFormat("yyyymmddhhmmss").format(new Date());
		//C:\Users\bcm43\eclipse-workspace\sfdcautomationframework\src\test\java\reports
		//C:\Users\bcm43\eclipse-workspace\sfdcautomationframework\src\test\java\reports
		String reportPath= System.getProperty("user.dir")+"\\src\\test\\java\\reports\\"+dateFormat +"sfdc.html";
	    extent=new ExtentReports();
		ExtentSparkReporter sparkHtml=new ExtentSparkReporter(reportPath);
		extent.attachReporter(sparkHtml);
	}
	
	/**
	 * @param browserName should be either of the string 'Chrome','firefox','safari'
	 * @param headless set to true to run in headless mode
	 * @return driver objects on wrong param return null
	 * @author bcm43
	 *
	 */
	public static WebDriver getBrowserType(String browserName ,boolean headless) {
		
		String browser=browserName.toLowerCase();
		WebDriver driver=null;
		
		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			if(headless) {
				ChromeOptions co=new ChromeOptions();
				co.addArguments("--headless");
				driver=new ChromeDriver(co);
			}else
			{
				driver=new ChromeDriver();
			}
			break;
			
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			if(headless) {
				FirefoxOptions co=new FirefoxOptions();
				co.addArguments("---headless");
				driver=new FirefoxDriver(co);
			}else
			{
				driver=new FirefoxDriver();
			}
			break;
			
		case "safari":
			WebDriverManager.safaridriver().setup();
			driver= new SafariDriver();
			break;
		
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver= new EdgeDriver();
			break;
			
		  default: 
			  System.out.println("provide a right input browsers supported are:'chrome','firefox','edge','safari'");
			break;
		}
		return driver;
		
	}
	
	@BeforeSuite
	public void setUp()
	{
		configureExtentReport();
	}
	@AfterSuite
	public void tearDown()
	{
		extent.flush();
	}
	

}
