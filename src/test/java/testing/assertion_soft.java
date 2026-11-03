package testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class assertion_soft {

    WebDriver driver;

    @BeforeClass
    public void browser_setup() throws InterruptedException {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        Thread.sleep(3000);
    }

    @Test(priority = 1)
    public void enter_login_credentials() throws InterruptedException {

        Thread.sleep(3000);

        driver.findElement(By.name("username")).sendKeys("Admin");

        driver.findElement(By.name("password")).sendKeys("admin123");
    }

    @Test(priority = 2)
    public void click_on_login_button() throws InterruptedException {

        Thread.sleep(2000);

        driver.findElement(By.tagName("button")).click();

        Thread.sleep(4000);

        String actual = driver.getCurrentUrl();

        String expected =
                "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";

        SoftAssert so = new SoftAssert();

        so.assertEquals(actual, expected);

        System.out.println("Login verified successfully");

        so.assertAll();
    }

    @AfterClass
    public void quit_browser() {

        if (driver != null) {
            driver.quit();
        }
    }
}