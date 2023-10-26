package introToSelenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowActivities {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// System.setProperty("webdriver.chrome.driver",
				//"C:\\Users\\sai.vamala_wenable\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// To enable full screen mode
		driver.manage().window().maximize();
		driver.get("https://www.google.com");

		// To navigate to any website, instead of using driver.get("");
		// It opens in another tab.
		driver.navigate().to("http://www.rahulshettyacademy.com");

		// Difference between .get() and .navigate() is that "if we use driver.get(),
		// method -> By default selenium will wait till all the components are loaded on
		// the page, but for .navigate() -> Selenium will wait till something is loaded.
		// Hence, for the first time, it is preferred to use "driver.get()" and later
		// use "driver.navigate().to()".
		
		// Navigating back to the first page
		driver.navigate().back();
		
		// Navigating forward to the last page
		driver.navigate().forward();

	}

}
