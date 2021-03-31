package elementMapper;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageElementMapper {

    public WebElement email;

    public WebElement passwd;

    public WebElement SubmitLogin;

    @FindBy(css = "h1.page-heading")
    public WebElement authenticationPageLogin;

    @FindBy(id = "email_create")
    public WebElement email_create;

    @FindBy(css = "button#SubmitCreate.btn")
    public WebElement button_create_account;

    @FindBy(id = "create_account_error")
    public WebElement create_account_error;


}
