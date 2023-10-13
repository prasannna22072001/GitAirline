package prasanna.Airline;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class DetailsPage extends AbstractComponent{

	WebDriver driver;
	
	
	public DetailsPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	By results1 = By.xpath("//div[@class='prdctn-hdng']");
	By flight_number = By.cssSelector(".info");
	By flight_data = By.xpath("//a/following-sibling::div[@class='u-text-ellipsis']");
	By right =By.cssSelector(".nav.right.ixi-icon-chevron");
	
	
	public String step1() {
		
		waitForElementToAppear(flight_number);
		String fnumber =driver.findElement(flight_number).getText();
		String[] words = fnumber.split(" ");
		String airline_number = words[2];
		return airline_number;
	
	}
	
	public void step2() throws InterruptedException {
		
		for(int i=1; i<=2; i++) {
		
			
		Thread.sleep(3000);
		String places =driver.findElement(By.xpath("(//div[@class='airport-code'])["+i+"]")).getText();
		String time = driver.findElement(By.xpath("(//div[@class='time'])["+i+"]")).getText();
		
		System.out.println(places+ "-" +time);
		Thread.sleep(4000);
		driver.navigate().back();
		}
	}
	
	
	
	public void step3() throws InterruptedException {
		
		Thread.sleep(4000);
		//waitForElementToAppear(results1);
		List <WebElement> data = driver.findElements(flight_data);
		WebElement d;
		do {
		d = data.stream().filter(q->q.getText().equalsIgnoreCase("6E5296, 6E537")).findFirst().orElse(null);
		if(d==null) {
			
			JavascriptExecutor js = (JavascriptExecutor) driver;

	        js.executeScript("window.scrollBy(0, 1000);");
			
	        driver.findElement(right).click();
		}else {
			System.out.println(d.getText());
		}
		}while(d==null);
	}
	
	
	
	
	
	
	
}
