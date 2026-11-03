package testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class assertion_class {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void browser_setup() {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test(priority = 1)
    public void enter_login_credentials() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")))
                .sendKeys("Admin");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")))
                .sendKeys("admin123");
    }

    @Test(priority = 2)
    public void click_on_login_button() {

        wait.until(ExpectedConditions.elementToBeClickable(By.tagName("button")))
                .click();

        wait.until(ExpectedConditions.urlContains("/dashboard/index"));

        String actualUrl = driver.getCurrentUrl();

        String expectedUrl =
                "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";

        Assert.assertEquals(actualUrl, expectedUrl);

        System.out.println("Login verified successfully");
        System.out.println("Actual URL: " + actualUrl);
    }

    @AfterClass
    public void quit_browser() {

        if (driver != null) {
            driver.quit();
        }
    }
}



