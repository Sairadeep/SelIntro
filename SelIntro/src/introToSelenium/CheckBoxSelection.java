package introToSelenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CheckBoxSelection {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		// Finding the preferred checkbox with the regular expression of css.
		driver.findElement(By.cssSelector("[id*='SeniorCitizenDiscount']")).click();
		// To check whether the element is selected or not
		Assert.assertTrue(driver.findElement(By.cssSelector("[id*='SeniorCitizenDiscount']")).isSelected());
		/*
		 * if (driver.findElement(By.cssSelector("[id*='SeniorCitizenDiscount']")).
		 * isSelected()) { System.out.println("CheckBox selected...!"); } else {
		 * System.out.println("CheckBox is not selected yet...!"); }
		 */
		// Know the number of the checkboxes available in the page.
		List<WebElement> checkBoxes = driver.findElements(By.xpath("//*[@type='checkbox']"));
		System.out.println("Total checkboxes available: " + checkBoxes.size());
		driver.close();
	}
}
