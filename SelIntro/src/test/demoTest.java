package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class demoTest {

	public static void main(String args[]) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\sai.vamala_wenable\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// Locators: id, name, css selector, xpath, className, tagName, linkText
		// (Passing the text of the link), partialLinkText
		// Css and Xpath are known as the customized syntax
		// If we want to validate css from console -> $('input[placeholder="Name"]')
		// If we want to validate xpath from console ->
		// $x('//input[@placeholder="Name"]')

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		// Sending username with the help of id locator
		driver.findElement(By.id("inputUsername")).sendKeys("Pradeep");
		// Sending password with the help of name locator
		driver.findElement(By.name("inputPassword")).sendKeys("Password@!23");
		// Clicking on the sign in button with the help of classname locator
		driver.findElement(By.className("signInBtn")).click();
		// Getting the text with the help of the css selector ".attributeValue
		String value = driver.findElement(By.cssSelector(".error")).getText();
		System.out.println(value);
		// Clicking on the forgot password with the help of the link text locator
		driver.findElement(By.linkText("Forgot your password?")).click();
		// Sending username in the forgot password form with the help of the xpath
		// locator
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Sai");
		// Sending the email address in the forgot password form with the help of the
		// customized css selector.
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("vsaipradeep217@gmail.com");
		// Clearing the provided input with the help of .clear() method and reaching the
		// element with the help of xpath indexing
		driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
		driver.findElement(By.cssSelector("input[type=\"text\"]:nth-child(3)")).sendKeys("pradeep217@gmail.com");

		// Indexing with Css input[type="text"]:nth-child(3) ---> Indexing number can
		// vary for both css and xpath indexing.

		// Parent child traverse in Xpath => //parentTagName/childTagName -->
		// Single slash '/' is treated as a child element.

		// Finding phone number element with xpath parent - child traverse
		// (//form/input)[3] or //form/input[3]
		// Grandparent - Parent - Child traverse //form//div/button[2]
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("9390005627");
		// Selecting reset button with help of css selector
		driver.findElement(By.cssSelector("button.reset-pwd-btn")).click();

		// Parent child traverse with Css => parentTagName<space>childTagName

		// Getting the text with parent child traverse of css selector
		System.out.println(driver.findElement(By.cssSelector("form p")).getText());

		driver.close();
	}
}
