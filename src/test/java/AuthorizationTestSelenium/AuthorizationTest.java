package AuthorizationTestSelenium;

import Autotesting_selenium.ChecksAuthorization;
import org.testng.annotations.Test;


public class AuthorizationTest extends ChecksAuthorization {

    @Test
    public void Social_StartSite_Test() {
        StartSite(SITE);
    }

    @Test (enabled = false)
    public void Social_Authorization_TestOK() {
        AuthorizationOK(LOGIN, PASSWORD);
        ExitSite();
    }

    @Test
    public void Social_Authorization_FailLogin() {
        AuthorizationFailNoLogin();
    }

    @Test
    public void Social_Authorization_FailNoPassword()  {
        AuthorizationFailNoPassword();
    }

    @Test
    public void Social_Authorization_FailPasswordValidation1() {
        AuthorizationFailPasswordValidation("1", "Пароль должен быть не менее 8 символов. Сейчас он 1");
        driver.navigate().refresh();
    }

    @Test
    public void Social_Authorization_FailPasswordValidation2() {
        AuthorizationFailPasswordValidation("123", "Пароль должен быть не менее 8 символов. Сейчас он 3");
        driver.navigate().refresh();
    }

    @Test
    public void Social_Authorization_FailPasswordValidation3() {
        AuthorizationFailPasswordValidation("1234567", "Пароль должен быть не менее 8 символов. Сейчас он 7");
        driver.navigate().refresh();
    }

    @Test
    public void Social_Authorization_Eye(){
        AuthorizationEye("kjbmfd");
    }

    @Test
    public void Social_Authorization_ButtonRegistration(){
        AuthorizationClickRegistration();
    }

    @Test
    public void Social_Authorization_ButtonSupport(){
        AuthorizationClickSupport();
    }

    @Test
    public void Social_Authorization_ButtonRecovery(){
        AuthorizationClickRecovery();
    }

    @Test
    public void Social_Authorization_Language(){
        AuthorizationClickLanguage();
    }

}
