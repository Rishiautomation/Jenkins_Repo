package Testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver driver;

	public XSSFWorkbook wbook;
	public XSSFSheet sheet;
	

	@BeforeMethod
	public void SetrupDriver() {
		 
		 WebDriverManager.chromedriver().setup();  
	        ChromeOptions options = new ChromeOptions();
	        driver = new ChromeDriver(options);
	        options.addArguments("--headless=new");  // Run in headless mode
	        options.addArguments("--no-sandbox");    // Bypass OS security model
	        options.addArguments("--disable-dev-shm-usage"); // Fix shared memory issues
	        options.addArguments("--remote-allow-origins=*");
	        
		driver.get("https://simplilearn.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	@AfterMethod
	public void TearDown() {
		driver.close();
	}
	
	@BeforeTest
	public void SetupExcel() throws IOException {
		FileInputStream fis = new FileInputStream("exceldata.xlsx");
		wbook = new XSSFWorkbook(fis);
		sheet = wbook.getSheet("Sheet1");
		
	}
	@AfterTest
	public void CloseExcel() throws IOException {
		
		wbook.close();
		
	}
}
