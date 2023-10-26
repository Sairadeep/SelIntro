package ecommerceApp;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().window().maximize();
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
				// rely on text as it changes.
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
