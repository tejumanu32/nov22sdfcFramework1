package pages;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.swing.text.Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import Utilities.utilities;

/**
 * this class contains the object repository of login page
 * @author bcm43
 *
 */
public class LoginPage extends BasePage {
	
	public LoginPage(WebDriver driver, ExtentTest test)
	{
		PageFactory.initElements(driver, this);
		this.test=test;
	}
	
	@FindBy(id="username")
	public WebElement username;
	
	@FindBy(name="pw")
	public WebElement password;
	
	@FindBy(id="Login")
	public WebElement loginButton;
	
	@FindBy(id="rememberUn")
	public WebElement rememberMe;
	
	@FindBy(css="#error")
	public WebElement loginErrorMessage;
	
	@FindBy(partialLinkText ="Forgot your")
	public WebElement forgotPassword;
	
	@FindBy(id="idcard-identity")
	public WebElement isSavedUsername;
	
	@FindBy(id="rememberUn")
	public WebElement selectRemembermeCheckbox;
	
	@FindBy(id="idcard_identity")
	public WebElement continueButton;
	
	@FindBy(id="continue")
	public WebElement savedUsername;
	
	
	
	
//****************************************************************************************************************************************	
	
	public boolean isFreeTrialIsSeen(WebDriver driver) throws IOException
	{
		test.addScreenCaptureFromPath(utilities.captureScreenshot(driver));
		return false;
	}
	
//*****************************************************************************************************************************************	
    
	
	/**
	 * this method enters the userName. call this when you are on login page
	 * @param userName String type
	 * @return true if user name is entered
	 * @throws IOException 
	 */
	public boolean enterUsername( WebDriver driver,String userName) throws IOException {
		if(username.isDisplayed()) {
			username.sendKeys(userName);
			test.info("username is entered");
			return true;
		}else
		{
			test.fail("username field is not visible");
			test.addScreenCaptureFromPath(utilities.captureScreenshot(driver), "enterusername  failure");
			return false;
		}
	}
		
	/**
	 * this method enters the password.call this when you are in logonPage
	 * @param pass string type
	 * @param driver webDriver type
	 * @return true if password is entered
	 * @throws IOException 
	 */
	
	//***************************************************************************************************************************
	public boolean enterPassword(String pass,WebDriver driver) throws IOException {
		if(password.isDisplayed()) {
			password.sendKeys(pass);
			test.info("password is entered");
			return true;
			}else
			{
				test.fail("password field is not visible");
				test.addScreenCaptureFromPath(utilities.captureScreenshot(driver), "login failure");
				return false;
			}
	}
	/**
	 * this method clicks on login button
	 * @param driver webDriver type
	 * @return true if click successful
	 * @throws IOException 
	 */
	
//**********************************************************************************************************************************	
		public boolean clickLogin(WebDriver driver) throws IOException {
			if(username.isDisplayed()) {
				loginButton.click();
				test.info("login is clicked");
				return true;
			}else
			{
				test.fail("clicklogin  is not visible");
				test.addScreenCaptureFromPath(utilities.captureScreenshot(driver), "login failure");
				return false;
			}
		
	}
		//*******************************************************************************************************************
	
	public void ctearPassword() 
	{
		password.clear();
	}
	//***********************************************************************************************************************
	
	public boolean isErrorMessageSeen(WebDriver driver) throws IOException
	{
		if(loginErrorMessage.isDisplayed()) 
		{
			test.info("error message is displayed");
			return true;
		}else {
			test.fail("errormessage is not displayed");
			test.addScreenCaptureFromPath(utilities.captureScreenshot(driver), "errormessage failure");
			return false;
		}
	}
//**********************************************************************************************************************************	
	public boolean isSavedUsernameSeen(WebDriver driver) throws IOException {
		if(isSavedUsername.isDisplayed())
		{
			test.info("username is displayed");
			return true;
		}else {
			test.fail("savedUsername is not displayed");
			test.addScreenCaptureFromPath(utilities.captureScreenshot(driver), "errormessage failure");
			return false;
		}
	}
//***********************************************************************************************************************************	
	
	public String getSavedUsername() {
		return isSavedUsername.getText();
	}
	
	
	public boolean selectRememberMecheckbox() {
		boolean checkboxStatus=false;
		if(rememberMe.isSelected())
		{
			checkboxStatus= true;
			test.info("rememberMeCheckBox is displayed");
		}else {
			rememberMe.click();
			checkboxStatus=true;
		}
		return checkboxStatus;
	}
	
//******************************************************************************************************************************************	
	public boolean forgotPasswordTest(WebDriver driver) throws IOException
	{
		boolean passwordStatus=false;
		if(forgotPassword.isDisplayed())
		{
			forgotPassword.clear();
			test.info("password fiels is empty");
			return true;
		}else {
			test.fail("password is entered");
			test.addScreenCaptureFromPath(utilities.captureScreenshot(driver), "errormessage failure");
			return false;
		}
	}
	
public boolean launch(WebDriver driver)
{
	driver.get("https://login.salesforce.com");
	driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
	return true;
}



	
	

}
