package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest{
    public WebDriver driver;
    @BeforeMethod
    public void Setup(){
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://admin-demo.nopcommerce.com/login");
        driver.manage().deleteAllCookies();
    }
    @AfterMethod
    public void TearDown(){
        if (driver!= null) {
            driver.quit();

        }
    }
}
