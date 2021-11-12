package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SampleTest_DataProvider2 {
	@Test(dataProvider = "bookTicketDataProvider")
	public void bookTicket(String src, String dest) {
		System.out.println("Execute source =>" +src +",Destination==>"+dest);
	}
	
	@DataProvider
	public Object[][] bookTicketDataProvider(){
			Object[][] objArr=new Object[5][2];
			objArr[0][0]="Bangalore";
			objArr[0][1]="Mysore";
			
			objArr[1][0]="Bangalore";
			objArr[1][1]="Mandya";
			
			objArr[2][0]="Bangalore";
			objArr[2][1]="Mangalore";
			
			objArr[3][0]="Bangalore";
			objArr[3][1]="Hassan";
			
			objArr[4][0]="Bangalore";
			objArr[4][1]="shivamogga";
			
			
		
		return objArr;
		
	}

}
