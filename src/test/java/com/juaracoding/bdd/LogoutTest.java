package com.juaracoding.bdd;

import com.juaracoding.driver.DriverSingleton;
import com.juaracoding.page.Factory.Login;
import com.juaracoding.page.Factory.Logout;
import com.juaracoding.utils.Constants;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LogoutTest {
    private static WebDriver driver;
    private static Logout logout;

    @BeforeAll
    public static void setUp(){
        DriverSingleton.getInstance(Constants.FIREFOX);
        driver = DriverSingleton.getDriver();
        logout = new Logout();
    }

//    @AfterAll
//    public static void finish(){
//        DriverSingleton.delay(3);
//        DriverSingleton.closeObjectInstance();
//    }

    @Given("User enter url account page")
    public void user_enter_url_account_page() {
        driver.get(Constants.URLMYACCOUNT);
    }
    @Then("User click logout button")
    public void user_click_logout_button(){
        logout.logoutUser();
    }
}
