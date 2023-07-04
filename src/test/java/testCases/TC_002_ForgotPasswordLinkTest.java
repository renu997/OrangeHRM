package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

import testBase.BaseClass;
import pageObjects.ForgotLinkPage;
//import pageObjects.WebDriverWait;


public class TC_002_ForgotPasswordLinkTest extends BaseClass {
	 
	ForgotLinkPage fp;
	//Wait<WebDriver>mywait=new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);
			
	@Test(priority=1)
	public void forgotPassword() throws InterruptedException
	{
		fp=new ForgotLinkPage(driver);
		fp.ClickForgot();
		logger.info("**Clicked on forgot link**");
		Thread.sleep(2000);
	}	
	@Test(priority=2)
		public void ResetPassword()
		{
		 fp.Enterusername();
		 logger.info("**Providing username**");
		 fp.ClickResetpass();
		 logger.info("**Clicked on reset password button**");
		//String s = fp.txtResetSuccessful();
		//System.out.println(s);
		}
	@Test(priority=3)
	public void CancelResetpass() throws InterruptedException
	{
		driver.navigate().back();
		Thread.sleep(3000);
		fp.CancelResetpass();
		logger.info("**Clicked on cancel button**");
	}
	}

