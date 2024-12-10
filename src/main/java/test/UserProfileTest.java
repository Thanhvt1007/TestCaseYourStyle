package test;

import base.BaseSetup;
import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import page.LoginPage;
import page.UserProfilePage;
import untils.WaitFor;

public class UserProfileTest extends BaseTest {
    static String birthdayInputXpath = "//body/section[3]/section[1]/div[2]/form[1]/div[2]/div[1]/div[3]/input[1]";
    static String clickProfile = "//img[@class='rounded-circle']";
    static String clickUsertoPage = "//li/a[contains(@href,'/yourstyle/accounts/profile?type=')]";

    @Test
    public static void testInsertInformationUser() {
        try {
            LoginPage.login("Vothithanh", "123456");
            UserProfilePage.UserProfileDetailInsertSuccess("Downloads//anh-cua-shin-1.jpg","0","VT Thanh","0349226904");
        } catch (Exception ex) {
            System.out.println("hi" + ex);
        }

    }
}
