package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import java.util.*;

public class ProductsPage {

    WebDriver driver;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addTopTwoExpensiveItems() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("inventory_item")));

        List<WebElement> items = driver.findElements(By.className("inventory_item"));
        // Build a list of (price, addToCartButton) pairs
        List<double[]> priceIndices = new ArrayList<>();

        for (int i = 0; i < items.size(); i++) {
            WebElement priceEl = items.get(i).findElement(By.className("inventory_item_price"));
            double price = Double.parseDouble(priceEl.getText().replace("$", ""));
            priceIndices.add(new double[]{price, i});
        }

        // Sort descending by price
        priceIndices.sort((a, b) -> Double.compare(b[0], a[0]));

        // Click "Add to cart" for the top 2 most expensive items
        for (int i = 0; i < 2; i++) {
            int itemIndex = (int) priceIndices.get(i)[1];
            WebElement addButton = items.get(itemIndex).findElement(By.cssSelector("button.btn_inventory"));
            addButton.click();
        }
    }

    public void goToCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.className("shopping_cart_link"))).click();
    }
}