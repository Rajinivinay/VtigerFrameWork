package vtiger.practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateMultipleOrganisationwithIndustry {
	@Test(dataProvider="organisations")
	public void CreateMultipleOrganisationwithIndustryTest(String name,String ind) {
		System.out.println(name);
		System.out.println(ind);
		
	}
	@DataProvider(name="organisations")
	public Object[][]getData(){
		Object[][] data=new Object[4][2];
		data[0][0]="qspider";
		data[0][1]="HealthCare";
		data[1][0]="allstates";
		data[1][1]="education";
		data[2][0]="wipro";
		data[2][1]="energy";
		data[3][0]="infosys";
		data[3][1]="education";
		return data;
		
	}

}
