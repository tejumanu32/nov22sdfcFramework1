package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * this class contains the object repository of login page
 * @author bcm43
 *
 */
public class LoginPage extends BasePage {
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="username")
	public WebElement username;
	
	@FindBy(name="pw")
	public WebElement password;
	
	@FindBy(id="Login")
	public WebElement loginButton;
	
	@FindBy(xpath="//*[@id='remamberUn']")
	public WebElement rememberMe;
	
	@FindBy(css="#error")
	public WebElement loginErrorMessage;
	
	@FindBy(partialLinkText ="Forgot your")
	public WebElement forgotPassword;
	
	/**
	 * this method enters the userName. call this when you are on login page
	 * @param userName String type
	 * @param driver webDriver type
	 * @return true if user name is entered
	 */
	public boolean enterUsername(String userName,WebDriver driver) {
		if(username.isDisplayed()) {
			this.username.sendKeys(userName);
			return true;
		}else
		{
			return false;
		}
	}
		
	/**
	 * this method enters the password.call this when you are in logonPage
	 * @param pass string type
	 * @param driver webDriver type
	 * @return true if password is entered
	 */
	public boolean enterPassword(String pass,WebDriver driver) {
		if(password.isDisplayed()) {
			this.password.sendKeys(pass);
			return true;
			}else
			{
			return false;
			}
	}
	/**
	 * this method clicks on login button
	 * @param driver webDriver type
	 * @return true if click successful
	 */
		public boolean clickLogin(WebDriver driver) {
			if(username.isDisplayed()) {
				this.loginButton.click();;
				return true;
			}else
			{
				return false;
			}
		
	}
	
	





	
	

}
