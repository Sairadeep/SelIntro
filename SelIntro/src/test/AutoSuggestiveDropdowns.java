package test;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestiveDropdowns {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.id("autosuggest")).sendKeys("In");
		Thread.sleep(2000);
		List<WebElement> options = driver.findElements(By.xpath("//li[contains(@class,'menu')]"));
		for (WebElement option : options) {
			if (option.getText().equalsIgnoreCase("India")) {
				System.out.println("Selected option: " + option.getText());
				option.click();
				break;
			}
		}
      driver.close();
	}
}
