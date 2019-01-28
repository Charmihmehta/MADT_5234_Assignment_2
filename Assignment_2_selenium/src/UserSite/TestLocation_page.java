package UserSite;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class TestLocation_page {

	protected final static String CHROME_DRIVER_PATH = "/Users/charmimehta/Downloads/chromedriver";
	protected static WebDriver driver;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		// Start Chrome
		System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
		driver = new ChromeDriver();
		
		// Set the "waiting period" between each command
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		driver.quit();
	}
//Test cases for Location file
	@Test
	void listAlllocations()
	{
		driver.get("http://localhost:8888/donut_shop/public/locations.php");
		List<WebElement> locations =  driver.findElements(By.className("all_locations"));
		System.out.println("How many elemnts: " + locations.size());
		assertEquals(6, locations.size());
		for(int i =0 ; i< locations.size(); i++)
		{
			WebElement e = locations.get(i);
			System.out.println("locations:"+e.getText());
			
		}
		
		

	}


	
}