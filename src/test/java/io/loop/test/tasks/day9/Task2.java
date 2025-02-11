package io.loop.test.tasks.day9;

import io.loop.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Task2 {
    @Test
    public void dragAndDrop() throws InterruptedException {
        Driver.getDriver().get("https://loopcamp.vercel.app/drag-and-drop-circles.html");
        WebElement smallCircle = Driver.getDriver().findElement(By.id("draggable"));
        WebElement bigCircle = Driver.getDriver().findElement(By.id("droptarget"));
        Actions actions = new Actions(Driver.getDriver());

        actions.dragAndDropBy(smallCircle,0,50).perform();
        String expected = "Try again!";
        String actual = Driver.getDriver().findElement(By.id("droptarget")).getText();
        assertEquals(actual, expected,"Expected didnt match actual");
    }
}


