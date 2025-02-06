package io.loop.test.tasks;

import io.loop.test.base.TestBase;
import io.loop.test.utilities.DocuportConstants;
import io.loop.test.utilities.DocuportUtils;
import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class day7Task1 extends TestBase {
    @Test
    public void docuport() throws InterruptedException {
        driver.get(DocuportConstants.DOCUPORT_TEST);
        DocuportUtils.login(driver,DocuportConstants.ADVISOR);

        Thread.sleep(5000);
        WebElement user = driver.findElement(By.xpath("//span[normalize-space()='Users']"));
        user.click();
        Thread.sleep(5000);

        WebElement search = driver.findElement(By.xpath("//span[@class='subtitle-2 text-none' and contains(text(), 'Search')]"));
        search.click();
Thread.sleep(5000);
        WebElement emailAddressInput = driver.findElement(By.xpath("//input[@id='input-257']"));
        emailAddressInput.sendKeys("alex.de.souza@gmail.com");
        WebElement searchButton = driver.findElement(By.xpath("//span[@class='v-btn__content' and contains(text(), 'Search')]"));
        searchButton.click();
Thread.sleep(5000);
        WebElement fullName = driver.findElement(By.xpath("//span[@class = 'ml-2' and contains(text(), 'Alex De Souza')]"));
        Thread.sleep(5000);
        WebElement validateUserName = driver.findElement(By.xpath("//td[@class='text-start' and contains(text(), 'alexdesouze')]"));
        String actualUserName = validateUserName.getText();
        String expectedUserName = "alexdesouze";
        Assert.assertEquals(actualUserName, expectedUserName, "Actual does not match expected");


        String actualName = fullName.getText();
        String expectedName = "Alex De Souza";
        Assert.assertEquals(actualName, expectedName);

        Thread.sleep(5000);
        WebElement validatePhoneNumber = driver.findElement(By.xpath("//span[contains(text(), '+994512060042')]"));
        String actualPhoneNumber = validatePhoneNumber.getText();
        String expectedPhoneNumber = "+994512060042";
        Assert.assertEquals(actualPhoneNumber, expectedPhoneNumber, "Actual does not match expected");

        Thread.sleep(5000);
        WebElement validateRole = driver.findElement(By.xpath("//span[@class='ma-1 v-chip v-chip--outlined theme--light v-size--small primary primary--text']"));
        String actualRole = validateRole.getText().toLowerCase();
        String expectedRole = "client";
        Assert.assertEquals(actualRole, expectedRole, "Actual does not match expected");
        Thread.sleep(5000);

        WebElement advisor = driver.findElement(By.xpath("//td[@class='text-start' and contains(text(), 'Batch1 Group1')]"));
        String actualAdvisor = advisor.getText();
        String expectedAdvisor = "Batch1 Group1";
        Assert.assertEquals(actualAdvisor, expectedAdvisor, "Actual does not match expected");




    }
}
