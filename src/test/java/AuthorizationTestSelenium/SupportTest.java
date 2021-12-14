package AuthorizationTestSelenium;

import Autotesting_selenium.ChecksSupport;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SupportTest extends ChecksSupport {

    @BeforeClass
    public void Up(){
        driver.get("http://45.134.255.54:5000/support");
    }

    @Test
    public void Social_Support_Ok() {
        SupportOk();
        driver.navigate().refresh();
    }

    @Test
    public void Social_Support_Error(){
        SupportError();
        driver.navigate().refresh();
    }

    @Test
    public void Social_Support_BtnAuthorization(){
        SupportBtnAuthorization();
    }

    @Test
    public void Social_Support_Language(){
        SupportClickLanguage();
    }
}
