package practice;

import java.util.Date;

import org.testng.annotations.Test;

public class CurrentDate {
	
	@Test
	public void currentdate() throws Throwable {
		
		Date dateObj=new Date();
		String date= dateObj.toString();
		System.out.println(date);
		
		String[] today= date.split(" ") ;
		String day=today[0];
		String month=today[1];
		String actDate=today[2];
		String year=today[5];
		
		String travelDate= day+" "+month+" "+actDate+" "+year;
		System.out.println(travelDate);

}
}
