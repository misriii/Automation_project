package pages;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class ourstoryPage {

    WebDriver driver;
    WebDriverWait wait;

    public ourstoryPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Locators
    By ourStoryTitle = By.xpath("//h1[normalize-space()='OUR STORY']");
    By video = By.tagName("video");
    By playButton = By.xpath("//button[contains(@aria-label,'Play')]");
    By contentSection = By.xpath("//h2[contains(text(),'The purple menace')]");
    By image = By.xpath("//img");
    By subscribeSection = By.xpath("//h2[contains(text(),'Subscribe')]");

    // Methods

    public String getPageTitle() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(ourStoryTitle)).getText();
    }

    public boolean isVideoDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(video)).isDisplayed();
    }

    public boolean isContentVisible() {
        return driver.findElement(contentSection).isDisplayed();
    }

    public boolean isImageDisplayed() {
        return driver.findElement(image).isDisplayed();
    }

    public boolean isSubscribeVisible() {
        return driver.findElement(subscribeSection).isDisplayed();
    }
}