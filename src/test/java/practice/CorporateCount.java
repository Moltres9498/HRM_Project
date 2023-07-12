package practice;

import org.testng.annotations.Test;
import com.hrm.genric.BaseClass;
import com.hrm.genric.ExcelUtlity;
import com.hrm.genric.FileUtlity;
import com.hrm.genric.WebActionUtility;
import com.hrm.pom.CorporatePage;
import com.hrm.pom.DashboardPage;

public class CorporateCount extends BaseClass {

	@Test
	
	public void countthecorporate() throws Throwable {
		
		FileUtlity fLib = new FileUtlity();
		ExcelUtlity eLib = new ExcelUtlity();
		WebActionUtility wLib = new WebActionUtility();

		/*get the FILE PATH*/
		String TEST_SCRIPT_EXCEL_FILE_PATH =    fLib.getFilePathFromPropertiesFile("testScriptdatafilePath");

		/*New test script data*/
		String CPNAME1 = eLib.getDataFromExcelBasedTestId(TEST_SCRIPT_EXCEL_FILE_PATH, "Corporate", "TY_01", "CorporateName");
		
		DashboardPage dp=new DashboardPage(driver);
		CorporatePage cp=new CorporatePage(driver);
		
		wLib.waitForElementInDOM(driver);
		
		/*verify the count*/
		String text1 = dp.CorporateCnt();
		int t1=Integer.parseInt(text1);
		System.out.println("Before count is fetched"+" "+t1);
		
		/*step 2 : navigate to corporate Module and navigate to Add corporate sub-module*/
		dp.CorporateModule();
		
		/*step 4 :  create a new corporate*/
		cp.AddCorporate(CPNAME1);
		wLib.swithToAlertWindowAndAccpect(driver, "Insert Successfully!!!");
		
		/*verify the count*/
		dp.Dashboard();
		String text2 = dp.CorporateCnt();
		int t2 = Integer.parseInt(text2);
		System.out.println("After count is fetched"+" "+t2);
		if(t2==(t1+1)) {
			System.out.println("Corporate addition is working");
		}
		else {
			System.out.println("Corporate addition is not working");
		}
	}
}