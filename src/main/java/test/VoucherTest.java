package test;

import base.BaseTest;
import org.testng.annotations.Test;
import page.LoginPage;
import page.VoucherPage;


public class VoucherTest extends BaseTest {
    @Test(priority = 1)
    public static void testInsertVoucherSuccess() throws Exception {
        LoginPage.login("guest", "123456");
        VoucherPage.InsertVoucherSuccess("SALE12", "SALE 12/12", "12", "100000",
                "10", "100000", "10", "Giảm giá phần trăm", "2024", "July",
                "12", "2024", "July", "15", "isPublic", "Đã thành công");
        Thread.sleep(30000);
    }

    @Test(priority = 2)
    public static void testInsertVoucherIsEmpty() throws Exception {
        LoginPage.login("guest", "123456");
        VoucherPage.InsertVoucherInvalid(""
        );
        Thread.sleep(5000);
    }
}
