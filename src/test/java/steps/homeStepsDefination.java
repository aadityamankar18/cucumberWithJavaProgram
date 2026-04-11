package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class homeStepsDefination {
    WebDriver driver;   // 👈 class-level driver

    @Given("opened the application")
    public void opened_the_application() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com/");
    }

    @When("added the credentials")
    public void added_the_credentials() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).submit();
    }

    @Then("login successful")
    public void login_successful() throws InterruptedException {
        if(driver.getCurrentUrl().equals("https://www.saucedemo.com/inventory.html")) {
            System.out.println("Login successful");
        } else {
            System.out.println("Login failed");
        }
        Thread.sleep(2000);  // Just to see the result before closing the browser
        driver.quit();
    }
}
