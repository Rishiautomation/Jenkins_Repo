package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import Testcases.BaseClass;

public class HomePage   {

	WebDriver driver = BaseClass.driver;
	
	
	public HomePage() {
		
		PageFactory.initElements(driver, this);
	}
	public void configurations() {
		System.out.println("on Homepage");
	}
}
