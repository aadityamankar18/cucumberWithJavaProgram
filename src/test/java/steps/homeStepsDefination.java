package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class homeStepsDefination {
    WebDriver driver;   // 👈 class-level driver

    By username = By.id("user-name");
    By password = By.id("password");
    By loginButton = By.id("login-button");

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @Given("opened the application")
    public void opened_the_application() {
        driver.get("https://www.saucedemo.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("login-button")));
    }

    @When("user enters {string} and {string}")
    public void added_the_credentials(String user, String pass) {
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(loginButton).submit();
    }

    @Then("login should be {string}")
    public void login_should_be(String status) {
        String currentUrl = driver.getCurrentUrl();

        if(status.equals("success") && currentUrl.contains("inventory.html")) {
            System.out.println("Login successful");
        } else if(status.equals("fail") && !currentUrl.contains("inventory.html")) {
            System.out.println("Login failed as expected");
        } else {
            System.out.println("Unexpected result");
        }
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);  // Just to see the result before closing the browser
        driver.quit();
    }
}
