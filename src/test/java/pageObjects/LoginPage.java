package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ResourceBundle;

public class LoginPage extends BasePage{

	public ResourceBundle rb;//= ResourceBundle.getBundle("config");// Load config.properties
	public LoginPage(WebDriver driver)
	{
		super(driver);
		
	}
	//Element
	@FindBy(name="username")WebElement usern;
	@FindBy(name="password")WebElement pass;
	@FindBy(xpath="//button[@type='submit']")WebElement submitbutton;
	
	
	//Action methods
	
	  public void setUserName() 
	  { 
	  usern.sendKeys(rb.getString("username")); 
	  }
	  public void setUserPassword() 
	  { 
	  pass.sendKeys(rb.getString("password")); 
	  }
	  public void clickLogin() 
	  { 
	  submitbutton.click(); 
	  }
	  
	}
	

