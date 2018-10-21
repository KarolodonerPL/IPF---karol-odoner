package TestCases;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.junit.Test;

public class TestCaseTwo {

	@Test
	public void test() {

    	
    	//Define driver
    	WebDriver driver = new ChromeDriver();
    	
    	// 1. Open “automationpractice.com”
		driver.get("http://automationpractice.com");
		
		// 2. Maximize window
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		// 3. Log in Existing user
		driver.findElement(By.xpath("//div[2]/div/div/nav/div[1]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("karol.test@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"passwd\"]")).sendKeys("testTest");
		driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]/span")).click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		// 4. Check if page was change to correct one
		String expectedTitle="My account - My Store";
	    String actualTitle = driver.getTitle();
	    if(actualTitle.equals(expectedTitle)){
	        System.out.println("Test Pass");
	    }
	    else{
	        System.out.println("Test Failed");
	    }
		
		// Close window
		driver.close();
	}

}

