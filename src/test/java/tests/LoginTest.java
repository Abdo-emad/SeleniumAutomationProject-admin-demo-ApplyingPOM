package tests;

import Base.BaseTest;
import Pages.LoginPage;
import Utils.ExcelUtils;
import Utils.Log;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

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
    public void ValidLogin(String userEmail, String pass){
        Log.Info("Starting Valid Login Test");
       LoginPage loginPage = new LoginPage(driver);
        loginPage.EnterEmail(userEmail);
        loginPage.EnterPassword(pass);
        loginPage.LoginClick();
        System.out.println(driver.getTitle());
        Log.Info("Validating the title of the page");
        Assert.assertEquals(driver.getCurrentUrl(),"https://admin-demo.nopcommerce.com/login");
          }
}
