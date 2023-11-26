package quangtester.com.pages;

import org.openqa.selenium.By;
import org.testng.Assert;
import quangtester.com.keywords.WebUI;

import static quangtester.com.keywords.WebUI.*;

public class CustomerPage {
    private String PAGE_URL = "https://crm.anhtester.com/admin/clients";
    private String PAGE_TEXT = "Customers Summary";

    private By headerPageCustomers = By.xpath("//div[@class='panel-body']//div[@class='mbot15']//h4");
    private By menuProjects = By.xpath("//span[normalize-space()='Projects']");
    private By buttonAddCustomer = By.xpath("//a[normalize-space()='New Customer']");


    //Hàm xử lý
    public void verifyCustomerPage() {
        //Kiểm tra url có đúng trang Customer chưa
        Assert.assertEquals(getCurrentURL(),PAGE_URL,"URL chưa đúng trang Customer");
        //Kiểm tra headerPage có tồn tại không
        Assert.assertTrue(checkElementExist_UseBy(headerPageCustomers),"Customer Header Page not existing");
        //Kiểm tra headerPage có giống giá trị truyền vào không
        Assert.assertEquals(getTextElement(headerPageCustomers),PAGE_TEXT,"Customer Header Page is not match");
    }

    public AddNewCustomerPage clickNewCustomerButton() {
        //Kiểm tra button Add Customer có tồn tại
        waitForElementVisible(buttonAddCustomer,10);
        //Click vào button
        clickElement(buttonAddCustomer);

        return new AddNewCustomerPage();
    }

    //Open tab menu Projects
    public ProjectsPage openProjectsPage() {
        waitForPageLoaded();
        clickElement(menuProjects);

        return new ProjectsPage();
    }
}
