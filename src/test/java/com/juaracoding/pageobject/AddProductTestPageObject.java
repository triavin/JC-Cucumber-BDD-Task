package com.juaracoding.pageobject;

import com.juaracoding.driver.DriverSingleton;
import com.juaracoding.page.Factory.AddProduct;
import com.juaracoding.utils.Constants;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AddProductTestPageObject {
    public WebDriver driver;
    public AddProduct addProduct;
    @BeforeClass
    public void setUp() {
        DriverSingleton.getInstance(Constants.FIREFOX);
        driver = DriverSingleton.getDriver();
        DriverSingleton.delay(Constants.SORTDELAY);
        addProduct = new AddProduct();
    }

//    @AfterClass
//    public void finish(){
//        DriverSingleton.delay(Constants.SORTDELAY);
//        DriverSingleton.closeObjectInstance();
//    }

    @Test(priority = 1)
    public void addProduct1(){

        addProduct.findProduct("dress");
        DriverSingleton.scrollDown("500");
        addProduct.addToCart1();
        Assert.assertNotNull(addProduct.getValidation());
        System.out.println("product has add to cart");
    }
    @Test(priority = 2)
    public void addProduct2(){

        addProduct.findProduct("dress");
        DriverSingleton.scrollDown("500");
        addProduct.addToCart2();
        Assert.assertNotNull(addProduct.getValidation());
        System.out.println("product has add to cart");
    }
}
