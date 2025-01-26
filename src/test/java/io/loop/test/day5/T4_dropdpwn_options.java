package io.loop.test.day5;

import com.sun.source.tree.AssertTree;
import io.loop.test.utilities.GeneralConstants;
import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

/*
    1. Open Chrome browser
    2. Go to https://demoqa.com/select-menu
    3. go old style select menu
    4. Select Yellow and validate
    5. Select Red and validate
    6. Select White and validate
    Use all Select options. (visible text, value, index)
     */
public class T4_dropdpwn_options {

    WebDriver driver;
    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverUtil.getDriver(GeneralConstants.BROWSER);
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/select-menu");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
@AfterMethod
    public void tearDownMethod(){
       // driver.close();
}
@Test
    public void colarTest(){
    Select dropdown = new Select(driver.findElement(By.xpath("//select[@id='oldSelectMenu']")));
    dropdown.selectByIndex(3);
    Assert.assertEquals(dropdown.getFirstSelectedOption().getText(),"Yellow","actual doesnt match with expected");

    dropdown.selectByValue("red");
    Assert.assertEquals(dropdown.getFirstSelectedOption().getText(),"Red","actual doesnt match with expected");

    dropdown.selectByVisibleText("White");
    Assert.assertEquals(dropdown.getFirstSelectedOption().getText(),"White","actual doesnt match with expected");

    dropdown.selectByContainsVisibleText("Purp");
    Assert.assertEquals(dropdown.getFirstSelectedOption().getText(), "Purple", "Actual does not match the Expected");
    }

}
