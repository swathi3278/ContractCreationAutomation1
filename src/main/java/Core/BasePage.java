package main.java.Core;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	//locator
	By byViperLogo = By.xpath("//div/a[@class='logo']/img[@alt='Viper']");
	
	
	protected WebDriver driver;	
	WebDriverWait wait = null;
	
	public BasePage() { }
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Integer.valueOf(System.getProperty("explicitWait")));
	}
	
	protected WebElement getElement(By by) throws Exception{
		 Thread.sleep(2000);
		wait.until(ExpectedConditions.presenceOfElementLocated(by));
		WebElement ele = driver.findElement(by);		
		Actions actions = new Actions(driver);
		actions.moveToElement(ele).perform();
		return ele;
	}
	
	protected String getRandomStrinng(int length, String type) throws Exception{
		String randomString = "";
		String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		String numeric = "1234567890";
		String alphanumeric = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
		Random random = new Random();
		
		switch(type) {
		case "ALPHA" : 
			break;
		case "NUMERIC": randomString = String.valueOf(random.nextInt(100000000)).substring(0,length);		
			break;
		case "ALPHANUMERIC":
			break;
		}
		
		return randomString;
	}
	
	public void clickLogo() throws Exception{
		getElement(byViperLogo).click();
	}
	
	protected boolean verifyElementPresent(By by) throws Exception{
		boolean isPresent = true;
		try {		   
			wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.presenceOfElementLocated(by));
			WebElement ele = driver.findElement(by);
		}
		catch(Exception ex) {
			isPresent = false;
		}
		return isPresent;
	}
	
}
