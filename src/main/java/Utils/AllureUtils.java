package Utils;

import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class AllureUtils  {
    public static void getScreenShot(WebDriver driver) throws IOException {
        File src=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File des = new File("ScreenShot/screenshot"+TimeStampUtils.getTimeStamp()+".png");
        FileUtils.copyFile(src, des);
        Allure.addAttachment("Screenshot", "image/png", Arrays.toString(FileUtils.readFileToByteArray(des)), ".png");
        System.out.println("Screenshot taken");


    }
}
