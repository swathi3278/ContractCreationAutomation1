package main.java.Core;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.internal.TestResult;
import org.openqa.selenium.chrome.ChromeDriver;


public class BaseTest {
	
	protected WebDriver driver;
	
	@BeforeSuite
	public void BeforeSuite() throws IOException{
		ExcelUtility.loadTestData();
	}
	
	@BeforeMethod
	public void beforeMethod(Method method ) throws IOException {
		String methodName = method.getName();
		ExcelUtility.prepareteTeastcaseData(methodName);		
		initializeDriver();
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) throws Exception{
		if(result.getStatus() == TestResult.SUCCESS) {
			
		} else if(result.getStatus() == TestResult.FAILURE) {
			
		}
		
		if(driver != null) {
			driver.quit();
		}	
		
		
	}
	
	@AfterSuite
	public void afterSuite()  throws Exception{
		ExcelUtility.closeTestData();
	}
	
	private void initializeDriver() {
		String appUrl = System.getProperty("appUrl");
		String browserName = System.getProperty("browser");
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		
		if(browserName.equals("chrome")) {
			driver = new ChromeDriver();
		}
		
		driver.get(appUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

}
