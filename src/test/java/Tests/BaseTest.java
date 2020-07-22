package Tests;

import Pages.HomePage;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITest;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    public WebDriver driver ;
    HomePage homePage;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://demo.nopcommerce.com/");
        homePage = new HomePage(driver);
    }


    @AfterMethod
    public void takeScreenShotsInFail(ITestResult result) throws IOException {
        if (ITestResult.FAILURE == result.getStatus()){
           TakesScreenshot tsc = ((TakesScreenshot)driver);
           File src = tsc.getScreenshotAs(OutputType.FILE);
           FileUtils.copyFile(src, new File("src/test/ScreenShots/" + result.getName()+ ".png"));

        }

    }


    @AfterClass
    public void closeBrowser(){
        driver.close();
    }
}
