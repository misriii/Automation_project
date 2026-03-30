package pages;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class productPage {

	WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;

    public productPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
        js = (JavascriptExecutor) driver;
    }
    
    By filterOptions = By.cssSelector(".filter-category");
    By selectedFilter = By.cssSelector(".filter-category.selected");


    By productCards = By.xpath("//section[@class='container-list-tiles']");
    By quantityDropdown = By.xpath("//select[@name='quantity']");
    By productNames = By.cssSelector(".container-list-tiles h3");
    By productPrices = By.cssSelector(".price");


    By addToCartBtn = By.xpath("//button[normalize-space()='Add to cart']");
    By viewCartBtn = By.xpath("//a[contains(text(),'View cart')]");
   
    By productNameDetails = By.cssSelector("h3");
    By productPriceDetails = By.xpath("//span[contains(text(),'$')]");



    public void clickJS(By locator) {
        WebElement el = wait.until(ExpectedConditions.elementToBeClickable(locator));
        js.executeScript("arguments[0].click();", el);
    }

    public void waitVisible(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    
    public void openProductListing() {

        driver.get("https://ginandjuice.shop/catalog");

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector(".container-list-tiles")
        ));
    }

    public int getProductCount() {
        return driver.findElements(productCards).size();
    }

    public String getProductNameFromListing(int index) {
        return driver.findElements(productNames).get(index).getText();
    }

    public String getProductPriceFromListing(int index) {
        return driver.findElements(productPrices).get(index).getText();
    }

    public void clickProduct(int index) {
        By product = By.xpath("(//span[text()='View details'])[" + (index + 1) + "]");
        clickJS(product);
    }


    public String getProductNameFromDetails() {
        waitVisible(productNameDetails);
        return driver.findElement(productNameDetails).getText();
    }

    public String getProductPriceFromDetails() {
        return driver.findElement(productPriceDetails).getText();
    }

    public void selectQuantity(String qty) {
        waitVisible(quantityDropdown);
        driver.findElement(quantityDropdown).sendKeys(qty);
    }

    public void clickAddToCart() {
        clickJS(addToCartBtn);
    }

    public boolean isViewCartVisible() {
        return driver.findElements(viewCartBtn).size() > 0;
    }
    
    public void selectFilter(String filterName) {

        By filter = By.xpath("//a[contains(@class,'filter-category') and normalize-space()='" + filterName + "']");

        WebElement el = wait.until(ExpectedConditions.presenceOfElementLocated(filter));

        
        js.executeScript("arguments[0].scrollIntoView(true);", el);
        js.executeScript("arguments[0].click();", el);

       
        wait.until(ExpectedConditions.urlContains("category"));
    }

    public int getFilteredProductCount() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productNames));
        return driver.findElements(productNames).size();
    }
    

    

}