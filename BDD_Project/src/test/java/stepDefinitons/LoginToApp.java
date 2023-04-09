package stepDefinitons;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginToApp {
	WebDriver driver;

	@Given("As a user I will launch browser {string}")
	public void as_a_user_i_will_launch_browser(String browser) {
		if (browser.equals("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(options);
		} else if (browser.equals("Edge")) {
			driver = new EdgeDriver();
		} else {
			System.out.println("browser not found");
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Given("Enter the url {string}")
	public void enter_the_url(String url) {
		driver.get(url);
	}

	@When("login page is displayed I will enter invalid username {string} and password {string}")
	public void login_page_is_displayed_i_will_enter_invalid_username_and_password(String username, String password) {
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);

	}

	@When("click on login")
	public void click_on_login() {
		driver.findElement(By.id("submitbutton")).click();
	}

	@Then("Error message should display for user {string}")
	public void error_message_should_display_for_user(String ExpectedErrorMsg) {
		
		String actualerrormessage = driver.findElement(By.xpath("//div[@class='errorMessage']")).getText();
		Assert.assertEquals(ExpectedErrorMsg,actualerrormessage ,"comparing both error messages");

	}

}
