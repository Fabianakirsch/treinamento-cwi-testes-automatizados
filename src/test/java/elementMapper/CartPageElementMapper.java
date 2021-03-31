package elementMapper;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPageElementMapper {

    @FindBy(className = "page-heading")
    public WebElement cart_sumary;

    @FindBy(css = ".cart_description .product-name")
    public WebElement productNameCart;

}
