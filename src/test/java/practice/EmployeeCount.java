package practice;

import java.io.File;
import org.testng.annotations.Test;
import com.hrm.genric.BaseClass;
import com.hrm.genric.ExcelUtlity;
import com.hrm.genric.FileUtlity;
import com.hrm.genric.WebActionUtility;
import com.hrm.pom.DashboardPage;
import com.hrm.pom.EmployeePage;

public class EmployeeCount extends BaseClass {

	@Test
	
	public void counttheemployee() throws Throwable {
		FileUtlity fLib = new FileUtlity();
		ExcelUtlity eLib = new ExcelUtlity();
		WebActionUtility wLib = new WebActionUtility();

		/*get the FILE PATH*/
		String TEST_SCRIPT_EXCEL_FILE_PATH =    fLib.getFilePathFromPropertiesFile("testScriptdatafilePath");

		/*New test script data*/
		String companyID = eLib.getDataFromExcelBasedTestId(TEST_SCRIPT_EXCEL_FILE_PATH, "Employee", "TY_01", "CompanyID");
		String firstname = eLib.getDataFromExcelBasedTestId(TEST_SCRIPT_EXCEL_FILE_PATH, "Employee", "TY_01", "FirstName");
		String lastName = eLib.getDataFromExcelBasedTestId(TEST_SCRIPT_EXCEL_FILE_PATH, "Employee", "TY_01", "LastName");
		String middleName = eLib.getDataFromExcelBasedTestId(TEST_SCRIPT_EXCEL_FILE_PATH, "Employee", "TY_01", "MiddleName");
		String Dept = eLib.getDataFromExcelBasedTestId(TEST_SCRIPT_EXCEL_FILE_PATH, "Employee", "TY_01", "Department");
		String branch = eLib.getDataFromExcelBasedTestId(TEST_SCRIPT_EXCEL_FILE_PATH, "Employee", "TY_01", "Branch");
		String position = eLib.getDataFromExcelBasedTestId(TEST_SCRIPT_EXCEL_FILE_PATH, "Employee", "TY_01", "Position");
		String contactno = eLib.getDataFromExcelBasedTestId(TEST_SCRIPT_EXCEL_FILE_PATH, "Employee", "TY_01", "ContactNumber");
		String sss = eLib.getDataFromExcelBasedTestId(TEST_SCRIPT_EXCEL_FILE_PATH, "Employee", "TY_01", "SSS");
		String tin = eLib.getDataFromExcelBasedTestId(TEST_SCRIPT_EXCEL_FILE_PATH, "Employee", "TY_01", "TIN");
		String hdmf = eLib.getDataFromExcelBasedTestId(TEST_SCRIPT_EXCEL_FILE_PATH, "Employee", "TY_01", "HDMF/Pag-ibig");
		String gsis = eLib.getDataFromExcelBasedTestId(TEST_SCRIPT_EXCEL_FILE_PATH, "Employee", "TY_01", "GSIS");

		DashboardPage dp=new DashboardPage(driver);
		EmployeePage ep= new EmployeePage(driver);
		
		wLib.waitForElementInDOM(driver);
		
		/*verify the count*/
		String text1 = dp.EmployeeCnt();
		int t1=Integer.parseInt(text1);
		System.out.println("Before count is fetched"+" "+t1);
		
		/*step 2 : navigate to Employee Module and navigate to Add Employee sub-module*/
		dp.EmployeeModule();

		/*step 4 :  create a new Employee*/
		File f = new File("./src/test/resources/HRM TC.xlsx");
		String Abspath = f.getAbsolutePath(); 
		File f1 = new File("./src/test/resources/Ford.jpg");
		String Abspath1 = f1.getAbsolutePath(); 
		ep.AddEmployee(companyID,firstname,lastName,middleName,Dept,branch,position,contactno,sss,tin,hdmf,gsis,Abspath, Abspath1 );
		wLib.swithToAlertWindowAndAccpect(driver, "Insert Successfully!!!");
		
		/*verify the count*/
		dp.Dashboard();
		String text2 = dp.EmployeeCnt();
		int t2 = Integer.parseInt(text2);
		System.out.println("After count is fetched"+" "+t2);
		if(t2==(t1+1)) {
			System.out.println("Employee addition is working");
		}
		else {
			System.out.println("Employee addition is not working");
		}
	}
}