package quangtester.com.pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import static quangtester.com.keywords.WebUI.*;

public class AddNewCustomerDiaglog {
    public String PAGE_TEXT_GROUP = "Add New Customer Group";

    public By titleGroup = By.xpath("//span[@class='add-title']");
    public By inputNameGroup = By.xpath("//input[@id='name']");
    public By buttonSubmitGroup = By.xpath("//button[@group='submit']");

}
