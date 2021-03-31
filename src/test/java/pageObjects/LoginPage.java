package pageObjects;

import elementMapper.LoginPageElementMapper;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;
import utils.Browser;

public class LoginPage extends LoginPageElementMapper {

    public LoginPage() {
        PageFactory.initElements(Browser.getCurrentDriver(), this);
    }

    @Step("Preencheu o email")
    public void fillEmail() {
        email.sendKeys("fabiana.kirsch31@gmail.com");
    }

    @Step("Preencheu a senha")
    public void fillPasswd() {
        passwd.sendKeys("221296");
    }

    @Step("Clicou Sign In")
    public void clickBtnSubmitLogin() {
        SubmitLogin.click();
    }

    public boolean isPageLogin() {
        return getAuthenticationPageLogin().equals("AUTHENTICATION");
    }

    public String getAuthenticationPageLogin() {
        return authenticationPageLogin.getText();
    }

    public void createAnAccountEmail(String email) {
        email_create.sendKeys(email);
    }

    public void clickButtonCreateAnAccount() {
        button_create_account.click();
    }

    public boolean isErrorCreateAccount() {
        return getErrorCreateAccount()
                .contains("An account using this email address has already been registered");
    }

    public String getErrorCreateAccount(){
        return create_account_error.getText();
    }

}
