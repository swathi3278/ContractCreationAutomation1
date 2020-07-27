package Pages;

import java.awt.RenderingHints.Key;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.HashMap;

import javax.crypto.KeyAgreementSpi;

import org.apache.poi.ss.usermodel.DateUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import Core.BasePage;
import Core.ExcelUtility;

public class CreateContractPage extends BasePage {
public int Row = 0; 
		
	public CreateContractPage(WebDriver driver) {
			super(driver);
	}
	
	//locators
		
		By bySegment = By.xpath("//mat-select[@name='salesMarketSegmentName']//div[@class='mat-select-value']");
		By byCountry = By.xpath("//mat-select[@formcontrolname='country']//div[@class='mat-select-arrow-wrapper']");
		By byEdition = By.xpath("//div//div//div[@class='mat-form-field-infix']/mat-select[@name='edition']");
		By bySubscriberNumber = By.xpath("//input[@formcontrolname='subscriberNumber']");
		By byType = By.xpath("//mat-select[@name='type']//div[@class='mat-select-value']");
		By byStartDate = By.xpath("//input[@formcontrolname='startDate']");
		By byEndDate = By.xpath("//input[@formcontrolname='endDate']");
		By byPackage = By.xpath("//mat-select[@name='package']//div[@class='mat-select-arrow-wrapper']");
		By byAddmeter = By.linkText("+ Add Meter");
		By byAddOn = By.xpath("//mat-select[@name='addOnId']//div[@class='mat-select-arrow-wrapper']");
		By byPremiumCheck = By.xpath("//span[text()=' D&B Credit Premium ']");
		By byPremiumAddon = By.xpath("//span[text()='Add Ons']");
		By byFundMeter = By.xpath("//span[text()=' D&B Credit Funds Meter ']");
		By byAccountupload = By.xpath("//div[@formarrayname='addOnMeters']/div[2]//input[@formcontrolname='meterValue']");
		By byPriceband = By.xpath("//mat-select[@name='priceBand']//div[@class='mat-select-arrow-wrapper']");
		By byFirstName = By.xpath("//input[@formcontrolname='firstName']");
		By byLastName = By.xpath("//input[@formcontrolname='lastName']");
		By byLoginEmail = By.xpath("//input[@formcontrolname='email']");
		By byFillCompanyAddress = By.linkText("Fill with company address");
		By byContractCreateButton = By.xpath("//button[@type='submit']");
		By byViperLogo = By.xpath("//div/a[@class='logo']/img[@alt='Viper']");
		
		By byBisnodeInternational = By.xpath("//*[contains(text(),'Bisnode International')]");
		By byBisnodeDACH = By.xpath("//*[contains(text(),' Bisnode DACH ')]");
		By byAltares = By.xpath("//*[contains(text(),' Altares ')]");
		By byEmergingBusinesses = By.xpath("//*[contains(text(),' Emerging Businesses ')]");
		By byBisnodeCentral = By.xpath("//*[contains(text(),' Bisnode Central ')]");
		By byBisnodeNordics = By.xpath("//*[contains(text(),' Bisnode Nordics ')]");
		By byInforma = By.xpath("//*[contains(text(),' Informa ')]");
		By byCRIFDB = By.xpath("//*[contains(text(),' CRIF D&B ')]");
		By byInterfax = By.xpath("//*[contains(text(),' Interfax ')]");
		By byEnterprise = By.xpath("//*[contains(text(),' Enterprise ')]");
		By byICAP = By.xpath("//*[contains(text(),' ICAP ')]");
		By byBunisessCreditReports = By.xpath("//*[contains(text(),' Bunisess Credit Reports ')]");
		By byCommandCredit = By.xpath("//*[contains(text(),' Command Credit ')]");
		By byNACM = By.xpath("//*[contains(text(),' NACM ')]");
		By byDBIsrael = By.xpath("//*[contains(text(),' D&B Israel ')]");
		By byTSR = By.xpath("//*[contains(text(),' TSR ')]");
		By byHuaxiaDBChina = By.xpath("//*[contains(text(),' Huaxia D&B China ')]");
		By byDunBradstreetTaiwan = By.xpath("//*[contains(text(),' Dun & Bradstreet Taiwan')]");
		By byDunBradstreetHKLTD = By.xpath("//*[contains(text(),' Dun & Bradstreet(HK)LTD ')]");
		
		By bycanada = By.xpath("///div/mat-option/span[@class='mat-option-text' and text()=' Canada ']");
		By byunitedstates = By.xpath("///div/mat-option/span[@class='mat-option-text' and text()=' United States ']");
		By byireland = By.xpath("///div/mat-option/span[@class='mat-option-text' and text()=' Ireland ']");
		By byuk = By.xpath("///div/mat-option/span[@class='mat-option-text' and text()=' United Kingdom ']");
		By byindia = By.xpath("///div/mat-option/span[@class='mat-option-text' and text()=' India ']");
		
		By byCreditunlimitedUS = By.xpath("//span[@title='D&B Credit Unlimited U.S.']");
		By byusandcaunlimitedwithmeter = By.xpath("//span[@title='US and Canada Unlimited with Meter']");
		By byGlobalunlimited = By.xpath("//span[@title='Global Unlimited']");
		By byCreditunlimtedCA = By.xpath("//span[@title='D&B Credit Unlimited CA']");
		By byGFM = By.xpath("//span[@title='Global Fully Metered']");
		By byUnlimiteddomestic = By.xpath("//span[@title='Unlimited Domestic with Meter']");
		By byDomesticEEA = By.xpath("//span[@title='D&B Credit Unlimited Domestic and European (EEA) with Meter']");
		By byUnlimiteddomesticeuropeandamerica = By.xpath("//span[@title='Unlimited Domestic, Europe and Americas with Meter']");
	
		By byoneterm = By.xpath("//span[text() = 'One Term')]");
		By byautorenew = By.xpath("//span[text() = ' Auto Renew ')]");
		By bymultiterm = By.xpath("//span[text() = ' Multi Term')]");
		
		By bypriceband6 = By.xpath("//span[text()=' 6 ']");
		By bypriceband5 = By.xpath("//span[text()=' 5 ']");
		By bypriceband4 = By.xpath("//span[text()=' 4 ']");
		By bypriceband3 = By.xpath("//span[text()=' 3 ']");
		By bypriceband2 = By.xpath("//span[text()=' 2 ']");
		By bypriceband1 = By.xpath("//span[text()=' 1 ']");
		By byContractDetailsTitle = By.xpath("//mat-panel-title[contains(text(),'Contract Details')]");
		
		String SegmentDropdownOption = "//mat-option//span[contains(text(),'@@')]";
		String CountryDropdownOption = "//mat-option//span[contains(text(),'@@')]";
		String EditionDropdownoption = "//mat-option//span[contains(text(),'@@')]";
		String TypeDropdownoption = "//mat-option//span[contains(text(),'@@')]";
		String PackageDropdownoption = "//mat-option//span[contains(text(),'@@')]";
		String PricebandDropdownoption = "//div[contains(@id,'cdk-overlay')]//mat-option//span[contains(text(),'@@')]";
		//String PricebandDropdownoption = "//span[contains(text(),'@@')]";
		
		private void selectSegmentOption(String option) throws Exception{
			System.out.println("selectSegmentOption: " + option);
	    	getElement(bySegment).click();
			getElement(By.xpath(SegmentDropdownOption.replace("@@", option))).click();
	    }
	    
	    private void selectCountryOption(String option) throws Exception{
	    	System.out.println("selectCountryOption: " + option);
	    	getElement(byCountry).click();
			getElement(By.xpath(CountryDropdownOption.replace("@@", option))).click();
	    }
	    
	    private void selectEditionOption(String option) throws Exception{
	    	System.out.println("selectEditionOption: " + option);
	    	getElement(byEdition).click();
			getElement(By.xpath(EditionDropdownoption.replace("@@", option))).click();
	    }
	    
	    private void selectTypeOption(String option) throws Exception{
	    	System.out.println("selectTypeOption: " + option);
	    	getElement(byType).click();
			getElement(By.xpath(TypeDropdownoption.replace("@@", option))).click();
	    }
	    
	    private void selectPackageOption(String option) throws Exception{
	    	System.out.println("selectPackageOption: " + option);
	    	getElement(byPackage).click();
			getElement(By.xpath(PackageDropdownoption.replace("@@", option))).click();
	    }
	    
	    private void selectPriceBand(String option) throws Exception{
	    	System.out.println("selectPriceBand : " + option);
	    	getElement(byPriceband).click();
	    	Thread.sleep(2);
			getElement(By.xpath(PricebandDropdownoption.replace("@@", option))).click();
	    }
	    
	    private void setSubscribeNumber(String content) throws Exception{
	    	System.out.println("setSubscribeNumber: " + content);
	    	ExcelUtility.updateCell(Row, 11, content);
	    	getElement(bySubscriberNumber).click();
			getElement(bySubscriberNumber).sendKeys(content);
	    }
	    
	    private void setStartDate(String startDate) throws Exception {
	    	System.out.println("setStartDate");
	    	SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
	    	
	    	getElement(byStartDate).click();
	    	String date = "";
	    	if(startDate != null && startDate != "") {	
	    		date = String.valueOf(sdf.parse(startDate));
	    	} else {
	    		date = String.valueOf(sdf.format(new Date()));
	    	}
	    	ExcelUtility.updateCell(Row, 17, date);
	    	getElement(byStartDate).sendKeys(date);
	    	System.out.println("setStartDate: " + date);
	    }
	    
	    private void setEndDate(String startDate) throws Exception {
	    	System.out.println("setEndDate");
	    	SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");	    	
	    	getElement(byEndDate).click();
	    	String date = "";
	    	if(startDate != null && startDate != "") {	
	    		date =String.valueOf(sdf.parse(startDate));				
	    	} else {
	    		LocalDate dt = LocalDate.now().plusYears(2);
	    		date = dt.getMonthValue() + "-" + dt.getDayOfMonth()+"-"+dt.getYear();	    		
	    	}
	    	ExcelUtility.updateCell(Row, 18, date);
	    	getElement(byEndDate).sendKeys(date);
	    	System.out.println("setEndDate: " + date);
	    }
	    
	    private void setFirstName(String content)throws Exception {
	    	System.out.println("setFirstName: " + content);
	    	getElement(byFirstName).click();
			getElement(byFirstName).sendKeys(content);
	    }
	    
	    private void setLastName(String content) throws Exception{
	    	System.out.println("setLastName");
	    	getElement(byLastName).click();
			getElement(byLastName).sendKeys(content);
			System.out.println("setStartDate: " + content);
	    }
	    
	    private void setLoginMail(String content) throws Exception{
	    	System.out.println("setLoginMail");
	    	String randomString = getRandomString(3, "NUMERIC");
	    	String email = content.split("@")[0]+"_"+randomString+"@"+content.split("@")[1];	    	
	    	getElement(byLoginEmail).click();
			getElement(byLoginEmail).sendKeys(email);
			ExcelUtility.updateCell(Row, 16, email);
			System.out.println("setLoginMail: " + email);
	    }
	    
	    private void clickFillWithCompanyAddress() throws Exception{
	    	System.out.println("clickFillWithCompanyAddress");
	    	getElement(byFillCompanyAddress).click();			
	    }
	    
	    private void clickContractCreateButton() throws Exception{		
	    	System.out.println("clickContractCreateButton");
	    	getElement(byContractCreateButton).click();
	    }
	    
	    private void clickAddMeter() throws Exception{		
	    	System.out.println("clickAddMeter");
	    	getElement(byAddmeter).click();
	    }
	    
	    private void clickAddOn()throws Exception {		
	    	System.out.println("clickAddOn");
	    	getElement(byAddOn).click();
	    }
	    
	    private void selectFundMeter(String content) throws Exception{
	    	System.out.println("selectFundMeter");
	    	clickAddMeter();
	    	clickAddOn();
	    	getElement(byFundMeter).click();
			driver.findElement(By.xpath("//input[@name='meterValue']")).sendKeys(content);			
	    }
	    
	    private void selectAccountUploadMeter(String content) throws Exception{
	    	System.out.println("selectAccountUploadMeter");
	    	getElement(byAddmeter).click();
			driver.findElement(By.xpath("//div[@formarrayname='addOnMeters']/div[2]//input[@formcontrolname='meterValue']")).sendKeys(content);	
	    }
	    
	    private void selectPrimiumCheckBox() throws Exception{
	    	System.out.println("selectPrimiumCheckBox");
			getElement(byPremiumAddon).click();
    		getElement(byPremiumCheck).click();
			//driver.findElement(By.tagName("body")).click();
	    }
	    
	    public void createCoreUser(String content) throws Exception{	
	    	System.out.println("createCoreUser");
  			selectFundMeter(content);
  			System.out.println("createCoreUser: " + content);
		}
	    
	    public void createAdvantageUser(String content1, String content2) throws Exception{	
	    	System.out.println("createAdvantageUser: " + content1);
	    	selectFundMeter(content1);
	    	System.out.println("createAdvantageUser: " + content2);
  			selectAccountUploadMeter(content2);
		}
	    
		public void createPremiumUser(String content1, String content2)throws Exception {
			System.out.println("createPremiumUser");
			selectPrimiumCheckBox();
			Actions action = new Actions(driver);
			action.sendKeys(Keys.ESCAPE).perform();
			selectFundMeter(content1);
			System.out.println("createAdvantageUser: " + content1);
  			selectAccountUploadMeter(content2);  
  			System.out.println("createAdvantageUser: " + content2);
		}
				
		public CreateContractPage createContract(String segment, String country, String edition, String subscribernumber, String type, String Startdate,
				String enddate, String packages, String addmeter, String addon, String fundmeter, String accountupload, String priceband,
				String firstname, String lastname, String loginemail, String companyaddress, String createcontractbutton, String viperlogo) throws Exception{
			
			getElement(bySegment).click();
			getElement(bySegment).sendKeys(segment);
			
			getElement(byCountry).click();
			getElement(byCountry).sendKeys(country);
			
			getElement(byEdition).click();
			getElement(byEdition).sendKeys(edition);
			
			getElement(bySubscriberNumber).click();
			getElement(bySubscriberNumber).sendKeys(subscribernumber);
			
			getElement(byType).click();
			getElement(byType).sendKeys(type);
			
			getElement(byStartDate).click();
			getElement(byStartDate).sendKeys(Startdate);
			
			getElement(byEndDate).click();
			getElement(byEndDate).sendKeys(enddate);
			
			getElement(byPackage).click();
			getElement(byPackage).sendKeys(packages);
			
			getElement(byAddmeter).click();
			getElement(byAddmeter).sendKeys(addmeter);
			
			getElement(byAddOn).click();
			getElement(byAddOn).sendKeys(addon);
			
			getElement(byFundMeter).click();
			getElement(byFundMeter).sendKeys(fundmeter);
			
			getElement(byAccountupload).click();
			getElement(byAccountupload).sendKeys(accountupload);
			
			getElement(byPriceband).click();
			getElement(byPriceband).sendKeys(priceband);
			
			getElement(byFirstName).click();
			getElement(byFirstName).sendKeys(firstname);
			
			getElement(byLastName).click();
			getElement(byLastName).sendKeys(lastname);
			
			getElement(byLoginEmail).click();
			getElement(byLoginEmail).sendKeys(loginemail);
			
			getElement(byFillCompanyAddress).click();
			getElement(byFillCompanyAddress).sendKeys(companyaddress);
			
			getElement(byContractCreateButton).click();
			getElement(byContractCreateButton).sendKeys(createcontractbutton);
			
			getElement(byViperLogo).click();
			getElement(byViperLogo).sendKeys(viperlogo);
			
			Thread.sleep(1000);
			return new CreateContractPage(driver);	
			
//			
//			if (data.get("Credit Editions").equals("Core")) {
//				
//					if (data.get("Package").equals("Global Unlimited")) {
//						//check is it correct
//					}
//					else {
//					getElement(byAddmeter).click();
//					getElement(byAddOn).click();
//					getElement(byFundMeter).click();
//					driver.findElement(By.xpath("//input[@name='meterValue']")).sendKeys(data.get("Funds Meter"));
//					}
//			}
//				
//			else if(data.get("Credit Editions").equals("Advantage")){
//					
//					if (data.get("Package").equals("Global Unlimited")) {
//						getElement(byAddmeter).click();
//						driver.findElement(By.xpath("//div[@formarrayname='addOnMeters']/div[1]//input[@formcontrolname='meterValue']")).sendKeys(data.get("Account upload"));
//					}
//					else {
//						getElement(byAddmeter).click();
//						getElement(byAddOn).click();
//						
//						getElement(byFundMeter).click();
//						driver.findElement(By.xpath("//div[@formarrayname='addOnMeters']/div[1]//input[@formcontrolname='meterValue']")).sendKeys(data.get("Funds Meter"));						
//					
//						getElement(byAddmeter).click();
//						driver.findElement(By.xpath("//div[@formarrayname='addOnMeters']/div[2]//input[@formcontrolname='meterValue']")).sendKeys(data.get("Account upload"));
//					}
//			}
//			
//			else if(data.get("Credit Editions").equals("Premium")){
//				
//				if (data.get("Package").equals("Global Unlimited")) {
//					getElement(byPremiumAddon).click();
//					getElement(byPremiumCheck).click();
//					getElement(byAddmeter).click();
//					driver.findElement(By.xpath("//div[@formarrayname='addOnMeters']/div[1]//input[@formcontrolname='meterValue']")).sendKeys(data.get("Account upload"));
//				}
//				else {
//					
//					//Not working - after selecting premium checkbox
//					getElement(byPremiumAddon).click();
//					getElement(byPremiumCheck).click();
//					//driver.findElement(By.tagName("body")).click();
//					
//					getElement(byAddmeter).click();
//					getElement(byAddOn).click();
//					
//					getElement(byFundMeter).click();
//					driver.findElement(By.xpath("//div[@formarrayname='addOnMeters']/div[1]//input[@formcontrolname='meterValue']")).sendKeys(data.get("Funds Meter"));						
//				
//					getElement(byAddmeter).click();
//					driver.findElement(By.xpath("//div[@formarrayname='addOnMeters']/div[2]//input[@formcontrolname='meterValue']")).sendKeys(data.get("Account upload"));
//				}
		//}
			
			//with unlimited account upload limit need check how to give in input sheet for advantage and premium
			
			/*driver.findElement(By.linkText("+ Add Meter")).click();
			driver.findElement(
					By.xpath("//mat-select[@name='addOnId']//div[@class='mat-select-arrow-wrapper']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//span[text()=' Unlimited Accounts Upload ']")).click();*/

			//selectPriceBand(data.get("Price Band"));
			//getElement(byPriceband).click();
			//getElement(byPriceband).sendKeys(data.get("Price Band"));

//			getElement(byFirstName).click();
//			getElement(byFirstName).sendKeys(data.get("First Name"));
//			
//			getElement(byLastName).click();
//			getElement(byLastName).sendKeys(data.get("Last Name"));
//			
//			getElement(byLoginEmail).click();
//			getElement(byLoginEmail).sendKeys(data.get("Login Email"));
//			
//			getElement(byFillCompanyAddress).click();
//			
//			getElement(byContractCreateButton).click();
			
//			getElement(byViperLogo).click();
//			getElement(byViperLogo).sendKeys(viperlogo);
//			
//			return new CreateContractPage(driver);	
			
		}
		
		public CompanyContract createContract(HashMap<String, String> data) throws Exception{
			try {
				//Row = rowNo;
				selectSegmentOption(data.get("Segment"));
				//ExcelUtility.updateCell(Row, 11, data.get("Subcriber Number")+getRandomString(6,"NUMERIC"));
				selectCountryOption(data.get("Country"));
				selectEditionOption(data.get("Edition"));
				setSubscribeNumber(data.get("Subcriber Number")+getRandomString(6,"NUMERIC"));
				
				selectTypeOption(data.get("Contract Type"));
				setStartDate(data.get("byStartDate"));
				setEndDate(data.get("byEndDate"));			
				selectPackageOption(data.get("Package"));
				if (data.get("Credit Editions").equals("Core")) {
					if (data.get("Package").equals("Global Unlimited")) {
						//check is it correct
					}
					else {
						createCoreUser(data.get("Funds Meter"));
					}
				}
				else if((data.get("Credit Editions").equals("Advantage"))) {
					if (data.get("Package").equals("Global Unlimited")) {
						getElement(byAddmeter).click();
						driver.findElement(By.xpath("//div[@formarrayname='addOnMeters']/div[1]//input[@formcontrolname='meterValue']")).sendKeys(data.get("Account upload"));
					}
					else
					createAdvantageUser(data.get("Funds Meter"), data.get("Account upload"));
				}
				else if((data.get("Credit Editions").equals("Premium"))) {
					createPremiumUser(data.get("Funds Meter"), data.get("Account upload"));
				}
				selectPriceBand(data.get("Price Band"));
				setFirstName(data.get("First Name"));
				setLastName(data.get("Last Name"));
				setLoginMail(data.get("Login Email"));	
				clickFillWithCompanyAddress();
				clickContractCreateButton();
			} 
			catch(Exception ex) {
			  driver.navigate().refresh();
			}
				return new CompanyContract(driver);
		}	    
	}
