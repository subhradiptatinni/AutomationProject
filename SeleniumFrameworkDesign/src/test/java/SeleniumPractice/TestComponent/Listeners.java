package SeleniumPractice.TestComponent;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import SeleniumPractice.resources.ExtentReporterNG;

public class Listeners extends BaseTest implements ITestListener {
	
	ExtentTest test;
	WebDriver driver;
	ExtentReports extent= ExtentReporterNG.getReportObject();
	ThreadLocal <ExtentTest> extentTest= new ThreadLocal<ExtentTest>();
	String filePath= null;
	
	@Override  
	public void onTestFailure(ITestResult result) {  
		
		extentTest.get().fail(result.getThrowable());
	// TODO Auto-generated method stub 
		try {
			driver= (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.fail(result.getThrowable());
		
		 try {
			filePath= getScreenShot(result.getMethod().getMethodName(), driver);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		 extentTest.get().addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
	System.out.println("Failure of test cases and its details are : "+result.getName());  
	}  
	  
	@Override  
	public void onTestSkipped(ITestResult result) {  
	// TODO Auto-generated method stub  
	System.out.println("Skip of test cases and its details are : "+result.getName());  
	}  
	  
	@Override  
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {  
	// TODO Auto-generated method stub  
	System.out.println("Failure of test cases and its details are : "+result.getName());  
	}  
	  
	@Override  
	public void onStart(ITestContext result) {  
	// TODO Auto-generated method stub  
		test= extent.createTest(result.getName());
		extentTest.set(test);
	}  
	  
	@Override  
	public void onFinish(ITestContext result) {  
	// TODO Auto-generated method stub  
		extent.flush();
	} 
	
	@Override  
	public void onTestSuccess(ITestResult result) { 
		
		extentTest.get().log(Status.PASS, "Test passed");
	// TODO Auto-generated method stub  
	} 

}
