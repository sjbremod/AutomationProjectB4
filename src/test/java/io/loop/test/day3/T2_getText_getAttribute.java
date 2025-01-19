package io.loop.test.day3;

import io.loop.test.utilities.DocuportConstants;
import io.loop.test.utilities.GeneralConstants;
import io.loop.test.utilities.LoopCampConstants;
import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
    go to url: https://loopcamp.vercel.app/registration_form.html
    validate header text expected:  Registration form
    validate placeholder attribute value for first name expected - first name
     */
public class T2_getText_getAttribute {
    public static void main(String[] args) {

        // go to the url https://loopcamp.vercel.app/registration_form.html
        WebDriver driver = WebDriverUtil.getDriver(GeneralConstants.BROWSER);
        driver.manage().window().maximize();

        driver.navigate().to(LoopCampConstants.REGISTRATION_FORM_RUL);

        //locate the element
        WebElement headerForForm = driver.findElement(By.tagName("h2"));

        //use getText method
        String actualHeaderForForm = headerForForm.getText();

        if(actualHeaderForForm.equals(LoopCampConstants.EXPECTED_HEADER_FOR_FORM)){
            System.out.println("Expected header for form: \"" + LoopCampConstants.EXPECTED_HEADER_FOR_FORM + "\", matches actual header: \"" + actualHeaderForForm + "\" => TEST PASSED");
        } else {
            System.err.println("Expected header for form: \"" + LoopCampConstants.EXPECTED_HEADER_FOR_FORM + "\", DOES NOT MATCH actual header: \"" + actualHeaderForForm + "\" => TEST FAILED");
        }
        // use get attribute method, which returns the value of the attribute, not the text
        WebElement firstNamePlaceholder = driver.findElement(By.name("firstname"));
        String ActualPlaceHolderForFirstName = firstNamePlaceholder.getAttribute("placeholder");

        if (ActualPlaceHolderForFirstName.equals(LoopCampConstants.EXPECTED_PLACEHOLDER_FIRSTNAME)) {
            System.out.println("expected placeholder: ");
            System.out.println("test passed");
        }else {
            System.err.println("expected placeholder doesnt match actual: ");
            System.err.println("test failed");
        }



    }
}
