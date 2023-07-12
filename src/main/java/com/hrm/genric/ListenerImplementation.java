package com.hrm.genric;

import java.io.File;
import java.time.LocalDateTime;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImplementation extends BaseClass implements ITestListener {

	public void onTestStart(ITestResult result) {

	}

	public void onTestSuccess(ITestResult result) {

	}

	public void onTestFailure(ITestResult result) {
		String Methodname = result.getMethod().getMethodName();
		TakesScreenshot ts=(TakesScreenshot) BaseClass.sdriver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		LocalDateTime dt = LocalDateTime.now();
		String datetime = dt.toString().replace(" ", "_").replace(":", "_");
		File dst = new File("./screenshots/"+Methodname+"_"+datetime+".png");
		try {
			FileUtils.copyFile(src, dst);
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void onTestSkipped(ITestResult result) {

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onTestFailedWithTimeout(ITestResult result) {

	}

	public void onStart(ITestContext context) {

	}

	public void onFinish(ITestContext context) {

	}
	
	

}
