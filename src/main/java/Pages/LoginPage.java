package Pages;

import Pages.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "Email")
    WebElement emailTb;
    public void setEmailTb(String email){
        emailTb.sendKeys(email);
    }

    @FindBy(id = "Password")
    WebElement passwordTb;
    public void setPasswordTb(String password){
        passwordTb.sendKeys(password);
    }

    @FindBy(css = "input.button-1.login-button")
    WebElement loginBtn;
    public void clickLoginBtn(){
        loginBtn.click();
    }
}
