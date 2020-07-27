package Tests;

import org.testng.annotations.Test;

import Core.BaseTest;
import Core.ExcelUtility;
import Pages.CreateContractPage;
import Pages.LandingPage;
import Pages.LoginPage;

public class ContractTest extends BaseTest{

	@Test
	public void CreateAndValidateCanadaCatract() throws Exception {
		System.out.println(ExcelUtility.startRow + " -" + ExcelUtility.endRow);
			LoginPage loginPage = new LoginPage(driver);
			LandingPage landingPage = loginPage.performUserLogin("dnbstage@yopmail.com", "Password123");			
			for(int index = 0; index < ExcelUtility.rowCount; index++){		
			try {
					landingPage.PerformDUNSSearch(ExcelUtility.lTestData.get(index).get("DUNS"));
					CreateContractPage createContractPage =  landingPage.clickNewSubscriberContract();
					createContractPage.Row = index + ExcelUtility.startRow;
					createContractPage.createContract(ExcelUtility.lTestData.get(index));
					createContractPage.clickLogo();  
					ExcelUtility.updateResult(index + ExcelUtility.startRow, true, "");
				}
				catch (Exception ex) {
					ExcelUtility.updateResult(index + ExcelUtility.startRow, false, ex.getMessage());
				}			
		     }
		}
	
	@Test
	public void CreateContractEPUSCreditAdvOT() throws Exception {
		System.out.println(ExcelUtility.startRow + " -" + ExcelUtility.endRow);
		LoginPage loginPage = new LoginPage(driver);
		LandingPage landingPage = loginPage.performUserLogin("dnbstage@yopmail.com", "Password123");
		 int row = 0;
		for(int index=ExcelUtility.startRow; index < ExcelUtility.endRow; index++){		
			try {
				landingPage.PerformDUNSSearch(ExcelUtility.lTestData.get(index).get("DUNS"));
				CreateContractPage createContractPage =  landingPage.clickNewSubscriberContract();
				createContractPage.Row = index;
				createContractPage.createContract(ExcelUtility.lTestData.get(index));
				createContractPage.clickLogo();  
				ExcelUtility.updateResult(index, true, "");
			}
			catch (Exception ex) {
				ExcelUtility.updateResult(index, false, ex.getStackTrace().toString());
			}
	     }
    }
	
	@Test
	public void CreateContractEPUSCreditPremiumOT() throws Exception {
		LoginPage loginPage = new LoginPage(driver);
		LandingPage landingPage = loginPage.performUserLogin("dnbstage@yopmail.com", "Password123");
		int row = 0;
		for(int index=ExcelUtility.startRow; index < ExcelUtility.endRow; index++){		
			try {
				landingPage.PerformDUNSSearch(ExcelUtility.lTestData.get(row).get("DUNS"));
				CreateContractPage createContractPage =  landingPage.clickNewSubscriberContract();
				createContractPage.Row = index;
				createContractPage.createContract(ExcelUtility.lTestData.get(row));
				createContractPage.clickLogo();  
				ExcelUtility.updateResult(index, true, "");
			}
			catch (Exception ex) {
				ExcelUtility.updateResult(index, false, ex.getMessage());
			}
	     }
    }
}
