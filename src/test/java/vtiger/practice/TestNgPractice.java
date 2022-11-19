package vtiger.practice;

import org.testng.annotations.Test;

public class TestNgPractice {
	@Test(invocationCount=2,priority=1)
	public void createCustomer() {
		System.out.println("customer created");
	}
	@Test(priority=2)
	public void modifyCustomer() {
		System.out.println("customer created");
	}
	@Test(priority=3)
	public void deleteCustomer() {
		System.out.println("customer created");
	}
}
