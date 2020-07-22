package Pages;

import net.bytebuddy.implementation.bind.annotation.FieldValue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @FindBy(linkText = "Register")
    WebElement registerLink;
    public void clickRegisterLink(){
        registerLink.click();
    }

    @FindBy(linkText = "Log in")
    WebElement loginLink;
    public void clickLoginLink(){
        loginLink.click();
    }
    public Boolean isLoginLinkDisplayed(){
        return loginLink.isDisplayed();
    }

    @FindBy(linkText = "Log out")
    WebElement logoutLink;
    public void clickLogout(){
        logoutLink.click();
    }
    public Boolean isLogoutLinkDisplayed(){
        return logoutLink.isDisplayed();
    }

    @FindBy(linkText = "Computers")
    WebElement computersLink;
    public void hoverComputerLink(){
        Actions actions = new Actions(driver);
        actions.moveToElement(computersLink).perform();
    }

    @FindBy(id = "small-searchterms")
    WebElement searchTB;
    public void setSearchTB(String product){
        searchTB.sendKeys(product);
    }

    @FindBy(id = "ui-id-3")
    WebElement suggestedList;
    public void clickSuggestedList(){
        suggestedList.click();
    }

    @FindBy(linkText = "Notebooks")
    WebElement noteBooksLink;
    public void hoverNoteBookLink(){
        Actions actions = new Actions(driver);
        actions.moveToElement(noteBooksLink).perform();
    }
    public void clickNoteBookLink(){
        noteBooksLink.click();
    }

    @FindBy(css = "input.button-1.search-box-button")
    WebElement searchBtn;
    public void clickSearchBtn(){
        searchBtn.click();
    }

    public void testError(){
        Actions actions = new Actions(driver);
        actions.moveToElement(computersLink).moveToElement(noteBooksLink).click(noteBooksLink).build().perform();
    }
}
