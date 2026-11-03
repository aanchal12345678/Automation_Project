package testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class suit_class {
    WebDriver driver;
    @BeforeClass
    public void browser_setup() throws InterruptedException{
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(5000);
    }
    @Test(priority=1)
    public void enterLoginCredentials() throws InterruptedException {
        Thread.sleep(4000);
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");

    }
    @Test(priority=2)
    public void click_on_Login_Button(){
        driver.findElement(By.tagName("button")).click();

    }
    @AfterClass
    public void user_logout() throws InterruptedException {
        driver.findElement(By.cssSelector("[alt=\"profile picture\"]")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//a[text()='Logout']")).click();

    }
    @AfterSuite
      public void quit_browser(){
        if(driver!=null) {
            driver.quit();
        }
    }
}

