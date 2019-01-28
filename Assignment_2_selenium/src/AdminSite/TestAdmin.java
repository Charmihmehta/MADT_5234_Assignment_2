package AdminSite;



import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class TestAdmin {

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
    
    //Test case for index page
    
    @Test
    void adminLink()
    {
        driver.get("http://localhost:8888/donut_shop/admin/index.php");
       
         driver.findElement(By.xpath("/html/body/a")).click();
        String actualOutput = driver.getTitle();
         if(actualOutput.contentEquals("Admin Panel"))
         {
             System.out.println("Admin Page Link is working");
         }
         else {
             System.out.println("Admin Page Link is not working");
         }
    }
    
    
    //Test for Show product page
    @Test
    void editLink()
    {
        driver.get("http://localhost:8888/donut_shop/admin/show-products.php");
       
         driver.findElement(By.xpath("//*[@id=\"edit_btn\"]/a")).click();
        String actualOutput = driver.getTitle();
         if(actualOutput.contentEquals("Edit Product"))
         {
             System.out.println("Edit Product link is working");
         }
         else {
             System.out.println("Edit Product link is not working");
         }
    }
    
    @Test
    void deleteLink()
    {
        driver.get("http://localhost:8888/donut_shop/admin/show-products.php");
       
         driver.findElement(By.xpath("//*[@id=\"delete_btn\"]/a")).click();
        String actualOutput = driver.getTitle();
         if(actualOutput.contentEquals("Delete Product"))
         {
             System.out.println("Delete Product link is working");
         }
         else {
             System.out.println("Delete Product link is not working");
         }
    }
    
    @Test
    void listAllDonuts()
    {
        driver.get("http://localhost:8888/donut_shop/admin/show-products.php");
        List<WebElement> donuts =  driver.findElements(By.id("name_cell"));
        System.out.println("How many donuts: " + donuts.size());
        assertEquals(16, donuts.size());
        for(int i =0 ; i< donuts.size(); i++)
        {
            WebElement e = donuts.get(i);
            
            System.out.println("No. of donuts:"+e.getText()) ;
            
        }
         System.out.println("***************************************************");
        
    
    }
    
    @Test
    void addProductLink()
    {
        driver.get("http://localhost:8888/donut_shop/admin/show-products.php");
       
         driver.findElement(By.xpath("//*[@id=\"add_btn\"]/a")).click();
        String actualOutput = driver.getTitle();
         if(actualOutput.contentEquals("Add Product"))
         {
             System.out.println("Add Product link is working");
         }
         else {
             System.out.println("Add Product link is not working");
         }
    }
    
    //Test case for Add product page
    
    @Test
    void backButton()
    {
        driver.get("http://localhost:8888/donut_shop/admin/add-product.php");
       
         driver.findElement(By.xpath("/html/body/div/div/a")).click();
        String actualOutput = driver.getTitle();
         if(actualOutput.contentEquals("Admin Panel"))
         {
             System.out.println("Back Button is working");
         }
         else {
             System.out.println("Back button is not working");
         }
    }
    
    @Test 
    void addProduct() {
    	driver.get("http://localhost:8888/donut_shop/admin/add-product.php");
    	WebElement inputBox1 = driver.findElement(By.id("name"));
		inputBox1.sendKeys("Venilla Donut");
		
		WebElement inputBox2 = driver.findElement(By.id("desc"));
		inputBox2.sendKeys("Venilla flavour with that perfect doughnut texture");
	
		WebElement inputBox3 = driver.findElement(By.id("price"));
		inputBox3.sendKeys("1.50");
		
		WebElement Addbutton2 = driver.findElement(By.xpath("//*[@id=\"form_add\"]/button"));
		Addbutton2.click();
		
		WebElement msg = driver.findElement(By.tagName("p"));
		
		String actualOutput = msg.getText();
		
		if (actualOutput.contentEquals("Product added successfully")) {
			System.out.println("Product is added!");
		}
		else {
			System.out.println("Product is not added!");
		}
		
    }
    
  //Test case for Edit product page
    
    @Test
    void goBackButton()
    {
        driver.get("http://localhost:8888/donut_shop/admin/edit-product.php");
       
         driver.findElement(By.xpath("/html/body/div/div/a")).click();
        String actualOutput = driver.getTitle();
         if(actualOutput.contentEquals("Admin Panel"))
         {
             System.out.println("Go Back Button is working");
         }
         else {
             System.out.println("Go Back button is not working");
         }
    }
   
    @Test
    void updateProduct() {
    	  driver.get("http://localhost:8888/donut_shop/admin/edit-product.php?id=1");
        
    	  WebElement inputBox3 = driver.findElement(By.id("price"));
    	  inputBox3.clear();
  		  inputBox3.sendKeys("2.10");
  		
  		  WebElement updatebutton = driver.findElement(By.xpath("//*[@id=\"update_btn\"]/button"));
  		  updatebutton.click();
          
          WebElement tdata = driver.findElement(By.xpath("//*[@id=\"price_cell\"]"));
          
          String actualOutput = tdata.getText();
          
          if (actualOutput.contentEquals("2.10")) {
              System.out.println("Updated price!");
          }
          else {
              System.out.println("Not Updated price!");
          }
    }
    
   
    //Test case for delete product page
    
    @Test
    void deleteProduct() {
    	  driver.get("http://localhost:8888/donut_shop/admin/delete-product.php?id=34");
    	  WebElement e = driver.findElement(By.id("optn_select"));
    	WebElement e1 = driver.findElement(By.xpath("//*[@id=\"optn_select\"]/button"));
    	
    	e1.click();
    	 WebElement tdata = driver.findElement(By.id("id_cell"));
    	 String actualOutput = tdata.getText();
    	 if(actualOutput.contentEquals("")) {
    		 System.out.println("Product deleted");
    	 }
    	 else
    	 {
    		 System.out.println("Product not deleted");
    	 }
    
    } 
    
}


