package quangtester.com.pages;

import com.beust.ah.A;
import org.openqa.selenium.By;
import org.testng.Assert;

import static quangtester.com.keywords.WebUI.*;

public class TaskPage {
    private String PAGE_URL = "https://crm.anhtester.com/admin/tasks";
    private String PAGE_TEXT = "Tasks Summary";

    private By headerPageTask = By.xpath("//span[normalize-space()='Tasks Summary']");
    private By buttonAddTask = By.xpath("//a[normalize-space()='New Task']");

    //Hàm xử lý
    public void verifyTaskPage() {
        //Kiểm tra url có đúng trang Task chưa
        Assert.assertEquals(getCurrentURL(),PAGE_URL,"URL chưa đúng trang Task");
        //Kiểm tra headerPage có tồn tại không
        Assert.assertTrue(checkElementExist_UseBy(headerPageTask),"Task Header Page not existing");
        //Kiểm tra headerPage có giống giá trị truyền vào không
        Assert.assertEquals(getTextElement(headerPageTask),PAGE_TEXT,"Task Header Page is not match");
    }

    public AddNewTaskPage clickNewTaskButton() {
        //Kiểm tra button Task Projects có tồn tại
        waitForElementVisible(buttonAddTask,10);

        //Click vào button
        clickElement(buttonAddTask);
        return new AddNewTaskPage();
    }

}
