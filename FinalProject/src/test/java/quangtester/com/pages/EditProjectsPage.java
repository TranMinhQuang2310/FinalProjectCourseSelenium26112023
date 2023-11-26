package quangtester.com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import quangtester.com.drivers.DriverManager;
import quangtester.com.keywords.WebUI;

import static quangtester.com.keywords.WebUI.*;
import static quangtester.com.keywords.WebUI.clickElement;

public class EditProjectsPage {
    private String PAGE_TEXT = "Edit Project";

    public By tabEditProject = By.xpath("//h4[normalize-space()='Edit Project']");

    //Project Name
    public By inputProjectName = By.xpath("//input[@id='name']");

    //Customer sau khi add
    public By dropdownCustomer = By.xpath("//select[@id='clientid']/following-sibling::button");
    public By inputCustomer = By.xpath("//div[@class='dropdown-menu open']//div[@class='bs-searchbox']//input[@aria-controls='bs-select-6']");
    //Chọn kết quả đầu tiên
    public By chooseFirstCustomer = By.xpath("//div[@class='dropdown-menu open']//div[@id='bs-select-6']//ul//li//a[@id='bs-select-6-0']");

    //Checkbox Calculate progress through tasks
    public By checkboxCalculate = By.xpath("//div[@class='checkbox checkbox-success']//label");

    //Progress

    //Billing Type
    public By dropdownBillingType = By.xpath("//select[@id='billing_type']/following-sibling::button");
    //Chọn Project Hours
    public By chooseBillingType = By.xpath("//div[@class='dropdown-menu open']//div[@id='bs-select-1']//ul//li[3]//a[@id='bs-select-1-2']");

    //Status
    public By dropdownStatus = By.xpath("//select[@id='status']/following-sibling::button");
    //Chọn In Progress
    public By chooseStatus = By.xpath("//div[@class='dropdown-menu open']//div[@id='bs-select-2']//ul//li[2]");

    //Rate Per Hour
    public By inputRatePerHour = By.xpath("//label[normalize-space()='Rate Per Hour']/following-sibling::input");

    //Estimate Hours
    public By inputEstimateHours = By.xpath("//label[normalize-space()='Estimated Hours']/following-sibling::input");

    //Members
    public By dropdownMembers = By.xpath("//select[@id='project_members[]']/following-sibling::button");
    public By inputMembers = By.xpath("//div[@class='dropdown-menu open']//div[@class='bs-searchbox']//input[@aria-controls='bs-select-3']");
    //Chọn kết quả đầu tiên
    public By chooseFirstMember = By.xpath("//div[@class='dropdown-menu open']//div[@id='bs-select-3']//ul//li[1]//a[@id='bs-select-3-0']");

    //Start Date
    //Click Open Calendar
    public By calendarStartDate = By.xpath("//label[@for='start_date']/following-sibling::div");
    //Click icon next để qua tháng 12
    public By nextMonthStartDate = By.xpath("//div[@class='xdsoft_datetimepicker xdsoft_noselect xdsoft_']//div[@class='xdsoft_datepicker active']//div[@class='xdsoft_monthpicker']//button[@class='xdsoft_next']");
    //Nhấn vào dropdown chọn tháng
    public By dropdownMonthStartDate = By.xpath("//div[@class='xdsoft_datetimepicker xdsoft_noselect xdsoft_']//div[@class='xdsoft_datepicker active']//div[@class='xdsoft_monthpicker']//div[@class='xdsoft_label xdsoft_month']");
    // Chọn tháng 11
    public By chooseMonthStartDate = By.xpath("//div[@class='xdsoft_datetimepicker xdsoft_noselect xdsoft_']//div[@class='xdsoft_datepicker active']//div[@class='xdsoft_monthpicker']//div[@class='xdsoft_label xdsoft_month']//div[@class='xdsoft_select xdsoft_monthselect xdsoft_scroller_box']//div//div[@data-value='10']");
    //Nhấn vào dropdown chọn năm
    public By dropdownYearStartDate = By.xpath("//div[@class='xdsoft_datetimepicker xdsoft_noselect xdsoft_']//div[@class='xdsoft_datepicker active']//div[@class='xdsoft_monthpicker']//div[@class='xdsoft_label xdsoft_year']");
    //Chọn năm 2024
    public By chooseYearStartDate = By.xpath("//div[@class='xdsoft_datetimepicker xdsoft_noselect xdsoft_']//div[@class='xdsoft_datepicker active']//div[@class='xdsoft_monthpicker']//div[@class='xdsoft_label xdsoft_year']//div[@class='xdsoft_select xdsoft_yearselect xdsoft_scroller_box']//div//div[@data-value='2024']");
    //Chọn ngày 25/11/2024
    public By chooseDayStartDate = By.xpath("//div[@class='xdsoft_datetimepicker xdsoft_noselect xdsoft_']//div[@class='xdsoft_datepicker active']//div[@class='xdsoft_calendar']//table//tbody//tr[4]//td[@data-date='20']");

    //Deadline
    //Click Open Calendar
    public By calendarDeadline = By.xpath("//label[normalize-space()='Deadline']/following-sibling::div");
        //Nhập ngày vào ô input Deadline
    public By inputDate = By.xpath("//input[@id='deadline']");

        //Click icon prev để chuyển về tháng 7
    //public By prevMonthDeadline = By.xpath("(//div[@class='xdsoft_datetimepicker xdsoft_noselect xdsoft_'])[1]//div[@class='xdsoft_datepicker active']//div[@class='xdsoft_monthpicker']//button[@class='xdsoft_prev']");
        //Nhấn vào dropdown chọn tháng
    //public By dropdownMonthDeadline = By.xpath("(//div[@class='xdsoft_datetimepicker xdsoft_noselect xdsoft_'])[1]//div[@class='xdsoft_datepicker active']//div[@class='xdsoft_monthpicker']//div[@class='xdsoft_label xdsoft_month']");
        // Chọn tháng 10
    //public By chooseMonthDeadline = By.xpath("(//div[@class='xdsoft_datetimepicker xdsoft_noselect xdsoft_'])[1]//div[@class='xdsoft_datepicker active']//div[@class='xdsoft_monthpicker']//div[@class='xdsoft_label xdsoft_month']//div[@class='xdsoft_select xdsoft_monthselect xdsoft_scroller_box']//div[@data-value='9']");
        //Nhấn vào dropdown chọn năm
    //public By dropdownYearDeadline = By.xpath("(//div[@class='xdsoft_datetimepicker xdsoft_noselect xdsoft_'])[1]//div[@class='xdsoft_datepicker active']//div[@class='xdsoft_monthpicker']//div[@class='xdsoft_label xdsoft_year']");
        //Chọn năm 2025
    //public By chooseYearDeadline = By.xpath("(//div[@class='xdsoft_datetimepicker xdsoft_noselect xdsoft_'])[1]//div[@class='xdsoft_datepicker active']//div[@class='xdsoft_monthpicker']//div[@class='xdsoft_label xdsoft_year']//div[@class='xdsoft_select xdsoft_yearselect xdsoft_scroller_box']//div[@data-value='2025']");
        //Chọn ngày 25/8/2025
    //public By chooseDayDeadline = By.xpath("(//div[@class='xdsoft_datetimepicker xdsoft_noselect xdsoft_'])[1]//div[@class='xdsoft_datepicker active']//div[@class='xdsoft_calendar']//table//tbody//tr[5]//td[@data-date='25']");

    //Tags
    public By dropdownTags = By.xpath("//label[normalize-space()='Tags']/following-sibling::ul");
        //Xóa tags Automation Test
    public By deleteTags = By.xpath("//ul[@class='tagit ui-widget ui-widget-content ui-corner-all']//li[1]//a");
        //Nhập vào ô Tag
    public By inputTags = By.xpath("//input[@placeholder='Tag']");

    //Description
    public By descripton = By.xpath("//p[normalize-space()='Description']/following-sibling::div[@class='form-group']//div[@id='mceu_15']//div[@id='mceu_15-body']//div[@id='mceu_34']");

    //Check vào checkbox Send project created email
    public By checkSendProject = By.xpath("//div[@class='checkbox checkbox-primary tw-mb-0']//label[@for='send_created_email']");

    //Save
    public By buttonSave = By.xpath("//div[@class='panel-body']/following-sibling::div//button[@type='submit']");

    //Scroll chuột tới button Save
    public By scrollToButtonSave = By.xpath("//div[@class='panel-body']/following-sibling::div//button[@type='submit']");

    //Hàm xử lý
    public void verifyEditProjectsPage() {
        //Kiểm tra headerPage có tồn tại không
        Assert.assertTrue(checkElementExist_UseBy(tabEditProject),"EditProjectsPage Header Page not existing");
        //Kiểm tra headerPage có giống giá trị truyền vào không
        Assert.assertEquals(getTextElement(tabEditProject),PAGE_TEXT,"EditProjectsPage Header Page is not match");
    }

    //Tạo hàm edit field Project Name
    public void editProjectName(String EDIT_PROJECT_NAME) {
        //Clear dữ liệu cũ
        DriverManager.getDriver().findElement(inputProjectName).clear();
        //Nhập dữ liệu mới vào
        setText(inputProjectName,EDIT_PROJECT_NAME);
    }

    //Tạo hàm edit field Customer
    public void editSelectCustomer(String nameCustomer) {
        //click vào dropdown
        clickElement(dropdownCustomer);
        //Nhập vào ô input sau đó chọn kết quả
        DriverManager.getDriver().findElement(inputCustomer).sendKeys(nameCustomer);
        //Chọn kết quả đầu tiên
        clickElement(chooseFirstCustomer);
    }

    //Tạo hàm edit field Rate Per Hour
    public void editRatePerHour() {
        //Clear dữ liệu cũ
        DriverManager.getDriver().findElement(inputRatePerHour).clear();
        //Nhập dữ liệu mới vào
        DriverManager.getDriver().findElement(inputRatePerHour).sendKeys("33333");
    }

    //Tạo hàm edit field Estimated Hours
    public void editEstimatedHours() {
        //Clear dữ liệu cũ
        DriverManager.getDriver().findElement(inputEstimateHours).clear();
        //Nhập dữ liệu mới vào
        DriverManager.getDriver().findElement(inputEstimateHours).sendKeys("666");
    }

    //Tạo hàm edit field Members
    public void selectMembers(String nameMembers) {
        //click vào dropdown
        clickElement(dropdownMembers);
        //Nhập vào ô input kết quả đã chọn trước đó
        DriverManager.getDriver().findElement(inputMembers).sendKeys(nameMembers);
        //Chọn kết quả đầu tiên
        clickElement(chooseFirstMember);
        //Click vào dropdown lần nữa
        clickElement(dropdownMembers);
    }

    //Tạo hàm edit field Project Name
    public void editDeadline() {
        //Clear dữ liệu cũ
        DriverManager.getDriver().findElement(inputDate).clear();
        //Nhập dữ liệu mới vào
        DriverManager.getDriver().findElement(inputDate).sendKeys("28-12-2024");
    }

    public void EditDataProjects(String EDIT_PROJECT_NAME,String Edit_NameCustomer,String Edit_NameMembers) {
        waitForPageLoaded();
        editProjectName(EDIT_PROJECT_NAME);

        editSelectCustomer(Edit_NameCustomer);

        //Tích checkox Calculate
        clickElement(checkboxCalculate);

        clickElement(dropdownBillingType);
        clickElement(chooseBillingType);

        clickElement(dropdownStatus);
        clickElement(chooseStatus);

        editRatePerHour();

        editEstimatedHours();

        selectMembers(Edit_NameMembers);

        //Scroll chuột tới button Save
        JavascriptExecutor jsEnd = (JavascriptExecutor) DriverManager.getDriver();
        jsEnd.executeScript("arguments[0].scrollIntoView(false)", DriverManager.getDriver().findElement(scrollToButtonSave));
        WebUI.sleep(2);

        clickElement(calendarStartDate);
        clickElement(nextMonthStartDate);
        clickElement(dropdownMonthStartDate);
        clickElement(chooseMonthStartDate);
        clickElement(dropdownYearStartDate);
        clickElement(chooseYearStartDate);
        clickElement(chooseDayStartDate);

        clickElement(calendarDeadline);
        WebUI.sleep(2);
        editDeadline();

        //clickElement(prevMonthDeadline);
        //clickElement(dropdownMonthDeadline);
        //clickElement(chooseMonthDeadline);
        //clickElement(dropdownYearDeadline);
        //clickElement(chooseYearDeadline);
        //clickElement(chooseDayDeadline);
        clickElement(calendarDeadline);

        clickElement(dropdownTags);
        WebUI.sleep(1);
        clickElement(deleteTags);
        WebUI.sleep(3);
        setText(inputTags,"Test");
        pressEnter();

        clickElement(descripton);
        setText(descripton,"aaaaaaaaaa");

        clickElement(checkSendProject);

        clickElement(buttonSave);




    }
}
