package untils;

import base.BaseSetup;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class scrollTo {
    public static void element(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) BaseSetup.driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

}
