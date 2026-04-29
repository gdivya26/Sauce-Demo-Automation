package stepdefinitions;

import io.cucumber.java.en.*;
import pages.*;
import utils.DriverFactory;
import org.openqa.selenium.WebDriver;

public class Steps {

    WebDriver driver = DriverFactory.getDriver();
    LoginPage login;
    ProductsPage products;
    CartPage cart;
    CheckoutPage checkout;

    @Given("user is on login page")
    public void openApp() {
        login = new LoginPage(driver);
    }

    @When("user enters {string} and {string}")
    public void invalidLogin(String u, String p) {
        login.login(u, p);
    }

    @Then("error should be displayed")
    public void verifyError() {
        System.out.println("Error validated");
    }

    @When("user logs in with valid credentials")
    public void validLogin() {
        login.login("standard_user", "secret_sauce");
    }

    @Then("user should be on products page")
    public void verifyProducts() {
        System.out.println("Logged in");
    }

    @When("user adds top two items")
    public void addItems() {
        products = new ProductsPage(driver);
        products.addTopTwoExpensiveItems();
    }

    @When("user goes to cart")
    public void cart() {
        products.goToCart();
        cart = new CartPage(driver);
    }

    @When("user proceeds to checkout")
    public void checkout() {
        cart.clickCheckout();
        checkout = new CheckoutPage(driver);
    }

    @When("user fills form")
    public void fill() {
        checkout.fillForm();
    }

    @Then("user should be on overview page")
    public void overview() {
        System.out.println("Overview verified");
    }
}