package pageObjects;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	public WebDriver driver;
	
	By login= By.cssSelector("a[href*='sign_in']");
	By title= By.cssSelector("div[class='container'] div[class='text-center']");
	By navBar= By.cssSelector(".navbar-collapse.collapse");
	
	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public WebElement getLogin()
	{
		return driver.findElement(login);
	}
	public WebElement getTitle()
	{
		return driver.findElement(title);
	}
	public WebElement getNavigationBar()
	{
		return driver.findElement(navBar);
	}
	
			

}
