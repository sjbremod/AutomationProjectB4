package io.loop.test.tasks.day7;

import io.loop.test.base.TestBase;
import io.loop.test.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class day7Task3 extends TestBase {
    @Test
    public void testWindows(){
        driver.get("https://loopcamp.vercel.app/");
        WebElement multipleWindowsLink = driver.findElement(By.xpath("//a[@href='windows.html']"));
        multipleWindowsLink.click();

        WebElement poweredByLoopcamp = driver.findElement(By.xpath("//div[@style='text-align: center;']"));
        String actualPoweredByLoopcamp = poweredByLoopcamp.getText().toLowerCase();
        String expectedPoweredByLoopcamp = "powered by loopcamp";
        assert actualPoweredByLoopcamp.contains(expectedPoweredByLoopcamp) : "Actual does not match expected";

        String actualTitle = driver.getTitle();
        String expectedTitle = "Windows";
        Assert.assertEquals(actualTitle, expectedTitle, "Actual title does not match expected");

        WebElement clickHere = driver.findElement(By.xpath("//a[@href='windows/new.html']"));
        clickHere.click();


        BrowserUtils.switchWindowAndValidate(driver, "https://loopcamp.vercel.app/windows/new.html", "New Window");




    }

}
