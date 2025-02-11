package io.loop.test.day8;

import io.loop.test.base.TestBase;
import io.loop.test.utilities.PizzaOrderWebTableUtil;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class T0_pizza_order extends TestBase {

    @Test
    public void test_pizza_type() {
        driver.get("https://loopcamp.vercel.app/web-tables.html");
        String name = "Bart Fisher";
        String expectedPizzaType = "Cheese";
       String actualPizzaType = PizzaOrderWebTableUtil.returnFieldValue(driver, name, "pizzaType");

        System.out.println("actualPizzaType = " + actualPizzaType);

        assertEquals(actualPizzaType, expectedPizzaType,"Actual doesnt match Expected");
    }






}
