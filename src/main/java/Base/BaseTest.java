package Base;

import Driver.DriverManager;
import Utils.AllureUtils;
import Utils.Log;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

public class BaseTest{
    public WebDriver driver;
    @BeforeMethod
    @Step("Setup")
    public void Setup(){
        Log.Info("Test started");
        driver= DriverManager.CreateInstance("edge");
        driver.manage().window().maximize();
        //driver.get("https://admin-demo.nopcommerce.com/login");
        driver.get("https://www.saucedemo.com/");
        driver.manage().deleteAllCookies();
    }
    @AfterMethod
    @Step("TearDown")
    public void tearDown(ITestResult result) throws IOException {
        if (ITestResult.SUCCESS == result.getStatus()) {
            AllureUtils.attachScreenshotToAllure("Success", "ScreenShot/screenshot" + result.getName() + ".png");
        }
        driver.quit();
    }

}
