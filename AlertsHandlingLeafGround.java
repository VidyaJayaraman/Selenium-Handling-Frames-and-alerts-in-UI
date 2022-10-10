package week4.day1;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertsHandlingLeafGround {
	
	// https://www.leafground.com/alert.xhtml;jsessionid=node01uchomb9dxu9r44hnc5vr79fp344596.node0
	
	public static void main(String[] args) throws InterruptedException {
		
		// Chrome Setup and Disable Browser Notifications
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		// Launch URL
						
	    ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://www.leafground.com/alert.xhtml;jsessionid=node01uchomb9dxu9r44hnc5vr79fp344596.node0");
	    driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		
		//Alert (Simple Dialog)
		
		driver.findElement(By.xpath("//h5[text()=' Alert (Simple Dialog)']//following::span[2]")).click();
		Alert alert1 = driver.switchTo().alert();
		alert1.accept();
		
		// Alert (Confirm Dialog)
		
		driver.findElement(By.xpath("//h5[text()=' Alert (Confirm Dialog)']//following::span[2]")).click();
		Alert alert2 = driver.switchTo().alert();
		alert2.dismiss();
		
		// Sweet Alert (Simple Dialog)
		
		driver.findElement(By.xpath("//h5[text()='Sweet Alert (Simple Dialog)']//following::span[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//p[contains(text(),'inspectable')]//following :: span[text()='Dismiss']")).click();
		
		
		// Sweet Modal Dialog
		
		driver.findElement(By.xpath("//h5[text()='Sweet Modal Dialog']//following::span[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='Modal Dialog (Sweet Alert)']//following::span")).click();
	
		// Alert (Prompt Dialog)
		
		driver.findElement(By.xpath("//h5[text()=' Alert (Prompt Dialog)']//following::span[2]")).click();
		Alert alert3 = driver.switchTo().alert();
		alert3.sendKeys("Vidya");
		alert3.accept();
		
		
		// Sweet Alert (Confirmation)
		
		driver.findElement(By.xpath("//h5[text()='Sweet Alert (Confirmation)']//following::span[2]")).click();
		Thread.sleep(1000);
	    driver.findElement(By.xpath("//span[text()='Are you sure you want to proceed?']//following::span[text()='Yes']")).click();
	   
	    // Minimize and Maximize
	  
	    driver.findElement(By.xpath("//h5[text()='Minimize and Maximize']//following::span[2]")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//span[text()='Min and Max']//following::span[1]")).click();
	    
	}

}


