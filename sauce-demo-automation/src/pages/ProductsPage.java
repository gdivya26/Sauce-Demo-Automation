package pages;

import org.openqa.selenium.*;
import java.util.*;

public class ProductsPage {

    WebDriver driver;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addTopTwoExpensiveItems() {

        List<WebElement> prices = driver.findElements(By.className("inventory_item_price"));
        List<Double> priceList = new ArrayList<>();

        for (WebElement e : prices) {
            priceList.add(Double.parseDouble(e.getText().replace("$", "")));
        }

        Collections.sort(priceList, Collections.reverseOrder());

        for (int i = 0; i < 2; i++) {
            String price = "$" + priceList.get(i);
            WebElement item = driver.findElement(By.xpath("//div[text()='" + price + "']/ancestor::div[@class='inventory_item']//button"));
            item.click();
        }
    }

    public void goToCart() {
        driver.findElement(By.className("shopping_cart_link")).click();
    }
}