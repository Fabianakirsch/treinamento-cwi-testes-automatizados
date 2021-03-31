package pageObjects;

        import elementMapper.CreateAccountPageElementMapper;
        import org.openqa.selenium.support.PageFactory;
        import org.openqa.selenium.support.ui.ExpectedConditions;
        import utils.Browser;

        import java.util.concurrent.TimeUnit;

public class CreateAccountPage extends CreateAccountPageElementMapper {

    public CreateAccountPage() {
        PageFactory.initElements(Browser.getCurrentDriver(), this);
    }

    public boolean isPageCreateAccount() {
        return (getPageCreateAccount().equals("CREATE AN ACCOUNT"));
    }

    public String getPageCreateAccount() {
        waitBrowser();
        return create_an_account.getText();
    }

    public void waitBrowser() {
        Browser.wait.until(ExpectedConditions.urlContains("#account-creation"));
    }

    String firstname = "Fabiana";
    String lastname = "Kirsch";

    public void fillFirstname() {
        first_name.sendKeys(firstname);
    }

    public void fillLastname() {
        last_name.sendKeys(lastname);
    }

    public void fillPasswd() {
        password.sendKeys("FABI321");
    }

    public void fillPersonalInformation() {
        title.click();
        select_day_birth.click();
        select_month_birth.click();
        select_year_birth.click();
        newsletter.click();
        offers_partners.click();
    }

    public void fillAddress() {
        address.sendKeys("Rua Odon Cavalcante");
    }

    public void fillCity() {
        city.sendKeys("Novo Hamburgo");
    }

    public void selectState() {
        state.click();
    }

    public void fillPostalCode(String postalcode) {
        postal_code.sendKeys(postalcode);
    }

    public void selectCountry() {
        country.click();
    }

    public void fillPhoneMobile() {
        phone_mobile.sendKeys("980124238");
    }

    public void fillAddressInformation() {
        company.sendKeys("CWI");
        address2.sendKeys("Apartamento");
        additional_information.sendKeys("XXXX");
        home_phone.sendKeys("35602153");
    }

    public void clickButtonRegister() {
        button_register.click();
    }

    public boolean isPageMyAccount() {
        return (getPageMyAccount().equals("MY ACCOUNT"));
    }

    public String getPageMyAccount() {
        waitPageLoading();
        return my_account.getText();
    }

    public void waitPageLoading() {
        Browser.wait.until(ExpectedConditions.urlContains("controller=my-account"));
    }

    public boolean isNameAddress() {
        return getFirstnameAddress().equals(firstname) && (getLastnameAddress().equals(lastname));
    }

    public String getFirstnameAddress() {
        return firstname_address.getAttribute("value");
    }

    public String getLastnameAddress() {
        return lastname_address.getAttribute("value");
    }

    public String getEmail() {
        return email.getAttribute("value");
    }

    public boolean isError() {
        return getError().contains("error");
    }

    public String getError() {
        return error.getText();
    }

    public void waitingPageError() {
        Browser.wait.until(ExpectedConditions.urlContains("controller=authentication"));
    }

}
