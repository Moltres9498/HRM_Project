package com.hrm.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {

	@FindBy(xpath="//p[text()='Dashboard']")
	private WebElement Dashboardbtn;
	
	@FindBy(xpath="//p[contains(text(),'EMPLOYEE')]")
	private WebElement Employeemodule;

	@FindBy(xpath="//p[normalize-space()='Add Employee']")
	private WebElement Addemployeemodule;
	
	@FindBy(xpath="//p[contains(text(),'CORPORATE')]")
	private WebElement Corporatemodule;

	@FindBy(xpath="//p[normalize-space()='Add Corporate']")
	private WebElement AddCorporatemodule;
	
	@FindBy(xpath="//p[contains(text(),'BRANCHES')]")
	private WebElement Branchesmodule;

	@FindBy(xpath="//p[normalize-space()='Add Braches']")
	private WebElement AddBranchesmodule;
	
	@FindBy(xpath="//p[contains(text(),'ADMIN')]")
	private WebElement Adminmodule;

	@FindBy(xpath="//p[normalize-space()='Add Admin']")
	private WebElement AddAdminmodule;
	
	@FindBy(xpath="//span[text()='Administrator']")
	private WebElement Administratorbtn;
	
	@FindBy(xpath="//span[.='Employee']/../span[@class='info-box-number']")
	private WebElement Employeecount;
	
	@FindBy(xpath="//span[.='Corporate']/../span[@class='info-box-number']")
	private WebElement Corporatecount;
	
	@FindBy(xpath="//span[.='Braches']/../span[@class='info-box-number']")
	private WebElement Branchcount;
	
	@FindBy(xpath="//span[contains(text(),'Admin')]/../span[@class='info-box-number']")
	private WebElement Admincount;

	@FindBy(xpath="//a[@data-toggle='dropdown']")
	private WebElement lgtdrpdwn;

	@FindBy(xpath="//i[@class='fa fa-power-off']")
	private WebElement lgtbtn;

	public DashboardPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void EmployeeModule() {
		Employeemodule.click();
		Addemployeemodule.click();
	}
	
	public void CorporateModule() {
		Corporatemodule.click();
		AddCorporatemodule.click();
	}
	
	public void BranchesModule() {
		Branchesmodule.click();
		AddBranchesmodule.click();
	}
	
	public void AdminModule() {
		Adminmodule.click();
		AddAdminmodule.click();
	}
	
	public void logout() {
		lgtdrpdwn.click();
		lgtbtn.click();
	}
	
	public void Dashboard() {
		Dashboardbtn.click();
	}
	
	public void Administrator() {
		Administratorbtn.click();
	}
	
	public String EmployeeCnt() {
		String actualcount = Employeecount.getText();
		return actualcount;
	}
	
	public String CorporateCnt() {
		String actualcount1= Corporatecount.getText();
		return actualcount1;
	}
	
	public String BranchCnt() {
		String actualcount2= Branchcount.getText();
		return actualcount2;
	}
	
	public String AdminCnt() {
		String actualcount3= Admincount.getText();
		return actualcount3;
	}
}