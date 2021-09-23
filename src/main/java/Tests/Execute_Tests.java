package Tests;

import Helpers.TakeScreenshot;
import Setup.Setup_Class;
import Functionality.Functionality_Class;
import Helpers.Report_Helper;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;

import java.io.IOException;

public class Execute_Tests extends Report_Helper {

    private WebDriver driver = Setup_Class.startBrowserOfChoice("https://phptravels.com/demo/", "chrome");
    TakeScreenshot screenshot = new TakeScreenshot();
    Functionality_Class functionality_class =PageFactory.initElements(driver,Functionality_Class.class);
    public Execute_Tests() {
    }
    @Test
    public void Scroll_To_FAQ_Test() throws InterruptedException {
        test = extent.createTest("FAQ Test", "Click FAQ");
        test.log(Status.PASS, "FAQ Option");


        functionality_class.Scroll_To_FAQs();
        screenshot.takeSnapShot(driver,"FAQ Screenshot");
    }
    @Test (priority = 1)
    public void Select_Newsletter_Tests() throws InterruptedException {
        functionality_class.Select_NewsLetter();
    }
    @Test (priority = 2)
    public void Subscribe_Test() throws InterruptedException {
        functionality_class.Subscribe();
        screenshot.takeSnapShot(driver,"Subscribe Screenshot");
    }
    @Test(priority = 3)
    public void Click_Docs_Menu_Test() throws InterruptedException {
        functionality_class.Click_Docs_Menu();
    }
    @Test(priority = 4)
    public void Click_Pricing_Menu_Test()
    {
        functionality_class.Pricing_Menu();
    }
    @Test(priority = 5)
    public void Verify_Price_Heading_Test()
    {
        functionality_class.Verify_Pricing_Heading();
    }
    @Test(priority = 6)
    public void Select_Option_And_Buy()
    {
        functionality_class.Click_Buy_Now_Button();
    }

    @AfterTest(description = "This method will quit the driver after all the test")
    public void Exit_Test()
    {
       // driver.quit();
    }
}
