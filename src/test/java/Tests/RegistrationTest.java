package Tests;

import Pages.HomePage;
import Pages.RegisterPage;
import au.com.bytecode.opencsv.CSVReader;
import net.bytebuddy.utility.RandomString;
import org.testng.Assert;
import org.testng.DataProviderHolder;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class RegistrationTest extends BaseTest {

    HomePage homePage;
    RegisterPage registerPage;

    @DataProvider
    public Object[][] registerData(){
        Object[][] data = new Object[1][7];
        //1st row
        data[0][0] = "Mohamed";
        data[0][1] = "Khalil";
        data[0][2] = "16";
        data[0][3] = "April";
        data[0][4] = "1990";
        data[0][5] = "mido@test04.com";
        data[0][6] = "011001414";

        return data;
    }

    @Test(dataProvider = "registerData")
    public void registerSuccess( String firstName, String lastName,
                                 String dayOfBirth, String monthOfBirth,
                                 String yearOfBirth, String email,
                                 String password) throws InterruptedException {
        homePage = new HomePage(driver);
        homePage.clickRegisterLink();
        Thread.sleep(500);

        registerPage = new RegisterPage(driver);
        registerPage.clickMaleRd();
        Thread.sleep(500);
        registerPage.setFirstNameTb(firstName);
        Thread.sleep(500);
        registerPage.setLastNameTb(lastName);
        Thread.sleep(500);
        registerPage.setBirthDate(dayOfBirth,monthOfBirth,yearOfBirth);
        Thread.sleep(500);
        registerPage.setEmailTb(email);
        Thread.sleep(500);
        registerPage.setPasswordTb(password);
        Thread.sleep(500);
        registerPage.setConfirmPasswordTb(password);
        Thread.sleep(500);
        registerPage.clickRegisterBtn();
        Thread.sleep(500);
        Assert.assertEquals(driver.getCurrentUrl(),
                "https://demo.nopcommerce.com/registerresult/1?returnUrl=/");
        Assert.assertTrue(homePage.isLogoutLinkDisplayed());
        
    }


    CSVReader reader;

    @Test
    public void registerSuccess_2() throws InterruptedException, IOException {
        String csvPath = "src/test/java/Data/RegistrationData.csv";
        reader = new CSVReader(new FileReader(csvPath));
        String[] csvCell ;

        while ((csvCell = reader.readNext()) != null){
            String firstName = csvCell[0];
            String lastName = csvCell[1];
            String dayOfBirth = csvCell[2];
            String monthOfBirth = csvCell[3];
            String yearOfBirth = csvCell[4];
            String email = csvCell[5];
            String password = csvCell[6];


            homePage = new HomePage(driver);
            homePage.clickRegisterLink();
            Thread.sleep(500);

            registerPage = new RegisterPage(driver);
            registerPage.clickMaleRd();
            Thread.sleep(500);
            registerPage.setFirstNameTb(firstName);
            Thread.sleep(500);
            registerPage.setLastNameTb(lastName);
            Thread.sleep(500);
            registerPage.setBirthDate(dayOfBirth,monthOfBirth,yearOfBirth);
            Thread.sleep(500);
            registerPage.setEmailTb(email);
            Thread.sleep(500);
            registerPage.setPasswordTb(password);
            Thread.sleep(500);
            registerPage.setConfirmPasswordTb(password);
            Thread.sleep(500);
            registerPage.clickRegisterBtn();
            Thread.sleep(500);
            Assert.assertEquals(driver.getCurrentUrl(),
                    "https://demo.nopcommerce.com/registerresult/1?returnUrl=/");
            Assert.assertTrue(homePage.isLogoutLinkDisplayed());
            homePage.clickLogout();
            Thread.sleep(500);

        }



    }
}
