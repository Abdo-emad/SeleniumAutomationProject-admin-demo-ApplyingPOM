package Pages;

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
    public  void EnterEmail(String Email){
        driver.findElement(emailField).clear();
        driver.findElement(emailField).sendKeys(Email);
    }
    public  void EnterPassword(String Password){
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(Password);
    }
    public void LoginClick(){
        driver.findElement(loginButton).click();
    }
}
