package Autotesting_selenium;

import org.openqa.selenium.By;

interface Variables {
    //Переменные, которые некуда засунуть:)
    int sleep = 2000;
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
    By FORGOT_YOUR_PASSWORD_BUTTON = By.className("login__lin");
    By ERROR_AUTHORIZATION_LOGIN = By.className("form__error");
    String ERROR_LOGIN = "Введите Email";
    By ERROR_AUTHORIZATION_PASSWORD = By.cssSelector(".form__group:nth-of-type(2) .form__error");
    String ERROR_PASSWORD = "Введите пароль";

    //Регистрация
    By EMAIL_REGISTRATION = By.id("register-email");
    By PASSWORD_REGISTRATION = By.id("register-password");
    By PASSWORD_REGISTRATION_2 = By.cssSelector("[for='register-repeat-password']");
    By FIRST_NAME_REGISTRATION = By.className("register-firstName");
    By LAST_NAME_REGISTRATION = By.className("register-lastName");
    By CHECKBOX = By.className("register-confirm");
    By REGISTRATION_BUTTON = By.className("btn--white");
    By DOWN_BUTTON = By.cssSelector("[href='/login']");
    By SUPPORT_BUTTON = By.cssSelector("[href='/support']");
    By LANGUAGE = By.className("active");

    //Забыли пароль
    By EMAIL_PASSWORD_RECOVERY = By.id("forgot-email");
    By LOGIN_PASSWORD_RECOVERY = By.id("btn--white");
    By DOWN_PASSWORD_RECOVERY = By.cssSelector("[href='/login']");
}
