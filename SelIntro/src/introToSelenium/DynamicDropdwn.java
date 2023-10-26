package introToSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicDropdwn {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.xpath("//*[contains(@id,'originStation1_CTXTaction')]")).click();
		// driver.findElement(By.xpath("//a[@value='BLR']")).click();
		driver.findElement(
				By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR'] //a[contains(@value,'BLR')]"))
				.click();
		Thread.sleep(2000);
		// driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
		driver.findElement(
				By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[contains(@value,'MAA')]"))
				.click();
		// Parent Child traverse mechanism ==> //parentTagName/childtagName
		// Parent Child relationship mechanism ==> parentXpath<space>childXpath
		driver.close();
	}
}
