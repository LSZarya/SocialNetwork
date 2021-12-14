package Autotesting_selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class  BeforeAndAfter implements Variables {

    public EventFiringWebDriver driver;
    public WebDriverWait wait;

    @BeforeTest
    public void setUpStart(ITestContext iTestContext){
        WebDriverManager.chromedriver().setup();
        driver = new EventFiringWebDriver(new ChromeDriver());
        driver.register(new MarkBeforeClickListener());
        iTestContext.setAttribute("driver", driver);

        driver.manage().window().maximize();
        driver.navigate().to(SITE);

        wait = new WebDriverWait(driver, 5);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterTest
    public void teamDownEnd(){
        driver.quit();
    }
}
