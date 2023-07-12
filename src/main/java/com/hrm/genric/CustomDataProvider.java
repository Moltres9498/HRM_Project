package com.hrm.genric;

import org.testng.annotations.DataProvider;

public class CustomDataProvider {

	@DataProvider(name="Logindata")
	public Object[][] getdata() throws Throwable
	{
		ExcelUtlity eLib = new ExcelUtlity();
		FileUtlity fLib = new FileUtlity();	
		String TEST_SCRIPT_EXCEL_FILE_PATH =    fLib.getFilePathFromPropertiesFile("testScriptdatafilePath");
		Object[][] obj=new Object[1][2];
		obj[0][0]=eLib.getDataFromExcelBasedTestId(TEST_SCRIPT_EXCEL_FILE_PATH, "LoginDataProvider", "TY_01", "Username");
		obj[0][1]=eLib.getDataFromExcelBasedTestId(TEST_SCRIPT_EXCEL_FILE_PATH, "LoginDataProvider", "TY_01", "Password");
		return obj;
	}
	
}
