package hrm.headtest;

import org.testng.annotations.Test;
import com.hrm.genric.BaseClass;
import com.hrm.genric.ExcelUtlity;
import com.hrm.genric.FileUtlity;
import com.hrm.genric.WebActionUtility;
import com.hrm.pom.BranchPage;
import com.hrm.pom.DashboardPage;

public class BranchTest extends BaseClass {

	@Test
	public void Branch() throws Throwable{		

		/*create Object for utlity */
		FileUtlity fLib = new FileUtlity();
		ExcelUtlity eLib = new ExcelUtlity();
		WebActionUtility wLib = new WebActionUtility();

		/*get the FILE PATH*/
		String TEST_SCRIPT_EXCEL_FILE_PATH =    fLib.getFilePathFromPropertiesFile("testScriptdatafilePath");

		/*New test script data*/
		String BPNAME1 = eLib.getDataFromExcelBasedTestId(TEST_SCRIPT_EXCEL_FILE_PATH, "Branches", "TY_01", "BranchName");

		/*Edit test script data*/
		String BPNAME2 = eLib.getDataFromExcelBasedTestId(TEST_SCRIPT_EXCEL_FILE_PATH, "Branches", "TY_02", "BranchName");

		DashboardPage dp=new DashboardPage(driver);
		BranchPage bp=new BranchPage(driver);
		
		wLib.waitForElementInDOM(driver);

		/*step 2 : navigate to Branch Module and navigate to Add Branch sub-module*/
		dp.BranchesModule();

		/*step 4 :  create a new Branch*/
		bp.AddBranch(BPNAME1);
		wLib.swithToAlertWindowAndAccpect(driver, "Insert Successfully!!!");

		/*step 5 : verify newly added Branch*/
		bp.VerifyAddBrch(BPNAME1);

		/*step 6 : Edit Branch details*/
		bp.EditBrch(BPNAME2);
		wLib.swithToAlertWindowAndAccpect(driver, "Update Successfully!!!");

		/*step 7 : verify edited Branch*/
		bp.VerifyEditBrch(BPNAME2);
	
		/*step 8 :  Delete Branch details*/
		bp.DeleteBrch();
		wLib.swithToAlertWindowAndAccpect(driver, "Delete Successfully!!!");
		
		/*step 10 : verify deleted Branch*/
		bp.VerifyDeletedBranch(BPNAME2);
		
		//this is branch test
	}       
}