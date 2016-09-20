package redmine.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FirstFormPage extends Page {

    @FindBy(id = "edit-question")
    WebElement editquestion;

    @FindBy(id = "edit-next")
    WebElement buttonnext;

    public FirstFormPage(WebDriver driver) {
        super(driver);
    }

    public FirstFormPage writequestion(String text) {
        type(editquestion, text);
        return PageFactory.initElements(driver, FirstFormPage.class);
    }
    public TwoFormPage writequestionclick() {
        buttonnext.click();
        return PageFactory.initElements(driver, TwoFormPage.class);
    }

    public boolean questionPresent() {
        return isElementPresent(editquestion);
    }
    public boolean buttonPresent() {return isElementPresent(buttonnext);}

    @Override
   public void open() {
        driver.get("https://www.dmv.com/ask-a-question");
        }

}
