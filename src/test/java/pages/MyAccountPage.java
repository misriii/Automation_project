package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyAccountPage {

    WebDriver driver;
    WebDriverWait wait;

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    
    //Locators
    By pageTitle = By.xpath("//h1[contains(text(),'MY ACCOUNT')]");
    By profileIcon=By.xpath("//a[contains(@class,'account-icon')]");
    By myAccount = By.xpath("//a[normalize-space()='My account']");
    By orders = By.cssSelector(".order-item");
    By orderDetails = By.xpath("(//a[contains(text(),'Order details')])[1]");
  
    By orderNumber = By.xpath("//div[contains(text(),'Order no')]");
    By productName = By.xpath("//h4[contains(text(),'Product name')]/following-sibling::div");
    By paymentMethod = By.xpath("//div[contains(text(),'Debit card')]");
    By billingAddress = By.xpath("//h4[contains(text(),'Billing address')]");
    By shippingAddress = By.xpath("//b[contains(text(),'Shipping address')]");



    
    public void openMyAccount() {
        WebElement profile = wait.until(ExpectedConditions.visibilityOfElementLocated(profileIcon));

        Actions actions = new Actions(driver);
        actions.moveToElement(profile).perform();

        wait.until(ExpectedConditions.elementToBeClickable(myAccount)).click();
    }
    
 // Orders count
    public int getOrdersCount() {
        List<WebElement> list = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(orders));
        return list.size();
    }
    
 // Scroll (JS Executor)
    public void scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
    }
    
 // Click order details
    public void openOrderDetails() {
        wait.until(ExpectedConditions.elementToBeClickable(orderDetails)).click();
    }

    // Get data
    public String getOrderNumber() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(orderNumber)).getText();
    }

    public String getProductName() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(productName)).getText();
    }

    public String getPaymentMethod() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(paymentMethod)).getText();
    }

    public boolean isBillingDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(billingAddress)).isDisplayed();
    }

    public boolean isShippingDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(shippingAddress)).isDisplayed();
    }


   
}