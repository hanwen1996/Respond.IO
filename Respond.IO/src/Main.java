import java.awt.AWTException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class Main {
	public static void main(String[] args) throws InterruptedException, AWTException, IOException, ParseException {
		int  i = 0;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("===========================================\n");
		System.out.print("Welcome to Respond.IO Automation Testing\n");
		System.out.print("===========================================");
		System.out.print("\n1.Automation Testing \n2.Manual Testing");
		System.out.print("\nSelect function: ");
		 try {
	         i = Integer.parseInt(br.readLine());
	     } catch(NumberFormatException nfe) {
	         System.err.println("Invalid Format!");	    
	         }
		 switch (i) {
     	case 1:AutomationTesting();
     	    break;

     	case 2:ManualTesting();
 	    break;	    	    
		 }
	}
		

public static void AutomationTesting() throws InterruptedException, AWTException, IOException, ParseException{
	Scenario_1();
	Scenario_2();
	Scenario_3();
}


public static void ManualTesting() throws InterruptedException, AWTException, IOException, ParseException{
	int  i = 0;

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	System.out.print("===========================================\n");
	System.out.print("Welcome to Respond.IO Automation Testing\n");
	System.out.print("===========================================");
	System.out.print("\n1.Scenario 1 \n2.Scenario 2 \n3.Scenario 3");
	System.out.print("\nSelect function: ");
	 try {
         i = Integer.parseInt(br.readLine());
     } catch(NumberFormatException nfe) {
         System.err.println("Invalid Format!");	    
         }
	 switch (i) {
 	case 1:Scenario_1();
 	    break;

 	case 2:Scenario_2();
	    break;
	    
 	case 3:Scenario_3();
	    break;	    
	 }
}

@Test
public static void Scenario_1() throws InterruptedException, AWTException, IOException {
//Set the Path of Executable Browser Driver
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\wen\\Documents\\chromedriver_win32\\chromedriver.exe");

WebDriver driver = new ChromeDriver();//Launch Chrome

driver.manage().window().maximize();//Maximize window size
driver.manage().deleteAllCookies();//Delete all cookies

//Gets the amount of time to wait for a page load to complete before throwing an error.
driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));  
//Specifies the amount of time the driver should wait when searching for an element if it is not immediately present.
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));   

driver.get("https://iprice.my/computing/laptops");//Navigate to the /computing/laptops page
driver.findElement(By.xpath("//div[@id='main-filter-area']/div/div/div[2]/label")).click();//Click to expand filter menu
driver.findElement(By.xpath("//div[@id='main-filter-area']/div/div/amp-list/div/div/span[4]/span")).click();//Select the brand value = Dell	
Thread.sleep(2000);//Wait for 2 seconds

//Scroll Down 
JavascriptExecutor js = (JavascriptExecutor) driver;
js.executeScript("window.scrollBy(0,400)", "");

//Validate result which selected the valid brand 
String text = "Dell Laptops in Malaysia Price List";
List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),'" + text + "')]"));//Find the string of text and compare	
Assert.assertTrue("Text not found!", list.size() > 0);//Return Text not found! if the text not available
//Assert.assertFalse("Text found!", list.size() > 0);//Return Text found! if the text available

Thread.sleep(4000);//Wait for 4 seconds
driver.close(); //closes the browser	
}


@Test
public static void Scenario_2() throws InterruptedException, AWTException, IOException, ParseException {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\wen\\Documents\\chromedriver_win32\\chromedriver.exe");

	WebDriver driver = new ChromeDriver();//Launch Chrome

	driver.manage().window().maximize();//Maximize window size
	driver.manage().deleteAllCookies();//Delete all cookies
    
	//Gets the amount of time to wait for a page load to complete before throwing an error.
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));  
	//Specifies the amount of time the driver should wait when searching for an element if it is not immediately present.
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));   
    
	driver.get("https://iprice.my/clothing/dresses");//Navigate to the /clothing/dresses page	    
	driver.findElement(By.xpath("//div[@id='sort-option']/div/a[3]/span")).click();//Click price button to sort price ascending
	driver.findElement(By.xpath("//div[@id='sort-option']/div/a[3]/span")).click();//Click price button to sort price descending
	Thread.sleep(2000);//Wait for 2 seconds
	
	//Scroll Down 
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,400)", "");
	
	//Get 2 different price from website element and compare it is ascending or descending
    String price= driver.findElement(By.xpath("//*[@id=\"product-list\"]/a[1]/div[1]/div[2]/div")).getText();//Get price element
    String price2 = price.replaceAll("[RM,]", "");//Remove RM currency symbol
    double a=Double.parseDouble(price2);//Convert string to double
    String price3= driver.findElement(By.xpath("//*[@id=\"product-list\"]/a[5]/div[1]/div/div")).getText();//Get price element
    String price4 = price3.replaceAll("[RM,]", "");//Remove RM currency symbol
    double b=Double.parseDouble(price4);//Convert string to double 
    
    //Compare it is ascending or descending
    if(a> b) {	    
    	System.out.println("Sorting in Descending");
    }else {
    	System.out.println("Sorting in Ascending");
    }
    
    Thread.sleep(4000);//Wait for 4 seconds
	driver.close(); //closes the browser			
}


@Test
public static void Scenario_3() throws InterruptedException, AWTException, IOException, ParseException {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\wen\\Documents\\chromedriver_win32\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();//Launch Chrome

	driver.manage().window().maximize();//Maximize window size
	driver.manage().deleteAllCookies();//Delete all cookies
    
	//Gets the amount of time to wait for a page load to complete before throwing an error.
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));  
	//Specifies the amount of time the driver should wait when searching for an element if it is not immediately present.
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));   
    
	driver.get("https://iprice.my/");//Navigate to homepage
	driver.findElement(By.id("term")).sendKeys("iPhone 14");
	driver.findElement(By.xpath("//*[@id=\"search-btn\"]/i[1]")).click();	
	Thread.sleep(1000);//Wait for 1 seconds
	
	//Scroll Down 
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,200)", "");
	
	//Validate search result
	String text = "iPhone 14";
	List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),'" + text + "')]"));//Find the string of text and compare	
	Assert.assertTrue("Text not found!", list.size() > 0);//Return Text not found! if the text not available

	Thread.sleep(4000);//Wait for 4 seconds
	driver.close(); //closes the browser			
}







}