package Academy;

import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class HomePage extends Base {
	public WebDriver driver;

	public static Logger log=	LogManager.getLogger(Base.class.getName());
	
	@ BeforeTest 
	public void initialize() throws IOException
	{
		driver= initializeDriver();
		log.info("browser is initialised");
	}
	
	@Test(dataProvider="getData")
	
	public void homePageNavigation(String username, String password) throws IOException
	{
		driver.get(prop.getProperty("url"));
		
		LandingPage ln= new LandingPage(driver);
		
		ln.getLogin().click();
		
		LoginPage lg =new LoginPage(driver);
		lg.email().sendKeys(username);
		lg.password().sendKeys(password);
		lg.login().click();
	log.info("naviagted to login page");

		
	}
	@ DataProvider
	public Object[][] getData()
	{
		Object[][] data = new Object[2][2];
		data[0][0]="restricted@gmail.com";
		data[0][1]="ABHCL";
		log.info("it is restricted user");
		 data[1][0]="nonrestricted@gmail.com";
		data[1][1]="15876";
		log.info("it is non restricted user");
	
		return data;
	}
	
	@AfterTest  
	public void browserClose()
	{
		driver.close();
	}
	
}
