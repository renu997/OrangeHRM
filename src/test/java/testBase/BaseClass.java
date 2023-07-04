package testBase;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.beust.jcommander.Parameters;

import java.util.ResourceBundle;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClass {
	
  public ResourceBundle rb;// to read config.properties
  public  WebDriver driver;
  public Logger logger;
  
  @BeforeClass
  public void Setup() 
  {
	  rb = ResourceBundle.getBundle("config");// Load config.properties
	  
	  logger=LogManager.getLogger(this.getClass());//generate log 
	  
	
	  ChromeOptions options=new ChromeOptions();
	  options.setExperimentalOption("excludeSwitches",new String[] {"enable-automation"});
	  
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver(options);
	  
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  
	  driver.get(rb.getString("appURL"));
	  
	  driver.manage().window().maximize();
	  
  }
  
  @AfterClass
  public void tearDown()
  {
	driver.close();  
  }
  // random number,string,alphanumeric generate
  /*public String randomString()
  {
	  String generateString = RandomStringUtils.randomAlphabetic(5);
	  return generateString;
  }
  public String randomNumber()
  {
	  String generateNumber = RandomStringUtils.randomNumeric(10);
	  return generateNumber;
  }
  public String randomAlphaNumeric()
  {
	  String generateAlphaNumeric = RandomStringUtils.randomAlphanumeric(7);
	  return generateAlphaNumeric;
  }*/
}
