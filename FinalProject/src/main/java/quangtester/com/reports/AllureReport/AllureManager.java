package quangtester.com.reports.AllureReport;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import quangtester.com.drivers.DriverManager;

public class AllureManager {

    //Thêm log test vào Allure Report
    @Attachment(value = "{0}",type = "text/plain")
    public static String saveTextLog(String message) {
        return message;
    }

    //Thêm ảnh chụp màn hình vào Allure Report
    @Attachment(value = "Page screenshot",type = "image/png")
    public static byte[] saveScreenshotPNG() {
        return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
    }

}
