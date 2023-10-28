package assignment;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ExplicitAssignement {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\sai.vamala_wenable\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.manage().window().maximize();
		String userName = "rahulshettyacademy";
		String password = "learning";
		WebDriverWait toWait = new WebDriverWait(driver, Duration.ofSeconds(7));
		driver.findElement(By.id("username")).sendKeys(userName);
		driver.findElement(By.xpath("//*[@type='password']")).sendKeys(password);
		driver.findElement(By.cssSelector("input[value='user']")).click();
		toWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".modal-content")));
		driver.findElement(By.cssSelector(".btn-success")).click();
		WebElement typeSelect = driver.findElement(By.xpath("//select[@data-style='btn-info']"));
		Select drpSelect = new Select(typeSelect);
		drpSelect.selectByValue("consult");
		driver.findElement(By.name("terms")).click();
		driver.findElement(By.cssSelector(".btn-md")).click();
		toWait.until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(By.xpath("//app-card[@class='col-lg-3 col-md-6 mb-3']")));
		List<WebElement> countOfItems = driver.findElements(By.xpath("//button[@class='btn btn-info']"));
		for (int i = 0; i < countOfItems.size(); i++) {
			countOfItems.get(i).click();
		}
		driver.findElement(By.xpath("//a[contains(@class,'btn')]")).click();
		driver.findElement(By.cssSelector(".btn-success")).click();
		driver.findElement(By.id("country")).sendKeys("Ind");
		toWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='India']")));
		List<WebElement> countries = driver.findElements(By.xpath("//div[@class='suggestions'] //a"));
		for (WebElement selectLocation : countries) {
			if (selectLocation.getText().equalsIgnoreCase("India")) {
				selectLocation.click();
				break;
			}
		}
		driver.findElement(By.xpath("//*[@for='checkbox2']")).click();
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		toWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class,'alert')]")));
		Assert.assertTrue(driver.findElement(By.xpath("//*[contains(@class,'alert')]")).isDisplayed());
		driver.close(); 
	}
}
