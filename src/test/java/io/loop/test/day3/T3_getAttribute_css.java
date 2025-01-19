package io.loop.test.day3;
/*

    go to docuport app
    identify docuport with css
    get value of the attribute
    validate if it is "Docuport"
TODO
    the rest is home work
    locate:
    username
    password
    login
        with css
    login to docuport
    locate home icon of docuport after login or any other element after login
    validated that you logged in

     */
import io.loop.test.utilities.DocuportConstants;
import io.loop.test.utilities.DocuportUtils;
import io.loop.test.utilities.GeneralConstants;
import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T3_getAttribute_css {
    public static void main(String[] args) {
        WebDriver driver = WebDriverUtil.getDriver(GeneralConstants.BROWSER);
        driver.manage().window().maximize();
        driver.navigate().to(DocuportConstants.DOCUPORT_TEST);

        // locate the element with css
        WebElement logo = driver.findElement(By.cssSelector("img[src='/img/logo.d7557277.svg']"));

        //get the value of the attribute
        //String docuport = logo.getAttribute("alt");

        String docuport = logo.getDomAttribute("alt");
        System.out.println("docuport = " + docuport);

        //if(DocuportConstants)
        if(DocuportConstants.LOGO_DOCUPORT.equals(docuport)) {
            System.out.println("expected result matches actual");
            System.out.println("test passed");
        }else {
            System.out.println("does not match expected result");
            System.out.println("test failed");
        }






    }
}
