package tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.blogPage;

public class blogTest extends BaseTest {
	
	@Test
	public void verifyBlogNavigation() {
		HomePage homePage = new HomePage(driver);
		homePage.clickBlog();
		WebElement title = driver.findElement(By.xpath("//h1[normalize-space()='Blog']"));
		Assert.assertTrue(driver.getCurrentUrl().contains("blog"));	
		
	}
	
	@Test
	public void verifyViewPostNavigation() {
	    HomePage homePage = new HomePage(driver);
	    homePage.clickBlog();

	    blogPage blog = new blogPage(driver);

	    blog.scrollToViewPost();
	    blog.clickFirstBlog();

	    Assert.assertTrue(driver.getCurrentUrl().contains("post"));
	}
	
	
	@Test
	public void verifySearchValid() {
	    HomePage homePage = new HomePage(driver);
	    homePage.clickBlog();

	    blogPage blog = new blogPage(driver);

	    blog.searchBlog("The Complaint");

	    int count = blog.getBlogCount();
	    System.out.println("Result count: " + count);

	    Assert.assertTrue(count > 0, "No results found");
	}
	
	@Test
	public void verifySearchInvalid() {

	    HomePage homePage = new HomePage(driver);
	    homePage.clickBlog();

	    blogPage blog = new blogPage(driver);

	    blog.searchBlog("xyz123");

	    int count = blog.getBlogCount();

	    Assert.assertTrue(
	            count == 0 || driver.getPageSource().contains("Sorry! No result found"),
	            "Search invalid failed"
	    );
	}
	
	@Test
	public void verifySearchEmpty() {
	    HomePage homePage = new HomePage(driver);
	    homePage.clickBlog();

	    blogPage blog = new blogPage(driver);

	    blog.searchBlog("");

	    Assert.assertTrue(blog.getBlogCount() >= 0);
	}
	


}