package tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.productPage;
import pages.cart;
import base.BaseTest;

public class cartTest extends BaseTest {
	
    @Test
    public void verifyCartPageDisplayed() {
        cart cart = new cart(driver);

        cart.addSingleProductFlow();

        Assert.assertTrue(cart.isCartDisplayed(),
                "Cart page not displayed");
    }

    
    @Test
    public void verifyProductAddedToCart() {
    	cart cart = new cart(driver);

        cart.addSingleProductFlow();

        Assert.assertTrue(cart.getProductCount() > 0,
                "Product not added");
    }


   
    @Test
    public void verifyRemoveProduct() {
    	cart cart = new cart(driver);

        cart.addSingleProductFlow();
        cart.removeProduct();

        Assert.assertTrue(cart.isCartEmpty(),
                "Product not removed");
    }

  
    @Test
    public void verifyMultipleProductsAdded() {
        cart cart = new cart(driver);

        cart.addMultipleProductsFlow(2);

        Assert.assertTrue(cart.getProductCount() >= 2,
                "Multiple products not added");
    }


   
    @Test
    public void verifyPlaceOrder() {
    	 LoginPage login = new LoginPage(driver);
			login.profileClick();
			login.enterUsername("carlos");
			login.clickLogin();
			login.enterPassword("hunter2");
			login.clickLogin();
			HomePage homePage = new HomePage(driver);
			homePage.clickProducts();
    	cart cart = new cart(driver);

        cart.addSingleProductFlow();
        cart.placeOrder();

        Assert.assertTrue(cart.isOrderSuccess(),
                "Order failed");
    }

}