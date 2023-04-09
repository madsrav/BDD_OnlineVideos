package stepDefinitons;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login {
	WebDriver driver;
	@Given("As a user I will launch browser")
	public void as_a_user_i_will_launch_browser() {
		ChromeOptions options= new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
	   driver=new ChromeDriver(options);
	   driver.manage().window().maximize();
	   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	   
	}

	@Given("Enter the url")
	public void enter_the_url() {
	   driver.get("http://localhost:8888/");
	}

	@When("login page is displayed I will enter username and password")
	public void login_page_is_displayed_i_will_enter_username_and_password() {
	    driver.findElement(By.name("user_name")).sendKeys("admin");
	    driver.findElement(By.name("user_password")).sendKeys("admin");
	}

	@When("Click on login")
	public void click_on_login() {
	  driver.findElement(By.id("submitbutton")).click();
	}

	@Then("Home page should display")
	public void home_page_should_display() {
	  System.out.println(driver.getTitle());
	}

	@Then("Also I will verify that home page title")
	public void also_i_will_verify_that_home_page_title() {
	 Assert.assertEquals("Administrator - Home - vtiger CRM 5 - Commercial Open Source CRM", driver.getTitle(),"comparing the title of the page");
	 driver.close();
	}
	@When("login page is displayed I will enter username {string} and password {string}")
	public void login_page_is_displayed_i_will_enter_username_and_password(String username, String password) {
	driver.findElement(By.name("user_name")).sendKeys(username);
	driver.findElement(By.name("user_password")).sendKeys(password);
		
	}
	@Then("Error message should display for user")
	public void error_message_should_display_for_user() {
		
	String actualerrormessage = driver.findElement(By.xpath("//div[@class='errorMessage']")).getText();
	Assert.assertEquals(actualerrormessage ,"You must specify a valid username and password.");
	   
	}
}
