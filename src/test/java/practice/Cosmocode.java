package practice;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Cosmocode {


	@Test

	public void cosmo() {

		WebDriver driver=new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		
		driver.get("https://cosmocode.io/");
		WebElement more = driver.findElement(By.linkText("More"));

		Actions a=new Actions(driver);
		a.moveToElement(more).perform();

		driver.findElement(By.xpath("//div[@class='inside-navigation']//a[@class='mega-menu-link'][normalize-space()='Automation Practice | WebTable']")).click();

		List<WebElement> data = driver.findElements(By.xpath("//tr[*]/td[contains(text(),'Dollar')]/../td[contains(text(),'English')]/preceding-sibling::td[3]"));

		for(WebElement w:data) {
			System.out.println(w.getText());
		}
		driver.close();
	}
}