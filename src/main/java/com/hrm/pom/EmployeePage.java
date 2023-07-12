package com.hrm.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.hrm.genric.JavaUtlity;
import com.hrm.genric.WebActionUtility;

public class EmployeePage {

	@FindBy(xpath = "//button[(contains(text(),'Add'))]")
	private WebElement addemloyeebtn;

	@FindBy(xpath = "//div[@class='modal fade show']//input[@name='employee_companyid']")
	private WebElement addcompanyid;

	@FindBy(xpath = "//div[@class='modal fade show']//input[@name='employee_firstname']")
	private WebElement addfirstname;

	@FindBy(xpath = "//div[@class='modal fade show']//input[@name='employee_lastname']")
	private WebElement addlastname;

	@FindBy(xpath = "//div[@class='modal fade show']//input[@name='employee_middlename']")
	private WebElement addmiddlename;

	@FindBy(xpath = "//div[@class='modal fade show']//input[@name='branches_datefrom']")
	private WebElement addbranchdatefrom;

	@FindBy(xpath = "//div[@class='modal fade show']//input[@name='branches_recentdate']")
	private WebElement addbranchrecentdate;

	@FindBy(xpath = "//div[@class='modal fade show']//select[@name='employee_department']")
	private WebElement adddepartment;

	@FindBy(xpath = "//div[@class='modal fade show']//select[@name='employee_branches']")
	private WebElement addbranches;

	@FindBy(xpath = "//div[@class='modal fade show']//input[@name='employee_position']")
	private WebElement addposition;

	@FindBy(xpath = "//div[@class='modal fade show']//input[@name='employee_contact']")
	private WebElement addcontactno;

	@FindBy(xpath = "//div[@class='modal fade show']//input[@name='employee_sss']")
	private WebElement addsss;

	@FindBy(xpath = "//div[@class='modal fade show']//input[@name='employee_tin']")
	private WebElement addtin;

	@FindBy(xpath = "//div[@class='modal fade show']//input[@name='employee_hdmf_pagibig']")
	private WebElement addhdmf;

	@FindBy(xpath = "//div[@class='modal fade show']//input[@name='employee_gsis']")
	private WebElement addgsis;

	@FindBy(xpath = "//div[@class='modal fade show']//input[@name='employee_file201']")
	private WebElement addemployeefile201;

	@FindBy(xpath = "//div[@class='modal fade show']//input[@name='employee_image']")
	private WebElement addemployeeimage;

	@FindBy(xpath = "//button[text()='Save']")//added employee
	private WebElement savebtn;

	@FindBy(xpath = "//div[@class='col-sm-12 col-md-6']//input[@class='form-control form-control-sm']")//verify add, edit, delete
	private WebElement searchtxtbx;

	@FindBy(xpath = "//tr[@class='odd']//td[contains(text(),'Gojo')]")// verify add
	private WebElement verifyadd;

	@FindBy(xpath = "//tbody/tr[1]/td[9]/i[1]")//editing emp
	private WebElement editempbtn;

	@FindBy(xpath = "//div[@class='modal fade show']//button[@name='edit_emplo']")//edited emp
	private WebElement updateempbtn;

	@FindBy(xpath = "//tr[@class='odd']//td[contains(text(),'Levi')]")// verify edit
	private WebElement verifyedit;

	@FindBy(xpath = "//tbody/tr[1]/td[9]/object")//dwnld file
	private WebElement downloadempfile;

	@FindBy(xpath = "//tbody/tr[1]/td[9]/i[2]")//del emp
	private WebElement deletebtn;

	@FindBy(xpath = "//div[@class='modal fade show']//button[.='Delete']")//del in popup
	private WebElement deletebtninpopup;

	@FindBy(xpath = "//td[text()='No matching records found']")
	private WebElement verifydel ;


	public EmployeePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void AddEmployee(String cid, String fn, String ln, String mn, String dept, String brch, String posit, String Contno, String SSS, String Tin, String Hdmf, String Gsis, String abspth, String abspth1) throws Throwable {
		addemloyeebtn.click();
		addcompanyid.sendKeys(cid);
		addfirstname.sendKeys(fn);
		addlastname.sendKeys(ln);
		addmiddlename.sendKeys(mn);
		JavaUtlity jutl=new JavaUtlity();
		addbranchdatefrom.sendKeys(jutl.getDate());
		addbranchrecentdate.sendKeys(jutl.getDate(30));
		WebActionUtility wlib=new WebActionUtility();
		wlib.select(adddepartment, dept);
		wlib.select(addbranches, brch);
		addposition.sendKeys(posit);
		addcontactno.sendKeys(Contno);
		addsss.sendKeys(SSS);
		addtin.sendKeys(Tin);
		addhdmf.sendKeys(Hdmf);
		addgsis.sendKeys(Gsis);
		addemployeefile201.sendKeys(abspth);
		addemployeeimage.sendKeys(abspth1);
		savebtn.click();
	}

	public void VerifyNewEmployee(String fn) {
		searchtxtbx.sendKeys(fn);
		String emplist = verifyadd.getText();
		if(emplist.contains(fn)) {
			Reporter.log(fn+ "is verified PASS");
		}else {
			Reporter.log(fn+ "is not verified FAIL");
		}
	}

	public void EditEmployee(String cid1, String fn1, String mn1, String abspth2, String abspth3) {
		editempbtn.click();
		addcompanyid.clear();
		addcompanyid.sendKeys(cid1);
		addfirstname.clear();
		addfirstname.sendKeys(fn1);
		addmiddlename.clear();
		addmiddlename.sendKeys(mn1);
		addemployeefile201.sendKeys(abspth2);
		addemployeeimage.sendKeys(abspth3);
		updateempbtn.click();
	}

	public void VerifyEditedEmployee(String fn1) {
		searchtxtbx.sendKeys(fn1);
		String editemp =verifyedit.getText();
		if(editemp.contains(fn1)) {
			Reporter.log(fn1+ "is verified PASS");
		}else {
			Reporter.log(fn1+ "is not verified FAIL");
		}
	}

	public void DownloadEmpFile() {
		downloadempfile.click();

	}

	public void DeleteEmployee() {
		deletebtn.click();
		deletebtninpopup.click();
	}

	public void VerifyDeletedEmployee(String fn1) {
		searchtxtbx.sendKeys(fn1);
		boolean text = verifydel.isDisplayed();
		if(text==true) {
			Reporter.log("Employee deleted", true);
		}else {
			Reporter.log("Employee not deleted", true);
		}
	}
}