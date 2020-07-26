package main.java.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends main.java.Core.BasePage{
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	//locatores
	By byUserNameTextbox = By.id("username");
	By byPasswordTextbox = By.id("password");
	By byContinueButton = By.xpath("//span[text()='Continue']");
	

	public LandingPage performUserLogin(String userName, String password) throws Exception {
		getElement(byUserNameTextbox).sendKeys(userName);
		getElement(byContinueButton).click();
		getElement(byPasswordTextbox).sendKeys(password);
		getElement(byContinueButton).click();
		Thread.sleep(10000);
		return new LandingPage(driver);		
	}
	
}
