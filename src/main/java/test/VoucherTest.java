package test;

import base.BaseTest;
import org.testng.annotations.Test;
import page.LoginPage;
import page.VoucherPage;


public class VoucherTest extends BaseTest {
    @Test(priority = 1)
    public static void testInsertVoucherSuccess() throws Exception {
        LoginPage.login("guest", "123456");
        Thread.sleep(5000);
        VoucherPage.InsertVoucherSuccess("SALE1", "SALE 1/1", "12", "100000",
                "10", "100000", "10", "Giảm giá phần trăm", "2024", "July",
                "12", "2024", "July", "15", "isPublic", "Đã thành công");
//        Thread.sleep(50000);
    }

    @Test(priority = 2)
    public static void testInsertVoucherIsEmpty() throws Exception {
        LoginPage.login("guest", "123456");
        VoucherPage.InsertVoucherInvalid(""
        );
        Thread.sleep(5000);
    }

    @Test(priority = 3)
    public static void testFindVoucherByName() throws Exception {
        LoginPage.login("guest", "123456");
        VoucherPage.findVoucherSuccessByName("SALE 12/12");
        Thread.sleep(5000);
    }

    @Test(priority = 4)
    public static void testFilterVoucherByStatus() throws Exception {
        LoginPage.login("guest", "123456");
        VoucherPage.filterVoucherByStatus("Công khai");
        Thread.sleep(5000);
    }

    @Test(priority = 5)
    public static void testFilterVoucherByType() throws Exception {
        LoginPage.login("guest", "123456");
        VoucherPage.filterVoucherByType("Giảm giá trực tiếp");
        Thread.sleep(5000);
    }
}
