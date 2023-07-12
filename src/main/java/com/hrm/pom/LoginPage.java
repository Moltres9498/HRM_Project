package com.hrm.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.hrm.genric.WebActionUtility;

public class LoginPage{
	
	@FindBy(name="hr_email")
	private WebElement Emailtxtbox;
	
	@FindBys(@FindBy(name = "hr_password"))
	private WebElement passwordtxtbox;
	
	@FindBy(id="hr_type")
	private WebElement HRtype;
	
	@FindBy(name="login_hr")
	private WebElement Loginbtn;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void loginToApp(String email,String password) throws Throwable
	{
		WebActionUtility wutil=new WebActionUtility();
		Emailtxtbox.sendKeys(email);
		passwordtxtbox.sendKeys(password);
		wutil.select(HRtype, "→ HR Head");
		Loginbtn.click();
		Reporter.log("Logged in Successfully", true);
	}
}