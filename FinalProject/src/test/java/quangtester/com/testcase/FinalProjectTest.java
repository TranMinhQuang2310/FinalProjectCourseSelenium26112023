package quangtester.com.testcase;

import org.testng.annotations.Test;
import quangtester.com.common.BaseTest;
import quangtester.com.helpers.PropertiesHelper;
import quangtester.com.keywords.WebUI;
import quangtester.com.pages.*;
import quangtester.com.utils.LogUtils;

import static quangtester.com.keywords.WebUI.*;

public class FinalProjectTest extends BaseTest {

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
    @Test
    public void loginTestSuccess() {
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginSuccess(PropertiesHelper.getValue("email"),PropertiesHelper.getValue("password"));
    }

    //Tạo 1 testcase invalid email
    @Test
    public void loginTestInvalidEmail() {
        loginPage = new LoginPage();
        loginPage.loginInvalid(PropertiesHelper.getValue("emailInvalid"),PropertiesHelper.getValue("password"));
    }

    //Tạo 1 testcase invalid password
    @Test
    public void loginTestInvalidPassword() {
        loginPage = new LoginPage();
        loginPage.loginInvalid(PropertiesHelper.getValue("email"),PropertiesHelper.getValue("passwordInvalid"));
    }

    //Thực hiện full luồng :
    @Test
    public void fullLuong() {

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

        //Open Projects page
        projectsPage = customerPage.openProjectsPage();
        //Kiểm tra trang Projects Page load được hay chưa và đúng hay chưa
        projectsPage.verifyProjectsPage();
        //Click vào button "New Project"
        addNewProjectsPage = projectsPage.clickNewProjectsButton();
        //Kiểm tra trang AddNewProjectsPage load được hay chưa và đúng hay chưa
        addNewProjectsPage.verifyAddNewProjectsPage();
        //Chạy hàm AddDataNewProjects để nhập dữ liệu
        addNewProjectsPage.AddDataNewProjects(PropertiesHelper.getValue("PROJECT_NAME"),PropertiesHelper.getValue("NAME_CUSTOMER"),PropertiesHelper.getValue("NAME_MEMBERS"));

        //--------------------------
        //Click lại Open Projects page
        customerPage.openProjectsPage();
        WebUI.sleep(2);
        //Search dữ liệu
        projectsPage.searchProject(PropertiesHelper.getValue("DATA_SEARCH"));
        WebUI.sleep(5);
        //Click vào dòng đầu tiên sau đó click vào Edit Project
        editProjectsPage = projectsPage.clickEditProjectsPage();
        WebUI.sleep(3);
        //Kiểm tra trang EditProjectsPage load được hay chưa và đúng hay chưa
        editProjectsPage.verifyEditProjectsPage();
        //Chạy hàm EditProjectsPage
        editProjectsPage.EditDataProjects(PropertiesHelper.getValue("EDIT_PROJECT_NAME"),PropertiesHelper.getValue("EDIT_NAME_CUSTOMER"),PropertiesHelper.getValue("EDIT_NAME_MEMBERS"));
        WebUI.sleep(2);

        //--------------------------
        //Click lại Open Projects page
        customerPage.openProjectsPage();
        WebUI.sleep(2);
        //Search dữ liệu sau khi Edit
        projectsPage.searchProject(PropertiesHelper.getValue("DATA_SEARCH_EDITED"));
        WebUI.sleep(5);
        //Click vào dòng đầu tiên sau đó click vào Delete Project
        projectsPage.DeleteProject();
        WebUI.sleep(2);

        //--------------------------
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
