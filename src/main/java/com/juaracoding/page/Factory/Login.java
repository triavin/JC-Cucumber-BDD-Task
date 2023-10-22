package com.juaracoding.page.Factory;

import com.juaracoding.driver.DriverSingleton;
import com.juaracoding.utils.LoginElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
    private WebDriver driver;

    @FindBy(xpath = LoginElement.USERNAMEXPATH)
    private WebElement username;
    @FindBy(xpath = LoginElement.PASSWORDXPATH)
    private WebElement password;
    @FindBy(css = LoginElement.LOGINBTNXPATH)
    private WebElement loginBtn;
    @FindBy(xpath = LoginElement.INVALIDTXT)
    private WebElement txtInvalid;
    @FindBy(xpath = LoginElement.VALIDTXT)
    private WebElement txtValid;

    // constructor Login
    public Login(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    // Login
    public void login(String username, String password){
        DriverSingleton.findLoginForm();
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        loginBtn.click();
    }
    public void inputUsername(String username){
        DriverSingleton.findLoginForm();
        this.username.sendKeys(username);
    }
    public void inputPassword(String password){
        DriverSingleton.findLoginForm();
        this.password.sendKeys(password);
    }
    public void clickBtnLogin(){
        DriverSingleton.findLoginForm();
        loginBtn.click();
    }

    public String getInvalid(){
        System.out.println(txtInvalid.getText());
        return txtInvalid.getText();
    }
    public String getValid(){
        System.out.println(txtValid.getText());
        return txtValid.getText();
    }

}
