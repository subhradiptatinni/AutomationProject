package SeleniumPractice.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	
public static ExtentReports getReportObject()
{
	String path= System.getProperty("E://New_Java_Project//SeleniumFrameworkDesign//reports//index.html");
	ExtentSparkReporter reporter = new ExtentSparkReporter(path);
	reporter.config().setReportName("Web automation results");
	reporter.config().setDocumentTitle("Test results");
	ExtentReports extent = new ExtentReports();
	extent.attachReporter(reporter);
	extent.setSystemInfo("Tester", "Subhradipta");
	extent.createTest(path);
	return extent;
}
}
