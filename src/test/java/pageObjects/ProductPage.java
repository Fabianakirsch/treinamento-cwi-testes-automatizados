package pageObjects;

import elementMapper.ProductPageElementMapper;
import org.openqa.selenium.support.PageFactory;
import utils.Browser;

public class ProductPage extends ProductPageElementMapper {

    public ProductPage() {
        PageFactory.initElements(Browser.getCurrentDriver(), this);
    }

    public boolean isPageReferenceProduct() {
        return referenceProduct().contains("demo_1");
    }

    public String referenceProduct() {
        return product_reference.getText();
    }

    public void clickAddToCar() {
        add_to_cart.click();
        proceed_to_checkout.click();
    }

    //Módulo 5

    public String getProductNamePDP(){
        return productNamePDP.getText();
    }

    public void clickButtonAddToCart(){
        buttonAddToCart.click();
    }

    public void clickButtonModalProceedToCheckout(){
        buttonModalProceedToCheckout.click();
    }


}
