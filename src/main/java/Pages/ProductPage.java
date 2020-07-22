package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends PageBase {
    public ProductPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(css = "div.product-name>h1")
    WebElement productName;
    public String getProductName(){
        return productName.getText();
    }
}
