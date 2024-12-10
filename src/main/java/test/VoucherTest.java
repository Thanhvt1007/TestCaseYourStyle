package test;

import page.LoginPage;
import page.VoucherPage;

public class VoucherTest {
    public static void testInsertVoucherSuccess(){
        LoginPage.login("guest","123456");
        VoucherPage.InsertVoucherSuccess("SALE12","SALE 12/12","10","100000","10","100000","10","Giảm giá phần trăm","2024","July","12","2024","July","15","isPublic","Đã thành công");
    }
}
