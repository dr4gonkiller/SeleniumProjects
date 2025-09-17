package www.Nearpedia.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class NearPediaResultPage extends NearpediaBase {
	
	By title = By.xpath("//div[@class='col-md-12']/h1");
	By relevanceSelect = By.cssSelector("#sort");

	public NearPediaResultPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void sortingPricesAscending() {
		explicitWait(title);
		selectElement(relevanceSelect, 1);
		
		//selectElement(relevanceSelect, "asc");		
	}
	
}
