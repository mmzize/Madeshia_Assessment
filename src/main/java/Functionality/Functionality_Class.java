package Functionality;

import Helpers.Scroll;
import Helpers.TakeScreenshot;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.Runtime;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import javax.swing.*;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Functionality_Class {
    private WebDriver driver;

    public Functionality_Class(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//span[contains(.,'Features')]")
    WebElement Features;

    @FindBy (xpath = "//a[contains(text(),'Newsletter Module')]")
    WebElement NewsLetter;

    @FindBy(id ="address")
    WebElement Email;

    @FindBy(xpath = "//button[contains(.,'SUBSCRIBE')]")
    WebElement Subscribe;

    @FindBy(xpath = "//a[@href='https://docs.phptravels.com']")
    WebElement Docs_Menu;

    @FindBy (xpath = "//a[contains(text(),'Pricing')]")
    WebElement Pricing;

    @FindBy(xpath = "(//div[contains(.,'Plans and Prices')])[7]")
    WebElement Pricing_Heading;

    @FindBy(id = "4")
    WebElement Select_Option;

    @FindBy (id = "order_button")
    WebElement Buy_Now;

    Scroll scroll = new Scroll();

    public void Scroll_To_FAQs() {
        scroll.Scroll_To_Element(driver);
        scroll.Scroll_To_Element_2(driver);
    }

    public void Select_NewsLetter() {
        WebDriverWait features= new WebDriverWait(driver,30);
        features.until(ExpectedConditions.visibilityOf(Features));
        Features.click();
        WebDriverWait newsletter= new WebDriverWait(driver,30);
        newsletter.until(ExpectedConditions.visibilityOf(NewsLetter));
        NewsLetter.click();
    }
    public void Subscribe() throws InterruptedException {
        scroll.Scroll_To_Element(driver);
        scroll.Scroll_To_Element_2(driver);
        scroll.Scroll_To_Element_2(driver);
        Email.sendKeys("demouser@travels.com");
        Subscribe.click();
        TimeUnit.SECONDS.sleep(5);
        driver.switchTo().alert().accept();
    }
    public void Click_Docs_Menu() throws InterruptedException {
        WebDriverWait docs= new WebDriverWait(driver,30);
        docs.until(ExpectedConditions.visibilityOf(Docs_Menu));

        Docs_Menu.click();
        TimeUnit.SECONDS.sleep(5);

        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        TakeScreenshot screenshot =new TakeScreenshot();
        screenshot.takeSnapShot(driver,"Docs Screenshot");
        driver.close();
        driver.switchTo().window(tabs2.get(0));

    }
    public void Pricing_Menu()
    {
        WebDriverWait pricing= new WebDriverWait(driver,30);
        pricing.until(ExpectedConditions.visibilityOf(Pricing));

        Pricing.click();
    }
    public void Verify_Pricing_Heading()
    {
        WebDriverWait price= new WebDriverWait(driver,30);
        price.until(ExpectedConditions.visibilityOf(Pricing_Heading));

        Assert.assertEquals(Pricing_Heading.getText(),"Plans and Prices");
    }
    public void Click_Buy_Now_Button()
    {
        WebDriverWait docs= new WebDriverWait(driver,30);
        docs.until(ExpectedConditions.visibilityOf(Select_Option));

        Select_Option.click();
        Buy_Now.click();
    }
}
