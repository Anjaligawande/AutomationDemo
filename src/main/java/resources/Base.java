package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	public WebDriver driver;
	public Properties prop;

	
	public WebDriver initializeDriver() throws IOException {
		 prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\DELL\\eclipse-workspace\\E2EProject\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		System.out.println(browserName);

		if (browserName.equals("chrome") ) {

			System.setProperty("webdriver.chrome.driver", "D:\\chromedriver\\chromedriver.exe");
			 driver = new ChromeDriver();

		}

		else if (browserName.equals("firefox") )
		{
			// D:\\geckodriver\\geckodriver.exe
			System.setProperty("webdriver.gecko.driver", "D:\\geckodriver\\geckodriver.exe");
			 driver = new ChromeDriver();

		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	

	}
	public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		
		FileUtils.copyFile(source,new File(destinationFile));
		return destinationFile;


	}

}
