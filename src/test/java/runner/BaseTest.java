package runner;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public abstract class BaseTest {  //abstract - создан только для наследования

    public static final String HUB_URL = "http://localhost:4444/wd/hub";

    private static boolean remoteWebDriver = false; //в этой части тест понимает откуда ему запускаться-с remote или local. выполнится 1 раз и до теста
    static {
        try {
            HttpURLConnection con = (HttpURLConnection) new URL(HUB_URL + "/status").openConnection();
            try {
                con.setRequestMethod("GET");
                remoteWebDriver = con.getResponseCode() == HttpURLConnection.HTTP_OK;
            } finally {
                con.disconnect();
            }
        } catch (IOException ignore) {}

        if (!remoteWebDriver) {
            WebDriverManager.chromedriver().setup();   //создали Web Driver
        }
    }

    private WebDriver driver;

    @BeforeMethod
    protected void setUpAll() {

        if (remoteWebDriver) {   //если поле remoteWebDriver-true-выполняем тело цикла(создается RemoteWebDriver), а если false - создаем WebDriver
            try {
                this.driver = new RemoteWebDriver(new URL(HUB_URL), DesiredCapabilities.chrome());
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
        } else {
            this.driver = new ChromeDriver();
        }

        this.driver.manage().window().maximize();
    }

    @AfterMethod
    protected void setDownAll() {
        driver.quit();
    }

    protected WebDriver getDriver() {
        return driver;
    }
}
