package vtiger.ContactsTests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractise {
	
	@Test(dataProvider = "phones")
	public void addProductToCartTest(String Name,String model,int price,int qty)
	{
		System.out.println("phone name"+Name+" model"+model+" price"+price+" quantity"+qty);
	}
	@DataProvider(name="phones")
	public Object[][] getData()
	{
		Object[][] data=new Object[3][4];
		data[0][0]="samsung";
		data[0][1]="A50";
		data[0][2]=25000;
		data[0][3]=10;
		
		data[1][0]="Iphone";
		data[1][1]="11pro";
		data[1][2]=5000;
		data[1][3]=20;
		
		data[2][0]="Vivo";
		data[2][1]="Y21";
		data[2][2]=10000;
		data[2][3]=15;
		
	
		return data;
	}

}
