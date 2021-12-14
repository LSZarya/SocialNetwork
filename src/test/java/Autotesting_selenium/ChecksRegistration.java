package Autotesting_selenium;

import org.openqa.selenium.By;
import org.testng.Assert;

public class ChecksRegistration extends BeforeAndAfter{

    By Error1 = By.cssSelector(".form__block:nth-of-type(1) .form__group:nth-of-type(1) .form__error");
    By Error2 = By.cssSelector(".form__block:nth-of-type(1) .form__group:nth-of-type(2) .form__error");
    By Error3 = By.cssSelector(".form__block:nth-of-type(1) .form__group:nth-of-type(3) .form__error");
    By Error4 = By.cssSelector(".form__block:nth-of-type(2) .form__group:nth-of-type(1) .form__error");
    By Error5 = By.cssSelector(".form__block:nth-of-type(2) .form__group:nth-of-type(2) .form__error");
    By ErrorCheckbox = By.cssSelector(".form__checkbox.invalid");
    By PrivacyPolicy = By.linkText("политикой конфиденциальности");
    By PrivacyPolicyText = By.className("title");
    By BtnClose = By.className("custom-modal-close");
    By BtnAuthorization = By.className("form-layout__btn");

    public void RegistrationOk(String email) throws InterruptedException {
        driver.findElement(EMAIL_REGISTRATION).sendKeys(email);
        driver.findElement(PASSWORD_REGISTRATION).sendKeys("Abc!2222");
        driver.findElement(PASSWORD_REGISTRATION_2).sendKeys("Abc!2222");
        driver.findElement(FIRST_NAME_REGISTRATION).sendKeys("Lev");
        driver.findElement(LAST_NAME_REGISTRATION).sendKeys("Zarya");
        driver.findElement(CHECKBOX).click();
        Thread.sleep(15000);
        driver.findElement(REGISTRATION_BUTTON);
        driver.navigate().refresh();
    }

    public void RegistrationError1() {
        driver.findElement(EMAIL_REGISTRATION).sendKeys("1");
        driver.findElement(PASSWORD_REGISTRATION).sendKeys("1");
        driver.findElement(PASSWORD_REGISTRATION_2).sendKeys("1");
        driver.findElement(FIRST_NAME_REGISTRATION).sendKeys("1");
        driver.findElement(LAST_NAME_REGISTRATION).sendKeys("1");
        driver.findElement(REGISTRATION_BUTTON).click();
        Assert.assertEquals(driver.findElement(Error1).getText(),"Введите корректный Email");
        Assert.assertEquals(driver.findElement(Error2).getText(),"Не соответствует требованиям безопасности");
        Assert.assertEquals(driver.findElement(Error3).getText(),"Пароль должен быть не менее 8 символов. Сейчас он 1");
        Assert.assertEquals(driver.findElement(Error4).getText(),"Минимальное количество символов 3");
        Assert.assertEquals(driver.findElement(Error5).getText(),"Минимальное количество символов 3");
        Assert.assertTrue(driver.findElements(ErrorCheckbox).size() > 0, "Ошибка чекбокса на экране");
        driver.navigate().refresh();
    }

    public void RegistrationError2() {
        driver.findElement(REGISTRATION_BUTTON).click();
        Assert.assertEquals(driver.findElement(Error1).getText(),"Введите Email");
        Assert.assertEquals(driver.findElement(Error2).getText(),"Введите пароль");
        Assert.assertEquals(driver.findElement(Error3).getText(),"Повтоите пароль");
        Assert.assertEquals(driver.findElement(Error4).getText(),"Обязательно поле");
        Assert.assertEquals(driver.findElement(Error5).getText(),"Обязательно поле");
        driver.findElement(PASSWORD_REGISTRATION_2).sendKeys("1");
        Assert.assertEquals(driver.findElement(Error3).getText(),"Пароли должны совпадать");
        driver.navigate().refresh();
    }

    public void RegistrationPrivacyPolicy() {
        driver.findElement(PrivacyPolicy).click();
        Assert.assertEquals(driver.findElement(PrivacyPolicyText).getText(),"ПОЛИТИКА КОНФИДЕНЦИАЛЬНОСТИ");
        driver.findElement(BtnClose).click();
    }

    public void RegistrationBtnAuthorization() {
        driver.findElement(BtnAuthorization).click();
        Assert.assertEquals(driver.findElement(By.tagName("h1")).getText(), "Привет!");
        driver.get("http://45.134.255.54:5000/registration");
    }

    public void RegistrationClickLanguage() {
        driver.findElement(LANGUAGE).click();
        driver.findElement(LANG_EN).click();
        Assert.assertEquals(driver.findElement(By.tagName("h1")).getText(), "Quick registration");
        driver.findElement(LANGUAGE).click();
        driver.findElement(LANG_RU).click();
        Assert.assertEquals(driver.findElement(By.tagName("h1")).getText(), "Быстрая регистрация");
    }

}
