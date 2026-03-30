package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class blogPage {
	
	WebDriver driver;
	WebDriverWait wait;

	public blogPage(WebDriver driver) {
		this.driver=driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
	}
		
		// Locators
		By viewPostBtns = By.xpath("//a[contains(text(),'View post')]");
		By blogTitle = By.xpath("//h1[normalize-space()='Blog']");
		By blogContent = By.tagName("p");
		By searchBox = By.name("search");
		By blogCards = By.xpath("//div[@class='blog-post']");
		
		public void scrollToViewPost() {
		    List<WebElement> buttons = wait.until(
		        ExpectedConditions.visibilityOfAllElementsLocatedBy(viewPostBtns)
		    );

		    ((JavascriptExecutor) driver).executeScript(
		        "arguments[0].scrollIntoView({block:'center'});",
		        buttons.get(0)
		    );
		}

		public void clickFirstBlog() {
		    List<WebElement> buttons = wait.until(
		        ExpectedConditions.visibilityOfAllElementsLocatedBy(viewPostBtns)
		    );

		    WebElement btn = buttons.get(0);
		    wait.until(ExpectedConditions.elementToBeClickable(btn)).click();
		}
		
	    public String getBlogTitle() {
	        return wait.until(ExpectedConditions.visibilityOfElementLocated(blogTitle)).getText();
	    }

	   
	    
	    public void searchBlog(String text) {

	        WebElement search = wait.until(
	                ExpectedConditions.visibilityOfElementLocated(searchBox)
	        );

	        search.clear();
	        search.sendKeys(text);
	        search.sendKeys(Keys.ENTER);

	        wait.until(ExpectedConditions.or(
	                ExpectedConditions.presenceOfAllElementsLocatedBy(
	                        By.cssSelector("a[href*='post']")
	                ),
	                ExpectedConditions.visibilityOfElementLocated(
	                        By.xpath("//*[contains(text(),'Sorry! No result found')]")
	                )
	        ));	    }
	    
	    
	    public int getBlogCount() {

	        wait.until(ExpectedConditions.or(
	                ExpectedConditions.presenceOfAllElementsLocatedBy(
	                        By.cssSelector("a[href*='post']")
	                ),
	                ExpectedConditions.visibilityOfElementLocated(
	                        By.xpath("//*[contains(text(),'Sorry! No result found')]")
	                )
	        ));

	        return driver.findElements(By.cssSelector("a[href*='post']")).size();
	    }
	    
		
	
}
