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

public class ListnerImplimentationLibrary implements ITestListener {
	ExtentReports report;
	ExtentTest test;

	public void onTestStart(ITestResult result) {
		String MethodName=result.getMethod().getMethodName();
		//System.out.println("test execution started"+MethodName);
		test=report.createTest(MethodName);
		test.log(Status.INFO, "test execution started");
		
	}

	public void onTestSuccess(ITestResult result) {
		String MethodName=result.getMethod().getMethodName();
		//System.out.println("test execution sucess"+MethodName);
		test.log(Status.PASS,MethodName+"-->pass");
		
	}

	public void onTestFailure(ITestResult result) {
		WebDriverLibrary wLib=new WebDriverLibrary();
		JavaLibraries jLib=new JavaLibraries();
		
		String MethodName=result.getMethod().getMethodName()+jLib.getSystemDateInFormat();
		//System.out.println("test execution failed"+MethodName);
		test.log(Status.FAIL, "failed");
		test.log(Status.FAIL, result.getThrowable());
		
		try {
			String path=wLib.takeScreenShot(BaseClass.sDriver,MethodName);
			test.addScreenCaptureFromPath(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult result) {
		String MethodName=result.getMethod().getMethodName();
		//System.out.println("test execution skipped"+MethodName);
		test.log(Status.SKIP,MethodName+"-->Skipped");
		test.log(Status.SKIP, result.getThrowable());
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
		
	}

	public void onStart(ITestContext context) {
		Reporter.log("Execution of suit started",true);
		ExtentSparkReporter htmlreport=new ExtentSparkReporter(".\\ExtentReports\\Report-"+new JavaLibraries().getSystemDateInFormat()+".html");
		htmlreport.config().setDocumentTitle("Execution reports for vTiger");
		htmlreport.config().setTheme(Theme.DARK);
		htmlreport.config().setReportName("vtiger execution reports");
		report=new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("Base Browser","chrome");
		report.setSystemInfo("Base Environment","Testing");
		report.setSystemInfo("Base URL","http://localhost:8888");
		report.setSystemInfo("Base Platform","Windows");
		report.setSystemInfo("Reportername ","rajini");
		
		
	}

	public void onFinish(ITestContext context) {
		
		 Reporter.log("Execution of suite Finished",true);
		 report.flush();
	}

}
