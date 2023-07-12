package hrm.headtest;

import java.io.File;
import org.testng.annotations.Test;
import com.hrm.genric.BaseClass;
import com.hrm.genric.ExcelUtlity;
import com.hrm.genric.FileUtlity;
import com.hrm.genric.WebActionUtility;
import com.hrm.pom.DashboardPage;
import com.hrm.pom.EmployeePage;

public class EmployeeTest extends BaseClass {

	@Test
	public void Employee() throws Throwable{		

		/*create Object for utlity */
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

		/*Edit test script data*/
		String companyID2 = eLib.getDataFromExcelBasedTestId(TEST_SCRIPT_EXCEL_FILE_PATH, "Employee", "TY_02", "CompanyID");
		String firstname2 = eLib.getDataFromExcelBasedTestId(TEST_SCRIPT_EXCEL_FILE_PATH, "Employee", "TY_02", "FirstName");
		String middleName2 = eLib.getDataFromExcelBasedTestId(TEST_SCRIPT_EXCEL_FILE_PATH, "Employee", "TY_02", "MiddleName");
		
		DashboardPage dp=new DashboardPage(driver);
		EmployeePage ep= new EmployeePage(driver);
		
		wLib.waitForElementInDOM(driver);
		
		/*step 2 : navigate to Employee Module and navigate to Add Employee sub-module*/
		dp.EmployeeModule();
		
		/*step 4 :  create a new Employee*/
		File f = new File("./src/test/resources/HRM TC.xlsx");
		String Abspath = f.getAbsolutePath(); 
		File f1 = new File("./src/test/resources/Ford.jpg");
		String Abspath1 = f1.getAbsolutePath(); 
		ep.AddEmployee(companyID,firstname,lastName,middleName,Dept,branch,position,contactno,sss,tin,hdmf,gsis,Abspath, Abspath1 );
		wLib.swithToAlertWindowAndAccpect(driver, "Insert Successfully!!!");

		/*step 5 : verify newly added employee*/
		ep.VerifyNewEmployee(firstname);

		/*step 6 : Edit Employee details*/
		File f2 = new File("./src/test/resources/HRM TC.xlsx");
		String Abspath2 = f2.getAbsolutePath(); 
		File f3 = new File("./src/test/resources/Ford.jpg");
		String Abspath3 = f3.getAbsolutePath(); 
		ep.EditEmployee(companyID2,firstname2,middleName2,Abspath2,Abspath3);
		wLib.swithToAlertWindowAndAccpect(driver, "Update Successfully!!!");

		/*step 7 : verify edited employee*/
		ep.VerifyEditedEmployee(firstname2);

		/*step 9 :  download employee file*/
		ep.DownloadEmpFile();

		/*step 8 :  Delete Employee details*/
		ep.DeleteEmployee();
		wLib.swithToAlertWindowAndAccpect(driver, "Delete Successfully!!!");

		/*step 10 : verify deleted employee*/
		ep.VerifyDeletedEmployee(firstname2);
	}       
}