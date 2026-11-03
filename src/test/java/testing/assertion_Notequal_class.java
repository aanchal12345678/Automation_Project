package testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class assertion_Notequal_class {

    WebDriver driver;
    String expected;

    @BeforeSuite
    public void browser_setup() throws InterruptedException {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        Thread.sleep(5000);

        expected = driver.getCurrentUrl();
    }

    @Test(priority = 1)
    public void enter_login_credentials() throws InterruptedException {

        Thread.sleep(3000);

        driver.findElement(By.name("username")).sendKeys("Admin");

        driver.findElement(By.name("password")).sendKeys("admin123");
    }

    @Test(priority = 2)
    public void click_on_login_button() throws InterruptedException {

        Thread.sleep(3000);

        driver.findElement(By.tagName("button")).click();

        Thread.sleep(4000);

        String actual = driver.getCurrentUrl();

        WebElement p = driver.findElement(
                By.xpath("//img[@alt=\"profile picture\"]")
        );

        Assert.assertTrue(p.isDisplayed());

        Assert.assertNotEquals(expected, actual);

        System.out.println("URL before login: " + expected);
        System.out.println("URL after login: " + actual);
        System.out.println("Login verified successfully!!!");
    }

    @AfterClass
    public void user_logout() throws InterruptedException {

        driver.findElement(
                By.cssSelector("[alt=\"profile picture\"]")
        ).click();

        Thread.sleep(3000);

        driver.findElement(
                By.xpath("//a[text()='Logout']")
        ).click();
    }

    @AfterSuite
    public void quit_browser() {

        if (driver != null) {
            driver.quit();
        }
    }
}