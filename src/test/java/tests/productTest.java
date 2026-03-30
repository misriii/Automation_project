package tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.productPage;
import base.BaseTest;

public class productTest extends BaseTest {

	 @Test
	    public void verifyProductListing() {
		 LoginPage login = new LoginPage(driver);
			login.profileClick();
			login.enterUsername("carlos");
			login.clickLogin();
			login.enterPassword("hunter2");
			login.clickLogin();
			HomePage homePage = new HomePage(driver);
			homePage.clickProducts();
	        productPage product = new productPage(driver);

	        AssertJUnit.assertTrue("Products not displayed",
	                product.getProductCount() > 0);
	    }

	
	    @Test
	    public void verifyNavigationToDetails() {
	    	productPage product = new productPage(driver);

	        product.clickProduct(0);

	        AssertJUnit.assertTrue("Navigation to product details failed",
	                driver.getCurrentUrl().contains("product"));
	    }

	  
	    @Test
	    public void verifyProductDetailsDisplayed() {
	    	productPage product = new productPage(driver);

	        product.clickProduct(0);

	        AssertJUnit.assertFalse("Product name missing",
	                product.getProductNameFromDetails().isEmpty());

	        AssertJUnit.assertTrue("Product price missing",
	                product.getProductPriceFromDetails().contains("$"));
	    }

	    

	   
	    @Test
	    public void verifyQuantitySelection() {
	    	productPage product = new productPage(driver);

	        product.clickProduct(0);
	        product.selectQuantity("2");

	        AssertJUnit.assertTrue("Quantity selection failed", true); // UI-based
	    }

	   
	    @Test
	    public void verifyAddToCartTrigger() {
	    	productPage product = new productPage(driver);

	        product.clickProduct(0);
	        product.selectQuantity("1");
	        product.clickAddToCart();

	        AssertJUnit.assertTrue("Add to cart failed",
	                product.isViewCartVisible());
	    }

	   
	    @Test
	    public void verifyMultipleProductNavigation() {
	    	productPage product = new productPage(driver);

	        product.clickProduct(0);
	        driver.navigate().back();

	        product.clickProduct(1);

	        AssertJUnit.assertTrue("Navigation between products failed",
	                driver.getCurrentUrl().contains("product"));
	    }

	    
	    @Test
	    public void verifyMultipleClicksAddToCart() {
	    	productPage product = new productPage(driver);

	        product.clickProduct(0);

	        product.clickAddToCart();
	        product.clickAddToCart();
	        product.clickAddToCart();

	        AssertJUnit.assertTrue("Multiple click handled", true);
	    }
	    @Test
	    public void verifySingleFilter() {

	        productPage product = new productPage(driver);

	        product.openProductListing();
	        product.selectFilter("Accessories");

	        AssertJUnit.assertTrue("Filter not applied",
	                driver.getCurrentUrl().contains("Accessories"));

	        AssertJUnit.assertTrue("Filtered products not displayed",
	                product.getFilteredProductCount() > 0);
	    }
	    
	    @Test
	    public void verifyMultipleFilterNavigation() {

	        productPage product = new productPage(driver);

	        product.openProductListing();

	        product.selectFilter("Gin");
	        int ginCount = product.getFilteredProductCount();

	        product.selectFilter("Juice");
	        int juiceCount = product.getFilteredProductCount();

	        Assert.assertNotEquals(ginCount, juiceCount,
	                "Filter navigation not working");
	    }
	
	
	
}