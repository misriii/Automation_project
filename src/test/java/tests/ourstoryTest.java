package tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.ourstoryPage;

public class ourstoryTest extends BaseTest {
	
	@Test
	public void verifyOurStoryNavigation() {
		HomePage home = new HomePage(driver);
	    home.clickOurStory();

	    Assert.assertTrue(driver.getCurrentUrl().contains("about"),
	            "Navigation to Our Story failed");
	}
	
	@Test
	public void verifyOurStoryTitle() {
	    HomePage home = new HomePage(driver);
	    home.clickOurStory();

	    ourstoryPage page = new ourstoryPage(driver);

	    System.out.println("Actual Title: " + page.getPageTitle());

	    Assert.assertTrue(
	        page.getPageTitle().trim().equalsIgnoreCase("OUR STORY"),
	        "Title mismatch"
	    );
	}
	
	@Test
	public void verifyVideoDisplayed() {
	    HomePage home = new HomePage(driver);
	    home.clickOurStory();

	    ourstoryPage page = new ourstoryPage(driver);

	    Assert.assertTrue(page.isVideoDisplayed(),
	            "Video is not displayed");
	}
	
	@Test
	public void verifyImageDisplayed() {
	    HomePage home = new HomePage(driver);
	    home.clickOurStory();

	    ourstoryPage page = new ourstoryPage(driver);

	    Assert.assertTrue(page.isImageDisplayed(),
	            "Image not displayed");
	}
}
