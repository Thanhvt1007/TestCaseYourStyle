package test;

import base.BaseSetup;
import base.BaseTest;
import org.testng.annotations.Test;
import page.LoginPage;

public class LoginTest extends BaseTest {
    static LoginPage loginPage = new LoginPage(BaseSetup.driver);

    //test login success
    @Test
    public static void loginByAdmin() {
        loginPage.login("guest", "123456");
    }

    //test login invalid user
    @Test
    public static void loginInvalidUserName() {
        loginPage.loginInvalid("Vothithan", "123456");
    }

    //test login invalid pass
    @Test
    public static void loginInvalidPassWord() {
        loginPage.loginInvalid("Vothithanh", "123479");
    }

    //test login empty username
    @Test
    public static void loginEmptyUserName() {
        loginPage.loginInvalidEmptyUserName("", "123456");
    }

    //test login empty password
    @Test
    public static void loginEmptyPassWord() {
        loginPage.loginInvalidEmptyPassWord("Vothithanh", "");
    }
}
   



