package redmine.pages;
import org.openqa.selenium.WebDriver;

public class HomePage extends Page {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
            driver.get("https://www.dmv.com/ask-a-question");
    }



}
