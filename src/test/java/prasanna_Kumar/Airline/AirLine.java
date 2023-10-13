package prasanna_Kumar.Airline;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import prasanna.Airline.CompanyPage;
import prasanna.Airline.DetailsPage;
import prasanna_Kumar.TestComponents.BaseTest;

public class AirLine extends BaseTest{

	String from ="Mumbai";
	String city ="BOM - Mumbai, India";
	String toCity ="HYD - Hyderabad, India";
	String month ="October 2023";
	String date = "26";
	String airline_number="AI619";
	
	
	@Test()
	public void Main() throws InterruptedException {
		
		//here i can call directly from Base test becasuse we extended baseTest class here and there public variables can be used here in child calss
		
		mainpage.step1(from);
		mainpage.step2(city);
		mainpage.step3(toCity);
		mainpage.calender(month ,date);
		
		System.out.println("prasanna");
		System.out.println("prasanna");
		System.out.println("prasanna");

		for( int i=0;i<4;i++) {
			System.out.println(i);
		}
		CompanyPage cpage = new CompanyPage(driver);
		cpage.step1(airline_number);
		
		DetailsPage Dpage = new DetailsPage(driver);
		String flight_number = Dpage.step1();
		Assert.assertEquals(flight_number, airline_number);
		Dpage.step2();
		Dpage.step3();
	}
	

	
}
