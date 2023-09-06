package practice;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MakeMyTripScenario {
	static {
		System.setProperty("webdriver.chrome.driver","./config/chromedriver.exe");
	}
	public static void main(String[] args) throws InterruptedException, IOException {

		ChromeOptions options = new ChromeOptions(); 
		options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"}); 
		
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.makemytrip.com/");
		driver.navigate().refresh();
		
		driver.findElement(By.xpath("//span[normalize-space()='From']")).click();
		driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys("b");
		driver.findElement(By.xpath("//p[contains(text(), 'Bengaluru, India')]")).click();
		
		driver.findElement(By.xpath("//span[normalize-space()='To']")).click();
		driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys("g");
		driver.findElement(By.xpath("//p[contains(text(), 'Goa - Dabolim Airport, India')]")).click();

		LocalDate currentDate = LocalDate.now();
		LocalDate departureDate = currentDate.plusDays(2);
		LocalDate arrivalDate = departureDate.plusDays(1);

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE MMM dd yyyy");

		WebElement departureInput = driver.findElement(By.xpath("//div[@role='gridcell' and @aria-label='"+departureDate.format(formatter)+"']"));
		departureInput.click();

		driver.findElement(By.xpath("//p[@class='latoBlack font12 greyText lineHeight16']")).click();
		WebElement arrivalInput = driver.findElement(By.xpath("//div[@role='gridcell' and @aria-label='"+arrivalDate.format(formatter)+"']"));
		arrivalInput.click();

		driver.findElement(By.xpath("//a[@class='primaryBtn font24 latoBold widgetSearchBtn ']")).click();

		driver.findElement(By.xpath("//button[@class='button buttonSecondry buttonBig fontSize12 relative']")).click();

		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1300)");

		List<WebElement> airlineElements = driver.findElements(By.xpath("//p[normalize-space()='Airlines']/..//p[@class='checkboxTitle']"));

		for (WebElement airlineElement : airlineElements) {
			String airlineNumberText = airlineElement.getText().replaceAll("[^0-9]", "");
			int airlineNumber = Integer.parseInt(airlineNumberText);
			if(airlineNumber<10) {
				airlineElement.click();
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
				wait.until(ExpectedConditions.visibilityOfAllElements(airlineElements));
				js.executeScript("window.scrollBy(0,1300)");
			}
		}
		List<WebElement> AirplaneNames = driver.findElements(By.xpath("//span[@class='boldFont blackText']"));

		List<WebElement> DepTime = driver.findElements(By.xpath("//div[@class='flexOne timeInfoLeft']//span"));

		List<WebElement> ArrTime = driver.findElements(By.xpath("//div[@class='flexOne timeInfoRight']/child::p/span/parent::p"));

		List<WebElement> Price = driver.findElements(By.xpath("//div[@class='makeFlex column relative splitfare textRight ']//p[contains(text(),'₹ ')]"));

		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("MMT");
		Row headerRow = sheet.createRow(0);
		Cell headerCell = headerRow.createCell(0);
		headerCell.setCellValue("Name");
		Cell headerCell2 = headerRow.createCell(1);
		headerCell2.setCellValue("Departure time");
		Cell headerCell3 = headerRow.createCell(2);
		headerCell3.setCellValue("Return time");
		Cell headerCell4 = headerRow.createCell(3);
		headerCell4.setCellValue("Price");

		for (int i = 0; i < AirplaneNames.size(); i++) {
			Row dataRow = sheet.createRow(i + 1);
			Cell dataCell = dataRow.createCell(0);
			dataCell.setCellValue(AirplaneNames.get(i).getText());
			Cell dataCell2 = dataRow.createCell(1);
			dataCell2.setCellValue(DepTime.get(i).getText());
			Cell dataCell3 = dataRow.createCell(2);
			dataCell3.setCellValue(ArrTime.get(i).getText());
			Cell dataCell4 = dataRow.createCell(3);
			dataCell4.setCellValue(Price.get(i).getText());
		}
		
		FileOutputStream fileOut = new FileOutputStream("./config/output.xlsx");
		workbook.write(fileOut);
		workbook.close();
		driver.quit();
	}
}