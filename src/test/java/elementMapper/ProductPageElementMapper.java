package elementMapper;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPageElementMapper {

    @FindBy(xpath = "//*[@id=\"product_reference\"]/span")
    public WebElement product_reference;

    @FindBy(xpath = "//*[@id=\"add_to_cart\"]/button")
    public WebElement add_to_cart;

    @FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a")
    public WebElement proceed_to_checkout;

    //Módulo 5

    @FindBy(css = "h1[itemprop=name]")
    public WebElement productNamePDP;

    @FindBy(css = "#add_to_cart > button")
    public WebElement buttonAddToCart;

    @FindBy(css = ".button-container a[title='Proceed to checkout']")
    public WebElement buttonModalProceedToCheckout;

}
