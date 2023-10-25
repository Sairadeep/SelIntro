package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class StaticDropdowns {

	public static void main(String[] args) {
		// In most of the cases, the static dropdowns are of select dropdowns where we
		// will have the tag <select>

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		// If the dropdown has select tag, selenium has a class called "Select" and we
		// need to create a object from it to use it.
		// Pass the webelement of the select drpdwn as an arguement of the class
		WebElement staticDrpdwn = driver.findElement(By.xpath("//*[contains(@id,'Currency')]"));
		Select drpdwn = new Select(staticDrpdwn);

		// Selecting an item of a list based on the index.
		drpdwn.selectByIndex(3);
		// To know what item is selected -> getFirstSelectedOption().getText() or
		// getAllSelectedOptions()
		System.out.println("Selected item based on index: " + drpdwn.getFirstSelectedOption().getText());

		// Selecting item based on the visible text
		drpdwn.selectByVisibleText("AED");
		System.out.println("Selected item based on visible text: " + drpdwn.getFirstSelectedOption().getText());

		// Selecting item based on the value
		drpdwn.selectByValue("INR");
		System.out.println("Selected item based on the value: " + drpdwn.getFirstSelectedOption().getText());
	}

}
