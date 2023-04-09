package dataTableOrganizationWithMap.stepDefinitions;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


//ctrl+shift+o--> to get the removed imports

public class DataTableOrganization {
	WebDriver driver;
	String name;
	String email;
	String phone;
	
	@Given("I will Launch browser")
	public void i_will_launch_browser() {
	  
	    ChromeOptions options = new ChromeOptions();
	    options.addArguments("--remote-allow-origins=*");
	    driver=new ChromeDriver(options);
	}
	@Given("enter the url")
	public void enter_the_url() {
	   driver.get("http:localhost:8888/");
	}
	@Given("when the login page is displayed i will enter username {string} and password {string}")
	public void when_the_login_page_is_displayed_i_will_enter_username_and_password(String username, String password) {
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
	}
	@Given("click on login")
	public void click_on_login() {
		driver.findElement(By.id("submitbutton")).click();
	}
	@When("home page is displayed click on contact")
	public void home_page_is_displayed_click_on_contact() {
		 driver.findElement(By.linkText("Contacts")).click();
	}
	@When("click on create contact button")
	public void click_on_create_contact_button() {
		driver.findElement(By.xpath("//img[contains(@alt,'Create Contac')]")).click();
	}
	@When("enter contact name contact email and contact phone")
	public void enter_contact_name_contact_email_and_contact_phone(DataTable dataTable) {
		List<Map<String, String>> data = dataTable.asMaps();
		 name = data.get(0).get("lname");
		 email=data.get(0).get("Email");
		 phone = data.get(0).get("Phone");
	   driver.findElement(By.name("lastname")).sendKeys(name);
	   driver.findElement(By.id("email")).sendKeys(email);
	   driver.findElement(By.id("mobile")).sendKeys(phone);
	}
	@When("click on save button")
	public void click_on_save_button() { 
		 driver.findElement(By.xpath("//input[@accesskey='S']")).click();
	}
	@Then("verify contact name and contact email and contact phone")
	public void verify_contact_name_and_contact_email_and_contact_phone() {
		String actlastname = driver.findElement(By.xpath("//span[@id='dtlview_Last Name']")).getText();
		String actemail = driver.findElement(By.xpath("//span[@id='dtlview_Email']")).getText();
		String actphone = driver.findElement(By.xpath("//span[@id='dtlview_Mobile']")).getText();
	    Assert.assertEquals(name,actlastname);
	    Assert.assertEquals(email,actemail);
	    Assert.assertEquals(phone,actphone);
		
	}
	@Then("close the browser")
	public void close_the_browser() {
	   driver.close();
	}

}
