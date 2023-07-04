package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Loginpageddt extends BasePage {

	public Loginpageddt(WebDriver driver) 
	{
		super(driver);	
	}
	//Element
		@FindBy(name="username")WebElement usern;
		@FindBy(name="password")WebElement pass;
		@FindBy(xpath="//button[@type='submit']")WebElement submitbutton;
		
		//actions
		public void setUserName(String username)
	    {
			usern.sendKeys(username);
	    }
		public void setUserPassword(String password)
		{
			pass.sendKeys(password);
		}
		public void clickLogin()
		{
			submitbutton.click();
		}

}
