package SingleFunctionTests;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class CheckDeviceNameWasChangedBefore {

    public AndroidDriver<MobileElement> driver;
    public WebDriverWait wait;

    int count = 0;
    int passedCount = 0;
    int failedCount = 0;
    int deviceNameCounter = 0;
    String deviceNameToSet = "Test ";

    @BeforeMethod
    public void setup() throws MalformedURLException {
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

    @Test
    public void Connection() throws InterruptedException {


        do {
            driver.launchApp();

            getDeviceName();

            //Press Setting button
            wait.until(ExpectedConditions.visibilityOfElementLocated
                    (By.id("com.cardo.smartset:id/settings_icon"))).click();
            //Open Device name page
            wait.until(ExpectedConditions.visibilityOfElementLocated
                    (By.id("com.cardo.smartset:id/device_info_container"))).click();
            //Press Unit name container
            wait.until(ExpectedConditions.visibilityOfElementLocated
                    (By.id("com.cardo.smartset:id/device_name"))).sendKeys(deviceNameToSet + deviceNameCounter);
            //Press Save button
            wait.until(ExpectedConditions.visibilityOfElementLocated
                    (By.id("com.cardo.smartset:id/material_design_toolbar_right_text_container"))).click();
            //Close Unit name page
            wait.until(ExpectedConditions.visibilityOfElementLocated
                    (By.id("com.cardo.smartset:id/material_design_toolbar_left_icon"))).click();
            //Close Settings page
            wait.until(ExpectedConditions.visibilityOfElementLocated
                    (By.id("com.cardo.smartset:id/material_design_toolbar_left_icon"))).click();

            //Find element and get value
            getDeviceName();

            driver.closeApp();

            driver.launchApp();

            //System.out.println("Connected");
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            //System.out.println("Added timeout");

            getDeviceNameAppReopened();

            driver.closeApp();
            //System.out.println("App is closed");
            count++;
            deviceNameCounter++;
            System.out.println("Total count is: " + count);

        }
        while (count < 50);

        System.out.println("Passed test: " + passedCount + "\nFailed tests: " + failedCount);
    }

    @AfterTest
    public void teardown() {
        driver.quit();
    }

    public void getDeviceName() {
        //Find element and get value
        AndroidElement element = (AndroidElement) driver.findElement(By.id("com.cardo.smartset:id/device_name_connected"));
        String deviceName = element.getAttribute("text");
        //Check is value is set
        System.out.println(deviceName);
    }

    public void getDeviceNameAppReopened() {
        //Find element and get value
        AndroidElement element = (AndroidElement) driver.findElement(By.id("com.cardo.smartset:id/device_name_connected"));
        String deviceNameAppReopebed = element.getAttribute("text");
        //Check is value is set
        System.out.println(deviceNameAppReopebed);
        if (deviceNameAppReopebed.equals(deviceNameToSet + deviceNameCounter)) {
            System.out.println("Test passed");
            passedCount++;
        } else {
            System.out.println("Test failed");
            failedCount++;
        }

    }
}