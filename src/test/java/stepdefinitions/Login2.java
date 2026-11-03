package stepdefinitions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Login2 {
    WebDriver driver;
    WebDriverWait wait;
    String user;
    String pass;
    @Before
    public  void setup(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
    }
    @After
    public void teardown() {
        if (driver != null){
            driver.quit();
        }
    }

    @Given("user got the login page")
    public void userGOTTheLoginPage(){
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }
    @When("Enter the login data {String} and {String}")
    public void enter_the_login_data(String username,String password) {

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
    }
    @And("press the enter button")
    public void press_the_enter_button(){
    }
    @Then("login succesful correct data")
    public void login_succesful_correct_data(){

    }
    @And(" user get error with incorrect data")
    public void  user_get_error_with_incorrect_data(){


    }

}


