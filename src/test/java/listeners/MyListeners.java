package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.ExtentReporter;

import java.io.IOException;

public class MyListeners implements ITestListener {

    ExtentReports extentReport;
    ExtentTest extentTest;
    @Override
    public void onStart(ITestContext context) {
        try {
            extentReport=ExtentReporter.generateExtentReport();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void onTestStart(ITestResult result) {
        String testName=result.getName();
        extentTest=extentReport.createTest(testName);
        extentTest.log(Status.INFO,testName+ "tarted executing");
        System.out.println(testName+"started executing");
    }
    @Override
    public void onTestSuccess(ITestResult result) {
        String testName=result.getName();
        extentTest=extentReport.createTest(testName);
        extentTest.log(Status.PASS,testName+"got successfully executed");
        System.out.println(testName+"got successfully executed");
    }
    @Override
    public void onTestFailure(ITestResult result) {
        String testName=result.getName();
        System.out.println(testName+"got failed");
        System.out.println(result.getThrowable());
    }
    @Override
    public void onTestSkipped(ITestResult result) {
        String testName=result.getName();
        System.out.println(testName+"got skipped");
        System.out.println(result.getThrowable());
    }
    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Execution of Project Test Finished");
    }
}
