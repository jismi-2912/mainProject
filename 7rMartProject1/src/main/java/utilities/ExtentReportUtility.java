package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportUtility {
	public static final ExtentReports extentReports = new ExtentReports();
	   
	//defining a thread-safe method for creating and returning an ExtentReports instance.
	public synchronized static ExtentReports createExtentReports() {
        // creating an ExtentSparkReporter instance, which is responsible for generating HTML report
		ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/extent-report.html");//folder

		reporter.config().setReportName("7rMartProject");

		extentReports.attachReporter(reporter);

		extentReports.setSystemInfo("Organization", "Obsqura");

		extentReports.setSystemInfo("Name", " Delna "); 

		return extentReports;

	}

}
