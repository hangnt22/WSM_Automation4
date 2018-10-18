package Project_WSM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class WSM {
    public WebDriver driver;
    public final int TIME_OUT = 20;
    public final String url_WSM = "https://wsm.framgia.vn/en";
    public final String url_OverTime = "https://wsm.framgia.vn/en/dashboard/users/367/request_ots";
    public final String login_btn = "//a[@class='wsm-btn btn-login']";
    public final String user_password = "//input[@id='user_password']";
    public final String user_email = "//input[@id='user_email']";
    public final String ok = "//button[@class='wsm-btn login-success']";
    public final String personal_request = "//span[contains(text(),'Personal requests')]";
    public final String overtime = "//a[contains(text(),'Overtime')]";
    public final String create_overtime = "//a[@class='btn btn-primary']";
    public final String staff_nameLabel = "//label[text()='Staff name']";
    public final String staff_nameTextbox = "//input[@id='employee_name']";
    public final String staff_codeLabel = "//label[text()='Staff code']";
    public final String staff_codeTextbox = "//input[@id='employee_code']";
    public final String branchLabel = "//label[text()='Branch']";
    public final String branchTextbox = "//span[@id='select2-chosen-1']";
    public final String groupLabel = "//label[text()='Group']";
    public final String groupTextbox = "//span[@id='select2-chosen-2']";
    public final String checkboxOT = "//span[text()='Do you OT for other group?']";
    public final String projectLabel = "//label[text()='Project']";
    public final String projectTextbox = "//input[@id='request_ot_project_name']";
    public final String fromLabel = "//label[text()='From']";
    public final String fromTextbox = "//input[@id='request_ot_from_time']";
    public final String toLabel = "//label[text()='To']";
    public final String toTextbox = "//input[@id='request_ot_end_time']";
    public final String reasonLabel = "//label[text()='Reason']";
    public final String reasonTextbox = "//textarea[@id='request_ot_reason']";

    public final String actual01 = "//h1[contains(text(),'Request overtime')]";
    public final String actual03 = "//h3[contains(text(),'New request for overtime')]";
    public final Boolean expect = true;
    public Boolean actual;
    public String actualText;


    void loginWSM() throws InterruptedException {
        clickAction(login_btn);
        wait_TimeOut();
        send_keys(user_email, InformationTest.email);
        send_keys(user_password, InformationTest.password);
        sleep(1);
        clickAction(ok);
    }

    void clickAction(String element) {
        driver.findElement(By.xpath(element)).click();

    }

    void send_keys(String element, String keys) {
        driver.findElement(By.xpath(element)).sendKeys(keys);

    }

    Boolean check_visibleElement(String element) {
        if (driver.findElement(By.xpath(element)).isDisplayed()) return true;
        return false;
    }

    void wait_TimeOut() {
        driver.manage().timeouts().implicitlyWait(TIME_OUT, TimeUnit.SECONDS);
    }

    void wait_element(String element) {
        new WebDriverWait(driver, TIME_OUT).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(element))));
    }

    void sleep(int time) throws InterruptedException {
        Thread.sleep(time * 500);
    }
}