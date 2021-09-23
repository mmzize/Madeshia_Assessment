package Helpers;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TakeScreenshot {

    public void takeSnapShot(WebDriver driver, String screenshotName) throws InterruptedException {

        TimeUnit.SECONDS.sleep(5);
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        //Copy the file to a location and use try catch block to handle exception
        try {
            FileUtils.copyFile(screenshot, new File(".//ScreenShots/" + screenshotName+ ".png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
