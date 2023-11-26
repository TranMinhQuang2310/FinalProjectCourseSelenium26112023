package quangtester.com.common;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.*;
import quangtester.com.TestListener;
import quangtester.com.drivers.DriverManager;
import quangtester.com.helpers.PropertiesHelper;

@Listeners(TestListener.class)
public class BaseTest {

    @BeforeMethod
    @Parameters({"browser"})
    //@Optional("chrome") => mặc định chạy vào Google Chrome nếu không set giá trị bên file Bai24_MultiBrowser.xml
    public static void createDriver(@Optional("edge") String browser) {
        WebDriver driver = setupDriver(browser);
        PropertiesHelper.loadAllFiles();
        //Set giá trị driver đã được khởi tạo vào ThreadLocal ở class DriverManager
        DriverManager.setDriver(driver);
    }

    public static WebDriver setupDriver(String browserName) {
        WebDriver driver;
        //Dùng trim() để cắt 2 đầu
        //Dùng toLowerCase() để chuyển kiểu chữ về kiểu bình thường
        switch (browserName.trim().toLowerCase()) {
            case "chrome" :
                driver = initChromeDriver();
                break;
            case "firefox" :
                driver = initFirefoxDriver();
                break;
            case "edge" :
                driver = initEdgeDriver();
                break;
            default:
                System.out.println("Browser :" + browserName + " is invalid, Launching Chrome as browser of choice...");
                driver = initChromeDriver();
        }
        return driver;

    }

    private static WebDriver initChromeDriver() {
        System.out.println("Launching Chrome browser...");
        WebDriverManager.chromedriver().setup();

        //How to fix Invalid Status code=403 text=Forbidden on ChromeDriver 111 using Selenium
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        return driver;
    }

    private static WebDriver initEdgeDriver() {
        System.out.println("Launching Edge browser...");
        WebDriverManager.edgedriver().setup();

        //How to fix Invalid Status code=403 text=Forbidden on ChromeDriver 111 using Selenium
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new EdgeDriver(options);
        driver.manage().window().maximize();
        return driver;
    }

    private static WebDriver initFirefoxDriver() {
        System.out.println("Launching Firefox browser...");
        WebDriverManager.firefoxdriver().setup();

        //How to fix Invalid Status code=403 text=Forbidden on ChromeDriver 111 using Selenium
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new FirefoxDriver(options);
        driver.manage().window().maximize();
        return driver;
    }

    @AfterMethod
    public static void closeDriver() {

        if(DriverManager.getDriver() != null) {
            DriverManager.quit();
        }
    }

}
