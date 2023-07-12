package com.hrm.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class BranchPage {

	@FindBy(xpath = "//button[(contains(text(),'Add'))]")
	private WebElement addbranchbtn;

	@FindBy(xpath = "//div[@class='modal fade show']//input[@name='branches_name']")
	private WebElement branchname;

	@FindBy(xpath = "//button[text()='Save']")
	private WebElement savebtn;

	@FindBy(xpath = "//div[@class='col-sm-12 col-md-6']//input[@class='form-control form-control-sm']")
	private WebElement searchtxtbx;

	@FindBy(xpath = "//tr[@class='odd']//td[contains(text(),'Mysore')]")
	private WebElement verifyadd;

	@FindBy(xpath = "//button[text()='Edit']")
	private WebElement editbrchbtn;

	@FindBy(xpath = "//div[@class='modal fade show']//button[@class='btn btn-primary']")
	private WebElement updatebtn;

	@FindBy(xpath = "//tr[@class='odd']//td[contains(text(),'Hassan')]")
	private WebElement verifyedit;

	@FindBy(xpath = "//button[@type='button'][normalize-space()='Delete']")
	private WebElement deletebrchbtn;

	@FindBy(xpath = "//div[@class='modal fade show']//button[.='Delete']")
	private WebElement deletebtninpopup;

	@FindBy(xpath = "//td[text()='No matching records found']")
	private WebElement verifydel ;

	public BranchPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void AddBranch(String bname) {
		addbranchbtn.click();
		branchname.sendKeys(bname);
		savebtn.click();	
	}

	public void VerifyAddBrch(String bname) {
		searchtxtbx.sendKeys(bname);
		String brchlist = verifyadd.getText();
		if(brchlist.contains(bname)) {
			Reporter.log(bname+ "is verified PASS",true);
		}else {
			Reporter.log(bname+ "is not verified FAIL",true);
		}
	}

	public void EditBrch(String bname1) {
		editbrchbtn.click();
		branchname.clear();
		branchname.sendKeys(bname1);
		updatebtn.click();
	}

	public void VerifyEditBrch(String bname1) {
		searchtxtbx.sendKeys(bname1);
		String editbrchlist = verifyedit.getText();
		if(editbrchlist.contains(bname1)) {
			Reporter.log(bname1+ "is verified PASS",true);
		}else {
			Reporter.log(bname1+ "is not verified FAIL",true);
		}
	}

	public void DeleteBrch() {
		deletebrchbtn.click();
		deletebtninpopup.click();
	}

	public void VerifyDeletedBranch(String bname1) {
		searchtxtbx.sendKeys(bname1);
		boolean text = verifydel.isDisplayed();
		if(text==true) {
			Reporter.log("Branch deleted", true);
		}else {
			Reporter.log("Branch deleted", true);
		}
	}
}