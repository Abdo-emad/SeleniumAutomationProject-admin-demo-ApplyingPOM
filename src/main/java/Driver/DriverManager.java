package Driver;

import org.openqa.selenium.WebDriver;

public class DriverManager {
   private static final ThreadLocal <WebDriver> driverThreadLocal = new ThreadLocal<>();
    public static WebDriver getDriver() {
        if (driverThreadLocal.get()==null){
            System.out.println("browser equal null");
            throw new NullPointerException("driver is null");
        }
        return driverThreadLocal.get();
    }

    public static void setDriver(WebDriver driver){
        driverThreadLocal.set(driver);
    }

    public static WebDriver CreateInstance(String browserName){
          WebDriver driver= BrowserFactory.getBrowser(browserName);
          setDriver(driver);
          return  getDriver();
    }

}
