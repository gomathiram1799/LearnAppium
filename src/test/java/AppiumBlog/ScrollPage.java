package AppiumBlog;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


public class ScrollPage extends BaseTest
{
    @Test
    public void ScrollDemo() throws InterruptedException
    {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        WebElement menuu = driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));
        menuu.click();
        Thread.sleep(3000);

    }
}

