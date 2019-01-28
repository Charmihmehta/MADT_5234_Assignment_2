package UserSite;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class TestCart_page {

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
	void listAllitems()
	{
		driver.get("http://localhost:8888/donut_shop/public/cart.php");
		List<WebElement> donuts =  driver.findElements(By.className("quatity"));
		System.out.println("Donuts in carts: " + donuts.size());
		assertEquals(1, donuts.size());
		for(int i =0 ; i< donuts.size(); i++)
		{
			WebElement e = donuts.get(i);
			 
			System.out.println("No. of donuts:"+e.getText()) ;
			
		}
		 System.out.println("***************************************************");
		
	
	}
	@Test
	void clickBackButton()
	{
		driver.get("http://localhost:8888/donut_shop/public/cart.php");
		
		//WebElement e = driver.findElement(By.xpath("//*[@id=\"about_us_page\"]/a"));
		 driver.findElement(By.linkText("<-- Go Back")).click();
		String actualOutput = driver.getTitle();
		 if(actualOutput.contentEquals("Home"))
		 {
			 System.out.println("Go Back link is working");
		 }
		 else {
			 System.out.println("Go Back link is not working");
		 }
		 System.out.println("***************************************************");
	}

	
	@Test
	void listTotalPrice()
	{
		driver.get("http://localhost:8888/donut_shop/public/cart.php");
		
		WebElement e = driver.findElement(By.id("total"));
		String total = e.getText();
		assertEquals("$3.99", total);
		if(total!= null)
		{
			System.out.println(total);
		}
		else
		{
			System.out.println("No values");
		}
			
		 System.out.println("***************************************************");
	
	}

	@Test
	void couponTest() {
		driver.get("http://localhost:8888/donut_shop/public/cart.php");
		WebElement coupon = driver.findElement(By.id("couponCode"));
		WebElement button = driver.findElement(By.id("btnCoupon"));
		
		coupon.sendKeys("MADT");
		button.click();
		WebElement p = driver.findElement(By.id("error"));
		
		String actualOutput = p.getText();
		
		if(actualOutput.contentEquals("Valid Code") && actualOutput !=null)
		{
			System.out.println("Code is valid");
		}
		else
		{
			System.out.println("Code invalid");
		}
		 System.out.println("***************************************************");
	}
	
}