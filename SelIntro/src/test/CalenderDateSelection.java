package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CalenderDateSelection {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		// Css -> tagName.className or .className and tagName#id or #id
		// If the class name has spaces, it means it have multiple classes, then
		// consider one class of it or remove spaces and add dot.
		/*
		 * driver.findElement(By.xpath("//*[contains(@id,'originStation1_CTXTaction')]")
		 * ).click(); // driver.findElement(By.xpath("//a[@value='BLR']")).click();
		 * driver.findElement( By.
		 * xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR'] //a[contains(@value,'BLR')]"
		 * )) .click(); Thread.sleep(2000); //
		 * driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
		 * driver.findElement( By.
		 * xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[contains(@value,'MAA')]"
		 * )) .click();
		 */
		// .ui-datepicker-days-cell-over.ui-datepicker-current-day.ui-datepicker-today
		// driver.findElement(By.cssSelector(".ui-state-active")).click();
		// Assert.assertFalse(driver.findElement(By.cssSelector("#ctl00_mainContent_view_date2")).isEnabled());
		driver.findElement(By.cssSelector("#ctl00_mainContent_rbtnl_Trip_1")).click();
		if (driver.findElement(By.id("Div1")).getAttribute("style").contains("1")) {
			Assert.assertTrue(true);
		} else {
			Assert.assertFalse(true);
		}
	}
}
