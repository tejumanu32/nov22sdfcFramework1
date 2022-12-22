package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseTest {
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

}
