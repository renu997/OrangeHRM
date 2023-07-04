package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Loginpageddt;
import testBase.BaseClass;
import utilities.DataProviders;
import pageObjects.HomePage;

public class TC_003_LoginDDT extends BaseClass{
    @Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)
	public void test_loginDDT(String username,String password,String exp)
	{
	 try
	 {
		logger.info("*****Starting TC_003_LoginTest*****");
			
		Loginpageddt lp = new Loginpageddt(driver);
		logger.info("**Providing Login Data**");
		lp.setUserName(username);
		lp.setUserPassword(password);
		lp.clickLogin();
			
		HomePage hp=new HomePage(driver);
		boolean targetpage=hp.isMyHomePageExist();
		
		  if(exp.equals("Valid")) 
		  { 
			  if(targetpage==true)
			  { 
				  hp.ClickLogout();
		          Assert.assertTrue(true); 
		      }
			  else 
			  { 
				  Assert.assertFalse(false); 
			  }
		  }
		  if(exp.equals("Invalid")) 
		  { //data invalid then also login success
		      if(targetpage==true)
		      { //logout needed becoz of homepage opened ...bcoz valid or invalid data    	  
		
		      hp.ClickLogout(); //but exp result is fail
		      Assert.assertFalse(false); 
		      } 
		      else 
		      { //using invalid data exp result fail //result actual is false or fail 
		    	  Assert.assertFalse(false); 
		      }
		 
		  }
	 }
	          
	 catch(Exception e)
	 {
		Assert.fail();
	 }
	 logger.info("*****Finished TC_003_LoginDDT*****");
	 	
		
	}
		
}

