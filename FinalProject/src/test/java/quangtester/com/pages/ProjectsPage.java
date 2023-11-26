package quangtester.com.pages;

import com.beust.ah.A;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import quangtester.com.drivers.DriverManager;

import static quangtester.com.keywords.WebUI.*;

public class ProjectsPage {
    private String PAGE_URL = "https://crm.anhtester.com/admin/projects";
    private String PAGE_TEXT = "Projects Summary";

    private By headerPageProjects = By.xpath("//div[@class='panel-body']//div[@class='row mbot15']//h4");
    private By buttonAddProjects = By.xpath("//a[normalize-space()='New Project']");

    //Click vào dữ liệu thuộc hàng đầu tiên, cột Project Name để thực hiện edit
    private By firstRowData = By.xpath("//tbody/tr[1]//td[1]//a");

    private By menuTask = By.xpath("//span[normalize-space()='Tasks']");

    //-------------------------------------
    //Search Project Page
    private By inputSearch = By.xpath("//input[@class='form-control input-sm']");

    //-------------------------------------
    //Edit Project Page
        //Lấy dòng đầu tiên trong bảng
    private By tdCustomerName = By.xpath("//tbody/tr[1]//td[2]/a");
        //Click vào button More
    private By buttonMore = By.xpath("//button[normalize-space()='More']");
        //Click vào edit Project
    private By chooseEditProject = By.xpath("//div[@class='btn-group open']//ul//li[2]//a");

    //-------------------------------------
    //Delete Project Page
        //Click vào Delete Project
    private By chooseDeleteProject = By.xpath("//div[@class='btn-group open']//ul//li[11]//a");

    //Hàm xử lý
    public void verifyProjectsPage() {
        //Kiểm tra url có đúng trang Projects chưa
        Assert.assertEquals(getCurrentURL(),PAGE_URL,"URL chưa đúng trang Projects");
        //Kiểm tra headerPage có tồn tại không
        Assert.assertTrue(checkElementExist_UseBy(headerPageProjects),"Projects Header Page not existing");
        //Kiểm tra headerPage có giống giá trị truyền vào không
        Assert.assertEquals(getTextElement(headerPageProjects),PAGE_TEXT,"Projects Header Page is not match");
    }

    //Add New Project
    public AddNewProjectsPage clickNewProjectsButton() {
        //Kiểm tra button Add Projects có tồn tại
        waitForElementVisible(buttonAddProjects,10);
        //Click vào button
        clickElement(buttonAddProjects);

        return  new AddNewProjectsPage();
    }

    //Search Project
    public void searchProject(String dataSearch) {
        DriverManager.getDriver().findElement(inputSearch).sendKeys(dataSearch,Keys.ENTER);
    }

    //Edit Project
    public EditProjectsPage clickEditProjectsPage() {
        //Click dòng đầu tiên trong bảng
        clickElement(tdCustomerName);
        //Click vào button More
        clickElement(buttonMore);
        //Click vào edit Project
        clickElement(chooseEditProject);

        return new EditProjectsPage();
    }

    //Delete Project
    public void DeleteProject() {
        //Click dòng đầu tiên trong bảng
        clickElement(tdCustomerName);
        //Click vào button More
        clickElement(buttonMore);
        //Click vào delete Project
        clickElement(chooseDeleteProject);
        //Nhấn Ok trên alert
        Alert alert = DriverManager.getDriver().switchTo().alert();
        alert.accept();

    }

    //Open tab menu Task
    public TaskPage openTaskPage() {
        waitForPageLoaded();
        clickElement(menuTask);

        return new TaskPage();

    }

}
