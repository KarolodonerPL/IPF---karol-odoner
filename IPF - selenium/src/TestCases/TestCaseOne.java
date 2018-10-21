package TestCases;
import java.util.concurrent.TimeUnit;
import Functions.Usful;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.junit.Test;

public class TestCaseOne {

	@Test
	public void test() {

    	
    	//Define driver
    	WebDriver driver = new ChromeDriver();
    	
    	// 1. Open “automationpractice.com”
		driver.get("http://automationpractice.com");
		
		// 2. Maximize window
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		// 3. Click Sign in new user
		driver.findElement(By.xpath("//div[2]/div/div/nav/div[1]/a")).click();
		
		// 4. generate random e-mail
		String randomEmail = Usful.getSaltString();
	    randomEmail = randomEmail +"@gmail.com";
	    
	    // 5. go to create a new user page 
		driver.findElement(By.xpath("//*[@id=\"email_create\"]")).sendKeys(randomEmail);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS); 
		driver.findElement(By.xpath("//*[@id=\"SubmitCreate\"]/span")).click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS); 
		
		// 6. File data for a new user
		driver.findElement(By.xpath("//*[@id=\"id_gender1\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"customer_firstname\"]")).sendKeys("firstName");
		driver.findElement(By.xpath("//*[@id=\"customer_lastname\"]")).sendKeys("lastName");
		driver.findElement(By.xpath("//*[@id=\"email\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"passwd\"]")).sendKeys("randomPassowrd");
		driver.findElement(By.xpath("//*[@id=\"days\"]")).sendKeys("27");
		driver.findElement(By.xpath("//*[@id=\"months\"]")).sendKeys("May");
		driver.findElement(By.xpath("//*[@id=\"years\"]")).sendKeys("1977");
		driver.findElement(By.xpath("//*[@id=\"firstname\"]")).sendKeys("firstName");
		driver.findElement(By.xpath("//*[@id=\"lastname\"]")).sendKeys("lastName");
		driver.findElement(By.xpath("//*[@id=\"address1\"]")).sendKeys("Random Adress 1");
		driver.findElement(By.xpath("//*[@id=\"city\"]")).sendKeys("Random City");
		driver.findElement(By.xpath("//*[@id=\"postcode\"]")).sendKeys("00000");;
		driver.findElement(By.xpath("//*[@id=\"id_state\"]")).sendKeys("Random State");;
		driver.findElement(By.xpath("//*[@id=\"id_country\"]")).sendKeys("USA");;
		driver.findElement(By.xpath("//*[@id=\"phone_mobile\"]")).sendKeys("303303303");;
		driver.findElement(By.xpath("//*[@id=\"alias\"]")).sendKeys("Random Alias");;
		driver.findElement(By.xpath("//*[@id=\"submitAccount\"]/span")).click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
				
		// 7. Check if page was change to user intarface 
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
