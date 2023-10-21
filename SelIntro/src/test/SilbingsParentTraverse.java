package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class SilbingsParentTraverse {
	public static void main(String[] args) {
		// Absolute Xpath: We are traversing from the root i.e., <html> and it always
		// starts with "/" => /html/body/header/div
		// Relative Xpath: Relatively pointing to a particular location.
		// starts with "//" => //header/div

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\SAI PRADEEP VAMALA\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		// Silbings to sibling traverse -> //header/div/following-sibling::tagname
		String SiblingtraverseButton = driver
				.findElement(By.xpath("//header/div/button/following-sibling::button[contains(text(),'Login')]"))
				.getText();

		// Child to parent traverse -> //header/div/button[1]/parent::tagname
		// Like that we can go any where and come anywhere => Grand Parent to Grand
		// Child or vice-versa

		// Child to parent to grandparent and then to another parent.
		// //header/div/button/following-sibling::button[contains(text(),'Login')]/parent::div/parent::header/a

		// Child - Child - parent - child
		// //header/div/button/following-sibling::button[contains(text(),'Login')]/parent::div/button[1]

		String childParentChildTraverse = driver.findElement(By.xpath("//header/div/button[1]/parent::div/button[2]"))
				.getText();
		Assert.assertEquals(SiblingtraverseButton, childParentChildTraverse);
		driver.close();
	}
}
