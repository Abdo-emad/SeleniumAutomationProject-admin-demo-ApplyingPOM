package Pages;

import Utils.Log;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
   public WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By emailField = By.id("Email");
    private final By passwordField = By.id("Password");
    private final By loginButton = By.xpath("//button[contains(text(),'Log in')]");

    @Step("Enter email")
    public  void EnterEmail(String Email){
        Log.Info("Clear the email field");
        driver.findElement(emailField).clear();
        Log.Info("Enter the email");
        driver.findElement(emailField).sendKeys(Email);
    }
    @Step("Enter password")
    public  void EnterPassword(String Password){
        Log.Info("Clear the password field");
        driver.findElement(passwordField).clear();
        Log.Info("Enter the password");
        driver.findElement(passwordField).sendKeys(Password);
    }
    @Step("Click on the login button")
    public void LoginClick(){
        Log.Info("Click on the login button");
        driver.findElement(loginButton).click();
    }
}
