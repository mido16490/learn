package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.IdentityHashMap;

public class RegisterPage extends PageBase{

    WebDriver driver;



    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "gender-male")
    WebElement maleRd;
    public void clickMaleRd(){
        maleRd.click();
    }

    @FindBy(id = "FirstName")
    WebElement firstNameTb ;
    public void setFirstNameTb(String fistName){
        firstNameTb.sendKeys(fistName);
    }

    @FindBy(id = "LastName")
    WebElement lastNameTb ;
    public void setLastNameTb(String lastName){
        lastNameTb.sendKeys(lastName);
    }

    @FindBy(name = "DateOfBirthDay")
    WebElement dayOfBirthSel;
    @FindBy(name = "DateOfBirthMonth")
    WebElement monthOfBirthSel;
    @FindBy(name = "DateOfBirthYear")
    WebElement yearOfBirthSel;
    public void setBirthDate(String dayOfBirth, String monthOfBirth, String yearOfBirth){
        Select daySelect = new Select(dayOfBirthSel);
        daySelect.selectByVisibleText(dayOfBirth);
        Select monthSelect = new Select(monthOfBirthSel);
        monthSelect.selectByVisibleText(monthOfBirth);
        Select yearSelect = new Select(yearOfBirthSel);
        yearSelect.selectByVisibleText(yearOfBirth);
    }

    @FindBy(id = "Email")
    WebElement emailTb ;
    public void setEmailTb(String email){
        emailTb.sendKeys(email);
    }

    @FindBy(id = "Password")
    WebElement passwordTb ;
    public void setPasswordTb(String password){
        passwordTb.sendKeys(password);
    }

    @FindBy(id = "ConfirmPassword")
    WebElement confirmPasswordTb ;
    public void setConfirmPasswordTb(String password){
        confirmPasswordTb.sendKeys(password);
    }

    @FindBy(id = "register-button")
    WebElement registerBtn ;
    public void clickRegisterBtn(){
        registerBtn.click();
    }



}
