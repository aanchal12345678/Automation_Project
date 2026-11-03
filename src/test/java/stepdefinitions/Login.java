package stepdefinitions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Login {
    WebDriver driver;
    WebDriverWait wait;
    @Given("Go to loginpage")
    public void go_to_loginpage() {
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @When("enter correct username and password")
    public void enter_correct_username_and_password() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username"))).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
    }

    @And("click on login button")
    public void click_on_login_button() {
        driver.findElement(By.tagName("button")).click();
    }

    @Then("login succesfull")
    public void login_succesfull() {
        String loginpageurl =driver.getCurrentUrl();
        Assert.assertNotEquals(loginpageurl,"https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }
    @Then("profile picture displayed")
    public void profile_picture_displayed() {
    }
}