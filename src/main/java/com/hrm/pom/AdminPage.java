package com.hrm.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.hrm.genric.WebActionUtility;

public class AdminPage {
	@FindBy(xpath = "//button[(contains(text(),'Add'))]")
	private WebElement addadminbtn;

	@FindBy(xpath = "//div[@class='modal fade show']//input[@name='hr_companyid']")
	private WebElement companyid;
	
	@FindBy(xpath = "//div[@class='modal fade show']//input[@name='hr_firstname']")
	private WebElement firstname;
	
	@FindBy(xpath = "//div[@class='modal fade show']//input[@name='hr_lastname']")
	private WebElement lastname;
	
	@FindBy(xpath = "//div[@class='modal fade show']//input[@name='hr_middlename']")
	private WebElement middlename;
	
	@FindBy(xpath = "//div[@class='modal fade show']//input[@name='hr_contactno']")
	private WebElement contactno;
	
	@FindBy(id="hr_type")
	private WebElement HRtype;
	
	@FindBy(xpath = "//div[@class='modal fade show']//input[@name='hr_email']")
	private WebElement email;
	
	@FindBy(xpath = "//div[@class='modal fade show']//input[@name='hr_password']")
	private WebElement password;

	@FindBy(xpath = "//button[@name='hr_admin']")
	private WebElement savebtn;

	@FindBy(xpath = "//div[@class='col-sm-12 col-md-6']//input[@class='form-control form-control-sm']")
	private WebElement searchtxtbx;
	
	@FindBy(xpath="//td[@class='sorting_1']")
	private WebElement plusbtn;

	@FindBy(xpath = "//tr[@class='odd']//td[contains(text(),'Gojo')]")
	private WebElement verifyadd;

	@FindBy(xpath = "//tbody/tr[1]/td[9]/i[1]")
	private WebElement editadminbtn;

	@FindBy(xpath = "//div[@class='modal fade show']//button[@class='btn btn-primary']")
	private WebElement updatebtn;

	@FindBy(xpath = "//tr[@class='odd']//td[contains(text(),'Levi')]")
	private WebElement verifyedit;

	@FindBy(xpath = "//tbody/tr[1]/td[9]/i[2]")
	private WebElement deleteadminbtn;

	@FindBy(xpath = "//div[@class='modal fade show']//button[.='Delete']")
	private WebElement deletebtninpopup;

	@FindBy(xpath = "//td[text()='No matching records found']")
	private WebElement verifydel ;

	public AdminPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void AddAdmin(String cid, String fn, String ln, String mn, String cn, String posi, String em, String pw) throws Throwable {
		addadminbtn.click();
		companyid.sendKeys(cid);
		firstname.sendKeys(fn);
		lastname.sendKeys(ln);
		middlename.sendKeys(mn);
		contactno.sendKeys(cn);
		WebActionUtility wutil=new WebActionUtility();
		wutil.select(HRtype, posi);
		email.sendKeys(em);
		password.sendKeys(pw);
		savebtn.click();	
	}

	public void VerifyAddAdmin(String fn) {
		searchtxtbx.sendKeys(fn);
		String adlist = verifyadd.getText();
		Assert.assertEquals(fn, adlist, fn+ "is verified PASS");
	}

	public void EditAdmin(String cid1, String fn1, String ln1) {
		editadminbtn.click();
		companyid.clear();
		companyid.sendKeys(cid1);
		firstname.clear();
		firstname.sendKeys(fn1);
		middlename.clear();
		middlename.sendKeys(ln1);
		updatebtn.click();
	}

	public void VerifyEditAdmin(String fn1) {
		searchtxtbx.sendKeys(fn1);
		String editadlist = verifyedit.getText();
		if(editadlist.contains(fn1)) {
			Reporter.log(fn1+ "is verified PASS", true);
		}else {
			Reporter.log(fn1+ "is verified PASS", true);
		}
	}

	public void DeleteAdmin() {
		deleteadminbtn.click();
		deletebtninpopup.click();
	}

	public void VerifyDeletedAdmin(String fn1) {
		searchtxtbx.sendKeys(fn1);
		boolean text = verifydel.isDisplayed();
		if(text==true) {
			Reporter.log("Admin deleted", true);
		}else {
			Reporter.log("Admin not deleted", true);
		}
	}
}