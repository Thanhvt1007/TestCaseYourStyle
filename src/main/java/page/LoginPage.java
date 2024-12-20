package page;

import base.BaseSetup;
import org.openqa.selenium.*;
import org.testng.Assert;
import untils.WaitFor;

public class LoginPage {
    WebDriver driver;

    static String inputUserName = "//input[@name='username']";
    static String inputPassword = "//input[@name='password']";
    //element error
    static String actucalResult = "//div[contains(@class,'swal2-popup swal2-modal swal2-icon-warning swal2-show')]/div[text()='Tên đăng nhập hoặc mật khẩu không đúng.']";
    //element empty username
    static String messageInvalidEmptyUserName = "body.ng-scope:nth-child(2) section.py-5.container:nth-child(3) section.login-section:nth-child(1) div.login-container.row.mx-auto div.login-form.col-md-6 div.input-container:nth-child(3) form.ng-pristine.ng-valid.was-validated div.form-outline.py-2.my-3:nth-child(1) > div.invalid-feedback";
    //element empty password
    static String getMessageInvalidEmptyPassword = "/html[1]/body[1]/section[3]/section[1]/div[1]/div[1]/div[2]/form[1]/div[2]/div[1]";

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public static void login(String username, String password) {
        try {
            WebElement ipUserName = WaitFor.waitElementVisible(BaseSetup.driver, By.xpath(inputUserName));
            ipUserName.sendKeys(username);
            WebElement ipPassWord = WaitFor.waitElementVisible(BaseSetup.driver, By.xpath(inputPassword));
            ipPassWord.sendKeys(password);
            ipPassWord.sendKeys(Keys.ENTER);
            Thread.sleep(10000);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //Invalid username or password
    public static void loginInvalid(String username, String password) {
        try {
            login(username, password);
            WebElement actualResultInvalid = WaitFor.waitElementVisible(BaseSetup.driver, By.xpath(actucalResult));
            String actualResultNotice = actualResultInvalid.getText();
            System.out.println("Actual Result" + actualResultNotice);
            Assert.assertEquals(actualResultNotice, "Tên đăng nhập hoặc mật khẩu không đúng.", "Actual results and expected results are not the same");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    //Invalid  empty username
    public static void loginInvalidEmptyUserName(String username, String password) {
        try {
            WebElement ipUserName = WaitFor.waitElementVisible(BaseSetup.driver, By.xpath(inputUserName));
            ipUserName.sendKeys(username);
            WebElement ipPassWord = WaitFor.waitElementVisible(BaseSetup.driver, By.xpath(inputPassword));
            ipPassWord.sendKeys(password);
            ipPassWord.sendKeys(Keys.ENTER);
            String validationMessage = ipUserName.getAttribute("validationMessage");
            System.out.println(validationMessage);
            Assert.assertEquals(validationMessage, "Please fill out this field.", "The validation message of Email field not match.");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //Invalid  empty password
    public static void loginInvalidEmptyPassWord(String username, String password) {
        try {
            WebElement ipUserName = WaitFor.waitElementVisible(BaseSetup.driver, By.xpath(inputUserName));
            ipUserName.sendKeys(username);
            WebElement ipPassWord = WaitFor.waitElementVisible(BaseSetup.driver, By.xpath(inputPassword));
            ipPassWord.sendKeys(password);
            ipPassWord.sendKeys(Keys.ENTER);
            String validationMessage =  ipPassWord.getAttribute("validationMessage");
            System.out.println(validationMessage);
            Assert.assertEquals(validationMessage, "Please fill out this field.", "The validation message of Email field not match.");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
