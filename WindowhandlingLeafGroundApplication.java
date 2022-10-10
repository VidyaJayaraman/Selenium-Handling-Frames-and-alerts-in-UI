package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowhandlingLeafGroundApplication {

	public static void main(String[] args) throws InterruptedException{
		
		
	   	// Chrome Setup and Disable Browser Notifications
				
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
				
		// Launch URL
				
        ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://www.leafground.com/window.xhtml");
	    driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	
		//Click and Confirm new Window Opens
		
		String title1 = driver.getTitle();
		System.out.println("Tab1 - "+title1);
		driver.findElement(By.xpath("//h5[text()='Click and Confirm new Window Opens']/following-sibling::button")).click();
		
		// Redirecting to new window after click on open
		
		Set<String> windowHandles1 = driver.getWindowHandles();
		List<String> windowHandles2 = new ArrayList<String>(windowHandles1);
		driver.switchTo().window(windowHandles2.get(1));
		String title2 = driver.getTitle();
		System.out.println("Tab2 - "+title2);
		if(title2.contains("Dash")) {
			System.out.println("New Window is Dashboard");	
		}
		driver.close();
		
		//Find the number of opened tabs in parent window
		
		driver.switchTo().window(windowHandles2.get(0));
		driver.findElement(By.xpath("//h5[text()='Find the number of opened tabs']/following-sibling::button")).click();
		Set<String> windowHandles3 = driver.getWindowHandles();
		List<String> windowHandles4 = new ArrayList<String>(windowHandles3);
		System.out.println("No of open tabs- List2 WindowHandles- "+windowHandles4.size());
		
		
		// Close all windows except Primary , first switch to main window to click that tab
		
		
	    driver.switchTo().window(windowHandles4.get(0));
		driver.findElement(By.xpath("//h5[text()='Close all windows except Primary']/following-sibling::button")).click();
		Set<String> windowHandles5 = driver.getWindowHandles();
		List<String> windowHandles6 = new ArrayList<String>(windowHandles5);
		System.out.println("List3 WindowHandles- "+windowHandles6.size());
		
		for(int i=1;i<windowHandles6.size();i++)
		{
		
			driver.switchTo().window(windowHandles6.get(i));
			driver.close();
		}
		
		// Wait for 2 new tabs to open - Open with delay
		
		driver.switchTo().window(windowHandles6.get(0));
		driver.findElement(By.xpath("//h5[text()='Wait for 2 new tabs to open']/following-sibling::button")).click();
		Set<String> windowHandles7 = driver.getWindowHandles();
		List<String> windowHandles8 = new ArrayList<String>(windowHandles7);
		System.out.println("List4 WindowHandles after closing- "+windowHandles8.size());
		
		for (String eachEle : windowHandles8) {
			
			driver.switchTo().window(eachEle);
			System.out.println(driver.getTitle());
			
		}
		
	
		
	}

}
