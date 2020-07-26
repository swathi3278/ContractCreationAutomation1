package test.java.Tests;

import org.testng.annotations.Test;

import main.java.Core.ExcelUtility;
import main.java.Pages.CreateContractPage;
import main.java.Pages.LandingPage;
import main.java.Pages.LoginPage;

public class ContractTest extends main.java.Core.BaseTest{

	@Test
	public void CreateAndValidateCanadaCatract() throws Exception {		
			LoginPage loginPage = new LoginPage(driver);
			LandingPage landingPage = loginPage.performUserLogin("dnbstage@yopmail.com", "Password123");
			for(int index=0; index < ExcelUtility.lTestData.size(); index++){				
				landingPage.PerformDUNSSearch(ExcelUtility.lTestData.get(index).get("DUNS"));
				CreateContractPage createContractPage =  landingPage.clickNewSubscriberContract();
				createContractPage.Row = index;
				createContractPage.createContract(ExcelUtility.lTestData.get(index));
				createContractPage.clickLogo();    
				ExcelUtility.updateResult(index+1, true);
		}
	}
	
	@Test
	public void CreateContractEPUSCreditAdvOT() throws Exception {
		
		LoginPage loginPage = new LoginPage(driver);
		LandingPage landingPage = loginPage.performUserLogin("dnbstage@yopmail.com", "Password123");
		//for(HashMap<String, String> test : ExcelUtility.lTestData) 
		for(int index=0; index < ExcelUtility.lTestData.size(); index++){
				System.out.println("Create Contrat2");
				landingPage.PerformDUNSSearch(ExcelUtility.lTestData.get(index).get("DUNS"));
				CreateContractPage createContractPage =  landingPage.clickNewSubscriberContract();
				createContractPage.createContract(ExcelUtility.lTestData.get(index));
				createContractPage.clickLogo();    
				ExcelUtility.updateResult(index+3, true);
		}
    }
	
	@Test
	public void CreateContractEPUSCreditPremiumOT1() throws Exception {
		
		LoginPage loginPage = new LoginPage(driver);
		LandingPage landingPage = loginPage.performUserLogin("dnbstage@yopmail.com", "Password123");
		//for(HashMap<String, String> test : ExcelUtility.lTestData) 
		for(int index=0; index < ExcelUtility.lTestData.size(); index++){
				System.out.println("Create Contrat3");
				landingPage.PerformDUNSSearch(ExcelUtility.lTestData.get(index).get("DUNS"));
				CreateContractPage createContractPage =  landingPage.clickNewSubscriberContract();
				createContractPage.createContract(ExcelUtility.lTestData.get(index));
				createContractPage.clickLogo();    
				ExcelUtility.updateResult(index+5, true);
		}
    }
	
	@Test
	public void CreateContractEPUSCreditPremiumOT() throws Exception {
		
		LoginPage loginPage = new LoginPage(driver);
		LandingPage landingPage = loginPage.performUserLogin("dnbstage@yopmail.com", "Password123");
		//for(HashMap<String, String> test : ExcelUtility.lTestData) 
		for(int index=0; index < ExcelUtility.lTestData.size(); index++){
				System.out.println("Create Contrat3");
				landingPage.PerformDUNSSearch(ExcelUtility.lTestData.get(index).get("DUNS"));
				CreateContractPage createContractPage =  landingPage.clickNewSubscriberContract();
				createContractPage.createContract(ExcelUtility.lTestData.get(index));
				createContractPage.clickLogo();    
				ExcelUtility.updateResult(index+5, true);
		}
    }
}
