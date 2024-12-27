package io.loop.test.day2;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
    public static void main(String[] args) throws InterruptedException {

        // setting up the web driver
        // WebDriverManager.chromedriver().setup();
        // if you use older version of selenium (4.21) you need webdrivermanager and boni garecia dependency

        // create the instance of the driver

        WebDriver driver = new ChromeDriver();

        // maximize the windows
        driver.manage().window().maximize();
        //driver.manage().window().fullscreen();

        // navigate to the page
        driver.get("https://www.loopcamp.io");

        // wait
        Thread.sleep(3000);

        // navigate to the page
        driver.navigate().to("https://www.google.com");

        //navigate back
        driver.navigate().back();

        // navigate foward
        driver.navigate().forward();

        // for refreshing the page
        driver.navigate().refresh();

        // quiting the browser
        driver.quit();


    }
}
