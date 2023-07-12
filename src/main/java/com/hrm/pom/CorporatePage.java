package com.hrm.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CorporatePage {
	@FindBy(xpath = "//button[(contains(text(),'Add'))]")
	private WebElement addcorporatebtn;

	@FindBy(xpath = "//div[@class='modal fade show']//input[@name='corporate_name']")
	private WebElement corporatename;

	@FindBy(xpath = "//button[text()='Save']")
	private WebElement savebtn;

	@FindBy(xpath = "//div[@class='col-sm-12 col-md-6']//input[@class='form-control form-control-sm']")
	private WebElement searchtxtbx;

	@FindBy(xpath = "//tr[@class='odd']//td[contains(text(),'Testing')]")
	private WebElement verifyadd;

	@FindBy(xpath = "//button[text()='Edit']")
	private WebElement editcorpbtn;

	@FindBy(xpath = "//div[@class='modal fade show']//button[@name='update']")
	private WebElement updatebtn;

	@FindBy(xpath = "//tr[@class='odd']//td[contains(text(),'Development')]")
	private WebElement verifyedit;

	@FindBy(xpath = "//button[@type='button'][normalize-space()='Delete']")
	private WebElement deletecorpbtn;

	@FindBy(xpath = "//div[@class='modal fade show']//button[.='Delete']")
	private WebElement deletebtninpopup;

	@FindBy(xpath = "//td[text()='No matching records found']")
	private WebElement verifydel ;

	public CorporatePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void AddCorporate(String cname) throws Throwable {
		addcorporatebtn.click();
		corporatename.sendKeys(cname);
		savebtn.click();	
	}

	public void Verifyaddcorp(String cname) {
		searchtxtbx.sendKeys(cname);
		String corplist = verifyadd.getText();
		if(corplist.contains(cname)) {
			Reporter.log(cname+ "is verified PASS");
		}else {
			Reporter.log(cname+ "is not verified FAIL");
		}
	}

	public void Editcorp(String cname1) {
		editcorpbtn.click();
		corporatename.clear();
		corporatename.sendKeys(cname1);
		updatebtn.click();
	}

	public void VerifyEditCorp(String cname1) {
		searchtxtbx.sendKeys(cname1);
		String editcorplist = verifyedit.getText();
		if(editcorplist.contains(cname1)) {
			Reporter.log(cname1+ "is verified PASS");
		}else {
			Reporter.log(cname1+ "is not verified FAIL");
		}
	}

	public void DeleteCorp() {
		deletecorpbtn.click();
		deletebtninpopup.click();
	}

	public void VerifyDeletedCorporate(String cname1) {
		searchtxtbx.sendKeys(cname1);
		boolean text = verifydel.isDisplayed();
		if(text==true) {
			Reporter.log("Corporate deleted", true);
		}else {
			Reporter.log("Corporate not deleted", true);
		}
	}
}