package practice;

import org.testng.annotations.Test;
import com.hrm.genric.BaseClass;
import com.hrm.genric.ExcelUtlity;
import com.hrm.genric.FileUtlity;
import com.hrm.genric.WebActionUtility;
import com.hrm.pom.BranchPage;
import com.hrm.pom.DashboardPage;

public class BranchCount extends BaseClass {

	@Test
	
	public void countthecorporate() throws Throwable {
		
		/*create Object for utlity */
		FileUtlity fLib = new FileUtlity();
		ExcelUtlity eLib = new ExcelUtlity();
		WebActionUtility wLib = new WebActionUtility();

		/*get the FILE PATH*/
		String TEST_SCRIPT_EXCEL_FILE_PATH =    fLib.getFilePathFromPropertiesFile("testScriptdatafilePath");

		/*New test script data*/
		String BPNAME1 = eLib.getDataFromExcelBasedTestId(TEST_SCRIPT_EXCEL_FILE_PATH, "Branches", "TY_01", "BranchName");

		DashboardPage dp=new DashboardPage(driver);
		BranchPage bp=new BranchPage(driver);
		
		wLib.waitForElementInDOM(driver);
		
		/*verify the count*/
		String text1 = dp.BranchCnt();
		int t1=Integer.parseInt(text1);
		System.out.println("Before count is fetched"+" "+t1);
		
		/*step 2 : navigate to Branch Module and navigate to Add Branch sub-module*/
		dp.BranchesModule();

		/*step 4 :  create a new Branch*/
		bp.AddBranch(BPNAME1);
		wLib.swithToAlertWindowAndAccpect(driver, "Insert Successfully!!!");
		
		/*verify the count*/
		dp.Dashboard();
		String text2 = dp.BranchCnt();
		int t2 = Integer.parseInt(text2);
		System.out.println("After count is fetched"+" "+t2);
		if(t2==(t1+1)) {
			System.out.println("Branch addition is working");
		}
		else {
			System.out.println("Branch addition is not working");
		}
	}
}