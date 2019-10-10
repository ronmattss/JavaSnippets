package school;

public abstract class Account {
	protected int accountNumber;
	protected double accountBalance;

	public Account(int accNumb) {
		setAccountNumber(accNumb);
		setAccountBalance(0.0);
	}

	public abstract int getAccountNumber();

	public void setAccountNumber(int accNumber) {
		this.accountNumber = accNumber;
	}

	public abstract double getAccountBalance();

	public void setAccountBalance(double accBalance) {

		this.accountBalance = accBalance;
	}
}
