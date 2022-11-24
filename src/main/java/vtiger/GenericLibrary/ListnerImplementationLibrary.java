package vtiger.GenericLibrary;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListnerImplementationLibrary implements ITestListener
{
	
	ExtentReports report;
	ExtentTest test;

	public void onTestStart(ITestResult result)
	{
		String MethodName = result.getMethod().getMethodName();
	System.out.println(MethodName+" Test Started");
		
	}

	public void onTestSuccess(ITestResult result)
	{
		String MethodName = result.getMethod().getMethodName();
		System.out.println(MethodName+" Test Passed");
	
	}

	public void onTestFailure(ITestResult result) 
	{
		webdriverLibrary wLib=new webdriverLibrary();
		JavaFileLibrary jLib=new JavaFileLibrary();
		
		String MethodName = result.getMethod().getMethodName()+jLib.getSystemDateInFormat();
		System.out.println(MethodName+"Test Failed");
		try {
			wLib.takeScreenShot(BaseClass.sDriver, MethodName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
	}

	public void onTestSkipped(ITestResult result) 
	{
		String MethodName = result.getMethod().getMethodName();
		System.out.println(MethodName+" Test Skipped");
	
	
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
	
	}

	public void onStart(ITestContext context) 
	{
	
		Reporter.log("Execution of Suite Started",true);
		//Execution of Start here,hence cofigure the extent reports here,D-M-Y-Min-Sec
		ExtentSparkReporter htmlReport=new ExtentSparkReporter(".\\ExtentReports\\Report-"+new JavaFileLibrary().getSystemDateInFormat()+".html");
	    htmlReport.config().setDocumentTitle("Execution Reports for vTiger");
	    htmlReport.config().setTheme(Theme.DARK);
	    htmlReport.config().setReportName("vTiger Execution Reports");
	    
	    
	    //attach the Reports to extent reports
	    report=new ExtentReports();
	    report.attachReporter(htmlReport);
	    report.setSystemInfo("Base Browser","Chrome");
	    report.setSystemInfo("BaseEnvironment","Testing");
	    report.setSystemInfo("BAse URL","https://localhost:8888");
	    report.setSystemInfo("Base Platform","Windows");
	    report.setSystemInfo("Repoter Name","Gowtham");
	    
	
	}

	public void onFinish(ITestContext context) 
	{
	Reporter.log("Test Suite is Fineshed",true);
	
	//Flush the report,-here the execution is fineshed
	report.flush();
	}

	}
	


