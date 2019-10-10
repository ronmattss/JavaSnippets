package school;

import java.util.*;

public class AccountArray {

	public static void main(String[] args) {
		ArrayList<Checking> check = new ArrayList<>();
		ArrayList<Savings> save = new ArrayList<>();
		ArrayList<Account> accs = new ArrayList<>();
		Random rand = new Random();
		
		Scanner sc = new Scanner(System.in);
		for(int i = 0; i< 10;i++)
		{
			if(i< 5)
			{
				int randInterest = rand.nextInt(20);
				System.out.print("Set Saving Account Num: ");
				save.add(new Savings(sc.nextInt(),randInterest));
				System.out.print("Set Saving Account Balance: ");
				save.get(i).setAccountBalance(sc.nextDouble());
				accs.add(save.get(i));
			}
			else
			{System.out.print("Set Checking Account Num: ");
				check.add(new Checking(sc.nextInt()));
				System.out.print("Set Checking Account Balance: ");
				check.get(i -5).setAccountBalance(sc.nextDouble());
				accs.add(check.get(i - 5));
			}
		}
		accs.forEach(acc->{acc.getAccountNumber();});
		
		sc.close();
	}


}
