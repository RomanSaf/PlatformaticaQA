import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

import javax.swing.*;
import java.beans.Visibility;
import java.security.Key;

public class UspsSearchTest extends BaseTest {

    @Test
    public void searchTest() throws InterruptedException {

        WebDriver page = new ChromeDriver();
        page.get("https://www.usps.com");
        Actions actions = new Actions(page);
        WebElement search = page.findElement(By.xpath("//a[contains(text(),'Search USPS.com')]"));
        WebElement searchField = page.findElement(By.xpath("//input[@id='global-header--search-track-search']"));

        actions.moveToElement(search)
                .moveToElement(searchField)
                .sendKeys("Christmas Tree")
                .sendKeys(Keys.ENTER)
                .perform();

        Thread.sleep(3000);

//        Assert.assertFalse(searchField.getText(), "Christmas Tree");
        page.quit();

    }


}
