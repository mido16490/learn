package Tests;

import Pages.HomePage;
import Pages.LoginPage;
import au.com.bytecode.opencsv.CSVReader;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LoginTests extends BaseTest {

    HomePage homePage;
    LoginPage loginPage;

    @Test(enabled = false)
    public void successLogin() throws InterruptedException {
        homePage = new HomePage(driver);
        homePage.clickLoginLink();

        loginPage = new LoginPage(driver);
        Thread.sleep(500);
        loginPage.setEmailTb("mido@test01.com");
        Thread.sleep(500);
        loginPage.setPasswordTb("011001414");
        loginPage.clickLoginBtn();
        Assert.assertTrue(homePage.isLogoutLinkDisplayed());
        homePage.clickLogout();
        Assert.assertTrue(homePage.isLoginLinkDisplayed());
    }

    CSVReader reader;

    @Test
    public void loginSuccess_2() throws IOException, InterruptedException {
        String csvPath = "src/test/java/Data/LoginData.csv";
        reader = new CSVReader(new FileReader(csvPath));
        String[] csvCell;

        while ((csvCell = reader.readNext()) != null ){
            String email = csvCell[0] ;
            String password = csvCell[1];

            homePage = new HomePage(driver);
            homePage.clickLoginLink();

            loginPage = new LoginPage(driver);
            Thread.sleep(500);
            loginPage.setEmailTb(email);
            Thread.sleep(500);
            loginPage.setPasswordTb(password);
            loginPage.clickLoginBtn();
            Assert.assertTrue(homePage.isLogoutLinkDisplayed());
            Thread.sleep(500);
            homePage.clickLogout();
            Assert.assertTrue(homePage.isLoginLinkDisplayed());
            Thread.sleep(500);
        }
    }
}
