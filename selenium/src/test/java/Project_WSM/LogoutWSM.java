package Project_WSM;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogoutWSM extends WSM {
    @BeforeMethod
    public void access() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/lib/chromedriver");
        driver = new ChromeDriver();
        driver.get(url_WSM);
        sleep(10);
    }

    @AfterMethod
    void closeBrowser() throws InterruptedException {
        driver.close();
    }

    //check logout successfully
    @Test(priority = 0)
    public void case1_Logout() throws InterruptedException {
        loginWSM();
        sleep(10);
        clickAction(img);
        sleep(10);
        clickAction(btLogout);
        sleep(10);
        String actualmsgLogout = gettext(flashmsg);
        assertEquals(actualmsgLogout, expected_msgLogout);
    }

    //check system redirects to login page
    @Test(priority = 1)
    public void case2_Logout() throws InterruptedException {
        loginWSM();
        sleep(10);
        clickAction(img);
        sleep(10);
        clickAction(btLogout);
        sleep(10);
        String expectTitle = "Working space";
        String actualTitle = driver.getTitle();
        assertEquals(expectTitle, actualTitle);
    }

    //check that user session is clear
    @Test(priority = 2)
    public void case3_Logout() throws InterruptedException {
        loginWSM();
        sleep(10);
        clickAction(img);
        sleep(10);
        clickAction(btLogout);
        sleep(10);
        //driver.get("https://wsm.framgia.vn/en/dashboard/user_settings/edit");
        driver.get(tryUrl);
        String actualmsgTryLogin = gettext(flashmsg);
        assertEquals(actualmsgTryLogin, expected_msgTrylogin);
    }

    //check that systems is redirected to login page when access any url of wsm
    @Test(priority = 3)
    public void case4_Logout() throws InterruptedException {
        loginWSM();
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");
        sleep(10);
        //driver.get("https://wsm.framgia.vn/en/dashboard/import_timesheets");
        driver.get(tryUrl1);
        sleep(10);
        clickAction(img);
        sleep(10);
        clickAction(btLogout);
        sleep(10);
        String actualmsgLogout = gettext(flashmsg);
        assertEquals(actualmsgLogout, expected_msgLogout);
    }

    //check that system isn't redirected any page when click on back button of browser
    @Test(priority = 4)
    public void case5_Logout() throws InterruptedException {
        loginWSM();
        sleep(10);
        clickAction(img);
        sleep(10);
        clickAction(btLogout);
        sleep(10);
        driver.navigate().back();
        sleep(10);
        Boolean check = true;
        assertEquals(check_visibleElement(login_btn), check);
    }

}
