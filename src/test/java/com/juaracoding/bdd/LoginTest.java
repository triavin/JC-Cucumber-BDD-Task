package com.juaracoding.bdd;

import com.juaracoding.driver.DriverSingleton;
import com.juaracoding.page.Factory.Login;
import com.juaracoding.utils.Constants;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginTest {
    private static WebDriver driver;
    private static Login login;

    @BeforeAll
    public static void setUp(){
        DriverSingleton.getInstance(Constants.FIREFOX);
        driver = DriverSingleton.getDriver();
        login = new Login();
    }

//    @AfterAll
//    public static void finish(){
//        DriverSingleton.delay(3);
//        DriverSingleton.closeObjectInstance();
//    }

    @Given("User enter url login page")
    public void user_enter_url_login_page() {
        driver.get(Constants.URLMYACCOUNT);
    }

    @When("User input valid username")
    public void user_input_valid_username() {
        login.inputUsername(Constants.USERNAME);
    }
    @When("User input invalid username")
    public void user_input_invalid_username() {
        login.inputUsername("UserTest");
    }
    @And("User input valid password")
    public void user_input_valid_password() {
        login.inputPassword(Constants.PASSWORD);
    }
    @And("User input invalid password")
    public void user_input_invalid_password() {
        login.inputPassword("Password");
    }
    @And("User click button login")
    public void user_click_button_login() {
        login.clickBtnLogin();
    }
    @Then("User get user greeting text")
    public void user_get_text_user_greeting_text(){
        Assert.assertEquals(login.getValid(),"Hello tesUser6801 (not tesUser6801? Log out)");
    }
}
