 package com.hrm.genric;

import org.testng.annotations.Test;

public class DataProviderTest {

		@Test(dataProvider = "Logindata", dataProviderClass = CustomDataProvider.class)
		
		public void logintest(String em, String pw) {
			System.out.println(em+" "+pw);
		}
}