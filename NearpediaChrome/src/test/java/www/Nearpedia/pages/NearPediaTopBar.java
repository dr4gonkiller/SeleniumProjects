package www.Nearpedia.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NearPediaTopBar extends NearpediaBase{
	
	By flightsOption = By.xpath("//a[contains(text(), 'Flights')]");
	
	public NearPediaTopBar(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub		
	}
	
	public void SelectFlightsOption() throws InterruptedException  {
		click(flightsOption);		
	}	
}
