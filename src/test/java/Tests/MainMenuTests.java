package Tests;

import Pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.InvocationTargetException;

public class MainMenuTests extends BaseTest {

    HomePage homePage;

    @Test
    public void testingHovering() throws InterruptedException {
        homePage = new HomePage(driver);
        homePage.hoverComputerLink();
        Thread.sleep(1000);
        homePage.hoverNoteBookLink();
        Thread.sleep(1000);
        homePage.clickNoteBookLink();
        Assert.assertTrue(driver.getCurrentUrl().contains("notebooks"));

    }
}
