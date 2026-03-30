package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;	
	}
	
	// Locators
	 By title = By.xpath("//title[normalize-space()='Home - Gin & Juice Shop']");
	 By logo = By.xpath("//div[@class='scanme-logo']");
	 By productsLink = By.linkText("PRODUCTS");
	 By blogLink = By.linkText("BLOG");
	 By ourStoryLink = By.linkText("OUR STORY");
	 By cartLink = By.xpath("//a[@class='cart-icon']//*[name()='svg']");
	 By bannerViewAllButton = By.linkText("VIEW ALL PRODUCTS");
	 By loginLink = By.xpath("//a[@class='account-icon']//*[name()='svg']");
	 
	 
	 
	 public void getTitle() {
	        driver.findElement(title);
	    }
	 
	 public boolean isLogoDisplayed() {
	        return driver.findElement(logo).isDisplayed();
	    }
	 
	 public void clickProducts() {
	        driver.findElement(productsLink).click();
	    }
	 
	 public void clickBlog() {
		 driver.findElement(blogLink).click();
	 }

	 public void clickOurStory() {
		 driver.findElement(ourStoryLink).click();
	 }
	 
	 public void ClickLogin() {
		 driver.findElement(loginLink).click();
	 }
	 
	 
	 public void ClickCart() {
		 driver.findElement(cartLink).click();
	 }

	
	 
	 
	
	 
	 
}
