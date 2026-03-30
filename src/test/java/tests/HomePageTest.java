package tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.time.Duration;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;

public class HomePageTest extends BaseTest {
	
	@Test
	public void title() {
        HomePage homePage = new HomePage(driver);
        String title = driver.getTitle();
        Assert.assertEquals(title, "Home - Gin & Juice Shop");
	}
	
	
	@Test
    public void verifyLogoIsDisplayed() {

        HomePage homePage = new HomePage(driver);
        boolean result = homePage.isLogoDisplayed();
        Assert.assertTrue(result, "Logo is not displayed");
    }
	
	@Test
	public void verifyProductNavigation() {
		HomePage homePage = new HomePage(driver);
		homePage.clickProducts();
		 WebElement title = driver.findElement(By.xpath("//h1[normalize-space()='Products']"));
		 Assert.assertTrue(title.isDisplayed(), "Products page did not open");
	}
	
	@Test
	public void verifyBlogNavigation() {
		HomePage homePage = new HomePage(driver);
		homePage.clickBlog();
		WebElement title = driver.findElement(By.xpath("//h1[normalize-space()='Blog']"));
		Assert.assertTrue(title.isDisplayed(), "Blog page did not open");
		
	}
	
	@Test
	public void verifyOurStoryNavigation() {
		HomePage homePage = new HomePage(driver);
		homePage.clickOurStory();
		WebElement title = driver.findElement(By.xpath("//h1[normalize-space()='OUR STORY']"));
		Assert.assertTrue(title.isDisplayed(), "Our story page did not open");
		
	}
	
	@Test
	public void verifyLoginNavigation() {
		HomePage homePage = new HomePage(driver);
		homePage.ClickLogin();
		WebElement login = driver.findElement(By.xpath("//h1[normalize-space()='Login']"));
		Assert.assertTrue(login.isDisplayed(), "Login page did not open");
		
	}
	
	@Test
	public void verifyCartNavigation() {
		HomePage homePage = new HomePage(driver);
		homePage.ClickCart();
		WebElement cart = driver.findElement(By.xpath("//h1[normalize-space()='Shopping cart']"));
		Assert.assertTrue(cart.isDisplayed(), "Cart page did not open");
		
	}
	
	
}
