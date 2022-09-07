package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import pageObjects.LandingPage;
import resources.Base;

public class ValidateTitle extends Base {
	public WebDriver driver;
	public static Logger log=	LogManager.getLogger(Base.class.getName());
	
	@ BeforeTest 
	public void initialize() throws IOException
	{
		driver= initializeDriver();
		driver.get(prop.getProperty("url"));
	}
	
	@ Test
	
	public void landingPageNavigation() throws IOException
	{
		
		LandingPage ln= new LandingPage(driver);
		Assert.assertEquals(ln.getTitle().getText(), "FEATURED COURSES12");
		log.info("validated text");
		 System.out.println("Test completed");
		
		
	}
	@AfterTest  
	public void browserClose()
	{
		driver.close();
	}
	

}
