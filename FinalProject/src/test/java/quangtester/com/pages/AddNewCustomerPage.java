package quangtester.com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import quangtester.com.drivers.DriverManager;
import quangtester.com.keywords.WebUI;

import static quangtester.com.keywords.WebUI.*;

public class AddNewCustomerPage extends AddNewCustomerDiaglog {
    private String PAGE_URL = "https://crm.anhtester.com/admin/clients/client";
    private String PAGE_TEXT = "Customer Details";

    public By tabCustomerDetail = By.xpath("//a[@aria-controls='contact_info']");
    //Company
    public By inputCompany = By.xpath("//input[@id='company']");
    //VAT Number
    public By inputVat = By.id("vat");
    //Phone
    public By inputPhoneNumber = By.id("phonenumber");
    //Website
    public By inputWebsite = By.id("website");

    //Groups
        //Nhấn vô button Add Group
    public By buttonAddGroup = By.xpath("//div[@class='input-group-btn']//a");
    public By dropdownGroups = By.xpath("//label[@for='groups_in[]']/following-sibling::div");
    public By inputGroups = By.xpath("//label[@for='groups_in[]']/following-sibling::div//input[@type='search']");

    //Currency
    public By dropdownCurrency = By.xpath("//select[@id='default_currency']/following-sibling::button");
    public By inputCurrency = By.xpath("//select[@id='default_currency']/following-sibling::div//input[@type='search']");

    //Default Language
    public By dropdownDefaultLanguage = By.xpath("//select[@id='default_language']/following-sibling::button");
    //Chọn kết quả đứng thứ 4
    public By chooseLanguage = By.xpath("//select[@id='default_language']/following-sibling::div//div[@id='bs-select-3']//li//a[@id='bs-select-3-3']");

    //Address
    public By inputAddress = By.id("address");
    //City
    public By inputCity = By.id("city");
    //State
    public By inputState = By.id("state");
    //Zip Code
    public By inputZipCode = By.id("zip");

    //Country
    public By dropdownCountry = By.xpath("//label[@for='country']/following-sibling::div");
    public By inputCountry = By.xpath("//label[@for='country']/following-sibling::div//input[@type='search']");

    //Scroll chuột tới button Save
    public By scrollToButtonSave = By.xpath("//div[@id='profile-save-section']//button[normalize-space()='Save']");

    //Save
    public By buttonSave = By.xpath("//div[@id='profile-save-section']//button[normalize-space()='Save']");


    //Hàm xử lý

    public void verifyAddNewCustomerPage() {
        //Kiểm tra url có đúng trang AddNewCustomerPage chưa
        Assert.assertEquals(getCurrentURL(),PAGE_URL,"URL chưa đúng trang AddNewCustomerPage");
        //Kiểm tra headerPage có tồn tại không
        Assert.assertTrue(checkElementExist_UseBy(tabCustomerDetail),"AddNewCustomerPage Header Page not existing");
        //Kiểm tra headerPage có giống giá trị truyền vào không
        Assert.assertEquals(getTextElement(tabCustomerDetail),PAGE_TEXT,"AddNewCustomerPage Header Page is not match");
    }

    //Tạo hàm để mở popup add Group
    public AddNewCustomerDiaglog AddGroup(String nameGroup) {
        //Nhấn nút add group
        clickElement(buttonAddGroup);
        waitForPageLoaded();
        sleep(1);

        //Kiểm tra xem có đúng là popup "Add New Customer Group" chưa
        String getTitleGroup = getTextElement(titleGroup);
        System.out.println("Title popup Group là :" + getTitleGroup );
        Assert.assertEquals(getTitleGroup,PAGE_TEXT_GROUP,"Failed . Title Customer Group not match");
        //Điền vào ô inputName
        setText(inputNameGroup,nameGroup);
        //Click button Submit
        clickElement(buttonSubmitGroup);

        return new AddNewCustomerDiaglog();
    }

    //Tạo hàm cho field Group
    public void selectGroup(String nameGroup) {
        //click vào dropdown
        clickElement(dropdownGroups);
        //Nhập vào ô input sau đó chọn kết quả
        DriverManager.getDriver().findElement(inputGroups).sendKeys(nameGroup,Keys.ENTER);
        //click lại vào ô dropdown
        clickElement(dropdownGroups);

    }

    //Tạo hàm cho field Country
    public void selectCountry() {
        //click vào dropdown
        clickElement(dropdownCountry);
        //Nhập vào ô input sau đó chọn kết quả
        DriverManager.getDriver().findElement(inputCountry).sendKeys("VietNam",Keys.ENTER);
    }

    public void AddDataNewCustomer(String COMPANY_NAME, String nameGroup) {
        waitForPageLoaded();
        setText(inputCompany,COMPANY_NAME);
        setText(inputVat,"10");
        setText(inputPhoneNumber, "097382423");
        setText(inputWebsite,"https://crm.anhtester.com/admin/clients/client");

        AddGroup(nameGroup);
        waitForPageLoaded();
        selectGroup(nameGroup);

        clickElement(dropdownCurrency);
        DriverManager.getDriver().findElement(inputCurrency).sendKeys("USD",Keys.ENTER);

        clickElement(dropdownDefaultLanguage);
        clickElement(chooseLanguage);

        //Scroll chuột tới button Save
        JavascriptExecutor jsEnd = (JavascriptExecutor) DriverManager.getDriver();
        jsEnd.executeScript("arguments[0].scrollIntoView(false)", DriverManager.getDriver().findElement(scrollToButtonSave));
        WebUI.sleep(2);

        setText(inputAddress,"Viet Nam");
        setText(inputCity,"Ho Chi Minh");
        setText(inputState,"abc" );
        setText(inputZipCode,"12234455345");

        selectCountry();

        clickElement(buttonSave);
        waitForPageLoaded();
    }


}
