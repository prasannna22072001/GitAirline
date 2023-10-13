package prasanna.Airline;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends AbstractComponent{

	WebDriver driver;
	
	
	public MainPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	By from = By.xpath("//div[text()='From']/following-sibling::input");
	By fromlist = By.xpath("//div[@class='city']");
	By to = By.xpath("//div[text()='To']/following-sibling::input");
	By date = By.cssSelector(".day.has-info");
	By month = By.xpath("//div[@class='rd-month-label']");
	By search = By.xpath("//button[contains(.,'Search')]");
	
	
	
	public void step1(String pickup) throws InterruptedException {
		
		
		waitForElementToAppear(from);
		
		
		WebElement toClear = driver.findElement(from);
		toClear.sendKeys(Keys.CONTROL + "a");
		toClear.sendKeys(Keys.DELETE);
		
		driver.findElement(from).sendKeys(pickup);
		
	}
	
	public void step2(String city) throws InterruptedException {
		
		//waitForElementToAppear(fromlist);
		List <WebElement> flist = driver.findElements(fromlist);
		//waitForElementToAppear(fromlist);
		Thread.sleep(2000);
		WebElement q =flist.stream().filter(a->a.getText().equalsIgnoreCase(city)).findFirst().orElse(null);
		q.click();
	}
	
	
	public void step3(String toCity) throws InterruptedException {
		
		driver.findElement(to).sendKeys("hy");
		Thread.sleep(2000);
		List <WebElement> tolist = driver.findElements(fromlist);
		
		WebElement t =tolist.stream().filter(a->a.getText().equalsIgnoreCase(toCity)).findFirst().orElse(null);
		t.click();
	}
	
	
	public void calender(String monthName, String exactdate) throws InterruptedException {
		
		List <WebElement> d =driver.findElements(date);
		
		List <WebElement> m = driver.findElements(month);
		
		
		
		WebElement day = m.stream().filter(a->a.getText().equalsIgnoreCase(monthName)).findFirst().orElse(null);
		//waitForElementToAppear(date);
		Thread.sleep(2000);
		day.findElement(By.xpath("following-sibling::table/tbody/tr/td/div[text()='"+exactdate+"']")).click();
		
		driver.findElement(search).click();
	}
	
	
	public void goTo() throws InterruptedException {
		driver.get("https://www.ixigo.com/");
		
	}
	
	
}
