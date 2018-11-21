package Project_WSM;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginWSM extends WSM {

    @BeforeMethod
    public void access() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/lib/chromedriver");
        driver = new ChromeDriver();
        driver.get(url_WSM);
        sleep(10);
        clickAction(login_btn);
    }

    @AfterMethod
    void closeBrowser() throws InterruptedException {
        driver.close();
    }

    //check exist variables
    @Test(priority = 0)
    public void case1() {
        String expectTitle = "Login";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectTitle, actualTitle);

        actual = check_visibleElement(user_email);
        Assert.assertEquals(actual, expectTrue);

        actual = check_visibleElement(user_password);
        Assert.assertEquals(actual, expectTrue);

        actual = check_visibleElement(remember);
        Assert.assertEquals(actual, expectTrue);

        actual = check_visibleElement(ok);
        Assert.assertEquals(actual, expectTrue);

        actual = check_visibleElement(btCancel);
        Assert.assertEquals(actual, expectTrue);

        actual = check_visibleElement(forgotpw);
        Assert.assertEquals(actual, expectTrue);
    }

    //check status of remember me radio button
    @Test(priority = 1)
    public void case2() {
        boolean check = driver.findElement(By.id("user_remember_me")).isSelected();
        assertEquals(check, false);
    }

    //check password is encrypted
    @Test(priority = 2)
    public void case3() {
        String actual = driver.findElement(By.id("user_password")).getAttribute("type");
        assertEquals(actual, "password");
    }

    //check login success
    @Test(priority = 3)
    public void case6() throws InterruptedException {
        loginWSM();
        String actualmsgLogin = gettext(flashmsg);
        assertEquals(actualmsgLogin, expected_msgLogin);
    }

    //check directory when login success
    @Test(priority = 4)
    public void case7() throws InterruptedException {
        loginWSM();
        sleep(10);
        String expectedTitle = "Your timesheet | Working space";
        String actualTitle = driver.getTitle();
        sleep(10);
        assertEquals(actualTitle, expectedTitle);
    }

    //check directory when click back button of browser
    @Test(priority = 5)
    public void case8() throws InterruptedException {
        loginWSM();
        driver.navigate().back();
        sleep(10);
        String expectedTitle = "Your timesheet | Working space";
        String actualTitle = driver.getTitle();
        sleep(10);
        assertEquals(actualTitle, expectedTitle);
    }

    //check status when close browser
    @Test(priority = 6)
    public void case9() throws InterruptedException {
        loginWSM();
        sleep(10);
        driver.get("https://www.google.com.vn/");
        sleep(10);
        driver.navigate().back();
        String actualmsgLogin = gettext(flashmsg);
        assertEquals(actualmsgLogin, expected_msgLogin);
    }

    //check login fail with email and password are null
    @Test(priority = 7)
    public void case10() throws InterruptedException {
        send_keys(user_email, "");
        sleep(10);
        send_keys(user_password, "");
        sleep(10);
        clickAction(ok);
        sleep(10);
        String actualemail = gettext(msgEmail);
        assertEquals(expected_msgEmailnull, actualemail);
        String actualpw = gettext(msgPassword);
        assertEquals(expected_msgPwlnull, actualpw);
    }

    //check login fail with invalid email and password
    @Test(priority = 8)
    public void case11() throws InterruptedException {
        send_keys(user_email, "abc@framgia.com");
        sleep(10);
        send_keys(user_password, "Framgia123");
        sleep(10);
        clickAction(ok);
        sleep(10);
        String actualmsg = gettext(msgError);
        sleep(10);
        assertEquals(actualmsg, expected_msgEmailPassword);
    }

    //check login fail with password don't corresponding with email
    @Test(priority = 9)
    public void case12() throws InterruptedException {
        send_keys(user_email, InformationTest.email);
        sleep(10);
        send_keys(user_password, "Framgia123");
        sleep(10);
        clickAction(ok);
        sleep(10);
        String actualmsg = gettext(msgError);
        sleep(10);
        assertEquals(actualmsg, expected_msgEmailPassword);
    }

    //check login fail with invalid email
    @Test(priority = 10)
    public void case13() throws InterruptedException {
        send_keys(user_email, "nguyen.thi.truc.na");
        sleep(10);
        send_keys(user_password, "Framgia123");
        sleep(10);
        clickAction(ok);
        sleep(10);
        String actualmsg = gettext(msgEmail);
        sleep(10);
        assertEquals(actualmsg, expected_msgEmailPassword);
    }
}
