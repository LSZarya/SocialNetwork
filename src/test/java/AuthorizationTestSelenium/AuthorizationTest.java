package AuthorizationTestSelenium;

import Autotesting_selenium.Checks;
import org.testng.annotations.Test;


public class AuthorizationTest extends Checks{

    @Test
    public void Social_StartSite_Test() throws InterruptedException {
        StartSite(SITE);
    }

    @Test
    public void Social_Authorization_TestOK() throws InterruptedException {
        AuthorizationOK(LOGIN, PASSWORD);

    }

    @Test
    public void Social_Authorization_FailLogin() throws InterruptedException {
        AuthorizationFailNoLogin();
    }

    @Test
    public void Social_Authorization_FailNoPassword() throws InterruptedException {
        AuthorizationFailNoPassword();
    }

    @Test
    public void Social_Authorization_FailPasswordValidation1() throws InterruptedException {
        AuthorizationFailPasswordValidation("1", "Пароль должен быть не менее 8 символов. Сейчас он 1");
    }

    @Test
    public void Social_Authorization_FailPasswordValidation2() throws InterruptedException {
        AuthorizationFailPasswordValidation("123", "Пароль должен быть не менее 8 символов. Сейчас он 3");
    }

    @Test
    public void Social_Authorization_FailPasswordValidation3() throws InterruptedException {
            AuthorizationFailPasswordValidation("1234567", "Пароль должен быть не менее 8 символов. Сейчас он 7");
    }


}
