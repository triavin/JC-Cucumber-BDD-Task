package com.juaracoding.bdd;

import com.juaracoding.driver.DriverSingleton;
import com.juaracoding.page.Factory.CheckoutProduct;
import com.juaracoding.utils.Constants;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CheckoutProductTest {
    private static WebDriver driver;
    private static CheckoutProduct checkoutProduct;

    @BeforeAll
    public static void setUp(){
        DriverSingleton.getInstance(Constants.FIREFOX);
        driver = DriverSingleton.getDriver();
        checkoutProduct = new CheckoutProduct();
    }

    @AfterAll
    public static void finish(){
        DriverSingleton.delay(3);
        DriverSingleton.closeObjectInstance();
    }

    @Given("User enter url cart")
    public void user_enter_url_cart() {
        driver.get(Constants.URLCART);
    }
    @And("User click proceed button")
    public void user_click_proceed_button() {
        checkoutProduct.clickProceedButton();
    }
    @And("User enter first name")
    public void user_enter_first_name() {
        checkoutProduct.inputFirstName(Constants.FIRSTNAME);
    }
    @And("User enter last name")
    public void user_enter_last_name() {
        checkoutProduct.inputLastName(Constants.LASTNAME);
    }
    @And("User select region")
    public void user_select_region() {
        checkoutProduct.selectRegion("indonesia");
    }
    @And("User enter street")
    public void user_enter_street() {
        checkoutProduct.inputStreet(Constants.STREET);
    }

    @And("User enter town")
    public void user_enter_town() {
        checkoutProduct.inputTown(Constants.TOWN);
    }
    @And("User select province")
    public void user_select_province() {
        checkoutProduct.selectProvince(Constants.PROVINCE);
    }
    @And("User enter postcode")
    public void user_enter_postcode() {
        checkoutProduct.inputPostcode(Constants.POSTCODE);
    }
    @And("User enter phone number")
    public void user_enter_phone_number() {
        checkoutProduct.inputPhoneNumber(Constants.PHONE);
    }
    @And("User click term agreement")
    public void user_click_term_agreement() {
        checkoutProduct.clickTerm();
    }
    @And("User click order button")
    public void user_order_button() {
        checkoutProduct.clickOrderButton();
    }
    @Then("User get validation text")
    public void user_get_validation_text(){
        Assert.assertEquals(checkoutProduct.getTxtValid(),"Thank you. Your order has been received.");
    }
}
