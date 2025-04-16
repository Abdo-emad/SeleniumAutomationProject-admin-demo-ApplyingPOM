package Base;

import Utils.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest{
    public WebDriver driver;
    @BeforeMethod
    public void Setup(){
        Log.Info("Test started");
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://admin-demo.nopcommerce.com/login");
        driver.manage().deleteAllCookies();
    }
    @AfterMethod
    public void TearDown(){
        Log.Info("Test completed");
        Log.Info("Closing the browser");
        if (driver!= null) {
            driver.quit();

        }
    }
}
