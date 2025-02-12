package Testcases;

import org.testng.annotations.Test;

import Pages.HomePage;

public class HomepageTest{

	
	@Test
	public void TC03_SomeName() {
		
		HomePage pg=new HomePage();
		pg.configurations();
	}
}
