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

public class BaseClass {

	FileUtlity fLib = new FileUtlity();	
	
	public static WebDriver sdriver;
	
	public WebDriver driver=null;

	@BeforeClass
	public void Openbrowser() throws Throwable {
		String ENV_FILE_PATH =    fLib.getFilePathFromPropertiesFile("projectConfigDataFilePath");
		String BROWSER = fLib.getDataFromProperties(ENV_FILE_PATH, "browser");
		if(BROWSER.equalsIgnoreCase("Chrome")) {		
			driver = new ChromeDriver();
		}else if(BROWSER.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		}else if(BROWSER.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
		}else {
			Reporter.log("Enter proper browser name", true);
		}
		driver.manage().window().maximize();
		String URL = fLib.getDataFromProperties(ENV_FILE_PATH, "url");
		driver.get(URL);
		sdriver=driver;
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