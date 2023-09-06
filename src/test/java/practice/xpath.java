package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class xpath {
	
	
	public static void main(String[] args) throws InterruptedException  {
		
		WebDriver driver = new FirefoxDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		
		driver.get("https://petdiseasealerts.org/");
		
		driver.findElement(By.xpath("//a[normalize-space()='Go to maps']")).click();
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		
		js.executeScript("window.scrollBy(0,500)");
		
		driver.switchTo().frame(0);
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[local-name()='svg' and @id='map-svg']//*[@id='regions']//*[@id='missouri']//*[@id='region-26']")).click();
		
		Thread.sleep(2000);
		
		driver.close();
		//thank you
	}
}