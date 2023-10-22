package com.juaracoding;

import com.juaracoding.driver.DriverSingleton;
import com.juaracoding.page.Factory.AddProduct;
import com.juaracoding.page.Factory.CheckoutProduct;
import com.juaracoding.utils.Constants;
import io.cucumber.java.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CheckoutTestPageFactory {
    public WebDriver driver;
    public CheckoutProduct checkoutProduct;
    @BeforeClass
    public void setUp() {
        DriverSingleton.getInstance(Constants.FIREFOX);
        driver = DriverSingleton.getDriver();
        DriverSingleton.delay(Constants.SORTDELAY);
        checkoutProduct = new CheckoutProduct();
    }

//    @AfterClass
//    public void finish(){
//        DriverSingleton.delay(Constants.SORTDELAY);
//        DriverSingleton.closeObjectInstance();
//    }

    // negative test
    @Test(priority = 1)
    public void testCOInvalid1(){
        checkoutProduct.checkout(
                Constants.FIRSTNAME,
                "",
                "Indonesia",
                Constants.STREET,
                Constants.TOWN,
                Constants.PROVINCE,
                Constants.POSTCODE,
                Constants.PHONE
        );
        Assert.assertNotNull(checkoutProduct.getTxtError());
        System.out.println(checkoutProduct.getTxtError());
    }

    // negative test
    @Test(priority = 2)
    public void testCOInvalid2(){
        checkoutProduct.checkout(
                Constants.FIRSTNAME,
                Constants.LASTNAME,
                "Indonesia",
                "",
                Constants.TOWN,
                Constants.PROVINCE,
                Constants.POSTCODE,
                Constants.PHONE
        );
        Assert.assertNotNull(checkoutProduct.getTxtError());
        System.out.println(checkoutProduct.getTxtError());
    }

    // positive test
    @Test(priority = 3)
    public void testCOValid(){
        checkoutProduct.checkout(
                Constants.FIRSTNAME,
                Constants.LASTNAME,
                "Indonesia",
                Constants.STREET,
                Constants.TOWN,
                Constants.PROVINCE,
                Constants.POSTCODE,
                Constants.PHONE
        );
        Assert.assertNotNull(checkoutProduct.getTxtValid());
        System.out.println(checkoutProduct.getTxtValid());
    }
}
