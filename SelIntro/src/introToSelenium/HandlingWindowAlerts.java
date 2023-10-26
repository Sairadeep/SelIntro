package introToSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingWindowAlerts {
	public static void main(String[] args) {
		String nameToInput = "Sai Pradeep";
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.id("name")).sendKeys(nameToInput);
		driver.findElement(By.cssSelector("#alertbtn")).click();
		// To handle the alerts, we need to switch the focus from webpage to alert.
		System.out.println(driver.switchTo().alert().getText());
		// To accept an alert.
		driver.switchTo().alert().accept();
		// Alert 1: It just has an option of accepting it.
		// Alert 2: We can either accept it or dismiss the alert.
		driver.findElement(By.id("name")).sendKeys(nameToInput);
		driver.findElement(By.id("confirmbtn")).click();
		System.out.println(driver.switchTo().alert().getText());
		// To cancel a alert.
		driver.switchTo().alert().dismiss();
	}
}
