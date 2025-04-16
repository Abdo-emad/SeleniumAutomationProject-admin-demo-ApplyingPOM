package tests;

import Base.BaseTest;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void ValidLogin(){
       LoginPage loginPage = new LoginPage(driver);
        loginPage.EnterEmail("admin@yourstore.com");
        loginPage.EnterPassword("admin");
        loginPage.LoginClick();
        System.out.println(driver.getTitle());
          }
}
