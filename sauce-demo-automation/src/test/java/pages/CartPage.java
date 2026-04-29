package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class CartPage {

    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickCheckout() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Ensure we are on cart page
        wait.until(ExpectedConditions.urlContains("cart"));

        // Wait for checkout button
        wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("[data-test='checkout']")
        )).click();
    }
}