package tests;

import Base.BaseTest;
import Pages.LoginPage;
import Utils.Log;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void ValidLogin(){
        Log.Info("Starting Valid Login Test");
       LoginPage loginPage = new LoginPage(driver);
        loginPage.EnterEmail("admin@yourstore.com");
        loginPage.EnterPassword("admin");
        loginPage.LoginClick();
        System.out.println(driver.getTitle());
        Log.Info("Validating the title of the page");
        Assert.assertEquals(driver.getCurrentUrl(),"https://admin-demo.nopcommerce.com/login");
          }
}
