package testng;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
public class Parameterization {
    WebDriver driver;
    @BeforeClass
    @Parameters({"browser", "url"})
    public void browser_setup(String browser, String url) throws InterruptedException {
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
            Thread.sleep(5000);
        } else if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
            Thread.sleep(5000);
        }
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
        String expected = driver.getCurrentUrl();

        driver.findElement(By.tagName("button")).click();

        Thread.sleep(3000);

        // URL after login
        String actual = driver.getCurrentUrl();

        WebElement p = driver.findElement(
                By.xpath("//img[@alt='profile picture']")
        );

        // Profile picture should be visible after successful login
        Assert.assertTrue(p.isDisplayed());

        // URL should change after login
        Assert.assertNotEquals(expected, actual);
        System.out.println("Login verified successfully!!!");
    }

    @Test(priority = 3)
    public void user_logout() throws InterruptedException {

        driver.findElement(By.cssSelector("[alt='profile picture']")).click();
        Thread.sleep(3000);

        driver.findElement(
                By.xpath("//a[text()='Logout']")).click();

        System.out.println("Logout successful");
    }

    @AfterClass
    public void quit_browser() {

        if (driver != null) {
            driver.quit();
        }
    }
}