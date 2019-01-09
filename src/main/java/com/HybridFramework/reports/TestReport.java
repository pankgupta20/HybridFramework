package com.HybridFramework.reports;

import java.io.IOException;

import org.testng.ITestResult;

import com.HybridFramework.screenshots.TakeScreenshot;
import com.HybridFramework.testbase.TestBase;
import com.relevantcodes.extentreports.LogStatus;

	    

public class TestReport extends TestBase{
	public TakeScreenshot tk;
	public TestReport(){
		tk = new TakeScreenshot();
	}
	
	public void getresult(ITestResult result) throws IOException{
		if(result.getStatus() == ITestResult.SUCCESS){
			test.log(LogStatus.PASS, result.getName()+ " : Test is pass");
		}
		else if(result.getStatus() == ITestResult.SKIP){
			test.log(LogStatus.SKIP, result.getName()+ " : Test is skipped and skip reason is: " + result.getThrowable());
		}
		else if(result.getStatus() == ITestResult.FAILURE){
			test.log(LogStatus.FAIL, result.getName()+ " : Test is fail and failure reason is: " + result.getThrowable());
			String screen = tk.takeScreenshot("");
			test.log(LogStatus.FAIL, test.addScreenCapture(screen));			
		}
		else if(result.getStatus() == ITestResult.STARTED){
			test.log(LogStatus.INFO, result.getName()+ " : Test is started ");
		}	
	}
}
