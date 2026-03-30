package tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;

public class MyAccountTest extends BaseTest {

  @Test 
  public void myAccountPageNavigation() {
	  LoginPage login = new LoginPage(driver);
		login.profileClick();
		login.enterUsername("carlos");
		login.clickLogin();
		login.enterPassword("hunter2");
		login.clickLogin();
		Assert.assertTrue(driver.getCurrentUrl().contains("my-account"));
  }
  
  @Test 
  public void OrdersDisplay() {
  LoginPage login = new LoginPage(driver);
	login.profileClick();
	login.enterUsername("carlos");
	login.clickLogin();
	login.enterPassword("hunter2");
	login.clickLogin();
  MyAccountPage page = new MyAccountPage(driver);
  Assert.assertTrue(page.getOrdersCount() > 0,
          "Orders not displayed");
  
  }
  
 @Test
  public void OrdersScroll() {
	  LoginPage login = new LoginPage(driver);
		login.profileClick();
		login.enterUsername("carlos");
		login.clickLogin();
		login.enterPassword("hunter2");
		login.clickLogin();
		MyAccountPage page = new MyAccountPage(driver);
		page.scrollDown();
  }
 
 @Test
 public void ViewDetails() {
	  LoginPage login = new LoginPage(driver);
		login.profileClick();
		login.enterUsername("carlos");
		login.clickLogin();
		login.enterPassword("hunter2");
		login.clickLogin();
		MyAccountPage page = new MyAccountPage(driver);
		page.openOrderDetails();

		Assert.assertTrue(driver.getCurrentUrl().contains("order/details"),
        "Order details navigation failed");
 }
 
@Test
 public void orderNumberDisplay() {
	  LoginPage login = new LoginPage(driver);
		login.profileClick();
		login.enterUsername("carlos");
		login.clickLogin();
		login.enterPassword("hunter2");
		login.clickLogin();
		MyAccountPage page = new MyAccountPage(driver);
		page.openOrderDetails();
		Assert.assertTrue(page.getOrderNumber().contains("Order no:"),
         "Order number missing");

}

@Test
public void productNameDisplay() {
	  LoginPage login = new LoginPage(driver);
		login.profileClick();
		login.enterUsername("carlos");
		login.clickLogin();
		login.enterPassword("hunter2");
		login.clickLogin();
		MyAccountPage page = new MyAccountPage(driver);
		page.openOrderDetails();
		Assert.assertFalse(page.getProductName().isEmpty(),
		          "Product name missing");
}

@Test
public void paymentDisplay() {
	  LoginPage login = new LoginPage(driver);
		login.profileClick();
		login.enterUsername("carlos");
		login.clickLogin();
		login.enterPassword("hunter2");
		login.clickLogin();
		MyAccountPage page = new MyAccountPage(driver);
		page.openOrderDetails();
		Assert.assertTrue(page.getPaymentMethod().contains("****"),
		          "Card details exposed");
}
@Test
public void billingAddressDisplay() {
	  LoginPage login = new LoginPage(driver);
		login.profileClick();
		login.enterUsername("carlos");
		login.clickLogin();
		login.enterPassword("hunter2");
		login.clickLogin();
		MyAccountPage page = new MyAccountPage(driver);
		page.openOrderDetails();
		Assert.assertTrue(page.isBillingDisplayed(),
		          "Billing address missing");
}
@Test
public void shippingAddressDisplay() {
	  LoginPage login = new LoginPage(driver);
		login.profileClick();
		login.enterUsername("carlos");
		login.clickLogin();
		login.enterPassword("hunter2");
		login.clickLogin();
		MyAccountPage page = new MyAccountPage(driver);
		page.openOrderDetails();
		Assert.assertTrue(page.isShippingDisplayed(),
		          "Shipping address missing");
}

}
