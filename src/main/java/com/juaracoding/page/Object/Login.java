package com.juaracoding.page.Object;

import com.juaracoding.driver.DriverSingleton;
import com.juaracoding.utils.LoginElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
    private WebDriver driver;

    // constructor Login
    public Login(){
        this.driver = DriverSingleton.getDriver();
    }

    // Login
    public void login(String username, String password){
        DriverSingleton.findLoginForm();
        driver.findElement(By.xpath(LoginElement.USERNAMEXPATH)).sendKeys(username);
        driver.findElement(By.xpath(LoginElement.PASSWORDXPATH)).sendKeys(password);
        driver.findElement(By.cssSelector(LoginElement.LOGINBTNXPATH)).click();
    }

    public String getAlert(){
        System.out.println(driver.findElement(By.xpath(LoginElement.INVALIDTXT)).getText());
        return driver.findElement(By.xpath(LoginElement.INVALIDTXT)).getText();
    }

}
