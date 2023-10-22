package com.juaracoding;

import com.juaracoding.driver.DriverSingleton;
import com.juaracoding.page.Factory.AddProduct;
import com.juaracoding.page.Factory.Login;
import com.juaracoding.utils.Constants;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestLoginPageFactory {
    private WebDriver driver;
    private Login login;
    @BeforeClass
    public void setUp() {
        DriverSingleton.getInstance(Constants.FIREFOX);
        driver = DriverSingleton.getDriver();
        driver.get(Constants.URLMYACCOUNT);
        DriverSingleton.delay(Constants.SORTDELAY);
        login = new Login();
    }

//    @AfterClass
//    public void finish(){
//        DriverSingleton.delay(Constants.SORTDELAY);
//        DriverSingleton.closeObjectInstance();
//    }

    // Negative Test
    @Test(priority = 1)
    public void loginTestInvalid(){
        DriverSingleton.findLoginForm();
        DriverSingleton.delay(Constants.SORTDELAY);
        login.login("ahsbuf", "123");
        DriverSingleton.delay(Constants.SORTDELAY);
        Assert.assertEquals(login.getInvalid(), "Invalid credentials");
        System.out.println("Test case invalid Login !");
    }

    // Negative Test
    @Test(priority = 2)
    public void loginTestNoUser(){
        DriverSingleton.findLoginForm();
        login.login("", Constants.PASSWORD);
        DriverSingleton.delay(Constants.SORTDELAY);
        Assert.assertEquals(login.getUserRequired(), "Required");
        System.out.println("Test case invalid Login ! User required");
    }

    // Negative Test
    @Test(priority = 3)
    public void loginTestNoPassword(){
        DriverSingleton.findLoginForm();
        login.login(Constants.USERNAME, "");
        DriverSingleton.delay(Constants.SORTDELAY);
        Assert.assertEquals(login.getPassRequired(), "Required");
        System.out.println("Test case invalid Login ! Password required");
    }

    // Positive Test
    @Test(priority = 4)
    public void loginTest(){
        DriverSingleton.findLoginForm();
        login.login(Constants.USERNAME, Constants.PASSWORD);
        DriverSingleton.delay(Constants.SORTDELAY);

    }

}
