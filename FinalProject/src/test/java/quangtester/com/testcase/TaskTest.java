package quangtester.com.testcase;

import org.testng.annotations.Test;
import quangtester.com.common.BaseTest;
import quangtester.com.helpers.PropertiesHelper;
import quangtester.com.pages.*;
import quangtester.com.utils.LogUtils;

import static quangtester.com.keywords.WebUI.sleep;

public class TaskTest extends BaseTest {
    //Khởi tạo đối tượng class
    LoginPage loginPage;
    DashboardPage dashboardPage;

    CustomerPage customerPage;
    AddNewCustomerPage addNewCustomerPage;

    ProjectsPage projectsPage;
    AddNewProjectsPage addNewProjectsPage;
    EditProjectsPage editProjectsPage;

    TaskPage taskPage;
    AddNewTaskPage addNewTaskPage;

    //Tạo 1 testcase đăng nhập thành công
    public void loginTestSuccess() {
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginSuccess(PropertiesHelper.getValue("email"),PropertiesHelper.getValue("password"));
    }


    @Test
    public void TaskTestSuccess() {
        LogUtils.info("Running Test Case loginTestSuccess");

        //Gọi lại hàm login success
        loginTestSuccess();

        LogUtils.info("loginTestSuccess");

        //Kiểm tra trang Dashboard Page load được hay chưa và đúng hay chưa
        dashboardPage.verifyDashboardPage();

        //Open Customer page
        customerPage = dashboardPage.openCustomerPage();

        //Open Projects page
        projectsPage = customerPage.openProjectsPage();

        //Open Task page
        taskPage = projectsPage.openTaskPage();
        //Kiểm tra trang Task Page load được hay chưa và đúng hay chưa
        taskPage.verifyTaskPage();
        //Click vào button "New Task"
        addNewTaskPage = taskPage.clickNewTaskButton();
        //Kiểm tra trang AddNewTaskPage load được hay chưa và đúng hay chưa
        //addNewTaskPage.verifyAddNewTaskPage();
        //Chạy hàm AddNewTaskPage để nhập dữ liệu
        addNewTaskPage.AddDataNewTask(PropertiesHelper.getValue("SUBJECT_NAME"));

        sleep(2);
    }
}
