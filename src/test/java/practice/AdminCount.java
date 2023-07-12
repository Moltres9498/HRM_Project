package practice;

import org.testng.annotations.Test;
import com.hrm.genric.BaseClass;
import com.hrm.genric.ExcelUtlity;
import com.hrm.genric.FileUtlity;
import com.hrm.genric.WebActionUtility;
import com.hrm.pom.AdminPage;
import com.hrm.pom.DashboardPage;

public class AdminCount extends BaseClass {

	@Test
	
	public void countthecorporate() throws Throwable {

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

		DashboardPage dp=new DashboardPage(driver);
		AdminPage am=new AdminPage(driver);
		
		wLib.waitForElementInDOM(driver);
		/*verify the count*/
		String text1 = dp.AdminCnt();
		int t1=Integer.parseInt(text1);
		System.out.println("Before count is fetched"+" "+t1);
		
		/*step 2 : navigate to Admin Module and navigate to Add Admin sub-module*/
		dp.AdminModule();
	
		/*step 4 :  create a new Admin*/
		am.AddAdmin(CID1, FN1, LN, MN1, CN,POS, EID, PW);
		wLib.swithToAlertWindowAndAccpect(driver, "Insert Successfully!!!");
		
		/*verify the count*/
		dp.Dashboard();
		String text2 = dp.AdminCnt();
		int t2 = Integer.parseInt(text2);
		System.out.println("After count is fetched"+" "+t2);
		if(t2==(t1+1)) {
			System.out.println("Admin addition is working");
		}
		else {
			System.out.println("Admin addition is not working");
		}
	}
}