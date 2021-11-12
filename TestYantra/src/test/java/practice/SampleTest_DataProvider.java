package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SampleTest_DataProvider {
	@Test(dataProvider = "bookTicketDataProvider")
	public void bookTicket(String src, String dest, int ticket) {
		System.out.println("Execute source =>" +src +",Destination==>"+dest);
	}
	
	@DataProvider
	public Object[][] bookTicketDataProvider(){
			Object[][] objArr=new Object[5][3];
			objArr[0][0]="Bangalore";
			objArr[0][1]="Mysore";
			objArr[0][2]=10;
			
			objArr[1][0]="Bangalore";
			objArr[1][1]="Mandya";
			objArr[1][2]=10;
			
			objArr[2][0]="Bangalore";
			objArr[2][1]="Mangalore";
			objArr[2][2]=10;
			
			objArr[3][0]="Bangalore";
			objArr[3][1]="Hassan";
			objArr[3][2]=10;
			
			objArr[4][0]="Bangalore";
			objArr[4][1]="shivamogga";
			objArr[4][2]=10;
			
		return objArr;
		
	}

}
