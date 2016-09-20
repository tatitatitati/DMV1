package redmine.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class Page {
    protected WebDriver driver;

    public Page(WebDriver driver) {
        this.driver = driver;
    }

    protected void type(WebElement webElement, String text) {
        webElement.clear();
        webElement.sendKeys(text);
    }
    public abstract void open();

    public boolean isElementPresent(WebElement element) {
        try {
            element.isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }

    }

    public boolean isTextPresent(String text) {
        try {
            if(driver.findElements(By.xpath("//*[contains(text(),'"+text+"')]")).isEmpty())
            return false;
            else return true;
        } catch (NoSuchElementException e) {
            return false;
        }
//        try {
//            driver.findElement(By.tagName("body")).getText().contains(text);
//            return true;
//        } catch (NoSuchElementException e) {
//            return false;
//        }

    }
}
