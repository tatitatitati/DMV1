package redmine.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import redmine.data.UserData;

import java.sql.Driver;


public class TwoFormPage extends Page{

    @FindBy(id="edit-subject")
    WebElement editsubject;

    @FindBy(id = "edit-question")
    WebElement editquestion;

    @FindBy(id = "edit-next")
    WebElement buttonnext;

    @FindBy(id = "edit-first-name")
    WebElement firstname;

    @FindBy(id = "edit-last-name")
    WebElement lastname;

    @FindBy(id = "edit-email")
    WebElement email;

    @FindBy(id="edit-question-state")
    WebElement editstate;

    @FindBy(id = "edit-agreement")
    WebElement agree;

    public TwoFormPage(WebDriver driver) {
        super(driver);
    }


    public TwoFormPage addcontacts(UserData user){
        type(firstname, user.firstname);
        type(lastname, user.secondname );
        type(email, user.email);
        agree.click();

        return PageFactory.initElements(driver, TwoFormPage.class);

    }

    public TwoFormPage buttonNextClick()
    {
        buttonnext.click();
        return PageFactory.initElements(driver, TwoFormPage.class);
    }

    public TwoFormPage addFirstname()
    {
        type(firstname,"Nya");
        return PageFactory.initElements(driver, TwoFormPage.class);
    }

    public boolean subjectPresent() {return isElementPresent(editsubject);}
    public boolean questionPresent() {
        return isElementPresent(editquestion);
    }
    public boolean buttonPresent() {return isElementPresent(buttonnext);}
    public boolean firstnamePresent() {return  isElementPresent(firstname);}
    public boolean lastnamePresent() {return  isElementPresent(lastname);}
    public boolean emailPresent() {return  isElementPresent(email);}
    public boolean statePresent() {return isElementPresent(editstate);}
    public boolean agreePresent() {return  isElementPresent(agree);}


    @Override
    public void open() {

    }
}
