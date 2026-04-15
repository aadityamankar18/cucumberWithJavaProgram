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
    WebDriver driver;

    // 🔹 SauceDemo locators
    By username = By.id("user-name");
    By password = By.id("password");
    By loginButton = By.id("login-button");

    // 🔹 Rahul Shetty locators
    By username2 = By.id("inputUsername");
    By password2 = By.name("inputPassword");
    By loginButton2 = By.xpath("//button[@type='submit']");

    // ================= HOOKS =================

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    // ================= GIVEN =================

    @Given("opened the application")
    public void opened_the_application() {
        driver.get("https://www.saucedemo.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));
    }

    @Given("opened the website")
    public void opened_the_website() {
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(username2));
    }

    // ================= WHEN =================

    @When("user enters {string} and {string}")
    public void user_enters_credentials(String user, String pass) {

        // SauceDemo
        if (driver.getCurrentUrl().contains("saucedemo")) {
            driver.findElement(username).sendKeys(user);
            driver.findElement(password).sendKeys(pass);
            driver.findElement(loginButton).submit();
        }

        // Rahul Shetty
        else if (driver.getCurrentUrl().contains("rahulshettyacademy")) {
            driver.findElement(username2).sendKeys(user);
            driver.findElement(password2).sendKeys(pass);
            driver.findElement(loginButton2).click();
        }
    }

    // ================= THEN =================

    @Then("saucedemo login should be {string}")
    public void saucedemo_login_should_be(String status) {

        String currentUrl = driver.getCurrentUrl();

        if (status.equals("success") && currentUrl.contains("inventory.html")) {
            System.out.println("SauceDemo Login successful");
        } else if (status.equals("fail") && !currentUrl.contains("inventory.html")) {
            System.out.println("SauceDemo Login failed as expected");
        } else {
            System.out.println("Unexpected result in SauceDemo");
        }
    }

    @Then("rahul login should be {string}")
    public void rahul_login_should_be(String status) {

        String currentUrl = driver.getCurrentUrl();

        if (status.equals("success") && currentUrl.contains("locatorspractice")) {
            System.out.println("RahulShetty Login successful");
        } else if (status.equals("fail") && !currentUrl.contains("locatorspractice")) {
            System.out.println("RahulShetty Login failed as expected");
        } else {
            System.out.println("Unexpected result in RahulShetty");
        }
    }
}