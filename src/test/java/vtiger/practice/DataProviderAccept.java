package vtiger.practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderAccept {
	@Test(dataProvider="phone")
	public void addProductToCartTest(String name,String model,int price,int qnt) {
		System.out.println("name:" +name+" model:" +model+ "price:" +price+ "qnt:"+qnt);
	
	}
	@DataProvider(name="phone")
   public Object[][]getData(){
		Object[][] data=new Object[3][4];
		data[0][0]="samsung";
		data[0][1]="A80";
		data[0][2]=25000;
		data[0][3]=10;
		data[1][0]="iphone";
		data[1][1]="11pro";
		data[1][2]=50000;
		data[1][3]=5;
		data[2][0]="vivo";
		data[2][1]="y21";
		data[2][2]=10000;
		data[2][3]=15;
		
	return data;
		
	}
   

}
