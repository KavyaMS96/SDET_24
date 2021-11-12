package practice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateOrgTest {
@BeforeClass
	public void configBC() {
	System.out.println("==========Launcch Browser========");
	}
	
	
@BeforeMethod
	public void  configBM() {
		
		System.out.println("==========Login========");
	}


	@Test
	public void createOrgTest() {
		System.out.println("Navigate to Org Module");
		System.out.println("create Org");
		System.out.println("verify");
	}
	@Test
	public void createOrgWithIndusTest() {
		System.out.println("Navigate to Org Module");
		System.out.println("create Org with industry");
		System.out.println("verify");
	}
	
	@Test
	public void createOrgWithRatingTest() {
		System.out.println("Navigate to Org Module");
		System.out.println("create Org with rating");
		System.out.println("verify");
	}
	
@AfterMethod
	public void configAM() {
	System.out.println("==========Log Out========");
	
}

@AfterClass
	public void configAC() {
		System.out.println("==========Close the Browser========");
	}
}
