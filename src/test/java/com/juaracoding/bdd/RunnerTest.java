package com.juaracoding.bdd;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/main/resources/feature/1Login.feature", "src/main/resources/feature/2AddProduct.feature", "src/main/resources/feature/3CheckoutProduct.feature", "src/main/resources/feature/4Logout.feature"},
        glue = "com.juaracoding",
        plugin = {"pretty","html:target/cucumber-report.html","json:target/cucumber.json"}
)
public class RunnerTest extends AbstractTestNGCucumberTests {

}
