package quangtester.com.testcase;

import org.testng.annotations.Test;
import quangtester.com.common.BaseTest;
import quangtester.com.helpers.PropertiesHelper;
import quangtester.com.pages.DashboardPage;
import quangtester.com.pages.LoginPage;
import quangtester.com.utils.LogUtils;

public class DashboardTest extends BaseTest {

    //Khởi tạo đối tượng class
    LoginPage loginPage;

    DashboardPage dashboardPage;

    //Tạo 1 testcase đăng nhập thành công
    public void loginTestSuccess() {
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginSuccess(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
    }

    @Test
    public void DasboardTest() {

        LogUtils.info("Running Test Case loginTestSuccess");

        //Gọi lại hàm login success
        loginTestSuccess();

        LogUtils.info("loginTestSuccess");

        //Kiểm tra trang Dashboard Page load được hay chưa và đúng hay chưa
        dashboardPage.verifyDashboardPage();
    }

}
