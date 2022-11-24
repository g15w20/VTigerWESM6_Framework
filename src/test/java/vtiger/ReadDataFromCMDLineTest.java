package vtiger;

import org.testng.annotations.Test;

public class ReadDataFromCMDLineTest {
	
	@Test()
	public void readData()
	{
		String BROWSER = System.getProperty("browser");
		String UserName = System.getProperty("username");
		System.out.println(BROWSER);
		System.out.println(UserName);
	}
	

}
