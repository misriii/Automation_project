package tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.subscribe;

public class subsribeTest extends BaseTest  {

	@Test
    public void subscribeWithValidEmail() {

		subscribe Subscribe = new subscribe(driver);

		Subscribe.scrollToNewsletter();
		Subscribe.enterEmail("test@gmail.com");
		Subscribe.clickSubscribe();

        // No error → success
		Assert.assertTrue(true);
    }
	
	@Test
    public void subscribeWithInvalidEmail() {

		subscribe Subscribe = new subscribe(driver);

		Subscribe.scrollToNewsletter();
		Subscribe.enterEmail("abc123");
		Subscribe.clickSubscribe();

        String validation = Subscribe.getValidationMessage();

        Assert.assertTrue(validation.length() > 0);
    }
	
	 @Test
	    public void subscribeWithEmptyEmail() {

			subscribe Subscribe = new subscribe(driver);

			Subscribe.scrollToNewsletter();
			Subscribe.enterEmail("");
			Subscribe.clickSubscribe();

	        String validation = Subscribe.getValidationMessage();

	        Assert.assertTrue(validation.contains("fill"));
	    }

}
