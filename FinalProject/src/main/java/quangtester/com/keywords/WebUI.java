package quangtester.com.keywords;

import com.aventstack.extentreports.Status;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import quangtester.com.drivers.DriverManager;
import quangtester.com.reports.ExtentReport.ExtentTestManager;
import quangtester.com.utils.LogUtils;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

public class WebUI {

    private static int EXPLICIT_WAIT_TIMEOUT = 10;
    private static int WAIT_PAGE_LOADED_TIMEOUT = 30;

    //Hàm getWebElement
    public static WebElement getWebElement(By by) {
        return DriverManager.getDriver().findElement(by);
    }

    //Hàm hover
    @Step("Hover on element {0}")
    public static void hoverOnElement(By by) {
        waitForElementVisible_UseSetCungTimeOut(by);
        Actions action = new Actions(DriverManager.getDriver());
        action.moveToElement(getWebElement(by));
        LogUtils.info("Hover on element :" + by);
        //ExtentTestManager.logMessage(Status.PASS,"Hover on element :" + by);
    }

    //Tạo hàm hightlight
    /**
     * by => truyền vào đối tượng element dạng By
     * return => Tô màu viền đỏ cho Element trên website
     */
    public static WebElement highLightElement(By by) {
        waitForElementVisible_UseSetCungTimeOut(by);
        // Tô màu border ngoài chính element chỉ định - màu đỏ (có thể đổi màu khác)
        if(DriverManager.getDriver() instanceof JavascriptExecutor) {
            ((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].style.border='3px solid red'",getWebElement(by));
            sleep(1);
        }
        return getWebElement(by);
    }

    /*
    Bài 33 :
        - Thêm cái @Step là để gắn step detail vào report
        - {0}, {1},...đại diện cho giá trị của các tham số bên dưới phương thức.
        Theo thứ tự luôn nhé. Và bắt đầu từ 0 (tham số thứ nhất)
    */
    @Step("Right click on element {0}")
    //Tạo hàm rightClick (click chuột phải)
    //context click => Nghĩa là click chuột phải
    public static void rightClickElement(By by) {
        waitForElementVisible_UseSetCungTimeOut(by);
        Actions action = new Actions(DriverManager.getDriver());
        action.contextClick(getWebElement(by));
        LogUtils.info("Right click on element " + by);
        //ExtentTestManager.logMessage(Status.PASS,"Right click on element " + by);
    }

    //Tạo 1 hàm in ra 1 câu thông báo
    public static void logConsole(String message) {
        System.out.println(message);
    }

    //Tạo 1 hàm để Open URL
    @Step("Open URL {0}")
    public static void openURL(String URL) {
        DriverManager.getDriver().get(URL);
        waitForPageLoaded();
        LogUtils.info("Open URL :" + URL);
        //ExtentTestManager.logMessage(Status.PASS,"Open URL :" + URL);

    }

    //Tạo hàm getCurrentURL
    @Step("Get Current URL")
    public static String getCurrentURL() {
        waitForPageLoaded();
        LogUtils.info("Get Current URL :" + DriverManager.getDriver().getCurrentUrl());
        //ExtentTestManager.logMessage(Status.PASS,"Get Current URL :" + DriverManager.getDriver().getCurrentUrl());
        return DriverManager.getDriver().getCurrentUrl();
    }

    //Tạo hàm để click vào 1 element
    @Step("Click on element {0}")
    public static void clickElement(By by) {
        waitForElementVisible_UseSetCungTimeOut(by);
        //Đặt hàm highlight để trước khi click vào element sẽ highlight lên
        highLightElement(by);
        getWebElement(by).click();
        LogUtils.info("Click on element :" + by);
        //ExtentTestManager.logMessage(Status.PASS,"Click on element :" + by);
    }

    //Tạo hàm để sendkey
    @Step("Set text {1} on element {0}")
    public static void setText(By by,String value) {
        waitForElementVisible_UseSetCungTimeOut(by);
        getWebElement(by).sendKeys(value);
        LogUtils.info("Set text " + value + " on element" + by);
        //ExtentTestManager.logMessage(Status.PASS,"Set text " + value + " on element" + by);
    }

    //Tạo hàm để isDisplayed
    @Step("Element is Displayed {0}")
    public static boolean checkIsDisplayed(By by) {
        waitForElementVisible_UseSetCungTimeOut(by);
        LogUtils.info("Element is Displayed  :" + getWebElement(by).isDisplayed());
        //ExtentTestManager.logMessage(Status.PASS,"Element is Displayed  :" + getWebElement(by).isDisplayed());
        return getWebElement(by).isDisplayed();
    }

    //Tạo hàm để getText
    @Step("Get text of element {0}")
    public static String getTextElement(By by) {
        waitForElementVisible_UseSetCungTimeOut(by);
        LogUtils.info("Get text of element " + by);
        LogUtils.info("===> Text :" + getWebElement(by).getText());
        //ExtentTestManager.logMessage(Status.PASS,"Get text of element " + by);
        //ExtentTestManager.logMessage(Status.INFO,"===> Text :" + getWebElement(by).getText());
        return getWebElement(by).getText();
    }

    //Tạo hàm để getAttribute
    @Step("Get attribute {1} value of element {0}")
    public static String getAttributeElement(By by , String attributeName) {
        waitForElementVisible_UseSetCungTimeOut(by);
        LogUtils.info("Get attribute value of element :" +by);
        LogUtils.info("===> Attribute value :" + getWebElement(by).getAttribute(attributeName));
        //ExtentTestManager.logMessage(Status.PASS,"Get attribute value of element :" +by);
        //ExtentTestManager.logMessage(Status.INFO,"===> Attribute value :" + getWebElement(by).getAttribute(attributeName));
        return getWebElement(by).getAttribute(attributeName);
    }

    //Tạo hàm để scroll thanh cuộn
    public static void scrollToElement(By by) {
        waitForElementPresent_UseSetCungTimeOut(by);
        //Dùng Action class
        //Dùng JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", getWebElement(by));
    }

    //Tạo hàm nhấn nút Enter
    public static boolean pressEnter() {
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            return true;
        }catch (Exception e) {
            return false;
        }
    }

    //Tạo hàm nhấn nút ESC
    public static boolean pressESC() {
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_ESCAPE);
            robot.keyRelease(KeyEvent.VK_ESCAPE);
            return true;
        }catch (Exception e) {
            return false;
        }
    }

    //================================================================================

    //Tạo hàm chờ trang load
    public static void sleep(double second) {
        try {
            Thread.sleep((long) (1000 * second));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    //----------------------------------------------------------------------------------------------
    public static void waitForElementVisible(By by, int seconds_of_timeout) {
        //Khởi tạo ExplicitWait để CHỜ tìm xem đối tượng có visible (vừa tồn tại trong DOM vừa tồn tại trên UI để người dùng thao tác)chưa
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(seconds_of_timeout),Duration.ofMillis(5000));

        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static void waitForElementVisible_UseSetCungTimeOut(By by) {
        //Khởi tạo ExplicitWait để CHỜ tìm xem đối tượng có visible (vừa tồn tại trong DOM vừa tồn tại trên UI để người dùng thao tác)chưa
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(EXPLICIT_WAIT_TIMEOUT),Duration.ofMillis(5000));

        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static void waitForElementPresent(By by,int seconds_of_timeouts) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(seconds_of_timeouts));

        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public static void waitForElementPresent_UseSetCungTimeOut(By by) {
        //Khởi tạo ExplicitWait để CHỜ tìm xem đối tượng có visible (vừa tồn tại trong DOM vừa tồn tại trên UI để người dùng thao tác)chưa
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(EXPLICIT_WAIT_TIMEOUT),Duration.ofMillis(5000));

        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public static void waitForElementClickable(By by, int seconds_of_timeouts) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(seconds_of_timeouts));

        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    //Áp dụng cho Bài 15 : TestFluentWait
    public static void waitForElementVisible_FluentWait (By by,int seconds_of_timeouts, int seconds_of_millis ) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(seconds_of_timeouts),Duration.ofMillis(seconds_of_millis));

        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    //----------------------------------------------------------------------------------------------

    //Áp dụng cho Bài 16 :
    public static Boolean checkElementExist_UseBy(By by) {
        List<WebElement> listElement = DriverManager.getDriver().findElements(by);

        if(listElement.size() > 0) {
            System.out.println("Element" + by + " existing .");
            return true;
        }else{
            System.out.println("Element" + by + " NOT exist.");
            return false;
        }
    }

    public static Boolean checkElementExist_UseXpath(String xpath) {
        List<WebElement> listElement = DriverManager.getDriver().findElements(By.xpath(xpath));

        if(listElement.size() > 0) {
            System.out.println("Element" + xpath + " existing .");
            return true;
        }else{
            System.out.println("Element" + xpath + " NOT exist.");
            return false;
        }
    }

    /**
     * Wait for Page loaded (Chờ đợi trang tải xong) (Javascript tải xong)
     */
    public static void waitForPageLoaded() {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(WAIT_PAGE_LOADED_TIMEOUT), Duration.ofMillis(500));
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();

        //Wait for Javascript to load
        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return js.executeScript("return document.readyState").toString().equals("complete");
            }
        };

        //Check JS is Ready
        boolean jsReady = js.executeScript("return document.readyState").toString().equals("complete");

        //Wait Javascript until it is Ready!
        if (!jsReady) {
            System.out.println("Javascript is NOT Ready.");
            //Wait for Javascript to load
            try {
                wait.until(jsLoad);
            } catch (Throwable error) {
                error.printStackTrace();
                Assert.fail("FAILED. Timeout waiting for page load.");
            }
        }
    }

    //----------------------------------------------------------------------------------------------

    //Áp dụng cho Bài 17 :
    //Kiểm tra xác nhận CÓ tồn tại
    public static boolean verifyElementVisible(By by,int second) {
        try {
            //Dùng hàm chờ đợi truyền vô xem object có visible(CÓ TỒN TẠI) hay không
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(second),Duration.ofMillis(500));
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            //Nếu trong thời gian chờ đợi tìm thấy object có visible => trả về true
            return true;
            //=> Nếu quá thời gian chờ đợi mà không tìm thấy object visible sẽ truyền xuống hàm catch báo lỗi => trả về false
        }catch (TimeoutException e) {
            e.printStackTrace();
            return false;
        }
    }

    //Kiểm tra xác nhận KHÔNG tồn tại
    public static boolean verifyElementNotVisible(By by ,int second) {
        try{
            //Dùng hàm chờ đợi truyền vô xem object có unvisible(KHÔNG TỒN TẠI) hay không
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(second),Duration.ofMillis(500));
            wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
            //Nếu trong thời gian chờ đợi tìm thấy object có unvisible => trả về true
            return true;
            //=> Nếu quá thời gian chờ đợi mà không tìm thấy object unvisible sẽ truyền xuống hàm catch báo lỗi => trả về false
        }catch (TimeoutException e) {
            e.printStackTrace();
            return false;
        }
    }

    //----------------------------------------------------------------------------------------------

    //Áp dụng cho Bài 28 :
    //Kiểm tra xác nhận KHÔNG tồn tại bằng Present
    public static boolean verifyElementNotPresent(By by ,int second) {
        try{
            //Dùng hàm chờ đợi truyền vô xem object có unvisible(KHÔNG TỒN TẠI) hay không
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(second),Duration.ofMillis(500));
            wait.until(ExpectedConditions.presenceOfElementLocated(by));
            //Nếu trong thời gian chờ đợi tìm thấy object có unpresent => trả về false
            return false;
            //=> Nếu quá thời gian chờ đợi mà không tìm thấy object unpresent sẽ truyền xuống hàm catch báo lỗi => trả về true
        }catch (Exception e) {
            return true;
        }
    }


}
