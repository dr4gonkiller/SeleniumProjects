package www.Nearpedia.pages;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NearPediaFlightsPage extends NearpediaBase {
	
	By flightFrom = By.xpath("//select[contains(@name, 'flight-from')]");
	By flightTo = By.xpath("//select[contains(@id, 'flight-to')]");
	By departing = By.cssSelector("#departing");
	By returning = By.cssSelector("#returning");
	By searchFlightButton = By.xpath("//button[contains(@class, 'btn-primary')]");
	

	public NearPediaFlightsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void SelectFlightFromAndTo() {
		selectOption(flightFrom, "CDMX");
		selectOption(flightTo, "La Habana");		
		explicitWait(departing);
		
		 // Calculate tomorrow's date
        LocalDate tomorrow = LocalDate.now().plusDays(1);
        String formattedDate = tomorrow.format(DateTimeFormatter.ofPattern("MM-dd-yyy"));        
        sendKeys(formattedDate, departing);  
        
        LocalDate returningFiveDaysAfterTomorrow = LocalDate.now().plusDays(6);
        String formattedDate2 = returningFiveDaysAfterTomorrow.format(DateTimeFormatter.ofPattern("MM-dd-yyy"));        
        sendKeys(formattedDate2, returning); 
        
        click(searchFlightButton);
        
	}
}
