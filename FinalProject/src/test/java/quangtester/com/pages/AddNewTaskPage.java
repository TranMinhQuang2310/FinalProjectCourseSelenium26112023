package quangtester.com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import quangtester.com.drivers.DriverManager;
import quangtester.com.keywords.WebUI;

import static quangtester.com.keywords.WebUI.*;


public class AddNewTaskPage {
    private String PAGE_URL = "https://crm.anhtester.com/admin/tasks";
    private String PAGE_TEXT = "Add new task";

    public By tabTaskDetail = By.xpath("//div[@id='_task_modal']//div[@class='modal-header']//button/following-sibling::h4[normalize-space()='Add new task']");

    //Nút New Task
    public By menuTask = By.xpath("//a[normalize-space()='New Task']");

    //Icon close popup
    public By iconClosePopup  = By.xpath("//div[@id='_task_modal']//button[@aria-label='Close']");

    //Checkbox Public
    public By checkboxPublic = By.xpath("//div[@class='checkbox checkbox-primary checkbox-inline task-add-edit-public tw-pt-2']");

    //Checkbox Billable
    public By checboxBillable = By.xpath("//div[@class='checkbox checkbox-primary checkbox-inline task-add-edit-billable tw-pt-2']");

    //Attach File
    public By buttonAttachFile = By.xpath("//a[normalize-space()='Attach Files']");
    public By labelAttachFile = By.xpath("//label[normalize-space()='Attachment']");
        //input Choose File
    public By inputChooseAttachFile = By.xpath("//label[normalize-space()='Attachment']/following-sibling::div//input");
        //Icon add thêm input Choose File
    public By iconAddInputChooseAttachFile = By.xpath("//label[normalize-space()='Attachment']/following-sibling::div//span//button[@class='btn btn-default add_more_attachments']");
        //Icon xóa input Choose File vừa thêm
    public By iconRemoveInputChooseAttachFile = By.xpath("//label[normalize-space()='Attachment']/following-sibling::div//span//button[@class='btn remove_attachment btn-danger']");

    //Subject
    public By inputSubject = By.xpath("//label[@for='name']/following-sibling::input");

    //Hourly Rate
    public By inputHourlyRate = By.xpath("//label[normalize-space()='Hourly Rate']/following-sibling::input");

    //Start Date
        //Click Open Calendar
    public By calendarStartDate = By.xpath("//label[@for='startdate']/following-sibling::div");
        //Click icon next để qua tháng 8
    public By nextMonthStartDate = By.xpath("(//div[@class='xdsoft_datetimepicker xdsoft_noselect xdsoft_'])[2]//div[@class='xdsoft_datepicker active']//div[@class='xdsoft_monthpicker']//button[@class='xdsoft_next']");

    //Due Date
        //Click Open Calendar Due Date
    public By calendarDueDate = By.xpath("//label[normalize-space()='Due Date']/following-sibling::div");
        //Nhập ngày vào ô input Due Date
    public By inputDueDate = By.xpath("//input[@id='duedate']");

    //Priority
    public By dropdownPriority = By.xpath("//label[@for='priority']/following-sibling::div");
        //Chọn High
    public By choosePriority = By.xpath("//div[@class='col-md-6'][3]//div[@class='form-group']//div[@class='dropdown bootstrap-select bs3 open']//div[@class='dropdown-menu open']//div[@id='bs-select-6']//ul//li[3]");

    //Repeat every
    public By dropdownRepeatEvery = By.xpath("//label[normalize-space()='Repeat every']/following-sibling::div");
    public By chooseRepeatEvery = By.xpath("//div[@class='col-md-6'][4]//div[@class='form-group']//div[@class='dropdown bootstrap-select bs3 open']//div[@class='dropdown-menu open']//div[@aria-activedescendant='bs-select-7-0']//ul//li[2]");

    //Related To
    public By dropdownRelatedTo = By.xpath("//label[normalize-space()='Related To']/following-sibling::div");
    public By chooseRelatedTo = By.xpath("//div[@class='dropdown bootstrap-select bs3 dropup open']//div[@class='dropdown-menu open']//div[@id='bs-select-9']//ul[@class='dropdown-menu inner ']//li[4]//a//span[contains(.,' Customer ')]");

    //Assignees
    public By dropdownAssignees = By.xpath("//label[normalize-space()='Assignees']/following-sibling::div");
    public By inputAssignees = By.xpath("//div[@class='dropdown bootstrap-select show-tick bs3 dropup open']//div[@class='dropdown-menu open']//div[@class='bs-searchbox']//input");

    //Followers
    public By dropdownFollowers = By.xpath("//label[normalize-space()='Followers']/following-sibling::div");
    public By inputFollowers = By.xpath("//div[@class='dropdown bootstrap-select show-tick bs3 dropup open']//div[@class='dropdown-menu open']//div[@class='bs-searchbox']//input");

    //Tags
    public By dropdownTags = By.xpath("//label[normalize-space()='Tags']/following-sibling::ul[1]");
    public By inputTags = By.xpath("//div[@id='inputTagsWrapper']//ul[1]//li//input");

    //Task Description
    public By inputTaskDescription = By.xpath("//p[normalize-space()='Task Description']/following-sibling::div");
    public By fieldTaskDescription = By.xpath("//p[normalize-space()='Task Description']/following-sibling::div[@class='form-group no-mbot']//div[@id='mceu_15']//div[@id='mceu_15-body']//div[@id='mceu_34']");

    //Scroll chuột tới title Task Description
    public By scrollToButtonSave = By.xpath("//p[normalize-space()='Task Description']");

    //Save
    public By buttonSave = By.xpath("//div[@id='_task_modal']//div[@class='modal-footer']//button[@type='submit']");




    //Hàm xử lý
    public void verifyAddNewTaskPage() {
        //Kiểm tra url có đúng trang AddNewTaskPage  chưa
        Assert.assertEquals(getCurrentURL(),PAGE_URL,"URL chưa đúng trang AddNewTaskPage");
        //Kiểm tra headerPage có tồn tại không
        Assert.assertTrue(checkElementExist_UseBy(tabTaskDetail),"AddNewTaskPage Header Page not existing");
        //Kiểm tra headerPage có giống giá trị truyền vào không
        Assert.assertEquals(getTextElement(tabTaskDetail),PAGE_TEXT,"AddNewTaskPage Header Page is not match");
    }

    //Kiểm tra label Attachment load được hay chưa và đúng hay chưa
    public void verfifyLabelAttachFile() {
        //Kiểm tra label Attachment có tồn tại không
        Assert.assertTrue(checkElementExist_UseBy(labelAttachFile),"Label Attachment not existing");
    }

    //Kiểm tra nút input Choose File load được hay chưa và đúng hay chưa
    public void verifyInputChooseFile() {
        //Kiểm tra nút input Choose File có tồn tại không
        Assert.assertTrue(checkElementExist_UseBy(inputChooseAttachFile),"Input Choose File  not existing");
    }

    public void AddDataNewTask(String SUBJECT_NAME) {
        waitForPageLoaded();
        //Click Icon close popup
        clickElement(iconClosePopup);

        //Nhấn lại nút New Task
        waitForPageLoaded();
        clickElement(menuTask);

        clickElement(checkboxPublic);
        clickElement(checboxBillable);

        clickElement(buttonAttachFile);
        waitForPageLoaded();
            //Kiểm tra label Attachment
        verfifyLabelAttachFile();
            //Kiểm tra nút input Choose File
        verifyInputChooseFile();
            //Click Icon add thêm input Choose File
        clickElement(iconAddInputChooseAttachFile);
            //Click Icon xóa input Choose File vừa thêm
        clickElement(iconRemoveInputChooseAttachFile);

        setText(inputSubject,SUBJECT_NAME);

        //Clear toàn bộ dữ liệu field Hourly Rate
        DriverManager.getDriver().findElement(inputHourlyRate).clear();
        //Điền giá trị mới vào field Hourly Rate
        setText(inputHourlyRate,"321333");

        clickElement(calendarStartDate);
        //clickElement(nextMonthStartDate);
        clickElement(calendarStartDate);

        clickElement(calendarDueDate);
        setText(inputDueDate,"27-11-2023");

        clickElement(dropdownPriority);
        //sleep(3);
        //clickElement(choosePriority);
        clickElement(dropdownPriority);

        clickElement(dropdownRepeatEvery);
        //sleep(5);
        //clickElement(chooseRepeatEvery);
        clickElement(dropdownRepeatEvery);

        //Scroll chuột tới button Save
        JavascriptExecutor jsEnd = (JavascriptExecutor) DriverManager.getDriver();
        jsEnd.executeScript("arguments[0].scrollIntoView(false)", DriverManager.getDriver().findElement(scrollToButtonSave));
        WebUI.sleep(2);

        clickElement(dropdownRelatedTo);
        //clickElement(chooseRelatedTo);
        clickElement(dropdownRelatedTo);

        clickElement(dropdownAssignees);
        sleep(3);
        DriverManager.getDriver().findElement(inputAssignees).sendKeys("Anh Tester",Keys.ENTER);
        clickElement(dropdownAssignees);

        clickElement(dropdownFollowers);
        sleep(3);
        DriverManager.getDriver().findElement(inputFollowers).sendKeys("Anh Tester",Keys.ENTER);
        clickElement(dropdownFollowers);

        clickElement(dropdownTags);
        setText(inputTags,"Test");
        pressEnter();


        clickElement(inputTaskDescription);
        clickElement(fieldTaskDescription);
        setText(fieldTaskDescription,"aaaaa");

        clickElement(buttonSave);

    }

}
