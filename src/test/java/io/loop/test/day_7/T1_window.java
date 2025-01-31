package io.loop.test.day_7;

import io.loop.test.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

/*
    1. Open a chrome browser
    2. Go to : http://the-internet.herokuapp.com/windows
    3. Assert: Title is “The Internet”
    4. Click to: “Click Here” link
    5. Switch to new Window.
    6. Assert: Title is “New Window”
     */
public class T1_window extends TestBase {

    @Test
    public void test_window_handle (){
        driver.get("https://the-internet.herokuapp.com//windows");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Assert.assertEquals(driver.getTitle(), "The Internet", "Expected didnt match actual title");

        System.out.println(driver.getWindowHandle());

        WebElement clickHere = driver.findElement(By.xpath("//a[text()='Click Here']"));
        clickHere.click();

        System.out.println(driver.getTitle());

        //get original window handle
        String originalWindow = driver.getWindowHandle();
        // get all window handles()
        Set<String> windowHandles = driver.getWindowHandles();

        // loop through and stay at the last window
        for (String each : windowHandles) {
            System.out.println("each window handle: " +each    );
            driver.switchTo().window(each);
        }
        System.out.println(driver.getTitle());
        // switch to original window
        driver.switchTo().window(originalWindow);
        System.out.println(driver.getTitle());



    }

}
