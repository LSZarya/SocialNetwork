package Autotesting_selenium;

import org.openqa.selenium.By;

interface Variables {
    //Переменные, которые некуда засунуть:)
    String TITLE_NEW = "Новости";
    String SITE = "http://45.134.255.54:5000";

    //Авторизация
    String LOGIN = "levagoli@mail.ru";
    String PASSWORD = "1234567a";

    String TITLE_AUTHORIZATION = "Авторизация";
    By BUTTON_REGISTRATION = By.cssSelector("[href='/registration']");
    By EMAIL_AUTHORIZATION = By.id("login-email");
    By PASSWORD_AUTHORIZATION = By.id("login-password");
    By LOGIN_BUTTON = By.cssSelector("[type='submit']");
    By ERROR_AUTHORIZATION_LOGIN = By.className("form__error");
    String ERROR_LOGIN = "Введите Email";
    By ERROR_AUTHORIZATION_PASSWORD = By.cssSelector(".form__group:nth-of-type(2) .form__error");
    String ERROR_PASSWORD = "Введите пароль";
    By BUTTON_PASSWORD_EYE = By.className("form__password-icon");
    By BUTTON_RECOVERY = By.className("login__link");

    //Регистрация
    By EMAIL_REGISTRATION = By.id("register-email");
    By PASSWORD_REGISTRATION = By.id("register-password");
    By PASSWORD_REGISTRATION_2 = By.id("register-repeat-password");
    By FIRST_NAME_REGISTRATION = By.id("register-firstName");
    By LAST_NAME_REGISTRATION = By.id("register-lastName");
    By CHECKBOX = By.id("register-confirm");
    By REGISTRATION_BUTTON = By.className("btn--white");
    By SUPPORT_BUTTON = By.cssSelector("[href='/support']");
    By LANGUAGE = By.className("active");
    By LANG_RU = By.cssSelector("li:nth-of-type(1)");
    By LANG_EN = By.cssSelector("li:nth-of-type(2)");

    //Забыли пароль
    By EMAIL_PASSWORD_RECOVERY = By.id("forgot-email");
    By LOGIN_PASSWORD_RECOVERY = By.id("btn--white");
    By DOWN_PASSWORD_RECOVERY = By.cssSelector("[href='/login']");
}
