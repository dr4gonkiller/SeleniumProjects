package www.Nearpedia.pages;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class NearpediaBase {
	
protected WebDriver driver;
	
	public NearpediaBase(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebDriver chromeDriverConnection() {		
		System.setProperty("webdriver.chrome.driver","./src/test/resources/webDrivers/chromedriver.exe" );
		driver = new ChromeDriver();
		return driver;
	}
	
	public void visit(String path) {
		driver.manage().window().maximize();
		
		String URL;
		File file = new File(path);
		URL = "file:///" + file.getAbsolutePath();
		driver.get(URL);			
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}	
	
	public void click(By locator) {
		driver.findElement(locator).click();
	}
	
	public void sendKeys(String inputText , By locator) {
		driver.findElement(locator).sendKeys(inputText);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	public void selectOption(By locator, String option) {
		WebElement selectElement = driver.findElement(locator);
		Select select = new Select(selectElement);
		select.selectByVisibleText(option);
		
	}
	
	public void explicitWait(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));		
	}
	
	public void selectElement(By locator, int value) {
		WebElement sortDropdown = driver.findElement(locator);
		Select select = new Select(sortDropdown);
		explicitWait(locator);
		select.selectByIndex(value);
	}
}
