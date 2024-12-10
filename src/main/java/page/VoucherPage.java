package page;

import base.BaseSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import untils.InputValidation;
import untils.WaitFor;

public class VoucherPage {
    static String menuVoucher = "//li[@class='nav-item']//a[@class='nav-link collapsed']//i[@class='bi bi-menu-button-wide']";
    static String clickVoucher = "//body[1]/aside[1]/ul[1]/li[7]/ul[1]/li[1]/a[1]/span[1]";
    static String btnAdd = "//a[@class='btn btn-outline-primary ms-4']";
    static String voucherId = "//input[@placeholder='Mã phiếu giảm giá']";
    static String voucherName = "//input[@name='voucherName']";
    static String disscountVoucher = "//input[@name='discountAmount']";
    static String maxTotalAmountVoucher = "//input[@name='maxTotalAmount']";
    //số lượng sử dụnh
    static String maxUsesVoucher = "//input[@name='maxUses']";
    //giá trị toi thieu
    static String minTotalAmountVoucher = "//input[@name='minTotalAmount']";
    //so lan su dụng
    static String maxUsesUserVoucher = "//input[@name='maxUsesUser']";
    // chọn loại voucher
    static String selectVoucher = "//select[@class='form-select']";
    //ngay bat dau
    static String statrVoucher = "//input[@name='startDate']";
    //click chon thang
    static String clickMonth = "//select[@class='flatpickr-monthDropdown-months']";
    //click chon nam
    static String inputYear = "//input[@class='numInput cur-year']";

    //ngay ket thu
    static String endVoucher = "//input[@name='endDate']";

    //mo ta
    static String description = "//textarea[@name='description']";
    // luu
    static String btnSave = "//button[@class='btn btn-outline-primary']";

    public static void InsertVoucherSuccess(String idVoucher, String nameVoucher, String dataDisscountVoucher, String maxVoucher, String quality, String minVoucher, String qualityUses, String typeVoucher, String yearStart, String monthStart, String dayStart, String yearEnd, String monthEnd, String dayEnd, String status, String descriptionn) {
       //kich MENU
        WebElement clickMenuVoucher = WaitFor.waitElementVisible(BaseSetup.driver, By.xpath(menuVoucher));
        clickMenuVoucher.click();
        //kich chon lop con truy cap
        WebElement clickVoucherDetail = WaitFor.waitElementVisible(BaseSetup.driver, By.xpath(clickVoucher));
        clickVoucherDetail.click();
        //nhan nut them
        WebElement clickAddVoucher = WaitFor.waitElementVisible(BaseSetup.driver, By.xpath(btnAdd));
        clickAddVoucher.click();
        // bắt nhập
        InputValidation.clearInput(BaseSetup.driver, idVoucher, By.xpath(voucherId));
        InputValidation.clearInput(BaseSetup.driver, nameVoucher, By.xpath(voucherName));
        InputValidation.clearInput(BaseSetup.driver, dataDisscountVoucher, By.xpath(disscountVoucher));
        InputValidation.clearInput(BaseSetup.driver, maxVoucher, By.xpath(maxTotalAmountVoucher));
        InputValidation.clearInput(BaseSetup.driver, quality, By.xpath(maxUsesVoucher));
        InputValidation.clearInput(BaseSetup.driver, minVoucher, By.xpath(minTotalAmountVoucher));
        InputValidation.clearInput(BaseSetup.driver, qualityUses, By.xpath(maxUsesUserVoucher));
        checkTypeVoucher(typeVoucher);
        WebElement clickStartDay = WaitFor.waitElementVisible(BaseSetup.driver, By.xpath(statrVoucher));
        clickStartDay.click();
        selectDay(yearStart, monthStart, dayStart);
        WebElement clickEndDay = WaitFor.waitElementVisible(BaseSetup.driver, By.xpath(endVoucher));
        clickEndDay.click();
        selectDay(yearEnd, monthEnd, dayEnd);
        checkRadioStatus(status);
        InputValidation.clearInput(BaseSetup.driver, descriptionn, By.xpath(description));
        WebElement clickSave = WaitFor.waitElementVisible(BaseSetup.driver, By.xpath(btnSave));
        clickSave.click();
    }

    public static void checkRadioStatus(String status) {
        //trang thai
        String radioStatus = "//input[@name='" + status + "']";
        WebElement clickStatus = WaitFor.waitElementVisible(BaseSetup.driver, By.xpath(radioStatus));
        clickStatus.click();
    }

    public static WebElement[] selectDay(String year, String day, String month) {
        //click chon ngay
        String xpathDay = "//span[(text()='" + day + "') and (@class='flatpickr-day')]";
        String xpathMonth = "//option[text()='" + month + "']";
        WebElement selectMonth = WaitFor.waitElementVisible(BaseSetup.driver, By.xpath(clickMonth));
        selectMonth.click();
        WebElement clickMonth = WaitFor.waitElementVisible(BaseSetup.driver, By.xpath(xpathMonth));
        clickMonth.click();
        WebElement selectYear = WaitFor.waitElementVisible(BaseSetup.driver, By.name(inputYear));
        selectYear.sendKeys(month);
        WebElement selectDay = WaitFor.waitElementVisible(BaseSetup.driver, By.xpath(xpathDay));
        selectDay.click();
        return new WebElement[]{selectMonth, selectYear, selectDay};
    }

    public static void checkTypeVoucher(String typeVouc) {
        WebElement clickType = WaitFor.waitElementVisible(BaseSetup.driver, By.xpath(selectVoucher));
        String xpathType = "//option[text()='" + typeVouc + "']";
        WebElement clickTypeVoucher = WaitFor.waitElementVisible(BaseSetup.driver, By.xpath(xpathType));

    }

}
