package com.juaracoding.page.Factory;

import com.juaracoding.driver.DriverSingleton;
import com.juaracoding.utils.CheckoutElement;
import com.juaracoding.utils.Constants;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CheckoutProduct {
    private WebDriver driver;
    public Select selectRegion;
    public Select selectProvince;
    @FindBy(xpath = CheckoutElement.PROCEEDCHECKOUT)
    private WebElement proceedBtn;
    @FindBy(xpath = CheckoutElement.FIRSTNAME)
    private WebElement firstName;
    @FindBy(xpath = CheckoutElement.LASTNAME)
    private WebElement lastName;
    @FindBy(xpath = CheckoutElement.REGION)
    private WebElement region;
    @FindBy(xpath = CheckoutElement.COMBOBOX)
    private WebElement comboBox;
    @FindBy(xpath = CheckoutElement.STREET)
    private WebElement street;
    @FindBy(xpath = CheckoutElement.TOWN)
    private WebElement town;
    @FindBy(xpath = CheckoutElement.PROVINCE)
    private WebElement province;
    @FindBy(xpath = CheckoutElement.POSTCODE)
    private WebElement postCode;
    @FindBy(xpath = CheckoutElement.PHONE)
    private WebElement phoneNumber;
    @FindBy(xpath = CheckoutElement.EMAIL)
    private WebElement email;
    @FindBy(xpath = CheckoutElement.TERMAGREEMENT)
    private WebElement term;
    @FindBy(xpath = CheckoutElement.ORDER)
    private WebElement orderBtn;
    @FindBy(xpath = CheckoutElement.TXTVALIDATION)
    private WebElement txtValid;
    @FindBy(xpath = CheckoutElement.TXTALERT)
    private WebElement txtError;



    // constructor Checkout Product
    public CheckoutProduct(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
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
        proceedBtn.click();

        DriverSingleton.scrollDown("600");

        this.firstName.clear();
        this.firstName.sendKeys(firstname);
        this.lastName.clear();
        this.lastName.sendKeys(lastname);
        this.region.click();
        this.comboBox.sendKeys(region,Keys.ENTER);
        this.street.clear();
        this.street.sendKeys(street);
        this.town.clear();
        this.town.sendKeys(town);

        DriverSingleton.scrollDown("230");

        this.province.click();
        this.comboBox.sendKeys(province,Keys.ENTER);
        this.postCode.clear();
        this.postCode.sendKeys(postcode);
        this.phoneNumber.clear();
        this.phoneNumber.sendKeys(phone);
        DriverSingleton.delay(2);
        term.click();
        orderBtn.click();

    }

    public String getTxtError() {
        return txtError.getText();
    }

    public WebElement getElementValid() {
        return txtValid;
    }
    public String getTxtValid() {
        return txtValid.getText();
    }

    public void clickProceedButton(){
        proceedBtn.click();
    }
    public void inputFirstName(String firstname){
        this.firstName.clear();
        this.firstName.sendKeys(firstname);
    }
    public void inputLastName(String lastname){
        this.lastName.clear();
        this.lastName.sendKeys(lastname);
    }
    public void selectRegion(String region){
        this.region.click();
        this.comboBox.sendKeys(region,Keys.ENTER);
    }
    public void inputStreet(String street){
        this.street.clear();
        this.street.sendKeys(street);
    }
    public void inputTown(String town){
        this.town.clear();
        this.town.sendKeys(town);
    }
    public void selectProvince(String province){
        this.province.click();
        this.comboBox.sendKeys(province,Keys.ENTER);
    }
    public void inputPostcode(String postcode){
        this.postCode.clear();
        this.postCode.sendKeys(postcode);
    }
    public void inputPhoneNumber(String phonenumber){
        this.phoneNumber.clear();
        this.phoneNumber.sendKeys(phonenumber);
    }
    public void clickTerm(){
        term.click();
    }
    public void clickOrderButton(){
        orderBtn.click();
    }


}
