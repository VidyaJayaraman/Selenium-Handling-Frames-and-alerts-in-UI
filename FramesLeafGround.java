package week4.day1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FramesLeafGround {

	public static void main(String[] args) {
		
	//  Frame handling in Selenium - https://www.leafground.com/frame.xhtml  
	
	// Chrome Setup and Disable Browser Notifications
	
	WebDriverManager.chromedriver().setup();
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--disable-notifications");
	
	// Launch URL
					
    ChromeDriver driver = new ChromeDriver(options);
	driver.get("https://www.leafground.com/frame.xhtml");
    driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	
	//How many frames in this page?
	
	List<WebElement> noOfFrames = driver.findElements(By.tagName("iframe"));
	int outerFrameCount = noOfFrames.size();
	System.out.println("No of outer frames " + outerFrameCount);
	
	// To check for Inner frames
	
	int innerFrameCount=0;
	for (WebElement webElement : noOfFrames) {
		
		driver.switchTo().frame(webElement);
		List<WebElement> innerframe = driver.findElements(By.tagName("iframe"));
		innerFrameCount = innerFrameCount+innerframe.size();
		driver.switchTo().defaultContent();
		
	}
	
    System.out.println("No of inner frames "+innerFrameCount);
    int totalFrameCount = innerFrameCount+outerFrameCount;
    System.out.println("Total no of frames " + totalFrameCount );
	
    //Click Me (Inside frame)	
		
	WebElement frame1 = driver.findElement(By.xpath("//h5[text()=' Click Me (Inside frame)']/following-sibling::iframe"));
	driver.switchTo().frame(frame1);
	driver.findElement(By.xpath("//button[text()='Click Me']")).click();
	driver.switchTo().defaultContent();
	
	// Click Me (Inside Nested frame)
	
	WebElement frame3 = driver.findElement(By.xpath("//h5[text()=' Click Me (Inside Nested frame)']/following-sibling::iframe"));
	driver.switchTo().frame(frame3);
	driver.switchTo().frame("frame2");
	driver.findElement(By.xpath("//button[text()='Click Me']")).click();
	
	
	
	
	}

}
