package page;

import base.BaseSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import untils.InputValidation;
import untils.WaitFor;
import untils.scrollTo;

public class VoucherPage {
    static String menuVoucher = "//li[@class='nav-item']//a[@class='nav-link collapsed']//i[@class='bi bi-receipt']";
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
    static String clickMonth = "//div[contains(@class,'open')]//select[@class='flatpickr-monthDropdown-months']";
    //click chon nam
    static String inputYear = "//div[contains(@class,'open')]//input[@class='numInput cur-year']";
    //ngay ket thu
    static String endVoucher = "//input[@name='endDate']";
    //mo ta
    static String description = "//textarea[@name='description']";
    // luu
    static String btnSave = "//button[@class='btn btn-outline-primary']";
    //-------------------------------------------------------------------------


    //Test case 1 : them voucher thanh cong
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
        scrollTo.element(clickStartDay);
        clickStartDay.click();
        selectDay(yearStart, monthStart, dayStart);
        WebElement clickEndDay = WaitFor.waitElementVisible(BaseSetup.driver, By.xpath(endVoucher));
        scrollTo.element(clickEndDay);
        clickEndDay.click();
        selectDay(yearEnd, monthEnd, dayEnd);
        checkRadioStatus(status);
        InputValidation.clearInput(BaseSetup.driver, descriptionn, By.xpath(description));
        WebElement clickSave = WaitFor.waitElementVisible(BaseSetup.driver, By.xpath(btnSave));
        scrollTo.element(clickSave);
        clickSave.click();
    }

    //thêm voucher k thảnh công - trống trường
    public static void InsertVoucherInvalid(String idVoucher) {
        try {
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
            //save
            WebElement clickSave = WaitFor.waitElementVisible(BaseSetup.driver, By.xpath(btnSave));
            for (int i = 0; i < 3; i++) {  //cuộn 3 lần
                ((JavascriptExecutor) BaseSetup.driver).executeScript("arguments[0].scrollIntoView(true);", clickSave);
                Thread.sleep(500);
            }
            clickSave.click();


            //BẮT LỖI THÔNG BÁO
            verifyEmpty("Mã giảm giá không được để trống");
            verifyEmpty("Tên giảm giá không được để trống");
            verifyEmpty("Giảm giá không được để trống");
            verifyEmpty("Số lượng không được để trống");
            verifyEmpty("Giá trị thấp nhất không được để trống");
            verifyEmpty("Số lần sử dụng không được để trống");
            verifyEmpty("Ngày bắt đầu không được để trống");
            verifyEmpty("Ngày kết thúc không được để trống");
        }catch (Exception ex){
        }
    }


    public static String verifyEmpty(String message) {
        String xpathEmpty = "//p[text()='" + message + "']";
        WebElement element = WaitFor.waitElementVisible(BaseSetup.driver, By.xpath(xpathEmpty));
        scrollTo.element(element);
        String actualResult = element.getText();
        Assert.assertEquals(actualResult, message, "Actual and expected not matches");
        return xpathEmpty;
    }

    //Phần check giá trị select
    public static void checkRadioStatus(String status) {
        //trang thai
        String radioStatus = "//input[@name='" + status + "']";
        WebElement clickStatus = WaitFor.waitElementVisible(BaseSetup.driver, By.xpath(radioStatus));
        scrollTo.element(clickStatus);
        clickStatus.click();
    }

    public static WebElement[] selectDay(String year, String month, String day) {
        //click chon ngay
        String xpathDay = String.format("//div[contains(@class,'open')]//span[text()='%s']", day);
        String xpathMonth = "//div[contains(@class,'open')]//select//option[text()='" + month + "']";
        WebElement selectMonth = WaitFor.waitElementVisible(BaseSetup.driver, By.xpath(clickMonth));
        selectMonth.click();
        WebElement clickMonth = WaitFor.waitElementVisible(BaseSetup.driver, By.xpath(xpathMonth));
        clickMonth.click();
        WebElement selectYear = WaitFor.waitElementVisible(BaseSetup.driver, By.xpath(inputYear));
        System.out.println("Year Input: "+ year);
        selectYear.click();
        selectYear.clear();
        selectYear.sendKeys(year);
        WebElement selectDay = WaitFor.waitElementVisible(BaseSetup.driver, By.xpath(xpathDay));
        selectDay.click();
        return new WebElement[]{selectMonth, selectYear, selectDay};
    }

    public static void checkTypeVoucher(String typeVouc) {
        WebElement clickType = WaitFor.waitElementVisible(BaseSetup.driver, By.xpath(selectVoucher));
        scrollTo.element(clickType);
        String xpathType = "//option[text()='" + typeVouc + "']";
        WebElement clickTypeVoucher = WaitFor.waitElementVisible(BaseSetup.driver, By.xpath(xpathType));
        clickTypeVoucher.click();
    }

}
