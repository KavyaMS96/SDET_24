package practice;

import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.sdet24.GenericUtility.BaseClass;
import com.sdet24.GenericUtility.BaseClassAnnotation;


@Listeners(com.sdet24.GenericUtility.ListnerImplementation.class)
public class ListnerTest extends BaseClassAnnotation {
	
	
	@Test
	public void listnertest() {
		
		System.out.println("Test Failed");
		Assert.fail();
		
	}

}
