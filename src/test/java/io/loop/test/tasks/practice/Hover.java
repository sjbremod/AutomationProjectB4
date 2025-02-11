package io.loop.test.tasks.practice;

import io.loop.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Hover {
    @Test
    public void testHover() {
        Driver.getDriver().get("https://loopcamp.vercel.app/hovers.html");
        WebElement user1Image = Driver.getDriver().findElement(By.xpath("//div[@class='example']//div[1]//img[1]"));
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(user1Image).perform();
    }
}
