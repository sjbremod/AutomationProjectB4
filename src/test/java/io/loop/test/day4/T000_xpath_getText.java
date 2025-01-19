package io.loop.test.day4;

import io.loop.test.utilities.DocuportConstants;
import io.loop.test.utilities.GeneralConstants;
import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*
    1. open chrome
    2. go to docuport
    3. click on forgot password
    4. validate url contains: reset-password
    5. validate - Enter the email address associated with yor account
    6. enter forgotpasswordg1@gmail.com to email box
    7. validate send button is displayed
    8. validate cancel button is displayed
    9. click send button
    10. validate - We've sent you an email with a link to reset your password. Please check your email
     */
public class T000_xpath_getText {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverUtil.getDriver(GeneralConstants.BROWSER);
        driver.manage().window().maximize();
        driver.get(DocuportConstants.DOCUPORT_TEST);

        //3.click on forget password
        WebElement forgotPassword = driver.findElement(By.xpath("//a[@href='/reset-password']"));
        forgotPassword.click();

        String actualURl = driver.getCurrentUrl();

        if(actualURl.contains(DocuportConstants.RESET_PASSWORD_URL)){
            System.out.println("test passed");
        }else{
            System.out.println("test failed");
        }
//step 5.
        WebElement validateMessage = driver.findElement(By.xpath("//div[contains(text(),'Enter')]"));
        String actualValidateMessage = validateMessage.getText();

        if(actualValidateMessage.equals(DocuportConstants.RESET_PASSWORD_MESSAGE)){
            System.out.println("test passed");
        }else{
            System.out.println("test failed");
        }
//6
        WebElement emailInputBox = driver.findElement(By.xpath("//input[contains(@id, 'input')]"));
        emailInputBox.sendKeys(DocuportConstants.EMAIL_FOR_RESET_PASSWORD);

        WebElement cancelButton = driver.findElement(By.xpath("//span[contains(.,'Cancel')]"));
        WebElement sendButton = driver.findElement(By.xpath("//span[normalize-space()='Send']"));
        if(cancelButton.isDisplayed()){
            System.out.println("test passed - cancel button is displayed");
        }else{
            System.out.println("test failed cancel button is not displayed");
        }
        if(sendButton.isDisplayed()){
            System.out.println("test passed send is displayed");
        }else{
            System.out.println("test failed send is NOT displayed");
        }
//9
        sendButton.click();
        Thread.sleep(5000);

        //10
        WebElement successMessage = driver.findElement(By.xpath("//span[@class='body-1']"));
        successMessage.getText();
        Thread.sleep(10000);
        System.out.println("test passed success message is displayed" +successMessage.getText());

        try {
            System.out.println(successMessage.getText());
        }catch (StaleElementReferenceException e) {
            System.out.println("element is not there anymore");
        }





    }
}
