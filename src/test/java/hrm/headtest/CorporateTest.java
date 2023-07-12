package hrm.headtest;

import org.testng.annotations.Test;
import com.hrm.genric.BaseClass;
import com.hrm.genric.ExcelUtlity;
import com.hrm.genric.FileUtlity;
import com.hrm.genric.WebActionUtility;
import com.hrm.pom.CorporatePage;
import com.hrm.pom.DashboardPage;


public class CorporateTest extends BaseClass {

	@Test
	public void Corporate() throws Throwable{		

		/*create Object for utlity */
		FileUtlity fLib = new FileUtlity();
		ExcelUtlity eLib = new ExcelUtlity();
		WebActionUtility wLib = new WebActionUtility();

		/*get the FILE PATH*/
		String TEST_SCRIPT_EXCEL_FILE_PATH =    fLib.getFilePathFromPropertiesFile("testScriptdatafilePath");

		/*New test script data*/
		String CPNAME1 = eLib.getDataFromExcelBasedTestId(TEST_SCRIPT_EXCEL_FILE_PATH, "Corporate", "TY_01", "CorporateName");

		/*Edit test script data*/
		String CPNAME2 = eLib.getDataFromExcelBasedTestId(TEST_SCRIPT_EXCEL_FILE_PATH, "Corporate", "TY_02", "CorporateName");

		DashboardPage dp=new DashboardPage(driver);
		CorporatePage cp=new CorporatePage(driver);
		
		wLib.waitForElementInDOM(driver);
		
		/*step 2 : navigate to corporate Module and navigate to Add corporate sub-module*/
		dp.CorporateModule();
		wLib.waitForElementInDOM(driver);
		
		/*step 4 :  create a new corporate*/
		cp.AddCorporate(CPNAME1);
		wLib.swithToAlertWindowAndAccpect(driver, "Insert Successfully!!!");
		
		/*step 5 : verify newly added corporate*/
		cp.Verifyaddcorp(CPNAME1);
		
		/*step 6 : Edit corporate details*/
		cp.Editcorp(CPNAME2);
		wLib.swithToAlertWindowAndAccpect(driver, "Update Successfully!!!");
		
		/*step 7 : verify edited corporate*/
		cp.VerifyEditCorp(CPNAME2);
		
		/*step 8 :  Delete corporate details*/
		cp.DeleteCorp();
		wLib.swithToAlertWindowAndAccpect(driver, "Delete Successfully!!!");
		
		/*step 10 : verify deleted corporate*/
		cp.VerifyDeletedCorporate(CPNAME2);
	}    
}