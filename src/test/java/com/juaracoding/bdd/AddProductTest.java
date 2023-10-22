package com.juaracoding.bdd;

import com.juaracoding.driver.DriverSingleton;
import com.juaracoding.page.Factory.AddProduct;
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

public class AddProductTest {
    private static WebDriver driver;
    private static AddProduct addProduct;

    @BeforeAll
    public static void setUp(){
        DriverSingleton.getInstance(Constants.FIREFOX);
        driver = DriverSingleton.getDriver();
        addProduct = new AddProduct();
    }

//    @AfterAll
//    public static void finish(){
//        DriverSingleton.delay(3);
//        DriverSingleton.closeObjectInstance();
//    }

    @Given("User search product")
    public void user_search_product() {
        addProduct.findProduct("dress");
    }
    @When("User click product")
    public void user_click_product() {
        addProduct.clickProduct();
    }
    @And("User scroll down web page")
    public void user_scroll_down_product() {
        DriverSingleton.scrollDown("500");
    }
    @And("User choose color")
    public void user_choose_color() {
        addProduct.chooseColor(1);
    }
    @And("User choose size")
    public void user_choose_size() {
        addProduct.chooseColor(1);
    }
    @Then("User get text")
    public void user_get_text(){
        Assert.assertEquals(addProduct.getValidation(),"View cart “white milkmaid hook and eye bodycon midi dress” has been added to your cart. ");
    }
}
