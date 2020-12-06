import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

import java.security.Key;

public class GroupBreakingBad extends BaseTest {

    public WebDriverWait getWait() {
        return new WebDriverWait(getDriver(), 10);

    }

    protected void waitForVisible(WebElement element) {
        getWait().until(ExpectedConditions.visibilityOf(element));
    }

    @Test
    public void nataliaVats() throws InterruptedException {

        WebDriver driver = getDriver();
        driver.get("https://www.aerotek.com/en/");

        WebElement button = driver.findElement(By.xpath("(//button[contains(text(), 'SEARCH')])[2]"));
        button.click();
        Thread.sleep(3000);

        WebElement input = driver.findElement(By.xpath("//input[contains(@class, 'ph-a11y-location-box')]"));
        Assert.assertEquals(input.getAttribute("placeholder"), "Enter City, State or Zip");
    }


    @Test
    public void searchFieldTestPK() throws InterruptedException {

        WebDriver driver = getDriver();
        Actions actions = new Actions(driver);
        driver.get("https://www.wikipedia.org");

        WebElement language = driver.findElement(By.xpath("//strong[contains(text(),'English')]"));
        WebElement search = driver.findElement(By.xpath("//input[@id='searchInput']"));

        language.click();
        actions
                .sendKeys(search, "Selenium Webdriver")
                .sendKeys(Keys.ENTER)
                .perform();

        driver.quit();

    }

}
