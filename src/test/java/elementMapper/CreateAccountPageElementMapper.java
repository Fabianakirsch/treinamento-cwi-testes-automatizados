package elementMapper;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javax.xml.xpath.XPath;

public class CreateAccountPageElementMapper {

    @FindBy(css = "#noSlide .page-heading")
    public WebElement create_an_account;

    @FindBy(css = "input#id_gender2")
    public WebElement title;

    @FindBy(css = "input#customer_firstname")
    public WebElement first_name;

    @FindBy(css = "input#customer_lastname")
    public WebElement last_name;

    @FindBy(id = "email")
    public WebElement email;

    @FindBy(css = "input#passwd")
    public WebElement password;

    @FindBy(css = "#days option[value='22']")
    public WebElement select_day_birth;

    @FindBy(css = "#months option[value='12']")
    public WebElement select_month_birth;

    @FindBy(css = "#years option[value='1996']")
    public WebElement select_year_birth;

    @FindBy(id = "newsletter")
    public WebElement newsletter;

    @FindBy(id = "optin")
    public WebElement offers_partners;

    @FindBy(id = "company")
    public WebElement company;

    @FindBy(id = "address1")
    public WebElement address;

    @FindBy(id = "address2")
    public WebElement address2;

    @FindBy(id = "city")
    public WebElement city;

    @FindBy(css = "#id_state option[value='5']")
    public WebElement state;

    @FindBy(id = "postcode")
    public WebElement postal_code;

    @FindBy(css = "#id_country option[value='21']")
    public WebElement country;

    @FindBy(id = "other")
    public WebElement additional_information;

    @FindBy(id = "phone")
    public WebElement home_phone;

    @FindBy(id = "phone_mobile")
    public WebElement phone_mobile;

    @FindBy(id = "submitAccount")
    public WebElement button_register;

    @FindBy(css = "#center_column h1.page-heading")
    public WebElement my_account;

    @FindBy(css = "input#firstname")
    public WebElement firstname_address;

    @FindBy(css = "input#lastname")
    public WebElement lastname_address;

    @FindBy(id = "email")
    public WebElement email_create;

    @FindBy (css = "#center_column .alert.alert-danger p")
    public WebElement error;


}
