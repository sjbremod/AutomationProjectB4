package io.loop.test.day5;

import io.loop.test.utilities.DocuportConstants;
import io.loop.test.utilities.GeneralConstants;
import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class T2_testNG_with_Selenium {
    WebDriver driver;
    String expected;
    String actual;

    @BeforeMethod
    public void setUpMethod() {
       driver = WebDriverUtil.getDriver(GeneralConstants.BROWSER);
       driver.manage().window().maximize();


    }
@Test
    public void goolgeTitle(){
        driver.get("https://www.google.com");
    System.out.println("((RemoteWebDriver) driver).getSessionId() = " + ((RemoteWebDriver) driver).getSessionId());
        expected = "Google";
        actual = driver.getTitle();
        assertEquals(actual,expected,"Actual " + actual + "does not match expected "+ expected);
}
@Test
    public void docuportTitle(){
        driver.get(DocuportConstants.DOCUPORT_TEST);
    System.out.println("((RemoteWebDriver) driver).getSessionId() = " + ((RemoteWebDriver) driver).getSessionId());
        expected = "Docuport";
        actual = driver.getTitle();
        assertTrue(actual.contains(expected),"Actual does not match expected");


}

}
