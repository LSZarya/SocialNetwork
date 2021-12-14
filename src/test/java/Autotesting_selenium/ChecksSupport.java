package Autotesting_selenium;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChecksSupport extends BeforeAndAfter{

    By BtnAuthorization = By.className("form-layout__btn");

    By email = By.id("support-feedback");
    By inputMessage = By.id("support-message");
    By btnSend = By.className("btn--white");
    By error = By.className("form__error");


    public void SupportOk() {
        driver.findElement(email).sendKeys("levagoL@sdfk.ru");
        driver.findElement(inputMessage).sendKeys("jjbfbjjbfdjbfkjbbfjbfkjbfjbfd_23");
        driver.findElement(btnSend).click();
    }

    public void SupportError() {
        driver.findElement(email).sendKeys("1");
        driver.findElement(btnSend).click();
        Assert.assertEquals(driver.findElement(error).getText(), "Введите корректный Email", "Ошибка на экране");
    }

    public void SupportBtnAuthorization() {
        driver.findElement(BtnAuthorization).click();
        Assert.assertEquals(driver.findElement(By.tagName("h1")).getText(), "Привет!");
        driver.get("http://45.134.255.54:5000/support");
    }

    @Test
    public void SupportClickLanguage() {
        driver.findElement(LANGUAGE).click();
        driver.findElement(LANG_EN).click();
        driver.findElement(LANGUAGE).click();
        driver.findElement(LANG_RU).click();
        Assert.assertEquals(driver.findElement(By.tagName("h1")).getText(), "Свяжитесь с нами!");
    }
}
