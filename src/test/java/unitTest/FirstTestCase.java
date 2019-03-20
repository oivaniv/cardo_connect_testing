package unitTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;

@Epic("Smoke Tests")
@Feature("FM Radio")

public class FirstTestCase {

    public AndroidDriver<MobileElement> driver;
    public WebDriverWait wait;

    @BeforeMethod
    public void BeforeTest() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "LG G6");
        caps.setCapability("udid", "LGH8705f292316");
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "8.0");
        caps.setCapability("appPackage", "com.cardo.smartset");
        caps.setCapability("appActivity", "com.cardo.smartset.ui.activities.PrivacyPolicyActivity");
        caps.setCapability("noReset", "true");
        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        wait = new WebDriverWait(driver, 10);
    }

    @Test(priority = 0, description = "Start and Stop FM Radio from FM page")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: Verify FM page basic functionality.")
    @Story("Basic functionality tests")
    public void firstTest() throws InterruptedException {

        //External report description


        //************************Test methods*****************
        pressRadioButton();
        System.out.println("FM page is opened");

        pressPlayFMButton();
        System.out.println("FM is started");

        pressStopFmButton();
        System.out.println("FM is stopped");

        pressXButton();
        System.out.println("FM page is closed");


    }

    @Step("Open FM page")
    public void pressRadioButton() {
        //Click on Accept button
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id("com.cardo.smartset:id/radio_button"))).click();
    }

    @Step("Press Start FM Button")
    public void pressPlayFMButton() {
        //Click on Allow permision popup
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id("com.cardo.smartset:id/activity_radio_start_stop_radio_btn"))).click();
    }

    @Step("Press Stop FM Button")
    public void pressStopFmButton() {
        //Click on Allow permision popup
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id("com.cardo.smartset:id/activity_radio_start_stop_radio_btn"))).click();
    }

    @Step("Press X button")
    public void pressXButton() {
        //Click on Allow permision popup
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id("com.cardo.smartset:id/material_design_toolbar_left_icon"))).click();
    }


//    @Test
//    public void secondTest ()throws InterruptedException{
//        //Click on Accept button
//        wait.until(ExpectedConditions.visibilityOfElementLocated
//                (By.id("com.cardo.smartset:id/accepting_btn"))).click();
//
//        //Click on Allow permision popup
//        wait.until(ExpectedConditions.visibilityOfElementLocated
//                (By.id("com.android.packageinstaller:id/permission_allow_button"))).click();
//        //Click on Allow permision popup
//        wait.until(ExpectedConditions.visibilityOfElementLocated
//                (By.id("com.android.packageinstaller:id/permission_allow_button"))).click();
//        //Click on Allow permision popup
//        wait.until(ExpectedConditions.visibilityOfElementLocated
//                (By.id("com.android.packageinstaller:id/permission_allow_button"))).click();
//    }


    @AfterMethod
    public void AfterTest() {
        driver.quit();
    }
}
