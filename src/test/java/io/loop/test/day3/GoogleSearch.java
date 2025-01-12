package io.loop.test.day3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearch {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        //driver.get() // will also work
        driver.navigate().to("https://www.google.com");
        driver.manage().window().maximize();

        String expectedTitle = "Google";

        //System.out.println(driver.getTitle());
       String actualTitle = driver.getTitle();

       if(actualTitle.contains(expectedTitle)) {
           System.out.println("actual title: " + actualTitle+ ", matches expected title " + expectedTitle + ". => TEST PASSED" ) ;
       }else{
           System.out.println("actual title: " + actualTitle+ ", does not matches expected title " + expectedTitle + ". => TEST failed");
       }

        String expectedUrl = "https://www.google.com";
       String actualUrl = driver.getCurrentUrl();
       if(actualUrl.contains(expectedUrl)) {
           System.out.println("actual url: " + actualUrl+ ", matches expected url " + expectedUrl + ". => TEST PASSED" );
       }else {
           System.out.println("actual url: " + actualUrl+ ", DOESNT match  expected url " + expectedUrl + ". => TEST FAILED" );
       }
       driver.quit();

    }
}
