package week4.day1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FramePracticeSelenium {

	public static void main(String[] args) throws InterruptedException {
		
		// Chrome Setup and Disable Browser Notifications
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		// Launch URL
						
        ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
	    driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		// Enter into  frame 
		
		WebElement frame1 = driver.findElement(By.xpath("//iframe[@id='frame1']"));
		driver.switchTo().frame(frame1);
		WebElement frame3 = driver.findElement(By.xpath("//iframe[@id='frame3']"));
		driver.switchTo().frame(frame3);
		
		// Click on Inner Frame Check box
		driver.findElement(By.xpath("//b[text()='Inner Frame Check box :']/following-sibling::input[@id='a']")).click();
		Thread.sleep(1000);
		
		
		// Enter into Second frame
		driver.switchTo().defaultContent();
		
		WebElement frame2 = driver.findElement(By.xpath("//iframe[@id='frame2']"));
		driver.switchTo().frame(frame2);
		
		//Select animals
		
		WebElement findElement = driver.findElement(By.id("animals"));
		Select dd = new Select(findElement);
		dd.selectByVisibleText("Avatar");
		
	}

}
