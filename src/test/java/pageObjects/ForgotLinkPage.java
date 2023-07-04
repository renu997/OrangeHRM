package pageObjects;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class ForgotLinkPage extends BasePage {

	public ForgotLinkPage(WebDriver driver) {
		super(driver);
	}
	//element
	@FindBy(xpath="//p[@class='oxd-text oxd-text--p orangehrm-login-forgot-header']")WebElement flink;
	@FindBy(xpath="//input[@placeholder='Username']")WebElement UserName;
	@FindBy(xpath="//button[@type='submit']")WebElement Resetpass;
	@FindBy(xpath="//button[@type='button']")WebElement Cancelreset;
	
	

	//actions
	public void ClickForgot()
	{
		flink.click();
	}
	public void Enterusername()
	{
		
		UserName.sendKeys("Admin");
	}
	public void ClickResetpass()
	{
		Resetpass.click();
	}
	public void CancelResetpass()
	{
		Cancelreset.click();
	}
	
	public String txtResetSuccessful()
		{
			String txt= Resetpass.getText();
			return txt;
		}
		
	}


