package AppiumBlog;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTest
{
    public AndroidDriver driver;
    public  AppiumDriverLocalService service;
    AndroidTouchAction touch;
    @BeforeClass
    public void ConfigureAppium() throws MalformedURLException {
         service = new AppiumServiceBuilder().withAppiumJS(new File("/opt/homebrew/lib/node_modules/appium/index.js"))
                .usingDriverExecutable(new File("/opt/homebrew/bin/node"))
                .withIPAddress("127.0.0.1").usingPort(4723).build();
        service.start();

        //code to start emulator
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Nexusss_6");
        options.setApp("/Users/gomathilakshmir/IdeaProjects/LearnAppium/src/ApiDemos-debug.apk");
         driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //replacement of thread.sleep()

    }
    public void longPressAction(WebElement ele)
    {
        touch = new AndroidTouchAction (driver);
        touch.longPress(LongPressOptions.longPressOptions()
                        .withElement (ElementOption.element (ele)))
                        .perform ();
    }
    public void swipeScreen(WebElement ele , String direction)
    {
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId",((RemoteWebElement)ele).getId(),
                "direction", direction,
                "percent", 0.2  //speed of scroll
        ));
    }

    @AfterClass
    public void tearDown()
    {
        driver.quit();
        service.stop();
    }
}
