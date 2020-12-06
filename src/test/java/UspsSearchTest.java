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
    public void searchFieldTestPK() throws InterruptedException {

        WebDriver page = new ChromeDriver();
        Actions actions = new Actions(page);
        page.get("https://www.wikipedia.org");
        WebElement language = page.findElement(By.xpath("//a[@id='js-link-box-en']/strong"));
        WebElement searchField = page.findElement(By.xpath("//input[@id='searchInput']"));
        Thread.sleep(3000);
        WebElement result = page.findElement(By.xpath("//span[@class='mw-redirectedfrom']"));


        actions.moveToElement(language)
                .click()
                .moveToElement(searchField)
                .click()
                .sendKeys("Christmas Tree")
                .sendKeys(Keys.ENTER);


        Thread.sleep(3000);
         Assert.assertFalse(result.isDisplayed());
        page.quit();

    }

}



