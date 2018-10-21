package TestCases;
import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.junit.Test;

public class testCaseThree {

	@Test
	public void test() {

    	
    	//Define driver
    	WebDriver driver = new ChromeDriver();
    	
    	// 1. Open “automationpractice.com”
		driver.get("http://automationpractice.com");
		
		// 2. Maximize window
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		// 3. Search for word: Nothing
		driver.findElement(By.xpath("//*[@id=\"search_query_top\"]")).sendKeys("nothing");
		driver.findElement(By.xpath("//*[@id=\"search_query_top\"]")).sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
	    // 4. Verified if page contain text
		if(driver.getPageSource().contains("No results were found for your search"))
		{
			System.out.println("Page Contain text Test Pass");
		}

		else
		{
			System.out.println("Page DOES NOT contain text Test Fail");
			fail("Page DOES NOT contain text Test Fail");
		}
		
		// Close window
		driver.close();
	}

}
