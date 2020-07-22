package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Base64;

public class SearchResultPage extends PageBase {
    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "div.page-title>h1")
    WebElement pageHead;
    public String getPageHead(){
        return pageHead.getText();
    }
}
