package quangtester.com.testcase;

import org.testng.annotations.Test;
import quangtester.com.common.BaseTest;
import quangtester.com.helpers.PropertiesHelper;
import quangtester.com.pages.LoginPage;

public class LoginTestInvalid extends BaseTest {

    //Khởi tạo đối tượng class
    LoginPage loginPage;

    //    Tạo 1 testcase invalid email
    @Test
    public void loginTestInvalidEmail() {
        loginPage = new LoginPage();
        loginPage.loginInvalid(PropertiesHelper.getValue("emailInvalid"), PropertiesHelper.getValue("password"));
    }

    //Tạo 1 testcase invalid password
    @Test
    public void loginTestInvalidPassword() {
        loginPage = new LoginPage();
        loginPage.loginInvalid(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("passwordInvalid"));
    }
}
