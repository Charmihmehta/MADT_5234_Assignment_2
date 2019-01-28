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

class TestUserSite {

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
//Test cases for index file
	@Test
	void listAlllinks()
	{
		driver.get("http://localhost:8888/donut_shop/public");
		// Store all links with the 'a' tag in a Array List
		List Alllinks = driver.findElements(By.tagName("a"));
		assertEquals(5, Alllinks.size());
		// Iterate the Array List
		Iterator iterate = Alllinks.iterator();
		System.out.println("All links:");
		while (iterate.hasNext()) {
		// Print the URL
		String url = ((WebElement) iterate.next()).getAttribute("href");
		System.out.println(url);
		}
		System.out.println("***************************************************");
	}
	@Test
	void homePageAboutLink() {

		
		driver.get("http://localhost:8888/donut_shop/public");
		//WebElement e = driver.findElement(By.xpath("//*[@id=\"about_us_page\"]/a"));
		 driver.findElement(By.linkText("About Us")).click();
		String actualOutput = driver.getTitle();
		 if(actualOutput.contentEquals("About Us"))
		 {
			 System.out.println("About us link is working");
		 }
		 else {
			 System.out.println("About us link is not working");
		 }
			 
//		System.out.println("Output:" + e.getAttribute("href"));
//		e.click();
//		System.out.println("Output:" );
	}
	
	
	@Test
void homePageLocationLink() {

		
		driver.get("http://localhost:8888/donut_shop/public");
		
		 driver.findElement(By.linkText("Locations")).click();
		String actualOutput = driver.getTitle();
		//System.out.println(actualOutput);
		 if(actualOutput.contentEquals("Location"))
		 {
			 System.out.println("Locations link is working");
		 }
		 else {
			 System.out.println("Locations link is not working");
		 }
			 

	}
	@Test
	void homePageIndexLink() {

	
	driver.get("http://localhost:8888/donut_shop/public");
	driver.findElement(By.xpath("//*[@id=\"index_page\"]/a/img")).click();
	 //driver.findElement(By.linkText("cart")).click();
	String actualOutput = driver.getTitle();
	//System.out.println(actualOutput);
	 if(actualOutput.contentEquals("Home"))
	 {
		 System.out.println("Home link is working");
	 }
	 else {
		 System.out.println("Home link not working");
	 }
		 

}
	@Test
void homePageMenuLink() {

		
		driver.get("http://localhost:8888/donut_shop/public");
		
		 driver.findElement(By.linkText("Menu")).click();
		String actualOutput = driver.getTitle();
		//System.out.println(actualOutput);
		 if(actualOutput.contentEquals("Menu"))
		 {
			 System.out.println("Menu link is working");
		 }
		 else {
			 System.out.println("Menu link is not working");
		 }
			 

	}
	@Test
		void homePageCartLink() {

		
		driver.get("http://localhost:8888/donut_shop/public");
		driver.findElement(By.xpath("//*[@id=\"cart_page\"]/a/i")).click();
		 //driver.findElement(By.linkText("cart")).click();
		String actualOutput = driver.getTitle();
		//System.out.println(actualOutput);
		 if(actualOutput.contentEquals("Checkout"))
		 {
			 System.out.println("Cart link is working");
		 }
		 else {
			 System.out.println("Cart is not working");
		 }
			 
		 System.out.println("***************************************************");
	}
	
}