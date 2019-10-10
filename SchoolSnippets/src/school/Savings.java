package school;

public class Savings extends Account {
	private int interestRate;

	public Savings(int accNumb, int rate) {
		super(accNumb);
		this.setInterestRate(rate);
	}

	@Override
	public int getAccountNumber() {
		System.out.println("Saving Information:\n Account Number: " + this.accountNumber + "\n Account Balance: $"
				+ this.getAccountBalance() + "\n Account Interest: " + getInterestRate() + "%");
		return this.accountNumber;
	}

	@Override
	public double getAccountBalance() {
		return this.accountBalance;
	}

	public int getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(int interestRate) {
		this.interestRate = interestRate;
	}

}
