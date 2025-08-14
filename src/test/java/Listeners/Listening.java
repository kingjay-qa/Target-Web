package Listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

import TestsCase.BaseTest;
import Utilities.CommonUtilities;

public class Listening implements ITestListener{
public void onTestStart(ITestResult result) {
		
	}

	public void onTestFailure(ITestResult result) {
		BaseTest.test.get().addScreenCaptureFromPath(CommonUtilities.captureScreenshot(BaseTest.getBrowser()));
		BaseTest.test.get().log(Status.FAIL, result.getName()+" FAILED");
	}

	public void onTestSuccess(ITestResult result) {
		BaseTest.test.get().log(Status.PASS, result.getName()+" PASSED");
		
	}
}
