package testCases;

import org.testng.annotations.Test;

import junit.framework.Assert;
import testBase.BaseClass;
import testBase.BaseClassgrouping;
import pageObjects.LoginPage;

public class TC_001_LoginTest extends BaseClassgrouping {
	
	//LoginPage lp = new LoginPage(driver);
	@Test(groups= {"Sanity","Master"}) //Step8 groups added
	public void UserLogin() throws InterruptedException
	{
		logger.info("application logs....");
		
		try{
			LoginPage lp = new LoginPage(driver);
		lp.setUserName();
		logger.info("**Providing UserName data**");
		Thread.sleep(3000);
		lp.setUserPassword();
		logger.info("**Providing UserPassword data**");
		Thread.sleep(3000);
		lp.clickLogin();
		logger.info("**Clicked on login button**");
		
		String s=driver.getTitle();
		if(s.equals("OrangeHRM"))
		{
			System.out.println(s);
			Assert.assertTrue(s, true);
		}
		}
		catch(Exception e)
		{
			Assert.assertFalse("fail test case", false);
		}
	}
}
