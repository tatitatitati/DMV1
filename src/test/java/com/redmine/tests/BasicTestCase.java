package com.redmine.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import redmine.data.UserData;

import java.util.concurrent.TimeUnit;


public class BasicTestCase {
    protected static WebDriver driver;
    public final static UserData user = new UserData("Tati", "Test", "wertyu@fghj.com");

    protected WebDriver getWebDriver() {
        if (driver == null) {
            //  System.setProperty("webdriver.chrome.driver", "C:/path/to/chromedriver.exe");
            //WebDriver driver = new ChromeDriver();
            System.setProperty("webdriver.gecko.driver", "src/Drivers/geckodriver.exe");
            driver = new FirefoxDriver();
              driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        }
        return driver;
    }
    @AfterSuite
    public void tearDown() throws Exception {
        driver.quit();
    }
}
