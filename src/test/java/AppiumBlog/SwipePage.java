package AppiumBlog;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SwipePage extends BaseTest
{
    @Test
    public void SwipeDemo()
    {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Photos")).click();
        WebElement firstIMG = driver.findElement(By.xpath("(//android.widget.ImageView)[1]"));
        Assert.assertEquals((driver.findElement(By.xpath("(//android.widget.ImageView)[1]"))).getAttribute("focusable"),"true");
        swipeScreen(firstIMG,"left");
        Assert.assertEquals((firstIMG).getAttribute("focusable"),"false");

    }

}
