package RetryAnalyzer;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class TestNgRetryAnalyzer implements IRetryAnalyzer {
    int count = 0;
    int maxTry = 2;
    //to add retry analyzer to the test class >> @Test(retryAnalyzer = TestNgRetryAnalyzer.class)
    @Override
    public boolean retry(ITestResult iTestResult) {
        if (count < maxTry) {
            count++;
            return true;
        }
        return false;
    }
}
