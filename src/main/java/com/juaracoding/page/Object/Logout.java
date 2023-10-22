package com.juaracoding.page.Object;

import com.juaracoding.driver.DriverSingleton;
import com.juaracoding.utils.Constants;
import com.juaracoding.utils.LogoutElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Logout {
    private WebDriver driver;

    // constructor Logout
    public Logout(){
        this.driver = DriverSingleton.getDriver();
    }

    // Logout
    public void logoutUser(){
        if (driver.getCurrentUrl().equals(Constants.URLMYACCOUNT)){
            driver.findElement(By.xpath(LogoutElement.LOGOUTBTNXPATH)).click();
        } else {
            driver.get(Constants.URLMYACCOUNT);
            driver.findElement(By.xpath(LogoutElement.LOGOUTBTNXPATH)).click();
        }
    }
}
