package testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Data_Provider {
    WebDriver driver;
    @Test (priority = 0)
    public void browser_setup() throws InterruptedException{
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(4000);
    }
    @Test(priority=1)
    public void enter_Login_Credentials(S)  throws InterruptedException{
        Thread.sleep(4000);
        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);

    }
    @Test(priority=2)
    public void clickLoginButton(){
        driver.findElement(By.tagName("button")).click();

    }
    @Test(priority=3)
    public void browser_tearDown(){
        if(driver!=null) {
            driver.quit();
        }
    }
}










}
