package MiniProj;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AutomationReportM implements ITestListener {

    public ExtentSparkReporter htmlreporter;
    public ExtentReports extent;
    public ExtentTest test;

    public void onFinish(ITestContext context) {
        extent.flush();
    }

    public void onStart(ITestContext context) {
        // Get the current date and format it
        String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        String reportPath = "C:\\Users\\2372586\\Downloads\\FlipkartAutomation\\FlipkartAutomation\\Report\\FlipkartAutomation-Report.html";

        htmlreporter = new ExtentSparkReporter(reportPath);
        extent = new ExtentReports();
        extent.attachReporter(htmlreporter);

        // Customizing the report	
        htmlreporter.config().setDocumentTitle("Online Shopping Automation");
        htmlreporter.config().setReportName("Automation Report");
        htmlreporter.config().setTheme(Theme.DARK);
        htmlreporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");

        // Adding system information
        extent.setSystemInfo("Report Generated On", date);
        extent.setSystemInfo("Computer Name", "Local Host");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("Tester Name", "Abhinay Iragavarapu");
        extent.setSystemInfo("OS", "Windows11");
        extent.setSystemInfo("Browser", "chrome");
    }

    public void onTestSuccess(ITestResult result) {
        test = extent.createTest(result.getName());
        test.log(Status.PASS, "Test case passed: " + result.getName());
        test.info("Test Completed");
    }

    public void onTestFailure(ITestResult result) {
        test = extent.createTest(result.getName());
        test.log(Status.FAIL, "Test case failed: " + result.getThrowable());
        test.info("Test interrupted");
    }

    public void onTestSkipped(ITestResult result) {
        test = extent.createTest(result.getName());
        test.log(Status.SKIP, "Test case skipped: " + result.getName());
        test.info("Test skipped");
    }
}
