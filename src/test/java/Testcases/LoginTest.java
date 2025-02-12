package Testcases;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Pages.LoginPage;

public class LoginTest extends BaseClass {

	@Test
	public void TC01_loginfailureTest() {

		LoginPage lp = new LoginPage();
		lp.LoginFunction("abc@xyz", "ABCXYZ");
		lp.ValidateErrorMsg("Please enter a valid email address");
	}

	@Test(dataProvider="TestData")
	@Parameters({ "param1", "param2" })
	public void TC02_LoginSuccessTest(String username, String Password) {

		LoginPage lp = new LoginPage();
		lp.LoginFunction(username, Password);
	}

	
	Map<String ,String> testdata = new HashMap<String, String>();
	@Test(dataProvider="dp")
	public void TC03_loginfailureTest(String Key) {

		LoginPage lp = new LoginPage();
		lp.LoginFunction(Key, testdata.get(Key));
	}

	@DataProvider(name = "dp")
	public Iterator<String> method1() {
       
		 testdata.put("aaa@xyz.com", "Abc@1234");
		 testdata.put("bbb@xyz.com", "edf@1234");
		 testdata.put("ccc@xyz.com", "ghl@1234");
		 
		 return testdata.keySet().iterator();
		 
	}
	@Test
	public void TC05_loginfailureTest() {

		LoginPage lp = new LoginPage();
		String UserNameVal = sheet.getRow(1).getCell(0).getStringCellValue();
		String PasswordVal = sheet.getRow(1).getCell(1).getStringCellValue();

		lp.LoginFunction(UserNameVal, PasswordVal);
		lp.ValidateErrorMsg("Please enter a valid email address");
	}
	
	@DataProvider(name="TestData")
	public Object[][] method2(){
		ArrayList<String[]> testData= new ArrayList<>();
		testData.add(new String[]{"aaa@xyz.com", "Abc@1234"});
	    testData.add(new String[]{"bbb@xyz.com", "edf@1234"});
	    testData.add(new String[]{"ccc@xyz.com", "ghl@1234"});
		
	    return testData.toArray(new Object[0][0]);
		}
		
	}

