package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class subscribe {
	
	
WebDriver driver;
WebDriverWait wait;


	public subscribe(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
	}
	
	
		 By emailField = By.name("email");
		 By subscribeButton = By.xpath("//button[normalize-space()='Subscribe']");
		 
		 public void scrollToNewsletter() {
		        WebElement email = wait.until(
		                ExpectedConditions.visibilityOfElementLocated(emailField));

		        ((JavascriptExecutor) driver).executeScript(
		                "arguments[0].scrollIntoView({block:'center'});", email);
		    }

		 
		
		 public void enterEmail(String email) {
		     driver.findElement(emailField).clear();
		     driver.findElement(emailField).sendKeys(email);
		 }

		
		
		 public void clickSubscribe() {
		     driver.findElement(subscribeButton).click();
		 }


		 
		    public String getValidationMessage() {
		        return driver.findElement(emailField).getAttribute("validationMessage");
		    }

	}


