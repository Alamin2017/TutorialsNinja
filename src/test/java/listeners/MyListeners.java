package listeners;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
public class MyListeners implements ITestListener  {
    ExtentSparkReporter htmlReporter;
    ExtentReports reports;
    ExtentTest test;
    public void configureReport()
    {
        htmlReporter=new ExtentSparkReporter("ExtentListenerReportDemo.html");
        reports=new ExtentReports();
        reports.attachReporter(htmlReporter);
        //add system information
        reports.setSystemInfo("Machine","Lenovo");
        reports.setSystemInfo("OS","10");
        reports.setSystemInfo("Browser","Chrome");
        reports.setSystemInfo("User","Al-Amin");
        //configuration to change look
        htmlReporter.config().setDocumentTitle("Extent Reporter Report Demo");
        htmlReporter.config().setReportName("This is my First Report");
        htmlReporter.config().setTheme(Theme.DARK);
    }
    public void onStart(ITestContext context) {
        configureReport();
        System.out.println("On Start method invoked");
    }
    public void onTestStart(ITestResult result) {
        System.out.println("Name of the test method started:"+result.getName());
    }
    public void onTestSuccess(ITestResult result) {
        System.out.println("Name of test method successfully executed:"+result.getName());
        test=reports.createTest(result.getName());
        test.log(Status.PASS, MarkupHelper.createLabel("Name of the passed test case is:"+result.getName() ,ExtentColor.GREEN));
    }
    public void onTestFailure(ITestResult result) {
        System.out.println("Name of test method not executed"+result.getName());
        test=reports.createTest(result.getName());
        test.log(Status.FAIL, MarkupHelper.createLabel("Name of the failed test case is:"+result.getName() ,ExtentColor.RED));
    }
    public void onTestSkipped(ITestResult result) {
        System.out.println("Name of test method skipped"+result.getName());
        test=reports.createTest(result.getName());
        test.log(Status.SKIP, MarkupHelper.createLabel("Name of the skipped test case is:"+result.getName() ,ExtentColor.YELLOW));
    }
    public void onFinish(ITestContext context) {
        System.out.println("On Finish method invoked");
        reports.flush();
    }
}
