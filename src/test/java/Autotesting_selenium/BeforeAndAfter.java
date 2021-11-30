package Autotesting_selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class  BeforeAndAfter implements Variables {
    public WebDriver driver;
    public WebDriverWait wait;

    @BeforeTest
    public void setUpStart(){
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(SITE);

        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterMethod
    public void teamDown(){
        driver.navigate().refresh();
    }

    @AfterTest
    public void teamDownEnd() throws InterruptedException {
        Thread.sleep(sleep);
        driver.quit();
    }

}
