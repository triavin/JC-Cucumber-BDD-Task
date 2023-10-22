package com.juaracoding.pageobject;

import com.juaracoding.driver.DriverSingleton;
import com.juaracoding.page.Factory.Logout;
import com.juaracoding.utils.Constants;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LogoutTestPageObject {
    private WebDriver driver;
    private Logout logout;
    @BeforeClass
    public void setUp() {
        DriverSingleton.getInstance(Constants.FIREFOX);
        driver = DriverSingleton.getDriver();
        driver.get(Constants.URLMYACCOUNT);
        DriverSingleton.delay(Constants.SORTDELAY);
        logout = new Logout();
    }

    @Test
    public void testLogout(){
        logout.logoutUser();
    }
}
