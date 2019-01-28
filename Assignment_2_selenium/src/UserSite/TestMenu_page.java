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

class TestMenu_page {

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
//Test cases for Menu file
	@Test
	void listAllDonuts()
	{
		driver.get("http://localhost:8888/donut_shop/public/menu.php");
		List<WebElement> donuts =  driver.findElements(By.className("column"));
		System.out.println("How many donuts: " + donuts.size());
		assertEquals(13, donuts.size());
		for(int i =0 ; i< donuts.size(); i++)
		{
			WebElement e = donuts.get(i);
			 
			System.out.println("No. of donuts:"+e.getText()) ;
			
		}
		 System.out.println("***************************************************");
		
	
	}
	
	@Test
	void clickAddToCart()
	{
		driver.get("http://localhost:8888/donut_shop/public/menu.php");
		WebElement e = driver.findElement(By.xpath("//*[@id=\"2\"]/button"));
		WebElement e1 = driver.findElement(By.id("cartAmt"));
		
		e.click();
		
		assertEquals("1",e1.getText());
		
		
	}


	
}