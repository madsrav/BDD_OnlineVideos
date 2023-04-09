package stepDefinitons;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateOrganization {
	WebDriver driver;
	@Given("As a user I will launch browser1")
	public void as_a_user_i_will_launch_browser1() {
	   ChromeOptions options = new ChromeOptions();
	   options.addArguments("--remote-allow-origins=*");
	   driver= new ChromeDriver(options);	
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	   driver.manage().window().maximize();
	}

	@Given("I will enter url")
	public void i_will_enter_url() {
	   driver.get("http:localhost:8888/");
	}
	@When("login page is displayed I will enter Username {string} and password {string}")
	public void login_page_is_displayed_i_will_enter_Username_and_password(String username, String password) {
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password,Keys.ENTER);
		//driver.findElement(By.id("submitbutton")).click();
	}

	@Given("In home page click on organization")
	public void in_home_page_click_on_organization() {
	  // driver.findElement(By.xpath("//td[@class='tabUnSelected']/a[.='Organizations']")).click();
	   driver.findElement(By.linkText("Organizations")).click();
	}

	@When("organization page is displayed click on create organization")
	public void organization_page_is_displayed_click_on_create_organization() {
	    driver.findElement(By.xpath("//img[contains(@alt,'Create Organ')]")).click();
	}

	@When("In organization page enter organization name {string} and organization email {string}")
	public void in_organization_page_enter_organization_name_and_organization_email(String orgname, String email) {
	   driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgname);
	   driver.findElement(By.xpath("//input[@name='email1']")).sendKeys(email);	
	}

	@Then("click on save")
	public void click_on_save() {
	   driver.findElement(By.xpath("//input[@accesskey='S']")).click();
	}

	@Then("Verify that organization is created or not {string}")
	public void verify_that_organization_is_created_or_not(String Orgname) {
	   String actualorgname = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	   Assert.assertEquals(actualorgname.contains(Orgname), true);
	   driver.quit();
	}

}
