package quangtester.com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import quangtester.com.drivers.DriverManager;
import quangtester.com.keywords.WebUI;

import static quangtester.com.keywords.WebUI.*;
public class AddNewProjectsPage {
    private String PAGE_URL = "https://crm.anhtester.com/admin/projects/project";
    private String PAGE_TEXT = "Add new project";

    public By tabProjectDetail = By.xpath("//h4[normalize-space()='Add new project']");

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
    //Chọn Fixed Rate
    public By chooseBillingType = By.xpath("//div[@class='dropdown-menu open']//div[@id='bs-select-1']//ul//li[2]//a[@id='bs-select-1-1']");

    //Status
    public By dropdownStatus = By.xpath("//select[@id='status']/following-sibling::button");
    //Chọn In Progress
    public By chooseStatus = By.xpath("//div[@class='dropdown-menu open']//div[@id='bs-select-2']//ul//li[2]");

    //Total Rate
    public By inputTotalRate = By.xpath("//label[normalize-space()='Total Rate']/following-sibling::input");

    //Estimate Hours
    public By inputEstimateHours = By.xpath("//label[normalize-space()='Estimated Hours']/following-sibling::input");

    //Members
    public By dropdownMembers = By.xpath("//select[@id='project_members[]']/following-sibling::button");
    public By inputMembers = By.xpath("//div[@class='dropdown-menu open']//div[@class='bs-searchbox']//input[@aria-controls='bs-select-3']");
    //Chọn kết quả đầu tiên
    public By chooseFirstMember = By.xpath("//div[@class='dropdown-menu open']//div[@id='bs-select-3']//ul//li[1]//a[@id='bs-select-3-2']");

    //Start Date
        //Click Open Calendar
    public By calendarStartDate = By.xpath("//label[@for='start_date']/following-sibling::div");
        //Click icon next để qua tháng 8
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
    public By chooseDayStartDate = By.xpath("//div[@class='xdsoft_datetimepicker xdsoft_noselect xdsoft_']//div[@class='xdsoft_datepicker active']//div[@class='xdsoft_calendar']//table//tbody//tr[5]//td[@data-date='25']");

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
        //Nhập vào ô Tag
    public By inputTags = By.xpath("//input[@placeholder='Tag']");

        //Chọn tags AnhTester
    public By chooseTags1 = By.xpath("//ul[@id='ui-id-1']//li[1]//div[contains(.,'AnhTester')]");
        //Chọn tags Java
    public By chooseTags2 = By.xpath("//ul[@id='ui-id-1']//li[3]//div[contains(.,'Java')]");

    //Description
    public By descripton = By.xpath("//p[normalize-space()='Description']/following-sibling::div[@class='form-group']//div[@id='mceu_15']//div[@id='mceu_15-body']//div[@id='mceu_34']//iframe[@id='description_ifr']");

    //Check vào checkbox Send project created email
    public By checkSendProject = By.xpath("//div[@class='checkbox checkbox-primary tw-mb-0']//label[@for='send_created_email']");

    //Save
    public By buttonSave = By.xpath("//div[@class='panel-body']/following-sibling::div//button[@type='submit']");


    //Scroll chuột tới button Save
    public By scrollToButtonSave = By.xpath("//div[@class='panel-body']/following-sibling::div//button[@type='submit']");


    //Hàm xử lý

    public void verifyAddNewProjectsPage() {
        //Kiểm tra url có đúng trang AddNewProjectsPage chưa
        Assert.assertEquals(getCurrentURL(),PAGE_URL,"URL chưa đúng trang AddNewProjectsPage");
        //Kiểm tra headerPage có tồn tại không
        Assert.assertTrue(checkElementExist_UseBy(tabProjectDetail),"AddNewProjectsPage Header Page not existing");
        //Kiểm tra headerPage có giống giá trị truyền vào không
        Assert.assertEquals(getTextElement(tabProjectDetail),PAGE_TEXT,"AddNewProjectsPage Header Page is not match");
    }

    //Tạo hàm cho field Customer
    public void selectCustomer(String nameCustomer) {
        //click vào dropdown
        clickElement(dropdownCustomer);
        //Nhập vào ô input sau đó chọn kết quả
        DriverManager.getDriver().findElement(inputCustomer).sendKeys(nameCustomer);
        //Chọn kết quả đầu tiên
        clickElement(chooseFirstCustomer);
    }

    //Tạo hàm cho field Members
    public void selectMembers(String nameMembers) {
        //click vào dropdown
        clickElement(dropdownMembers);
        //Nhập vào ô input sau đó chọn kết quả
        DriverManager.getDriver().findElement(inputMembers).sendKeys(nameMembers);
        //Chọn kết quả đầu tiên
        clickElement(chooseFirstMember);
        //Click vào dropdown lần nữa
        clickElement(dropdownMembers);
    }

    public void AddDataNewProjects(String PROJECT_NAME,String nameCustomer,String nameMembers) {
        waitForPageLoaded();
        setText(inputProjectName,PROJECT_NAME);
        selectCustomer(nameCustomer);

        //Bỏ checkox Calculate
        clickElement(checkboxCalculate);

        clickElement(dropdownBillingType);
        clickElement(chooseBillingType);

        clickElement(dropdownStatus);
        clickElement(chooseStatus);

        setText(inputTotalRate,"123");
        setText(inputEstimateHours,"24");

        selectMembers(nameMembers);

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
        setText(inputDate,"27-11-2023");

        //clickElement(prevMonthDeadline);
        //clickElement(dropdownMonthDeadline);
        //clickElement(chooseMonthDeadline);
        //clickElement(dropdownYearDeadline);
        //clickElement(chooseYearDeadline);
        //clickElement(chooseDayDeadline);
        clickElement(calendarDeadline);

        clickElement(dropdownTags);
        setText(inputTags,"Test");
        pressEnter();

//        clickElement(chooseTags1);
//        clickElement(chooseTags2);

        clickElement(descripton);
        //DriverManager.getDriver().switchTo().frame(0);
        WebUI.sleep(2);
        setText(descripton,"aaaaaaaaaa");

        clickElement(checkSendProject);

        clickElement(buttonSave);



    }


}
