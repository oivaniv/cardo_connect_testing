package SingleFunctionTests;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class CheckDeviceRidersTC {

    private AndroidDriver<MobileElement> driver;
    private WebDriverWait wait;

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
    public void checkBatteryLife() throws InterruptedException {

        int count = 0;
        int passedCount = 0;
        int failedCount = 0;

        do {
            driver.launchApp();

            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);


            //Click on Intercom button
            wait.until(ExpectedConditions.visibilityOfElementLocated
                    (By.id("com.cardo.smartset:id/intercom_btn"))).click();

            if (!driver.findElements(By.id("com.cardo.smartset:id/fragment_intercom_channels_list")).isEmpty()) {
                System.out.println("Test passed");
                passedCount++;
            } else {
                System.out.println("Test failed");
                failedCount++;
            }

            driver.closeApp();
            count++;
            System.out.println("Total count is: " + count);

        } while (count < 100);
        System.out.println("Passed test: " + passedCount + "\nFailed tests: " + failedCount);

        driver.closeApp();

    }

}
