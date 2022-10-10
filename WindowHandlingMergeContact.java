package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandlingMergeContact {

	public static void main(String[] args) {
		
		// Setup ChromeDriver and Launch URL
		
				WebDriverManager.chromedriver().setup();
				ChromeDriver driver = new ChromeDriver();
				driver.get("http://leaftaps.com/opentaps/control/login");
			    driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			              
                
				driver.findElement(By.id("username")).sendKeys("DemoCSR");
				driver.findElement(By.id("password")).sendKeys("crmsfa");
				driver.findElement(By.className("decorativeSubmit")).click();
				driver.findElement(By.linkText("CRM/SFA")).click();
		
		// Click on Contacts
				
				driver.findElement(By.linkText("Contacts")).click();
		
		// Click on MergeContacts
				
				driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
				
	    
	    // Click on From Contact Choose button
				
				driver.findElement(By.xpath("//img[@alt='Lookup']")).click();
				
	    // Switch to resulting window - Use windowhandles function
				
				Set<String> windowHandles = driver.getWindowHandles();
				List<String> windowHandles1 = new ArrayList<String>(windowHandles);
				System.out.println("window handles lis1 ------->"+windowHandles1);
				driver.switchTo().window(windowHandles1.get(1));
				
		// Choose From Contact from the list 		
				
				driver.findElement(By.xpath("//a[text()='DemoCustomer']")).click();
				
		//  Switch to parent window or previous main window entry with index 0 in list .
				
				driver.switchTo().window(windowHandles1.get(0));
				
		// Click on To contact choose button
				
				driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
				  
	    // Choose To contact from the list appearing from resulting window by switching to resulting window
				
				Set<String> windowHandles2 = driver.getWindowHandles();
				List<String> windowHandles3 = new ArrayList<String>(windowHandles2);
				System.out.println("window handles lis1 ------->"+windowHandles3);
				driver.switchTo().window(windowHandles3.get(1));				
				driver.findElement(By.xpath("//a[text()='DemoLBCust']")).click();
				
		// Click on Merge Button from main parent window		
				
				driver.switchTo().window(windowHandles1.get(0));				
				driver.findElement(By.xpath("//a[text()='Merge']")).click();
				
		// Switch to Alert
				
				Alert alert = driver.switchTo().alert();
				alert.accept();
				
		// Verify Title	
				
		        String title = driver.getTitle();
		        System.out.println("Title of the page is "+title);
		        
	}

}
