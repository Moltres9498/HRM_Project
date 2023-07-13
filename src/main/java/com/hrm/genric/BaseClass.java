package com.hrm.genric;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.hrm.pom.DashboardPage;

import com.hrm.pom.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	FileUtlity fLib = new FileUtlity();	
	
	public static WebDriver sdriver;
	
	public WebDriver driver=null;

	@BeforeClass
	public void Openbrowser() throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriverManager.firefoxdriver().setup();
		String ENV_FILE_PATH =    fLib.getFilePathFromPropertiesFile("projectConfigDataFilePath");
		//String BROWSER = fLib.getDataFromProperties(ENV_FILE_PATH, "browser");
		String BROWSER=System.getProperty("browser");
		if(BROWSER.equalsIgnoreCase("Chrome")) {		
		//	WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if(BROWSER.equalsIgnoreCase("Firefox")) {
			//WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else if(BROWSER.equalsIgnoreCase("Edge")) {
			//WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}else {
			Reporter.log("Enter proper browser name", true);
		}
		sdriver=driver;
		driver.manage().window().maximize();
		//String URL = fLib.getDataFromProperties(ENV_FILE_PATH, "url");
		String URL=System.getProperty("url");
		driver.get(URL);
	}
	
	@BeforeMethod
	public void login() throws Throwable {
		WebActionUtility wLib = new WebActionUtility();
		String ENV_FILE_PATH =    fLib.getFilePathFromPropertiesFile("projectConfigDataFilePath");
		String EMAIL = fLib.getDataFromProperties(ENV_FILE_PATH, "Email");
		String PASSWORd = fLib.getDataFromProperties(ENV_FILE_PATH, "password");
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(EMAIL, PASSWORd);
		wLib.swithToAlertWindowAndAccpect(driver, "Login Successfully!!");
	}

	@AfterMethod
	public void logout() throws Throwable {
		WebActionUtility wLib = new WebActionUtility();
		DashboardPage dp=new DashboardPage(driver);
		dp.logout();
		wLib.swithToAlertWindowAndAccpect(driver, "Successfully Logout!");
	}
	@AfterClass
	public void Closebrowser() {
		driver.close();
	}
}