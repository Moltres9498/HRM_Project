package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class Amazonprac {
	
@Test

    public static void main(String[] args) {
        // Set the path to the chromedriver executable
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Create a new instance of the ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Navigate to Amazon
        driver.get("https://www.amazon.com");

        // Find the search box and enter "iphone"
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("iphone");
        searchBox.submit();

        // Wait for the search results to load
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Find all the search result items
        List<WebElement> searchResults = driver.findElements(By.cssSelector(".sg-col-inner"));

        // Iterate over the search results and print the details of iPhones with prices > 70,000
        for (WebElement searchResult : searchResults) {
            WebElement priceElement = searchResult.findElement(By.cssSelector(".a-price-whole"));

            if (priceElement != null) {
                String priceString = priceElement.getText().replace(",", "");
                int price = Integer.parseInt(priceString);

                if (price > 70000) {
                    WebElement titleElement = searchResult.findElement(By.cssSelector(".a-size-medium"));
                    String title = titleElement.getText();

                    System.out.println("Title: " + title);
                    System.out.println("Price: " + price);
                    System.out.println();
                }
            }
        }

        // Close the browser
        driver.quit();
    }
}