package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;


import driverfactory.DriverFactory;
import utilities.ExtentManager;
import utilities.ScreenshotUtil;

public class ExtentTestListener implements ITestListener {
	private static final ExtentReports extent = ExtentManager.getExtentReports();
    private static final ThreadLocal<ExtentTest> test = new ThreadLocal<>();

	
	@Override
    public void onTestStart(ITestResult result) {

        ExtentTest extentTest = extent.createTest(
                result.getTestClass().getName()
                        + " : "
                        + result.getMethod().getMethodName()
        );

        test.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().log(Status.PASS, "Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
    	test.get().log(Status.FAIL, "Test Failed");
        test.get().log(Status.FAIL, result.getThrowable());

        try {
           

            String path = ScreenshotUtil.capture(
            		DriverFactory.getDriver(),
                    result.getMethod().getMethodName()
            );

            test.get().addScreenCaptureFromPath(path);

        } catch (Exception e) {
            test.get().log(Status.WARNING, "Screenshot not attached: " + e.getMessage());
        }
    }
    

    @Override
    public void onTestSkipped(ITestResult result) {
        test.get().log(Status.SKIP, "Test Skipped");
        test.get().log(Status.SKIP, result.getThrowable());
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush(); // 🔥 generates final HTML report
    }
}
