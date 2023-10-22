package com.juaracoding.page.Object;

import com.juaracoding.driver.DriverSingleton;
import com.juaracoding.utils.AddProductElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddProduct {
    private WebDriver driver;
    public Select selectColor;
    public Select selectSize;

    // constructor AddProduct
    public AddProduct(){
        this.driver = DriverSingleton.getDriver();
    }

    public void findProduct(String productName){
        driver.findElement(By.xpath(AddProductElement.SEARCHBTN)).click();
        driver.findElement(By.xpath(AddProductElement.SEARCHINPUT)).sendKeys(productName, Keys.ENTER);
    }

    public void addToCart1(){
        driver.findElement(By.xpath(AddProductElement.PRODUCT1)).click();
        DriverSingleton.scrollDown("500");


        selectColor = new Select(driver.findElement(By.xpath(AddProductElement.SELECTCOLOR)));
        selectSize = new Select(driver.findElement(By.xpath(AddProductElement.SELECTSIZE)));
        selectColor.selectByIndex(1);
        selectSize.selectByValue("medium");

        driver.findElement(By.xpath(AddProductElement.ADDCART)).click();
    }
    public void addToCart2(){
        driver.findElement(By.xpath(AddProductElement.PRODUCT2)).click();
        DriverSingleton.scrollDown("500");


        selectColor = new Select(driver.findElement(By.xpath(AddProductElement.SELECTCOLOR)));
        selectSize = new Select(driver.findElement(By.xpath(AddProductElement.SELECTSIZE)));

        selectColor.selectByIndex(1);
        selectSize.selectByValue("medium");
        driver.findElement(By.xpath(AddProductElement.ADDCART)).click();
    }

    public String getValidation(){
        return driver.findElement(By.xpath(AddProductElement.TXTALERT)).getText();
    }




}
