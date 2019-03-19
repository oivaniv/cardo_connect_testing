import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.*;
import io.qameta.allure.listener.TestLifecycleListener;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.Listeners.TestListener;

import java.net.MalformedURLException;
import java.net.URL;

@Listeners({TestListener.class})
@Epic("Basic functionality")
@Feature("FM page")

public class TestClass {

    public AndroidDriver<MobileElement> driver;
    public WebDriverWait wait;


    @BeforeMethod
    public void setup() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Nexus 5");
        caps.setCapability("udid", "03787176d024355e");
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "6.0.1");
        caps.setCapability("appPackage", "com.cardo.smartset");
        caps.setCapability("appActivity", "com.cardo.smartset.ui.activities.PrivacyPolicyActivity");
        caps.setCapability("noReset", "true");
        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        wait = new WebDriverWait(driver, 10);
    }


    @Test(priority = 0, description = "Verify FM page open functionality")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify FM page opem and close functionality.")
    @Story("FM page")


    //*****************Test Methods******************************8
    @Step("Press FM page button..")
    public void openFmPage() throws InterruptedException {
        MobileElement fmPageButton = driver.findElement(By.id("com.cardo.smartset:id/radio_button"));
        fmPageButton.click();
    }

    @Step("Press Play FM button..")
    public void pressPlayFMbutton() throws InterruptedException {
        MobileElement startFMButton = driver.findElement(By.id("activity_radio_start_stop_radio_btn"));
        startFMButton.click();
    }

    @Step("Press Stop FM button..")
    public void pressStopFmButton() {
        MobileElement stopFMButton = driver.findElement(By.id("activity_radio_start_stop_radio_btn"));
        stopFMButton.click();
    }

    @Step("Press X button..")
    public void pressClosePageButton() {
        MobileElement closeFmPageButton = driver.findElement(By.id("material_design_toolbar_left_icon"));
        closeFmPageButton.click();
    }




//        //System.out.println("Device connected");
//        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//        //System.out.println("Added timeout");
//
//        //Click on Radio button
//        wait.until(ExpectedConditions.visibilityOfElementLocated
//                (By.id("com.cardo.smartset:id/radio_button"))).click();
//
//        //Click on Start button
//        wait.until(ExpectedConditions.visibilityOfElementLocated
//                (By.id("com.cardo.smartset:id/activity_radio_start_stop_radio_btn"))).click();
//
//        //Click on Stop button
//        wait.until(ExpectedConditions.visibilityOfElementLocated
//                (By.id("com.cardo.smartset:id/activity_radio_start_stop_radio_btn"))).click();
//
//        //Click X button
//        wait.until(ExpectedConditions.visibilityOfElementLocated
//                (By.id("com.cardo.smartset:id/material_design_toolbar_left_icon"))).click();



    @AfterTest
    public void teardown() {
        driver.quit();
    }


}


//    @Test
//    public void ConnectionTest() throws InterruptedException {
//
//        System.out.println("Connected");
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        System.out.println("Added timeout");
//
//        //Find element and get value
//        AndroidElement element = (AndroidElement) driver.findElement(By.id("com.cardo.smartset:id/device_name_connected"));
//        String deviceName = element.getAttribute("text");
//
//        //Check is value is set
//        System.out.println(deviceName);
//
//        driver.closeApp();
//        System.out.println("App is closed");
//
//    }

//        //Find element and get value
//        AndroidElement element = (AndroidElement) driver.findElement(By.id("com.cardo.smartset:id/device_name_connected"));
//        String deviceName = element.getAttribute("text");


//Click on Quick Access button
//wait.until(ExpectedConditions.visibilityOfElementLocated
//(By.id("com.cardo.smartset:id/riding_mode_btn"))).click();

//        //Check is value is set
//        System.out.println(deviceName);
//
//        if (deviceName.equals("FREECOM4+")) {
//            System.out.println("Test passed");
//            passedCount++;
//        } else {
//            System.out.println("Test failed");
//            failedCount++;
//        }