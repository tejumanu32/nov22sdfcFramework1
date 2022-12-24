package pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import Utilities.utilities;
public class UseMenuPage extends BasePage {
	
	public UseMenuPage(WebDriver driver,ExtentTest test)
	{
		PageFactory.initElements(driver, this);
		this.test=test;
	}
	
	@FindBy(id="userNavLabel")
	public WebElement userMenu;
	
	@FindBy(id="//div[@id='userNav-menuItems']//a")
	public List<WebElement> userMenuOption;
	
	@FindBy(xpath="//div[@id='userNav-menuItems']//a[1]")
	public WebElement MyProfile;
	
	@FindBy(xpath="//div[@id='userNav-menuItems']//a[2]")
	public WebElement MySettings;
	
	@FindBy(xpath="//div[@id='userNav-menuItems']//a[3]")
	public WebElement DeveloperConsole;
	
    @FindBy(xpath="//div[@id='userNav-menuItems']//a[4]")
    public WebElement SwichToLightningExperience;
    
    @FindBy(xpath="//div[@id='userNav-menuItems']//a[5]")
    public WebElement Logout;
    
    //my profile
    @FindBy(xpath="(//div[@class='editPen'])[1]/a/img")
    public WebElement editProfilebutton;
    
    @FindBy(xpath="//div[@id='contactInfoContent']")
    public WebElement EditProfilePopupWindow;
    
    //about tab
    @FindBy(id="aboutTab")
    public WebElement AboutTagOnProfile;
    
    //lastname
    @FindBy(name="lastName")
    public WebElement LastnameOnAbouttag;
    
    @FindBy(xpath="//input[@value='Save All']")
    public WebElement SaveallOnAbouttab;
    
    //file
    @FindBy(linkText="File")
    public WebElement FileonMyProfile;
    
    @FindBy(id="chatterUploadFileAction")
    public WebElement UploadaFileFromYourComputer;
    
    @FindBy(id="chatterFile")
    public WebElement ChooseFileForFile;
    
    @FindBy(id="publishersharebutton")
    public WebElement ShareButtonOnFile;
    
    
    //post link
    @FindBy(xpath="//a[@id='publisherAttachTextPost']/span[1]")
    public WebElement ClickOnPostLink;
    
    @FindBy(xpath="//iframe[@class='cke_wysiwyg_frame cke_reset']")
    public WebElement SwichToNewWindow;
    
    @FindBy(xpath="//body[@spellcheck='true']")
    public WebElement EnterPostText;
    
    @FindBy(id="publishersharebutton")
    public WebElement ShareButtonOnPost;
    
    /**
     * this function is responsible to verify user menu items in user menu dropdown
     * this function has to be called after clicking on user menu
     * @return{Boolean} true if all options are verified successfully else return false
     */
    public boolean verifyUserMenuItems() {
    	boolean isoptionVerified=true;
    	String[] expectedUserMenuItems= {"My Profile", "My Settings", "Developer Console", "Swich to Lightning Experience","Logout"};
    	for(int i=0;i< userMenuOption.size();i++) {
    		String actualUserMenuItemValue= userMenuOption.get(i).getText();
    		if(actualUserMenuItemValue.equals(expectedUserMenuItems[i])) {
    		 	System.out.println("the option"+ expectedUserMenuItems[i]+"passed");
    		}else
    		{
    			System.out.println("the option"+ expectedUserMenuItems[i]+"failed");
    			isoptionVerified=false;

    		}
    		
    	}return isoptionVerified;
    }
 //*****************************************************************************************************************   
    
    /**
     * this function is responsible to verify user menu items in user menu dropdown
     * by passing an option name
     * @param optionNameExample: {"My Profile","Settings"}
     * @return{Boolean} true if option is selected or false
     */
   public boolean selectOptionInUserMenuDropdown(WebDriver driver ,String optionName)
   {
	  boolean isOptionSelected=false;
	  WebElement userMenuOption=driver.findElement(By.xpath("//*[text()='"+optionName +"']"));
	  if(userMenuOption.isDisplayed()) {
		  userMenuOption.click();
		  isOptionSelected=true;
	  }else
	  {
		  System.out.println("option "+ optionName + "notselected");
		  
	  }return isOptionSelected;
   }
   
   
 //*******************************************************************************************************  
   /**
    * this function will create post,should be called on my profile
    * @param EnterPostText webElment
    * @param message to be posted in text box 
    * @return true if post is created else  false
    */
     public boolean createPost(WebDriver driver,String message) {
	   boolean isPostCreated=false;
	   if(ClickOnPostLink.isDisplayed()) {
		   ClickOnPostLink.click();
		   System.out.println("clicked on the text box");
		   driver.switchTo().frame(0);
		   EnterPostText.sendKeys(message);
		   driver.switchTo().defaultContent();
		   System.out.println("enter the text in text box");
		   if(ShareButtonOnPost.isDisplayed()) {
			   ShareButtonOnPost.click();
			   System.out.println("clicked on the post button");
			   isPostCreated=true;
		   }
	   }return isPostCreated;
   }
     
   //***********************************************************************************************************  
     public boolean isUserMenuSeen() 
     {
    	 if(userMenu.isDisplayed()) 
    	 {
    		 return true;
          }else
          {
        	  return false;
          }
     }
     
    //******************************************************************************************************* 
     public boolean clickOnUserMenu() {
     if(userMenu.isDisplayed()) {
    		 userMenu.click();
    	 }return true;
     }
   //******************************************************************************************************** 
     public boolean openEditProfileModal() {
    	 boolean isEditProfilrWindowSeen=false;
    	 if(editProfilebutton.isDisplayed()) {
    		 editProfilebutton.click();
    		 if(EditProfilePopupWindow.isDisplayed())
    		 {
    			 isEditProfilrWindowSeen=true;
    			 
    		 }
    	 }return isEditProfilrWindowSeen;
     }
     
    //**************************************************************************************************************
     public boolean changeLastNameInAboutTag(WebDriver driver,String lastName) throws IOException {
    	 driver.switchTo().frame("contactInfoContentId");
    	 boolean isLastNameChanged=false;
    	 if(AboutTagOnProfile.isDisplayed())
    	 {
    		 AboutTagOnProfile.click();
    		 test.info("about tab is seen");
    		 if(LastnameOnAbouttag.isDisplayed()) 
    		 {
    			 LastnameOnAbouttag.clear();
    			 LastnameOnAbouttag.sendKeys(lastName);
    			 SaveallOnAbouttab.click();
    			 test.info("clicked on saveall button");
    			 isLastNameChanged=true;
    		 }else 
    		 
    		 {
    			 test.fail("About name tab is not visible");
    			 test.addScreenCaptureFromPath(utilities.captureScreenshot(driver));
    			 
    		 }
    	 }else 
    		 {
    			 test.fail("About tab is not visible");
    				test.addScreenCaptureFromPath(utilities.captureScreenshot(driver));
    		 }
    	 
 
    	 driver.switchTo().defaultContent();
    	 return isLastNameChanged;
    	}
     }