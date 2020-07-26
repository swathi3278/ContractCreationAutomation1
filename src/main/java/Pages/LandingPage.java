package main.java.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage extends main.java.Core.BasePage {
	
	public LandingPage(WebDriver driver) {
		super(driver);
	}
	
	//locators
	By bySearch = By.xpath("//div//div//div[@class='mat-select-value']");
	By bySearchDunsDropdown = By.xpath("//div/mat-option/span[@class='mat-option-text']/span[.='D-U-N-S']");
	By byDunsNumber = By.xpath("//div/div/div[@class='mat-form-field-infix']/input[@formcontrolname='duns']");
	/*BybySearchButton = By.xpath("//div/button/span");*/
	By bySearchButton = By.xpath("//span[text()=' Search ']");
	
	By byCreateNewSubscriberContract = By.xpath("//*[ contains(@translate, 'search.create-new-subscriber-contract') and contains(.,'Create New Subscriber Contract')]");
	By byCreateContract = By.xpath("//button//span[contains(.,' Create New Contract ')]");
	
	public void PerformDUNSSearch(String dNumber) throws Exception{
		
		getElement(bySearch).click();
		getElement(bySearchDunsDropdown).click();
		getElement(byDunsNumber).click();
		getElement(byDunsNumber).sendKeys(dNumber);;
		getElement(bySearchButton).click();		
		
	}
	
	public CreateContractPage clickNewSubscriberContract() throws Exception{
		if(verifyElementPresent(byCreateNewSubscriberContract)) {
			getElement(byCreateNewSubscriberContract).click();
		} else {
			getElement(byCreateContract).click();			
		}
		return new CreateContractPage(driver);	
	}

}
