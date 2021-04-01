package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.*;
import sun.rmi.runtime.Log;
import utils.Browser;
import utils.Utils;

import java.math.MathContext;
import java.sql.Time;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

@Feature("Testes site de ecommerce")
public class SetupTest extends BaseTests {

    @Test @Ignore
    @Story("Abrir o site")
    public void testOpeningBrowserAndLoadingPage() {
        assertTrue(Browser.getCurrentDriver().getCurrentUrl().contains(Utils.getBaseUrl()));
        System.out.println("Abrimos o navegador e carregamos a url");
    }

    @Test @Ignore
    @Story("Realizar o login")
    public void testLogin() {
        //Iniciar as páginas
        HomePage home = new HomePage();
        LoginPage login = new LoginPage();
        home.clickBtbLogin();
        System.out.println("Clicou Sign In e direcionou para página de login");
        assertTrue(Browser.getCurrentDriver().getCurrentUrl()
                .contains(Utils.getBaseUrl().concat("index.php?controller=authentication&back=my-account")));
        login.fillEmail();
        System.out.println("Preencheu o email");
        login.fillPasswd();
        System.out.println("Preencheu a senha");
        login.clickBtnSubmitLogin();
        System.out.println("Clicou Sign In");
        assertTrue(Browser.getCurrentDriver().getCurrentUrl()
                .contains(Utils.getBaseUrl().concat("index.php?controller=my-account")));
        System.out.println("Validou a url de minha conta");
        assertTrue(Browser.getCurrentDriver().findElement(By
                .className("page-heading")).getText().contains("MY ACCOUNT"));
        System.out.println("Validou a minha conta no site");


//        Browser.getCurrentDriver().findElement(By.className("login")).click();
//        System.out.println("Clicou Sign In e direcionou para página de login");
//        assertTrue(Browser.getCurrentDriver().getCurrentUrl()
//                .contains(Utils.getBaseUrl().concat("index.php?controller=authentication&back=my-account")));
//        Browser.getCurrentDriver().findElement(By.id("email")).sendKeys("fabiana.kirsch31@gmail.com");
//        System.out.println("Preencheu o email");
//        Browser.getCurrentDriver().findElement(By.id("passwd")).sendKeys("221296");
//        System.out.println("Preencheu a senha");
//        Browser.getCurrentDriver().findElement(By.id("SubmitLogin")).click();
//        System.out.println("Clicou Sign In");
//        assertTrue(Browser.getCurrentDriver().getCurrentUrl()
//                .contains(Utils.getBaseUrl().concat("index.php?controller=my-account")));
//        System.out.println("Validou a url de minha conta");
//        assertTrue(Browser.getCurrentDriver().findElement(By
//                .className("page-heading")).getText().contains("MY ACCOUNT"));
//        System.out.println("Validou a minha conta no site");
    }

    @Test @Ignore
    public void testSearch() {

        String quest = "T-SHIRT";
        String questResultQtd = "1";

        //Iniciar as páginas
        HomePage home = new HomePage();
        SearchPage search = new SearchPage();

        //Fazer a pesquisa
        home.doSearch(quest);

        //Validar a pesquisa
        assertTrue(search.isSearchPage());
        assertEquals(search.getTextLighter().replace("\"", ""), quest);
        assertThat(search.getTextHeading_counter(), CoreMatchers.containsString(questResultQtd));
        System.out.println("Realizada a pesquisa do produto");
    }

    @Test @Ignore
    public void testAcessSearch() {

        //Iniciar as páginas
        HomePage home = new HomePage();
        SearchPage search = new SearchPage();
        ProductPage product = new ProductPage();

        testSearch();

        //Acessar a página do produto que foi pesquisado
        search.clickAcessSearch();

        //Validar o acesso na página do produto
        assertTrue(product.isPageReferenceProduct());
        System.out.println("Realizado o acesso na página do produto pesquisado");
    }

    @Test @Ignore
    public void testAddToCar() {
        //Iniciar as páginas
        HomePage home = new HomePage();
        SearchPage search = new SearchPage();
        ProductPage product = new ProductPage();
        CartPage cart = new CartPage();

        testAcessSearch();

        //Adicionar produto ao carrinho
        product.clickAddToCar();

        //Validar a inserção do produto ao carrinho
        //       String summer = cart.checkCart();

        assertTrue(cart.checkCart().contains("SHOPPING-CART SUMMARY"));
        System.out.println("Produto adicionado ao carrinho");

    }


    @Test @Ignore
    public void testAcessCategoryTShirts() {
        //Iniciar as páginas
        HomePage home = new HomePage();
        CategoryPage category = new CategoryPage();

        //Clicar na categoria T-SHIRTS
//        home.clickCategoryTShirts();
        Browser.getCurrentDriver().findElement(By.linkText("T-SHIRTS")).click();

        //Validar se ao clicar na categoria T_SHIRTS ocorre o direcionamento correto
        assertTrue(category.isPageTShirts());
        System.out.println("A página de categoria foi acessada");
    }

    @Test @Ignore
    public void testAddProductToProductPage() {
        //Acessar a categoria T-Shirts
        testAcessCategoryTShirts();

        //Iniciar as páginas
        CategoryPage category = new CategoryPage();
        ProductPage pdp = new ProductPage();

        //Salva nome do produto na página da categoria
        String nameProductCategory = category.getProductNameCategory();

        //Clicar em More e direcionar para a página de produto
        category.clickProductAddToProductPage();

        //Verificar se produto está na página de detalhes do produto corretamente
        assertTrue(pdp.getProductNamePDP().equals(nameProductCategory));
        System.out.println("Acesso a PDP");
    }

    @Test @Ignore
    public void testAddProductToCartPage() {
        //Acessa a página de produto
        testAddProductToProductPage();

        //Iniciar as páginas
        ProductPage pdp = new ProductPage();
        CartPage cart = new CartPage();

        //Salvar o nome do produto na página de PDP
        String nameProductPDP = pdp.getProductNamePDP();

        //Clicar no botão de Adicionar ao carrinho
        pdp.clickButtonAddToCart();

        //Clicar no botão Proceed To Checkout
        pdp.clickButtonModalProceedToCheckout();

        //Validação
        String get = cart.getNameProductCart();
        assertEquals(cart.getNameProductCart(), nameProductPDP);
    }

    //DESAFIO --------------------------------------------------------------------------------------------

    @Test
    @Story("desafio: acessar a página Sign In")
    public void startSignIn() {
        //Iniciar as páginas
        HomePage home = new HomePage();
        LoginPage login = new LoginPage();

        //Clicar em Sign in
        home.clickBtbLogin();
        //Validação
        assertTrue(login.isPageLogin());
        System.out.println("Acessada a página de Sign In");
    }


    @Test
    @Story("desafio: inserir e-mail para criação da conta")
    public void insertEmailForCreateAnAccount() {
        startSignIn();

        //Iniciar as páginas
        LoginPage login = new LoginPage();
        CreateAccountPage account = new CreateAccountPage();

        //Incluir email e clicar em Create an account
        String email = Math.random() * 100 + "fabi.kirsch@gmail.com";
        login.createAnAccountEmail(email);
        login.clickButtonCreateAnAccount();
        //Validação
        assertTrue(account.isPageCreateAccount());
        System.out.println("Acessada a página de criação de conta");
        assertTrue(account.getEmail().equals(email));
        System.out.println("Email verificado");
    }

    @Test
    @Story("desafio: criar conta de novo usuário")
    public void createAnAccount() {
        insertEmailForCreateAnAccount();

        //Iniciar as páginas
        LoginPage login = new LoginPage();
        CreateAccountPage account = new CreateAccountPage();

        //Adicionar informações para criar a conta
        account.fillFirstname();
        account.fillLastname();
        account.fillPasswd();
        account.fillPersonalInformation();
        assertTrue(account.isNameAddress());
        account.fillAddress();
        account.fillCity();
        account.selectState();
        String postalcode = "11111";
        account.fillPostalCode(postalcode);
        account.selectCountry();
        account.fillPhoneMobile();
        account.fillAddressInformation();
        account.clickButtonRegister();
        //Validação
        assertTrue(account.isPageMyAccount());
        System.out.println("Conta criada");
    }

    @Test
    @Story("desafio: testar não preencher informações obrigatórias na criação da conta")
    public void noInformationRequiredWhenCreateAnAccount() {
        insertEmailForCreateAnAccount();

        //Iniciar as páginas
        LoginPage login = new LoginPage();
        CreateAccountPage account = new CreateAccountPage();

        //Utilitários
        String postalcode = "11111";

        //Sem adicionar nenhuma informação
        account.clickButtonRegister();
        assertTrue(account.isError());
        System.out.println(account.getError());

        //Não informar o firstname
        account.waitingPageError();
        account.fillLastname();
        account.fillPasswd();
        account.fillAddress();
        account.fillCity();
        account.selectState();
        account.fillPostalCode(postalcode);
        account.selectCountry();
        account.fillPhoneMobile();
        account.clickButtonRegister();
        //Validação
        assertTrue(account.isError());
        System.out.println(account.getError());

        //Não informar o lasttname
        account.waitingPageError();
        account.fillFirstname();
        account.fillPasswd();
        account.fillAddress();
        account.fillCity();
        account.selectState();
        account.fillPostalCode(postalcode);
        account.selectCountry();
        account.fillPhoneMobile();
        account.clickButtonRegister();
        //Validação
        assertTrue(account.isError());
        System.out.println(account.getError());

        //Não informar a password
        account.waitingPageError();
        account.fillFirstname();
        account.fillLastname();
        account.fillAddress();
        account.fillCity();
        account.selectState();
        account.fillPostalCode(postalcode);
        account.selectCountry();
        account.fillPhoneMobile();
        account.clickButtonRegister();
        //Validação
        assertTrue(account.isError());
        System.out.println(account.getError());

        //Não informar Address
        account.waitingPageError();
        account.fillFirstname();
        account.fillLastname();
        account.fillPasswd();
        account.fillCity();
        account.selectState();
        account.fillPostalCode(postalcode);
        account.selectCountry();
        account.fillPhoneMobile();
        account.clickButtonRegister();
        //Validação
        assertTrue(account.isError());
        System.out.println(account.getError());

        //Não informar City
        account.waitingPageError();
        account.fillFirstname();
        account.fillLastname();
        account.fillPasswd();
        account.fillAddress();
        account.selectState();
        account.fillPostalCode(postalcode);
        account.selectCountry();
        account.fillPhoneMobile();
        account.clickButtonRegister();
        //Validação
        assertTrue(account.isError());
        System.out.println(account.getError());

        //Não informar State
        account.waitingPageError();
        account.fillFirstname();
        account.fillLastname();
        account.fillPasswd();
        account.fillAddress();
        account.fillCity();
        account.fillPostalCode(postalcode);
        account.selectCountry();
        account.fillPhoneMobile();
        account.clickButtonRegister();
        //Validação
        assertTrue(account.isError());
        System.out.println(account.getError());

        //Não informar PostalCode
        account.waitingPageError();
        account.fillFirstname();
        account.fillLastname();
        account.fillPasswd();
        account.fillAddress();
        account.fillCity();
        account.selectState();
        account.selectCountry();
        account.fillPhoneMobile();
        account.clickButtonRegister();
        //Validação
        assertTrue(account.isError());
        System.out.println(account.getError());

        //Não informar Country
        account.waitingPageError();
        account.fillFirstname();
        account.fillLastname();
        account.fillPasswd();
        account.fillAddress();
        account.fillCity();
        account.selectState();
        account.fillPostalCode(postalcode);
        account.fillPhoneMobile();
        account.clickButtonRegister();
        //Validação
        assertTrue(account.isError());
        System.out.println(account.getError());

        //Não informar PhoneMobile
        account.waitingPageError();
        account.fillFirstname();
        account.fillLastname();
        account.fillPasswd();
        account.fillAddress();
        account.fillCity();
        account.selectState();
        account.fillPostalCode(postalcode);
        account.selectCountry();
        account.clickButtonRegister();
        //Validação
        assertTrue(account.isError());
        System.out.println(account.getError());
    }

    @Test
    @Story("desafio: testar inserir e-mail já existente na criação de conta")
    public void repeatEmailWhenCreateAnAccount() {
        startSignIn();

        //Iniciar as páginas
        LoginPage login = new LoginPage();
        CreateAccountPage account = new CreateAccountPage();

        //Incluir email e clicar em Create an account
        String email = "fabi.kirsch@gmail.com";
        login.createAnAccountEmail(email);
        login.clickButtonCreateAnAccount();
        //Validação
        login.isErrorCreateAccount();
        System.out.println("Verificou que já existe uma conta cadastrada com o e-mail inserido");
    }

    @Test
    @Story("desafio: testar preencher o campo PostalCode com o formato incorreto")
    public void incorrectFormatPostalCode() {
        startSignIn();

        //Iniciar as páginas
        LoginPage login = new LoginPage();
        CreateAccountPage account = new CreateAccountPage();

        //Incluir email e clicar em Create an account
        String email = Math.random() * 100 + "fabi.kirsch@gmail.com";
        login.createAnAccountEmail(email);
        login.clickButtonCreateAnAccount();
        //Validação
        assertTrue(account.isPageCreateAccount());
        System.out.println("Acessada a página de criação de conta");

        //Adicionar informações para criar a conta
        account.fillFirstname();
        account.fillLastname();
        assertTrue(account.getEmail().equals(email));
        account.fillPasswd();
        account.fillPersonalInformation();
        assertTrue(account.isNameAddress());
        account.fillAddress();
        account.fillCity();
        account.selectState();
        String postalcode = "000";
        account.fillPostalCode(postalcode);
        account.selectCountry();
        account.fillPhoneMobile();
        account.fillAddress();
        account.clickButtonRegister();
        //Validação
        assertTrue(account.isError());
        System.out.println(account.getError());
    }
}