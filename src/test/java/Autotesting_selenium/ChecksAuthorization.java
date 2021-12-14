package Autotesting_selenium;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class ChecksAuthorization extends BeforeAndAfter{

    public void StartSite(String url){
        driver.navigate().to(url);
        Assert.assertEquals(TITLE_AUTHORIZATION, driver.getTitle(),"Проверка заголовка");
    }

    public void AuthorizationOK(String login, String password){
        driver.findElement(EMAIL_AUTHORIZATION).sendKeys(login);
        driver.findElement(PASSWORD_AUTHORIZATION).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
        Assert.assertEquals(TITLE_NEW, driver.getTitle(), "Проверка заголовка");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("main-layout__user-pic")));
    }

    public void ExitSite(){
        driver.findElement(By.cssSelector(".main-layout__sidebar [href='#']")).click();
        Assert.assertEquals("Мы создали это место, чтобы вы смогли развиваться, чувствую себя максимально комфортно в кругу приятных людей. Это сообщество профессионалов, объединённых одной идеей — с помощью кода, магия станет реальностью!",driver.findElement(By.className("form-layout__text")).getText(),"Текст главной страницы, ниже привет");
    }

    public void AuthorizationFailNoLogin(){
        driver.findElement(LOGIN_BUTTON).click();
        Assert.assertEquals(driver.findElement(ERROR_AUTHORIZATION_LOGIN).getText(),ERROR_LOGIN);
    }

    public void AuthorizationFailNoPassword(){
        driver.findElement(LOGIN_BUTTON).click();
        Assert.assertEquals(driver.findElement(ERROR_AUTHORIZATION_PASSWORD).getText(),ERROR_PASSWORD);
    }

    public void AuthorizationFailPasswordValidation(String password, String error) {
        driver.findElement(PASSWORD_AUTHORIZATION).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
        Assert.assertEquals(driver.findElement(ERROR_AUTHORIZATION_PASSWORD).getText(), error);
        driver.findElement(PASSWORD_AUTHORIZATION).sendKeys(Keys.CLEAR);
    }

    public void AuthorizationEye(String password) {
        driver.findElement(PASSWORD_AUTHORIZATION).sendKeys(password);
        Assert.assertTrue(driver.findElement(BUTTON_PASSWORD_EYE).isDisplayed(),"Кнопка на экране");
        driver.findElement(BUTTON_PASSWORD_EYE).click();
        Assert.assertEquals(driver.findElement(PASSWORD_AUTHORIZATION).getAttribute("value"),password,"Пароль совпадает");
    }

    public void AuthorizationEyePassword(String password) {
        driver.findElement(PASSWORD_AUTHORIZATION).sendKeys(password);
        Assert.assertEquals(driver.findElement(PASSWORD_AUTHORIZATION).getAttribute("value"),password,"Пароль совпадает");
    }

    public void AuthorizationClickRegistration() {
        driver.findElement(Variables.BUTTON_REGISTRATION).click();
        Assert.assertEquals(driver.getTitle(),"Регистрация", "Открыта страница регистрации");
        Assert.assertEquals(driver.findElement(By.tagName("h1")).getText(), "Быстрая регистрация", "Проверка заголовка");
        driver.get(SITE);
    }

    public void AuthorizationClickSupport() {
        driver.findElement(Variables.SUPPORT_BUTTON).click();
        Assert.assertEquals(driver.getTitle(),"Написать в службу поддержки", "Открыта страница поддержки");
        Assert.assertEquals(driver.findElement(By.tagName("h1")).getText(), "Свяжитесь с нами!", "Проверка заголовка");
        driver.get(SITE);
    }

    public void AuthorizationClickRecovery() {
        driver.findElement(Variables.BUTTON_RECOVERY).click();
        Assert.assertEquals(driver.getTitle(),"Востановление", "Открыта страница поддержки");
        Assert.assertEquals(driver.findElement(By.tagName("h1")).getText(), "Восстановление пароля", "Проверка заголовка");
        driver.get(SITE);
    }

    public void AuthorizationClickLanguage() {
        driver.findElement(LANGUAGE).click();
        driver.findElement(LANG_EN).click();
        Assert.assertEquals(driver.findElement(By.tagName("h1")).getText(), "Hello!");
        driver.findElement(LANGUAGE).click();
        driver.findElement(LANG_RU).click();
        Assert.assertEquals(driver.findElement(By.tagName("h1")).getText(), "Привет!");
    }

}
