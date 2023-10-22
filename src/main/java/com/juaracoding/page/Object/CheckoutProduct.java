package com.juaracoding.page.Object;

import com.juaracoding.driver.DriverSingleton;
import com.juaracoding.utils.CheckoutElement;
import com.juaracoding.utils.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CheckoutProduct {
    private WebDriver driver;

    // constructor Checkout Product
    public CheckoutProduct(){
        this.driver = DriverSingleton.getDriver();
    }

    public void checkout(
            String firstname,
            String lastname,
            String region,
            String street,
            String town,
            String province,
            String postcode,
            String phone
    ){
        driver.get(Constants.URLCART);
        DriverSingleton.scrollDown("800");

        driver.findElement(By.xpath(CheckoutElement.PROCEEDCHECKOUT)).click();

        DriverSingleton.scrollDown("600");

        driver.findElement(By.xpath(CheckoutElement.FIRSTNAME)).clear();
        driver.findElement(By.xpath(CheckoutElement.FIRSTNAME)).sendKeys(firstname);
        driver.findElement(By.xpath(CheckoutElement.LASTNAME)).clear();
        driver.findElement(By.xpath(CheckoutElement.LASTNAME)).sendKeys(lastname);
        driver.findElement(By.xpath(CheckoutElement.REGION)).click();
        driver.findElement(By.xpath(CheckoutElement.COMBOBOX)).sendKeys(region, Keys.ENTER);
        driver.findElement(By.xpath(CheckoutElement.STREET)).clear();
        driver.findElement(By.xpath(CheckoutElement.STREET)).sendKeys(street);
        driver.findElement(By.xpath(CheckoutElement.TOWN)).clear();
        driver.findElement(By.xpath(CheckoutElement.TOWN)).sendKeys(town);

        DriverSingleton.scrollDown("230");

        driver.findElement(By.xpath(CheckoutElement.PROVINCE)).click();
        driver.findElement(By.xpath(CheckoutElement.COMBOBOX)).sendKeys(province, Keys.ENTER);
        driver.findElement(By.xpath(CheckoutElement.POSTCODE)).clear();
        driver.findElement(By.xpath(CheckoutElement.POSTCODE)).sendKeys(postcode);
        driver.findElement(By.xpath(CheckoutElement.PHONE)).clear();
        driver.findElement(By.xpath(CheckoutElement.PHONE)).sendKeys(phone);

        DriverSingleton.delay(2);

        driver.findElement(By.xpath(CheckoutElement.TERMAGREEMENT)).click();
        driver.findElement(By.xpath(CheckoutElement.ORDER)).click();

    }

    public String getTxtError() {
        return driver.findElement(By.xpath(CheckoutElement.TXTALERT)).getText();
    }

    public String getTxtValid() {
        return driver.findElement(By.xpath(CheckoutElement.TXTVALIDATION)).getText();
    }
}
