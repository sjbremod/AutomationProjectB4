package io.loop.test.utilities;

import com.beust.ah.A;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Set;

public class BrowserUtils {

    /**
     * validate if driver switched to expected url or title
     * @param driver
     * @param expectedUrl
     * @param expectedTitle
     * @author sjb
     * implements assertion
     */

    public static void switchWindowAndValidate(WebDriver driver,String expectedUrl,String expectedTitle) {
        // to lower case the params in order to avoid miss type
        expectedTitle = expectedTitle.toLowerCase();
        expectedUrl = expectedUrl.toLowerCase();

        //get all window handles, switch one by one and each time check if the url matches expected to stop

        Set<String> windowHandles = driver.getWindowHandles();
        for (String each : windowHandles) {
            driver.switchTo().window(each);
            if(driver.getCurrentUrl().toLowerCase().contains(expectedUrl)){
                break;
            }
        }

        Assert.assertTrue(driver.getTitle().toLowerCase().contains(expectedTitle));

    }

    /**
     * @param driver
     * @param targetTitle
     * @author sjb
     */
    public static void switchToWindow(WebDriver driver, String targetTitle){
        String origin = driver.getWindowHandle();
        for(String handle : driver.getWindowHandles()){
            driver.switchTo().window(handle);
            if(driver.getTitle().contains(targetTitle)){
                return;
            }
        }
        driver.switchTo().window(origin);
    }

}
