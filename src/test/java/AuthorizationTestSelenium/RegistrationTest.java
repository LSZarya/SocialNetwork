package AuthorizationTestSelenium;

import Autotesting_selenium.ChecksRegistration;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RegistrationTest extends ChecksRegistration {

    @BeforeClass
    public void Up(){
        driver.get("http://45.134.255.54:5000/registration");
    }

    @Test (enabled = false)
    public void Social_Registration_Ok() throws InterruptedException {
        RegistrationOk("LevaKrasava@mail.ru");
    }

    @Test
    public void Social_Registration_Error1() {
        RegistrationError1();
    }

    @Test
    public void Social_Registration_Error2() {
        RegistrationError2();
    }

    @Test
    public void Social_Registration_PrivacyPolicy() {
        RegistrationPrivacyPolicy();
    }

    @Test
    public void Social_Registration_BtnAuthorization(){
        RegistrationBtnAuthorization();
    }

    @Test
    public void Social_Registration_Language(){
        RegistrationClickLanguage();
    }
}
