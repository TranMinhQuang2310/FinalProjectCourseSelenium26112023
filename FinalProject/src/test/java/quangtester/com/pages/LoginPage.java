package quangtester.com.pages;

import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import quangtester.com.drivers.DriverManager;
import quangtester.com.helpers.PropertiesHelper;
import quangtester.com.keywords.WebUI;

import static quangtester.com.keywords.WebUI.*;

public class LoginPage {
    private String PAGETEXT = "Login";

    private By headerPage = By.xpath("//h1");
    private By inputEmail = By.xpath("//input[@id='email']");
    private By inputPassword = By.xpath("//input[@id='password']");
    private By buttonRemember_me = By.xpath("//div[@class='checkbox checkbox-inline']");
    private By buttonLogin = By.xpath("//button[normalize-space()='Login']");
    private By verify_remember_me = By.id("remember");
    private By messageErorEmail = By.xpath("//div[@class='text-center alert alert-danger']");


    private String PAGE_URL_DASHBOARD = "https://crm.anhtester.com/admin/";
    private By buttonOptionDashboard = By.xpath("//div[@class='screen-options-btn']");//Lấy tên nút "Dashboard Options"


    //Viết các hàm xử lý cho trang Login
    //1. Kiểm tra header page có phải tên "Login" không
    public void verifyHeaderPage() {
        Assert.assertEquals(getTextElement(headerPage), "Login","Failed . Name of Header Page not match");
    }

    //2 Điền email
    public void enterEmail(String email) {
        setText(inputEmail,email);
    }

    //3. Điền password
    public void enterPassword(String password) {
        setText(inputPassword,password);
    }

    //4. Check vào ô remember me
    public void clickRemember_me() {
        clickElement(buttonRemember_me);
    }

    //5. Sau khi click thì kiểm tra ô clickRemember_me đã được chọn hay chưa
    public void verifyclickRemember_me() {
        Assert.assertTrue(getWebElement(verify_remember_me).isSelected(),"Failed . Error Message no Selected");
    }

    //6. Click button Login
    public void clickOnLoginButton() {
        clickElement(buttonLogin);
    }

    public void verifyLoginSuccess() {
        //Kiểm tra URL có đúng vào trang Dashboard không
        Assert.assertEquals(getCurrentURL(),PAGE_URL_DASHBOARD,"URL chưa đúng trang Dashboard");
        //Kiểm tra nút "Dashboard Options" có tồn tại hay không
        Assert.assertTrue(checkElementExist_UseBy(buttonOptionDashboard),"Button Dashboard Options not existing");
        WebUI.sleep(2);
    }

    /*
        7 . Kiểm tra khi nhập sai Email or Password thì :
            -   Có hiển thị thông báo không
            -   In ra đoạn text xem có Đúng với từ truyền vào không
    */
    public void verifyErrorMessageDisplay() {
        Assert.assertTrue(getWebElement(messageErorEmail).isDisplayed(),"Failed . Error Message no display");
        Assert.assertEquals(getTextElement(messageErorEmail),"Invalid email or password");
    }

    //Hàm xử lý tổng hợp để login
    public DashboardPage loginSuccess(String email,String password) {
        openURL(PropertiesHelper.getValue("url"));
        verifyHeaderPage();
        enterEmail(email);
        enterPassword(password);
        clickRemember_me();
        verifyclickRemember_me();
        clickOnLoginButton();
        WebUI.sleep(2);
        verifyLoginSuccess();

        return new DashboardPage();
    }

    public void loginInvalid(String email,String password) {
        openURL(PropertiesHelper.getValue("url"));
        verifyHeaderPage();
        enterEmail(email);
        enterPassword(password);
        clickRemember_me();
        verifyclickRemember_me();
        clickOnLoginButton();
        WebUI.sleep(2);
        verifyErrorMessageDisplay();
    }




}
