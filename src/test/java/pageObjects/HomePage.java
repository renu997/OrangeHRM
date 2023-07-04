package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
    
	//element
    @FindBy(xpath="//div[@class='oxd-topbar-header-title']")WebElement msgHeading;;
	
	
	@FindBy(xpath="//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")WebElement ddown;
	@FindBy(xpath="//ul[@class='oxd-dropdown-menu']//li")List<WebElement> options;

	//actions
	public boolean isMyHomePageExist()   // MyAccount Page heading display status
	{
		try 
		{
			return (msgHeading.isDisplayed());
		} 
		catch (Exception e) 
		{
			return (false);
	    }
		
	}
	/*
	 * public void Checktitle() { // TODO Auto-generated method stub String title=
	 * driver.getTitle(); System.out.println(title); }
	 */
	/*
	 * public void ClickDDown() { ddown.click(); }
	 */
	public void ClickLogout()
	{
		ddown.click();
		options.size();
		for(int i=0;i<options.size();i++)
		{
			String s=options.get(i).getText();
			
			if(s.equals("Logout"))
			{
				options.get(i).click();
			}
		}
	}
	
	
	
}
