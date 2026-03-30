package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class cart {

    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;

    public cart(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        js = (JavascriptExecutor) driver;
    }
    
 // Product Listing
    By viewDetailsBtn = By.xpath("//span[text()='View details']");
    By productList = By.cssSelector(".container-list-tiles");

    By viewCartBtn = By.xpath("//a[contains(text(),'View cart')]");
    By cartTitle = By.xpath("//h1[normalize-space()='Shopping cart']");
    By productNames = By.cssSelector(".item-title");
    By productPrices = By.xpath("//span[@class='item-price']");
    By quantityDropdown = By.xpath("//select");
    By addToCartBtn = By.xpath("//button[contains(text(),'Add to cart')]");

    
    By totalAmount = By.xpath("//strong[contains(text(),'$')]");

    By removeBtn = By.cssSelector(".remove-icon button");

    By couponField = By.xpath("//input[@placeholder='Add coupon']");
    By applyBtn = By.xpath("//button[contains(text(),'Apply')]");

    By placeOrderBtn = By.xpath("//button[contains(text(),'Place order')]");

 // ===== COMMON METHODS =====

    public void clickJS(By locator) {
        WebElement el = wait.until(ExpectedConditions.elementToBeClickable(locator));
        js.executeScript("arguments[0].click();", el);
    }

    public void waitVisible(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    
    public void openProductListing() {
        driver.get("https://ginandjuice.shop/catalog");

        wait.until(ExpectedConditions.visibilityOfElementLocated(productList));
    }

    // ===== NAVIGATION =====
    
    public void clickProduct(int index) {

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(viewDetailsBtn));

        By product = By.xpath("(//span[text()='View details'])[" + (index + 1) + "]");

        clickJS(product);
    }
    
    public void selectQuantity(String qty) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(quantityDropdown));
        driver.findElement(quantityDropdown).sendKeys(qty);
    }

    public void clickAddToCart() {
        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn));
        js.executeScript("arguments[0].click();", btn);
    }


    public void openCart() {
        clickJS(viewCartBtn);
    }

    public boolean isCartDisplayed() {
        waitVisible(cartTitle);
        return driver.findElement(cartTitle).isDisplayed();
    }
 // ===== PRODUCT VALIDATION =====

    public int getProductCount() {
        return driver.findElements(productNames).size();
    }

    public String getTotal() {
        return driver.findElement(totalAmount).getText();
    }

    // ===== QUANTITY =====

    public void updateQuantity(String qty) {
        waitVisible(quantityDropdown);
        driver.findElement(quantityDropdown).sendKeys(qty);
    }

    // ===== REMOVE =====

    public void removeProduct() {
        clickJS(removeBtn);
    }

    public boolean isCartEmpty() {
        return driver.getPageSource().toLowerCase().contains("empty");
    }

    // ===== ORDER =====

    public void placeOrder() {
        clickJS(placeOrderBtn);
    }

    public boolean isOrderSuccess() {
        return driver.getCurrentUrl().contains("order")
                || driver.getPageSource().toLowerCase().contains("success");
    }
    
    // ===== FLOWS =====

    public void addSingleProductFlow() {
        productPage product = new productPage(driver);

        product.clickProduct(0);
        product.selectQuantity("1");
        product.clickAddToCart();

        openCart();
    }

    public void addMultipleProductsFlow(int count) {

        for (int i = 0; i < count; i++) {

            openProductListing();

            clickProduct(i);
            selectQuantity("1");
            clickAddToCart();
        }

        openCart();
    }
    



  
}