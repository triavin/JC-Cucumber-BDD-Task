package com.juaracoding.page.Factory;

import com.juaracoding.driver.DriverSingleton;
import com.juaracoding.utils.Constants;
import com.juaracoding.utils.LogoutElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Logout {
    private WebDriver driver;

    @FindBy(xpath = LogoutElement.LOGOUTBTNXPATH)
    private WebElement logoutBtn;


    // constructor Logout
    public Logout(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    // Logout
    public void logoutUser(){
        if (driver.getCurrentUrl().equals(Constants.URLMYACCOUNT)){
            logoutBtn.click();
        } else {
            driver.get(Constants.URLMYACCOUNT);
            logoutBtn.click();
        }
    }
}
