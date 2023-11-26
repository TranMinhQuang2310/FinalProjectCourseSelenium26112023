package quangtester.com.pages;

import org.openqa.selenium.By;
import org.testng.Assert;
import quangtester.com.keywords.WebUI;

import static quangtester.com.keywords.WebUI.*;

public class DashboardPage {

    private String PAGE_URL = "https://crm.anhtester.com/admin/";
    private String PAGE_TEXT = "Dashboard Options";
    private By menuCustomer = By.xpath("//span[normalize-space()='Customers']");
    private By buttonOptionDashboard = By.xpath("//div[@class='screen-options-btn']");//Lấy tên nút "Dashboard Options"

    //Hàm xử lý
    public void verifyDashboardPage() {
        //Kiểm tra URL có đúng vào trang Dashboard không
        Assert.assertEquals(getCurrentURL(),PAGE_URL,"URL chưa đúng trang Dashboard");
        //Kiểm tra nút "Dashboard Options" có tồn tại hay không
        Assert.assertTrue(checkElementExist_UseBy(buttonOptionDashboard),"Button Dashboard Options not existing");
        WebUI.sleep(2);

    }

    //Open tab menu Customers
    public CustomerPage openCustomerPage() {
        WebUI.waitForPageLoaded();
        clickElement(menuCustomer);

        return new CustomerPage();
    }

}
