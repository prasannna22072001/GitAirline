package prasanna.Airline;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class CompanyPage extends AbstractComponent{

	WebDriver driver;
	
	
	public CompanyPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	By results1 = By.xpath("//div[@class='prdctn-hdng']");
	By flight_data = By.xpath("//a/following-sibling::div[@class='u-text-ellipsis']");
	
	
	public void step1(String airline_number) {
		waitForElementToAppear(results1);
		List <WebElement> data = driver.findElements(flight_data);
		WebElement d = data.stream().filter(q->q.getText().equalsIgnoreCase(airline_number)).findFirst().orElse(null);
		d.findElement(By.xpath("parent::div[@class='u-text-ellipsis']/parent::div/parent::div/parent::div/following-sibling::div[2]/div/div/button[@class='c-btn u-link  enabled']")).click();
	}
	
}
