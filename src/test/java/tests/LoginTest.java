package tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.swing.text.Utilities;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Utilities.utilities;
import junit.framework.Assert;
import pages.LoginPage;
import pages.UseMenuPage;

public class LoginTest extends BaseTest{
	
	@Test
	public void loginErrorMessage_TC1() throws IOException
	{
		ExtentTest test=extent.createTest("loginErrorMessage_TC1");
		WebDriver driver=BaseTest.getDriver();
		LoginPage lp=new LoginPage(driver, test);//login page object is created
		Assert.assertTrue("should launch the app", lp.launch(driver));
		Assert.assertTrue("user name should be entered",lp.enterUsername(driver, "teju32@ma.com"));
		lp.ctearPassword();
		Assert.assertTrue("login button should be clicked", lp.clickLogin(driver));
		Assert.assertEquals(lp.loginErrorMessage.getText(), "Please enter your password.");
	}
	
	
	@Test
	public void loginToSF_TC02() throws IOException
	{
		WebDriver driver=BaseTest.getDriver();
		ExtentTest test=extent.createTest("loginToSF_TC02");
		LoginPage lp=new LoginPage(driver, test);//login page object is created
		Assert.assertTrue("should launch the app", lp.launch(driver));
		Assert.assertTrue("user name should be entered", lp.enterUsername(driver, "teju32@ma.com"));
		lp.ctearPassword();
		Assert.assertTrue(null, lp.enterPassword("Tejumanu32",driver));
		Assert.assertTrue("login button should be clicked", lp.clickLogin(driver));
		Assert.assertEquals(lp.isFreeTrialIsSeen(driver), "free trial should  not be seen");
		
	}
	
	
	@Test
	public void rememberMe_TC03() throws IOException
	{
		WebDriver driver=BaseTest.getDriver();
		ExtentTest test=extent.createTest("rememberMe_TC03");
		LoginPage lp=new LoginPage(driver, test);//login page object is created
		UseMenuPage ump=new UseMenuPage(driver, test);
		Assert.assertTrue("user name should be entered", lp.enterUsername(driver, "teju32@ma.com"));
		//driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		Assert.assertTrue("should launch the app", lp.launch(driver));
		Assert.assertTrue("user name should be entered",lp.enterUsername(driver,"teju32@ma.com"));
		Assert.assertTrue("password should be entered",lp.enterPassword("Tejumanu32", driver) );
		//lp.enterPassword("Tejumanu32",driver)
		Assert.assertTrue("should select remember me check box", lp.selectRememberMecheckbox());
		Assert.assertTrue("login button should be clicked", lp.clickLogin(driver));
		Assert.assertTrue("user menu should be opened", ump.clickOnUserMenu());
		Assert.assertTrue("logout should be clicked", ump.selectOptionInUserMenuDropdown(driver, "Logout"));
		utilities.waitForElement(driver, lp.isSavedUsername);
		Assert.assertEquals(lp.getSavedUsername(), "teju32@ma.com");
		
	}	
	

		
		
	
/*	@Test
	public void forgerPassword_TC04()
	{
		WebDriver driver=BaseTest.getDriver();
		LoginPage lp=new LoginPage(driver);//login page object is created
		UseMenuPage ump=new UseMenuPage(driver);
		//driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		Assert.assertTrue("should launch the app", lp.launch(driver));
		Assert.assertTrue("user name should be entered", lp.enterUsername("teju32@ma.com"));
		Assert.assertTrue("password should be entered", lp.password.clear());
		Assert.assertTrue("password should be entered", lp.forgotPasswordTest());
		Assert.assertTrue("login button should be clicked", lp.clickLogin(driver));
	}*/
	
	
	
}


















