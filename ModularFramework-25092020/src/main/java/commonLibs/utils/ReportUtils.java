package commonLibs.utils;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ReportUtils {
	
	private ExtentReporter htmlReport;
	
	private ExtentReports extentReport;
	
	private ExtentTest extentTest;
	
	public ReportUtils(String filename) {
		
		htmlReport = new ExtentHtmlReporter(filename);
		extentReport = new ExtentReports();
		
		extentReport.attachReporter(htmlReport);
		
	}

	public void createATestcase(String testcaseName) {
		extentTest = extentReport.createTest(testcaseName);
	}
	
	public void addLogs(Status status, String comment) {
		extentTest.log(status, comment);
	}
	
	public void addScreenshotInReport(String imageFilename) throws Exception{
		extentTest.addScreenCaptureFromPath(imageFilename);
	}
	
	public void flushReport() {
		extentReport.flush();
	}
}
