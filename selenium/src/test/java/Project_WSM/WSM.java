package Project_WSM;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class WSM {

    //constant
    public final int TIME_OUT = 20;
    public final Boolean expectTrue = true;
    public final String disbaleTrue = "true";

    //Variable
    public Boolean actual;
    public String actualText;
    public String actualDisabled;
    public WebDriver driver;

    //xpath login screen
    public final String login_btn = "//a[@class='wsm-btn btn-login']";
    public final String user_password = "//input[@id='user_password']";
    public final String user_email = "//input[@id='user_email']";
    public final String ok = "//button[@class='wsm-btn login-success']";

    //xpath WSM home screen
    public final String personal_request = "//span[contains(text(),'Personal requests')]";
    public final String overtime = "//a[contains(text(),'Overtime')]";

    //xpath Request Overtime list screen
    public final String create_overtime = "//a[@class='btn btn-primary']";
    public final String employeeXpath = "//tbody[@class='list-request-ots']//td[1]";
    public final String staffNameXpath = "//tbody[@class='list-request-ots']//td[2]";
    public final String dateOfCreationXpath = "//tbody[@class='list-request-ots']//td[3]";
    public final String fromXpath = "//tbody[@class='list-request-ots']//td[4]";
    public final String toXpath = "//tbody[@class='list-request-ots']//td[5]";
    public final String projectNameXpath = "//tbody[@class='list-request-ots']//td[6]";
    public final String reasonXpath = "//tbody[@class='list-request-ots']//td[7]";
    public final String statusXpath = "//tbody[@class='list-request-ots']//td[8]";
    public final String beingHandledByXpath = "//tbody[@class='list-request-ots']//td[9]";
    public final String requestHoursXpath = "//tbody[@class='list-request-ots']//td[10]";
    public final String actual01 = "//h1[contains(text(),'Request overtime')]";

    //xpath Create Request Overtime screen
    public final String staff_nameLabel = "//label[text()='Staff name']";
    public final String staff_nameTextbox = "//input[@id='employee_name']";
    public final String staff_codeLabel = "//label[text()='Staff code']";
    public final String staff_codeTextbox = "//input[@id='employee_code']";
    public final String branchLabel = "//label[text()='Branch']";
    public final String branchTextbox = "//span[@id='select2-chosen-1']";
    public final String groupLabel = "//label[text()='Group']";
    public final String groupTextbox = "//span[@id='select2-chosen-2']";
    public final String groupDropDown = "//span[@id='select2-chosen-3']";
    public final String optionDropDown = "//div[@role='option']";
    public final String checkboxOT = "//span[text()='Do you OT for other group?']";
    public final String projectLabel = "//label[text()='Project']";
    public final String projectTextbox = "//input[@id='request_ot_project_name']";
    public final String fromLabel = "//label[text()='From']";
    public final String fromTextbox = "//input[@id='request_ot_from_time']";
    public final String toLabel = "//label[text()='To']";
    public final String toTextbox = "//input[@id='request_ot_end_time']";
    public final String reasonLabel = "//label[text()='Reason']";
    public final String reasonTextbox = "//textarea[@id='request_ot_reason']";
    public final String saveBtn = "//input[@value='Save']";
    public final String error = "//li[@class='text-danger']";
    public final String errorProjectName = "//div[@id='request_ot_project_name-error']";
    public final String errorFrom = "//div[@id='request_ot_from_time-error']";
    public final String errorTo = "//div[@id='request_ot_end_time-error']";
    public final String errorReason = "//div[@id='request_ot_reason-error']";
    public final String newRequestScr = "//h3[contains(text(),'New request for overtime')]";

    //variables in logout
    public String img = "//img[@src='/assets/user_avatar_default-bc6c6c40940226d6cf0c35571663cd8d231a387d5ab1921239c2bd19653987b2.png']";
    public String btLogout = "//a[@class='button-logout']";

    //Url test
    public String url_WSM = "https://edev.framgia.vn";
    public String url_OverTime = "https://wsm.framgia.vn/en/dashboard/users/367/request_ots";
    public String tryUrl = "https://edev.framgia.vn/en/dashboard/user_settings/edit";
    public String tryUrl1 = "https://edev.framgia.vn/en/dashboard/import_timesheets";

    //message
    public String expected_msgEmailPassword = "Invalid email or password.";
    public String expected_msgEmail = "Please enter a valid email address";
    public String expected_msgEmailnull = "Email is required";
    public String expected_msgPwlnull = "Password is required";
    public String expected_msgLogin = "Signed in successfully.";

    public String expected_msgLogout = "Signed out successfully.";
    public String expected_msgTrylogin = "You need to sign in or sign up before continuing.";

    //variables in login
    public String remember = "//label[@class ='checkbox-remember']";
    public String btCancel = "//a[@class='wsm-btn login-cancel']']";
    public String forgotpw = "//a[@class='btn-forgot-password']";

    //variable message
    public String msgError = "//p[@class='alert alert-danger']";
    public String msgEmail = "//p[@for='user_email']";
    public String msgPassword = "//p[@for='user_password']";
    public String flashmsg = "//div[@id='flash-message']";

    public String expectedTitle = "Your timesheet | Working space";

    //Forgot Password screen
    //Data Test
    public final String wsm_email = "framgia.qa@gmail.com";
    public final String invalid_email = "abcddd";
    public final String not_existed_email = "abc123@framgia.com";
    public final String gmail_pw = "dn123456";
    //Element
    public final String fp_Okbtn = "//*[@id=\"devise-forgot-password-form\"]/div[2]/button";
    public final String fp_backlink = "/html/body/div[2]/div[2]/div[2]/a";
    public final String fp_emailtxb = "//*[@id=\"user_email\"]";
    public final String fp_error_message = "//*[@id=\"devise-forgot-password-form\"]/div[1]/p";
    public final String fp_alert_mess = "/html/body/div[2]/div[2]/section/div/p";
    public final String fp_without_email = "Email is required";
    public final String fp_invalid_email = "Please enter a valid email address";
    public final String fp_notfound_email = "Email not found";
    public final String fp_send_succes = "You will receive an email with instructions on how to reset your password in a few minutes.";
    //Gmail
    //Data Test
    public final String gmail_url = "https://mail.google.com";
    public final String email_fp_subject = "[WSM] Reset password instructions";
    //Element
    public final String gmail_checkbox = "//*[@id=\":39\"]/div";
    public final String gmail_delete = "//*[@id=\":5\"]/div[2]/div[1]/div/div[2]/div[3]";
    public final String gmail_emailtxb = "//*[@id=\"identifierId\"]";
    public final String gmail_next1btn = "//*[@id=\"identifierNext\"]/content/span";
    public final String gmail_next2btn = "//*[@id=\"passwordNext\"]/content";
    public final String gmail_passtxb = "//*[@id=\"password\"]/div[1]/div/div[1]/input";
    public final String gmail_subject_label = "//*[@class=\"F cf zt\"]/tbody/tr";
    public final String email_changepw_link = "//*[@class=\"ii gt\"]/div/div/table/tbody/tr[4]/td/a";
    public JavascriptExecutor js = (JavascriptExecutor) driver;
    //Change Password screen
    //Data Test
    public final String cp_invalid_leastpass = "123";
    public final String cp_invalid_morepass = "qa1234567812345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789t";
    public final String cp_without_bothpass = "Password is required";
    public final String cp_least_bothpass = "Please enter at least 6 characters";
    public final String cp_more_bothpass = "Please enter max 128 characters";
    public final String cp_notmatch_pass = "Please enter the same value again.";
    public final String cp_oldpass = "ab12345678";
    public final String cp_newpass = "qa123456";
    public final String cp_confirmpw = "ac234567";
    //Element
    public final String cp_title_lb = "/html/body/div/section/div[2]/label";
    public final String cp_newpass_txb = "//*[@id=\"user_password\"]";
    public final String cp_confirmpass_txb = "//*[@id=\"user_password_confirmation\"]";
    public final String cp_Okbtn = "//*[@id=\"devise-change-password-form\"]/div[3]/button";
    public final String cp_newpass_errorlb = "//*[@id=\"user_password-error\"]";
    public final String cp_confirmpass_errorlb = "//*[@id=\"user_password_confirmation-error\"]";
    public final String cp_alert_mess = "//*[@id=\"devise-change-password-form\"]/ul/li";
    public final String cp_newpass_lb = "//*[@id=\"devise-change-password-form\"]/div[1]/div/label";
    public final String cp_confirmpass_lb = "//*[@id=\"devise-change-password-form\"]/div[2]/div/label";
    //TimeSheet
    //Element
    public final String ts_alert = "//*[@id=\"flash-message\"]";
    public final String ts_title = "//*[@id=\"main-container\"]/div[2]/div[2]/div[1]/div[2]/h1";
    public final String ts_avatar = "//*[@id=\"navbar\"]/ul[2]/li[6]/a/img";
    public final String ts_logout_btn = "//*[@id=\"navbar\"]/ul[2]/li[6]/div/div[4]/a";
    public final String ts_cpsuccess = "Your password has been changed successfully. You are now signed in.";
    public final String login_alert_mess = "/html/body/div[2]/div[1]/section/div/p";


    //Login to WSM function
    void loginWSM() throws InterruptedException {
        clickAction(login_btn);
        wait_TimeOut();
        send_keys(user_email, InformationTest.email);
        send_keys(user_password, InformationTest.password);
        sleep(1);
        clickAction(ok);
    }

    //action click element xpath
    void clickAction(String element) {
        driver.findElement(By.xpath(element)).click();

    }

    //action clear element xpath
    void clearText(String element) {
        driver.findElement(By.xpath(element)).clear();

    }

    //action gettext element xpath
    String gettext(String element) {
        return driver.findElement(By.xpath(element)).getText();

    }

    //action send keys element xpath
    void send_keys(String element, String keys) {
        driver.findElement(By.xpath(element)).sendKeys(keys);

    }

    // check visible element xpath
    Boolean check_visibleElement(String element) {
        if (driver.findElement(By.xpath(element)).isDisplayed()) return true;
        return false;
    }

    // wait timeout function
    void wait_TimeOut() {
        driver.manage().timeouts().implicitlyWait(TIME_OUT, TimeUnit.SECONDS);
    }

    // wait element visible function
    void wait_element(String element) {
        new WebDriverWait(driver, TIME_OUT).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(element))));
    }

    // Sleep function
    void sleep(int time) throws InterruptedException {
        Thread.sleep(time * 100);
    }

    void open_changepass(String email) throws InterruptedException {
        driver.findElement(By.cssSelector("#devise-forgot-password-form > div.input-field > div.login-text-field > #user_email")).sendKeys(email);

        //Click OK button
        driver.findElement(By.cssSelector("#devise-forgot-password-form > div.text-center.pd-top-20 > button[name=\"button\"]")).click();
        sleep(20);
        driver.get(gmail_url);
        //Enter email and click Next button
        send_keys(gmail_emailtxb, wsm_email);
        clickAction(gmail_next1btn);
        ;
        sleep(20);

        //Enter Password of email and click Next button
        send_keys(gmail_passtxb, gmail_pw);
        clickAction(gmail_next2btn);
        sleep(30);
        //Open email
        driver.findElement(By.id(":3d")).click();
        sleep(10);

        //clickAction(email_changepw_link);
        clickAction(email_changepw_link);

        sleep(20);

        String oldTab = driver.getWindowHandle();
        ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
        newTab.remove(oldTab);
        // change focus to new tab
        driver.switchTo().window(newTab.get(0));
    }

    void change_password(String password) throws InterruptedException {
        send_keys(cp_newpass_txb, password);
        send_keys(cp_confirmpass_txb, password);
        clickAction(cp_Okbtn);

        sleep(20);

        clickAction(ts_avatar);
        clickAction(ts_logout_btn);
        sleep(10);
    }

    void delete_email() throws InterruptedException {
        driver.get(gmail_url);
        sleep(20);

        //delete email
        clickAction(gmail_subject_label);
        clickAction(gmail_delete);
        sleep(20);

    }

    void open_forgot_password() throws InterruptedException {
        //Open edv.framgia.vn
        System.setProperty("webdriver.chrome.driver", "src/lib/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(url_WSM);
        wait_TimeOut();
        sleep(5);

        driver.manage().window().maximize();

        //Click Login button
        clickAction(login_btn);
        sleep(5);

        //Click Forgot Password link
        driver.findElement(By.linkText("Forgot password")).click();
        sleep(20);

    }

}