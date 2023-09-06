package hrm.headtest;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import com.hrm.genric.BaseClass;
import com.hrm.genric.ExcelUtlity;
import com.hrm.genric.FileUtlity;
import com.hrm.genric.WebActionUtility;
import com.hrm.pom.AdminPage;
import com.hrm.pom.DashboardPage;

public class AdminTest extends BaseClass {

	@Test
	public void Admin() throws Throwable{		

		/*create Object for utlity */
		FileUtlity fLib = new FileUtlity();
		ExcelUtlity eLib = new ExcelUtlity();
		WebActionUtility wLib = new WebActionUtility();

		/*get the FILE PATH*/
		String TEST_SCRIPT_EXCEL_FILE_PATH =    fLib.getFilePathFromPropertiesFile("testScriptdatafilePath");

		/*New test script data*/
		String CID1 = eLib.getDataFromExcelBasedTestId(TEST_SCRIPT_EXCEL_FILE_PATH, "Admin", "TY_01", "CompanyID");
		String FN1 = eLib.getDataFromExcelBasedTestId(TEST_SCRIPT_EXCEL_FILE_PATH, "Admin", "TY_01", "FirstName");
		String LN = eLib.getDataFromExcelBasedTestId(TEST_SCRIPT_EXCEL_FILE_PATH, "Admin", "TY_01", "LastName");
		String MN1 = eLib.getDataFromExcelBasedTestId(TEST_SCRIPT_EXCEL_FILE_PATH, "Admin", "TY_01", "MiddleName");
		String POS = eLib.getDataFromExcelBasedTestId(TEST_SCRIPT_EXCEL_FILE_PATH, "Admin", "TY_01", "Position");
		String CN = eLib.getDataFromExcelBasedTestId(TEST_SCRIPT_EXCEL_FILE_PATH, "Admin", "TY_01", "ContactNumber");
		String EID = eLib.getDataFromExcelBasedTestId(TEST_SCRIPT_EXCEL_FILE_PATH, "Admin", "TY_01", "EmailAddress");
		String PW = eLib.getDataFromExcelBasedTestId(TEST_SCRIPT_EXCEL_FILE_PATH, "Admin", "TY_01", "Password");

		/*Edit test script data*/
		String CID2 = eLib.getDataFromExcelBasedTestId(TEST_SCRIPT_EXCEL_FILE_PATH, "Admin", "TY_02", "CompanyID");
		String FN2 = eLib.getDataFromExcelBasedTestId(TEST_SCRIPT_EXCEL_FILE_PATH, "Admin", "TY_02", "FirstName");
		String MN2 = eLib.getDataFromExcelBasedTestId(TEST_SCRIPT_EXCEL_FILE_PATH, "Admin", "TY_02", "MiddleName");
		
		DashboardPage dp=new DashboardPage(driver);
		AdminPage am=new AdminPage(driver);
		
		wLib.waitForElementInDOM(driver);

		/*step 2 : navigate to Admin Module and navigate to Add Admin sub-module*/
		dp.AdminModule();
		
		/*step 4 :  create a new Admin*/
		am.AddAdmin(CID1, FN1, LN, MN1, CN,POS, EID, PW);
		wLib.swithToAlertWindowAndAccpect(driver, "Insert Successfully!!!");

		/*step 5 : verify newly added Admin*/
		am.VerifyAddAdmin(FN1);

		/*step 6 : Edit Admin details*/
		am.EditAdmin(CID2, FN2, MN2);
		wLib.swithToAlertWindowAndAccpect(driver, "Update Successfully!!!");

		/*step 7 : verify edited Admin*/
		am.VerifyEditAdmin(FN2);
	
		/*step 8 :  Delete Admin details*/
		am.DeleteAdmin();
		wLib.swithToAlertWindowAndAccpect(driver, "Delete Successfully!!!");
		
		/*step 10 : verify deleted Admin*/
		am.VerifyDeletedAdmin(FN2);
	}       
}