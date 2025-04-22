package tests;

import Base.BaseTest;
import Pages.LoginPage;
import TestListeners.TestNgListeners;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

@Listeners(TestNgListeners.class)
public class E2EScenario extends BaseTest {
  //To attach the TestNgListeners class to the test class
    @Test
    @Step("Add to cart")

    @Description("Add to cart")
    public void AddToCart() throws IOException, InterruptedException {
     driver.findElement(By.id("user-name")).sendKeys("standard_user");
     driver.findElement(By.id("password")).sendKeys("secret_sauce");
     driver.findElement(By.id("login-button")).click();
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
       // looping1("Sauce Labs Backpack");
       AddSpecificItemToCart("Sauce Labs Bike Light");
        Thread.sleep(10000);
        Assert.assertTrue(driver.findElement(By.id("remove-sauce-labs-bike-light")).isDisplayed());


    }

    public void looping1(String ItemName){
        By container= By.xpath("//div[@class=\"inventory_item\"]");
        List<WebElement> containerElement= driver.findElements(container);
        for (int i=0;i<containerElement.size();i++ ){
            List<WebElement> items = driver.findElements(By.cssSelector(".inventory_item_name"));
            if (items.get(i).getText().equalsIgnoreCase(ItemName)){
                driver.findElements(By.xpath("//button[text()='Add to cart']")).get(i).click();
            }
        }
    }

    public void AddSpecificItemToCart(String itemName){
       By AddToCartButton= RelativeLocator.with(By.tagName("button")).below(driver.findElement(By.xpath("//div[text()='"+itemName+"']")));
       driver.findElement(AddToCartButton).click();
    }
}
