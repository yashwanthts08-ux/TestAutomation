package utilities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager  {
	private static ExtentReports extent;

	public static ExtentReports getExtentReports() {
		if (extent == null) {
			LocalDateTime now = LocalDateTime.now();
			String timeStamp = now.format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
			String reportname = "Extent report_" + timeStamp + ".html";

			String path = System.getProperty("user.dir")+"\\reports\\" + reportname;
			System.out.println(path);
			
			ExtentSparkReporter spark=new ExtentSparkReporter(path);
			spark.config().setDocumentTitle("Automation");
			spark.config().setReportName("regression");
			
			extent =new ExtentReports();
			extent.attachReporter(spark);
			
			extent.setSystemInfo("OS", System.getProperty("os.name"));
            extent.setSystemInfo("User", System.getProperty("user.name"));
            extent.setSystemInfo("Environment", "QA");
		}
		return extent;
	}

}
