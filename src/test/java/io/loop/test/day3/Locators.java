package io.loop.test.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("https://www.google.com");

        //locate the element
        WebElement searchBoxWithID = driver.findElement(By.id("APjFqb"));
        WebElement searchBoxWithName = driver.findElement(By.name("q"));
        WebElement aboutLing = driver.findElement(By.linkText("About"));
        aboutLing.click();





        String textToSearch = "Feyruz is the king of java";

        //searchBoxWithID.sendKeys(textToSearch);
        searchBoxWithName.sendKeys(textToSearch);

        //searchBoxWithID.clear();
       // searchBoxWithID.sendKeys("Nadir is smart" + Keys.ENTER);

        searchBoxWithName.sendKeys(Keys.ENTER);









    }
}
