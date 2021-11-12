package practice;

import org.testng.annotations.Test;

public class CustomerTest {
	
	@Test(invocationCount=4)
	public void createCustomerTest() {
		
		System.out.println("Execute HDFC CreateCustomerTest");
//		int[] arr= {123};
//		System.out.println(arr[5]);
		
	}
	
	@Test(dependsOnMethods="createCustomerTest")
	public void modifyCustomerTest() {
		System.out.println("Execute HDFC ModifyCustomerTest");
	}
	
	@Test(dependsOnMethods="modifyCustomerTest")
	public void deleteCustomerTest() {
		System.out.println("Execute HDFC DeleteCustomerTest");
	}

}
