package com.juaracoding.driver;

import com.juaracoding.driver.Strategy.DriverStrategy;
import com.juaracoding.driver.Strategy.DriverStrategyImplementer;
import com.juaracoding.utils.Constants;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class DriverSingleton {

    public static DriverSingleton instance = null;
    private static WebDriver driver;
    private static JavascriptExecutor jse;
    private static int windowHeight;
    private static int windowWidth;


    public DriverSingleton(String driver){
        instantiate(driver);
    }

    public WebDriver instantiate(String strategy){
        DriverStrategy driverStrategy = DriverStrategyImplementer.chooseImplementer(strategy);
        driver = driverStrategy.setStrategy();
        jse = (JavascriptExecutor) driver;
        driver.manage().timeouts().implicitlyWait(Constants.TIMEOUT, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        // Get window size
        Dimension initialSize = driver.manage().window().getSize();
        windowHeight = initialSize.getHeight();
        windowWidth = initialSize.getWidth();

        return driver;
    }

    public static DriverSingleton getInstance(String driver){
        if (instance == null){
            instance = new DriverSingleton(driver);
        }
        return instance;
    }

    public static WebDriver getDriver(){
        return driver;
    }

    public static JavascriptExecutor getJse(){
        return jse;
    }


    // method for close driver
    public static void closeObjectInstance(){
        instance = null;
        driver.quit();
    }

    // method delay
    public static void delay(long detik){
        // add delay to automation
        try{
            Thread.sleep(detik*1000);
        } catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }


    //scroll web page to find login form
    public static void findLoginForm(){
        System.out.println(windowHeight);

        if (windowHeight > 1382){
            jse.executeScript("window.scrollBy(0,500)");
            System.out.println("Scroll Down page by 500px");
        } else {
            jse.executeScript("window.scrollBy(0,600)");
            System.out.println("Scroll Down page by 600px");
        }

    }
    //scroll web page
    public static void scrollDown(String pixel){
            jse.executeScript("window.scrollBy(0," + pixel + ")");
    }
}
