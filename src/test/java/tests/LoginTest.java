package tests;

import Base.BaseTest;
import Pages.LoginPage;
import TestListeners.TestNgListeners;
import Utils.ExcelUtils;
import Utils.Log;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

import static Utils.ReadFromPropertyFile.GetDataFromPropFile;

@Listeners(TestNgListeners.class)  //To attach the TestNgListeners class to the test class
public class LoginTest extends BaseTest {
    @DataProvider(name="LoginData")
    public Object[][] getLoginData() throws IOException {

        String filePath = System.getProperty("user.dir")+"/testdata/TestData.xlsx";
        ExcelUtils.loadExcel(filePath, "Sheet1");
        int rowCount = ExcelUtils.getRowCount();
        Object[][] data = new Object[rowCount-1][2];

        for(int i=1; i<rowCount; i++) {

            data[i-1][0] = ExcelUtils.getCellData(i, 0);	// Username
            data[i-1][1] = ExcelUtils.getCellData(i, 1);	// Password
        }
        ExcelUtils.closeExcel();
        return data;
    }

    @Test(dataProvider ="LoginData" )
    public void Login(String userEmail, String pass){
        Log.Info("Starting Valid Login Test");
       LoginPage loginPage = new LoginPage(driver);
        loginPage.EnterEmail(userEmail);
        loginPage.EnterPassword(pass);
        loginPage.LoginClick();
        System.out.println(driver.getTitle());
        Log.Info("Validating the title of the page");
        Assert.assertEquals(driver.getCurrentUrl(),"https://admin-demo.nopcommerce.com/login");
        Log.trace("Test execution done");
    }


    @Test()
    public void ValidLogin() throws IOException {
        Log.Info("Starting Valid Login Test");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.EnterEmail(GetDataFromPropFile("userEmail"));
        loginPage.EnterPassword(GetDataFromPropFile("userPassword"));
        loginPage.LoginClick();
        System.out.println(driver.getTitle());
        Log.Info("Validating the title of the page");
        Assert.assertEquals(driver.getCurrentUrl(),"https://admin-demo.nopcommerce.com/login");
        Log.trace("Test execution done");
    }
}
