package school;

public class DemoAccounts {

	public static void main(String[] args) {
		Account acc = new Checking(217905);
		acc.setAccountBalance(200.00);
		acc.getAccountNumber();
		Account acc2 = new Savings(21781, 21);
		acc2.setAccountBalance(2001);
		acc2.getAccountNumber();

	}

}
