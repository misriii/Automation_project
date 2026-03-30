
package tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;

public class LoginTest extends BaseTest {

	
	@Test
	public void verifyValidLogin() {

	    LoginPage login = new LoginPage(driver);

	    login.profileClick();
	    login.enterUsername("carlos");
	    login.clickLogin();
	    login.enterPassword("hunter2");
	    login.clickLogin();

	    Assert.assertTrue(login.isLoginSuccessful(),
	            "Valid login failed");
	}
	
	@Test
	public void InvalidUsername() {
		LoginPage login = new LoginPage(driver);
		login.profileClick();
		login.enterUsername("rlos");
		login.clickLogin();
		login.enterPassword("hunter2");
		login.clickLogin();	
		Assert.assertEquals("Invalid username or password.", "Invalid username or password.");
		}
	
	
	@Test
	public void InvalidPassword() {
		LoginPage login = new LoginPage(driver);
		login.profileClick();
		login.enterUsername("carlos");
		login.clickLogin();
		login.enterPassword("wrong");
		login.clickLogin();
		String actualError=null;
		Assert.assertEquals("Invalid username or password.", "Invalid username or password.");
		}
	
	@Test
	public void blankInput() {
		LoginPage login = new LoginPage(driver);
		login.profileClick();
		login.clickLogin();
		Assert.assertEquals("Please fill in this field.", "Please fill in this field.");
	}
	
	@Test
    public void testLogout() {

        LoginPage login = new LoginPage(driver);

        // Open login page
        login.profileClick();

        // Login flow (correct order)
        login.enterUsername("carlos");
        login.clickLogin();
        login.enterPassword("hunter2");
        login.clickLogin();

        login.logout();

        Assert.assertTrue(driver.getCurrentUrl().contains("https://ginandjuice.shop/"),
                "Logout failed");

	}
	
	}
	
	
	

	
	
	
	 
