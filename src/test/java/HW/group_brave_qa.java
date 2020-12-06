package HW;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

public class group_brave_qa<th> extends BaseTest {

    @Test
    public void VictoriaRet() throws InterruptedException {

        WebDriver browser = getDriver();
        browser.get("https://www.ebay.com/");

        WebElement shop = browser.findElement(By.xpath("//*[@id='gh-shop-a']"));
        Assert.assertTrue(shop.isDisplayed());

        WebElement search = browser.findElement(By.xpath("//*[@class='gh-tb ui-autocomplete-input']"));
        search.sendKeys("dress");
        WebElement searchButton = browser.findElement(By.xpath("//*[@id='gh-btn']"));
        searchButton.click();

        Thread.sleep(3000);

        browser.quit();

    }

}
