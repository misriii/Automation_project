package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		wait=new WebDriverWait(driver, Duration.ofSeconds(15));
	}
	
	//Locators
	
	By profileIcon=By.xpath("//a[contains(@class,'account-icon')]");
	By userNameField = By.xpath("//input[@placeholder='Username']");
	By passwordField = By.xpath("//input[@placeholder='Password']");
	By loginBtn = By.xpath("//button[@type='submit' and normalize-space()='Log in']");
	By logoutBtn = By.xpath("//a[@href='/logout']");
	
	By profileIconAfterLogin = By.cssSelector("a.account-icon");

	public boolean isLoginSuccessful() {
	    return wait.until(
	            ExpectedConditions.visibilityOfElementLocated(profileIconAfterLogin)
	    ).isDisplayed();
	}
	
	public void profileClick() {
		driver.findElement(profileIcon).click();
	}
	
	public void enterUsername(String user) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(userNameField)).sendKeys(user);
	}
	
	public void enterPassword(String pass) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField)).sendKeys(pass);
	}
	
	public void clickLogin() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginBtn)).click();
	}
	
	
	public void logout() {

	    WebElement profile = wait.until(
	        ExpectedConditions.visibilityOfElementLocated(profileIcon)
	    );

	    Actions actions = new Actions(driver);
	    actions.moveToElement(profile).perform();

	    WebElement logout = wait.until(
	        ExpectedConditions.elementToBeClickable(logoutBtn)
	    );

	    logout.click();
	}
	
    public String getUrl() {
        return driver.getCurrentUrl();
    }
    

}

