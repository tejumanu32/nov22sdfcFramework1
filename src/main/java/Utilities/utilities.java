package Utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class utilities {
	
	public static boolean waitForElement(WebDriver driver,WebElement element) {
		boolean isElementClicable=false;
		WebDriverWait wait=new WebDriverWait(driver, null);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element));
			isElementClicable=true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}return isElementClicable;
	}
	
	public static String captureScreenshot(WebDriver driver) throws IOException {
		TakesScreenshot screenshot= (TakesScreenshot)driver;
		File sourceFile=screenshot.getScreenshotAs(OutputType.FILE);
		String dateFormat=new SimpleDateFormat("yyyymmddhhmmss").format(new Date());
		String dsPath=System.getProperty("user.dir")+"\\src\\test\\java\\reports\\screenShots\\"+dateFormat+"sfdc.png";
		File dsFile=new File(dsPath);
		FileUtils.copyFile(sourceFile, dsFile);
		return dsPath;
	}
}
