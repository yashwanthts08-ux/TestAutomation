package testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Testing {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		WebElement c = driver.findElement(By.id("country"));
		Select s = new Select(c);
		s.selectByVisibleText("United States");
	List<WebElement> o = s.getOptions();
	for(WebElement w:o) {
		System.out.println(w.getText());
	}
	driver.close();
}
	

}
