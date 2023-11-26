package quangtester.com.testcase;

import org.testng.annotations.Test;
import quangtester.com.common.BaseTest;
import quangtester.com.helpers.PropertiesHelper;
import quangtester.com.pages.AddNewCustomerPage;
import quangtester.com.pages.CustomerPage;
import quangtester.com.pages.DashboardPage;
import quangtester.com.pages.LoginPage;
import quangtester.com.utils.LogUtils;

public class CustomerTest extends BaseTest {

    //Khởi tạo đối tượng class
    LoginPage loginPage;

    DashboardPage dashboardPage;

    CustomerPage customerPage;
    AddNewCustomerPage addNewCustomerPage;

    //Tạo 1 testcase đăng nhập thành công
    public void loginTestSuccess() {
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginSuccess(PropertiesHelper.getValue("email"), PropertiesHelper.getValue("password"));
    }

    @Test
    public void CustomerSuccess() {
        LogUtils.info("Running Test Case loginTestSuccess");

        //Gọi lại hàm login success
        loginTestSuccess();

        LogUtils.info("loginTestSuccess");

        //Kiểm tra trang Dashboard Page load được hay chưa và đúng hay chưa
        dashboardPage.verifyDashboardPage();

        //Open Customer page
        customerPage = dashboardPage.openCustomerPage();
        //Kiểm tra trang Customer Page load được hay chưa và đúng hay chưa
        customerPage.verifyCustomerPage();
        //Click vào button "New Customer"
        addNewCustomerPage = customerPage.clickNewCustomerButton();
        //Kiểm tra trang AddNewCustomerPage load được hay chưa và đúng hay chưa
        addNewCustomerPage.verifyAddNewCustomerPage();
        //Chạy hàm AddDataNewCustomer để nhập dữ liệu
        addNewCustomerPage.AddDataNewCustomer(PropertiesHelper.getValue("COMPANY_NAME"),PropertiesHelper.getValue("NAME_GROUP"));
    }
}
