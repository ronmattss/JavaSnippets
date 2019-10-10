package school;

import java.util.*;

public class Checking extends Account {
	public Checking(int accNumb) {
		super(accNumb);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getAccountNumber() {
		System.out.println("Checking Information:\n Account Number: " + this.accountNumber + "\n Account Balance: $"
				+ this.accountBalance);

		return this.accountNumber;
	}

	@Override
	public double getAccountBalance() {
		return this.accountBalance;
	}

}
