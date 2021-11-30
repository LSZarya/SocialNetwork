package Autotesting_selenium;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Checks extends BeforeAndAfter{

    public void StartSite(String url) throws InterruptedException {
        driver.navigate().to(url);
        Thread.sleep(sleep);
        Assert.assertEquals(TITLE_AUTHORIZATION, driver.getTitle(),"Проверка заголовка");
        Thread.sleep(sleep);
    }

    public void AuthorizationOK(String login, String password) throws InterruptedException {
        driver.findElement(EMAIL_AUTHORIZATION).sendKeys(login);
        Thread.sleep(sleep);
        driver.findElement(PASSWORD_AUTHORIZATION).sendKeys(password);
        Thread.sleep(sleep);
        driver.findElement(LOGIN_BUTTON).click();
        Thread.sleep(3000);
        Assert.assertEquals(TITLE_NEW, driver.getTitle(), "Проверка заголовка");
        Thread.sleep(sleep);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("main-layout__user-pic")));
        driver.findElement(By.cssSelector(".main-layout__sidebar [href='#']")).click();
        Thread.sleep(3000);
    }

    public void AuthorizationFailNoLogin() throws InterruptedException {
        driver.findElement(LOGIN_BUTTON).click();
        Thread.sleep(sleep);
        Assert.assertEquals(driver.findElement(ERROR_AUTHORIZATION_LOGIN).getText(),ERROR_LOGIN);
        Thread.sleep(sleep);
    }

    public void AuthorizationFailNoPassword() throws InterruptedException {
        driver.findElement(LOGIN_BUTTON).click();
        Thread.sleep(sleep);
        Assert.assertEquals(driver.findElement(ERROR_AUTHORIZATION_PASSWORD).getText(),ERROR_PASSWORD);
        Thread.sleep(sleep);
    }

    public void AuthorizationFailPasswordValidation(String password, String error) throws InterruptedException {
        driver.findElement(PASSWORD_AUTHORIZATION).sendKeys(password);
        Thread.sleep(sleep);
        driver.findElement(LOGIN_BUTTON).click();
        Thread.sleep(sleep);
        Assert.assertEquals(driver.findElement(ERROR_AUTHORIZATION_PASSWORD).getText(), error);
        Thread.sleep(sleep);
        driver.findElement(PASSWORD_AUTHORIZATION).sendKeys(Keys.CLEAR);
        Thread.sleep(sleep);
    }

}
