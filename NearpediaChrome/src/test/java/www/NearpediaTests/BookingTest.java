package www.NearpediaTests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import www.Nearpedia.pages.NearPediaTopBar;
import www.Nearpedia.pages.NearPediaFlightsPage;
import www.Nearpedia.pages.NearPediaResultPage;
public class BookingTest {
	
	private WebDriver driver;
	NearPediaTopBar topBar;
	NearPediaFlightsPage flights;
	NearPediaResultPage results;
	
	@BeforeClass
	public void BeforeMethod() throws Exception{
		topBar = new NearPediaTopBar(driver);
		driver = topBar.chromeDriverConnection();	
		topBar.visit("C:/Users/ferme/Desktop/638532054517960156_392238/site/index.html");
	}
	
	@Test
	public void bookAflightTest() throws Exception{
		topBar.SelectFlightsOption();
		flights = new NearPediaFlightsPage(driver);
		flights.SelectFlightFromAndTo();
		results = new NearPediaResultPage(driver);
		results.sortingPricesAscending();
	}	
	
	@AfterClass
	public void AfterMethod() throws Exception{
		//driver.quit();
	}
	
}
