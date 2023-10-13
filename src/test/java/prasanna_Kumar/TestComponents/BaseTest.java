package prasanna_Kumar.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.asm.Advice.Return;
import prasanna.Airline.MainPage;





public class BaseTest {
	public static   WebDriver driver;
	public MainPage mainpage;
	
		public static  WebDriver initializeDriver() 
		{
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			return driver;
		
		}
	
	



//	public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException
//	{
//		//read json to string
//		String jsonContent = FileUtils.readFileToString(new File(filePath)
//				,StandardCharsets.UTF_8);
//		
//		//string to hashmap with jackson databin
//		
//		ObjectMapper mapper = new ObjectMapper();
//		List<HashMap<String,String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String,String>>>() {	
//		});
//	
//		return data;
//	}
////	
//	public String getScreenshot(String testCaseName,WebDriver driver) throws IOException
//	{
//		TakesScreenshot ts=(TakesScreenshot)driver;
//		File source = ts.getScreenshotAs(OutputType.FILE);
//		File file = new File(System.getProperty("user.dir")+"//reports//"+testCaseName+".png");
//		FileUtils.copyFile(source, file );
//		return System.getProperty("user.dir")+"//reports//"+testCaseName+".png";
//	
//	}
//	
//	@DataProvider
//	public Object[][] getData() throws IOException
//	{
//
//		
//		List <HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\prasanna\\data\\PurchaseOrder.json");
//		return new Object[][] {{data.get(0)},{data.get(1)}};
//	}
//	
//	
		
		
	@BeforeMethod(alwaysRun=true)
	public  MainPage launchApplication() throws IOException, InterruptedException
	{
		driver = initializeDriver();
		mainpage = new MainPage(driver);
		mainpage.goTo();
		return mainpage;
		
	}






}
