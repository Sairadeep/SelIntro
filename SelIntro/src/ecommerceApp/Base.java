package ecommerceApp;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {

	public static void main(String[] args) {
		// Explicit wait can be acheived in two ways:
		// 1: WebDriver wait
		// 2: Explicit Fluent
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		// Implicit Wait of 5 seconds
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.manage().window().maximize();
		addProductToCart(driver);
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@placeholder,'promo')]")));
		driver.findElement(By.xpath("//*[contains(@placeholder,'promo')]")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector(".promoBtn")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("promoInfo")));
		System.out.println(driver.findElement(By.className("promoInfo")).getText());
	}

	public static void addProductToCart(WebDriver driver) {
		// Static keyword is used as we are directly calling this method without
		// creating an object of the class.
		int j = 0;
		ArrayList<String> productsList = new ArrayList<String>();
		productsList.add("Cucumber");
		productsList.add("Brocolli");
		productsList.add("Tomato");
		productsList.add("Pumpkin");
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		// If preferred product is present, click on 'Add To Cart'.
		for (int i = 0; i < products.size(); i++) {
			// Arrays takes less memory than ArrayList.
			// ArrayList supports a method called contains() as to compare the product name
			// with the productsList.
			// If the arraylist contains the name then click on the element.
			String fetchedProduct = products.get(i).getText();
			String splitFetchedProduct = fetchedProduct.split("-")[0].trim();
			if (productsList.contains(splitFetchedProduct)) {
				// Hence, we are able to click on 'Add To Cart' of the cucumber but we can't
				// rely on text as it changes dynamically.
				// //div[@class='product-action'] //button[@type='button'] OR
				// //div[@class='product-action']/button
				j++;
				driver.findElements(By.xpath("//div[@class='product-action'] //button[@type='button']")).get(i).click();
				// break can't be used with arrays as we need to check for the other elements in
				// the array or arraylist.
				if (j == productsList.size())
					break;
			}
		}
	}
}
