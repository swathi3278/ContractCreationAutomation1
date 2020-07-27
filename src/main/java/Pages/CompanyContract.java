package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import Core.BasePage;

public class CompanyContract extends BasePage {

	// locator
	static By byBackButton = By.xpath("//button//span[contains(.,'Back')]");

	public CompanyContract(WebDriver driver) throws Exception {
		super(driver);
		verifyPage();
	}

	
	  public void verifyPage() throws Exception{ 
		  System.out.println("verifyPageCompanyContract");
		  Assert.assertNotNull(getElement(byBackButton), "Company Contract page is not loaded"); 
	  }
	

}
