package TestListeners;
import Utils.FilesUtils;
import Utils.Log;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;


public class TestNgListeners implements ITestListener {
    String path = System.getProperty("user.dir")+"./target";
    @Override
    public void onTestStart(ITestResult result) {
        Log.info("Test Start");
    }
@Override
    public void onTestSuccess(ITestResult result) {
        Log.info("Test Success");
    }
    @Override
    public void onTestFailure(ITestResult result) {
        Log.error("Test Failed");
    }
    @Override
    public void onTestSkipped(ITestResult result) {
        Log.trace("Test Skipped");
    }
    @Override
    public void onStart(ITestContext context) {
    }
    @Override
    public void onFinish(ITestContext context) {
        FilesUtils.deleteFiles(new File(path));
    }



}
