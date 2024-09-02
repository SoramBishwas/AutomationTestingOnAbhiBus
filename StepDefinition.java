package StepDefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDef {
	 WebDriver driver;
	 WebDriverWait wait;
	
	 @Given("the user opens the Abhibus website")
	public void the_user_opens_the_abhibus_website() {
		WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        
            System.out.println("Opening the Abhibus website");
            driver.get("https://www.abhibus.com/");
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));

           
	}

	@When("the user selects {string} as origin and {string} as destination")
	public void the_user_selects_as_origin_and_as_destination(String string, String string2) throws InterruptedException {
		 System.out.println("Clicking on 'From Station' input box");
         wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='From Station']"))).click();
         WebElement origin = driver.findElement(By.xpath("//input[@placeholder='From Station']"));
         origin.sendKeys("Bangalore");
         Thread.sleep(2000);
         origin.sendKeys(Keys.ENTER);
  
         WebElement destination = driver.findElement(By.xpath("//input[@placeholder='To Station']"));
         destination.click();
         destination.sendKeys("Goa");
         Thread.sleep(1000);
         destination.sendKeys(Keys.ENTER);
         System.out.println("Entering destination 'Goa'");
         Thread.sleep(1000);
	}

	@When("the user selects {string} as the travel date")
	public void the_user_selects_as_the_travel_date(String string) throws InterruptedException {
		 System.out.println("Selecting 'Tomorrow' for travel date");
         wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text() = 'Tomorrow']"))).click();
         driver.getTitle();       
         System.out.println("Succesfully loaded");
         Thread.sleep(2000);
	}

	@When("the user filters by {string} and {string} bus types")
	public void the_user_filters_by_and_bus_types(String string, String string2) {
		 driver.findElement(By.id("seat-filter-bus-type"));
         WebElement acCheckbox= driver.findElement(By.linkText("AC"));
         acCheckbox.click();
         System.out.println("AC selected");
         
         WebElement sleeperCheckbox= driver.findElement(By.linkText("Sleeper"));
         sleeperCheckbox.click();
         System.out.println("Sleeper Selected");
	}

	@When("the user selects seat {string}")
	public void the_user_selects_seat(String string) throws InterruptedException {
		WebElement showSeats= driver.findElement(By.xpath("//button[contains(text(), 'Show Seats')][1]"));
        showSeats.click();
        
        //Selecting Bus Seat
        WebElement Seat = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='4UC']")));
        Seat.click();
        Thread.sleep(2000);
	}

	@When("the user selects the boarding and dropping points")
	public void the_user_selects_the_boarding_and_dropping_points() throws InterruptedException {
		 WebElement boardingPointContainer=  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[text()='Silk Board - Near Skoda Showroom,  Towards Marathahalli']")));
         boardingPointContainer.click();
         Thread.sleep(2000);
      
         WebElement droppingPointDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[text()='Canacona']")));
         droppingPointDropdown.click();
         System.out.println("dropping point Selected");
         Thread.sleep(2000);
	}

	@Then("the user proceeds to payment")
	public void the_user_proceeds_to_payment() throws InterruptedException {
		 System.out.println("Proceeding to payment");
         WebElement proceedButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn  filled primary md inactive button']")));
         proceedButton.click();
         System.out.println("Proceeded to payment");

         // Skip
         Thread.sleep(3000);
         driver.findElement(By.xpath("//a[text()='Skip']")).click();
         System.out.println("The End");

	}



}
