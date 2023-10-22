package com.juaracoding.page.Factory;

import com.juaracoding.driver.DriverSingleton;
import com.juaracoding.utils.AddProductElement;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddProduct {
    private WebDriver driver;
    public Select selectColor;
    public Select selectSize;
    @FindBy(xpath = AddProductElement.PRODUCT1)
    private WebElement targetProduct1;
    @FindBy(xpath = AddProductElement.PRODUCT2)
    private WebElement targetProduct2;
    @FindBy(xpath = AddProductElement.SELECTCOLOR)
    private WebElement color;
    @FindBy(xpath = AddProductElement.SELECTSIZE)
    private WebElement size;
    @FindBy(xpath = AddProductElement.ADDCART)
    private WebElement addCartBtn;
    @FindBy(xpath = AddProductElement.TXTALERT)
    private WebElement txtAlert;
    @FindBy(xpath = AddProductElement.SEARCHBTN)
    private WebElement searchBtn;
    @FindBy(xpath = AddProductElement.SEARCHINPUT)
    private WebElement searchInput;



    // constructor AddProduct
    public AddProduct(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);


//        driver.get(Constants.URLHOMEPAGE);
    }

    public void findProduct(String productName){
        searchBtn.click();
        searchInput.sendKeys(productName, Keys.ENTER);
//        searchInput.sendKeys(Keys.ENTER);
    }

    public void addToCart1(){
        targetProduct1.click();
        DriverSingleton.scrollDown("500");
        selectColor = new Select(color);
        selectSize = new Select(size);
        selectColor.selectByIndex(1);
        selectSize.selectByValue("medium");
        addCartBtn.click();
    }
    public void addToCart2(){
        targetProduct2.click();
        DriverSingleton.scrollDown("500");
        selectColor = new Select(color);
        selectSize = new Select(size);
        selectColor.selectByIndex(1);
        selectSize.selectByValue("medium");
        addCartBtn.click();
    }

    public void clickProduct(){
        targetProduct1.click();
    }
    public void chooseColor(int index){
        selectColor = new Select(color);
        selectColor.selectByIndex(index);

        // select color use index base cause
        // not all product have same color parameter
        // it can cause errors in the test
        // because no elements / parameter are found
    }
    public void chooseSize(String size){
        selectSize = new Select(this.size);
        selectColor.selectByValue(size);

        // select size use value base because
        // it's easy to choose different size by value
        // because size option usually doesn't have much option
    }

    public String getValidation(){
        return txtAlert.getText();
    }


}
