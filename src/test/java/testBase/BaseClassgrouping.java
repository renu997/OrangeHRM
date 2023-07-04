package testBase;

import java.time.Duration;
import java.util.ResourceBundle;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager; //for logger
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClassgrouping {
	
		public ResourceBundle rb;// to read config.properties
		
		public Logger logger;// for Logging
		
		public static WebDriver driver;  // make it static so that you can use same instance in Extent report manager
		

		@BeforeClass(groups = { "Master", "Sanity", "Regression" }) //Step8 groups added
		@Parameters("browser")   // getting browser parameter from testng.xml
		public void setup(String br)
		{
			rb = ResourceBundle.getBundle("config");// Load config.properties
					
			logger = LogManager.getLogger(this.getClass());// for Logger  
			
			//launch right browser based on parameter
			if (br.equals("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			} else if (br.equals("edge")) {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
			} else {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}
						
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			driver.get(rb.getString("appURL")); // get url from config.properties file
			driver.manage().window().maximize();
		}

		@AfterClass(groups = { "Master", "Sanity", "Regression" }) //Step8 groups added
		public void tearDown() 
		{
			driver.close();
		}

	}


