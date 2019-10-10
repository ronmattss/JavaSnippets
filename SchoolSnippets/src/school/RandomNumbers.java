/*
 * Rivera, Ron Matthew R.
 * BSCS 2-2
 * */
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;



public class RandomNumbers {
	
    private static final int days_in_year = 365;
    private static final int trials_size = 10000;

    private static final Random random = new Random();

    private static boolean is_match_in_trial(int group_size) {
        Set<Integer> bdays = new HashSet<>();
        for (int i = 0; i < group_size; ++i) {
            bdays.add(random.nextInt(days_in_year));
        }
        return bdays.size() != group_size;
    }
    
    private static void run_trials(int group_size, int number_of_trials) {
        int number_of_matches = 0;
        for (int i = 0; i < number_of_trials; ++i) {
            if (is_match_in_trial(group_size)) {
                number_of_matches++;
            }
        }
        int percent = (int) (100.0 * number_of_matches / number_of_trials);
        if(percent == 70||percent == 80|| percent == 90||percent == 95||percent == 98||percent == 99) {
        System.out.println(String.format(
                "Found matching birthdays amongst %d people in %d out of %d trials, or %d%% of the time.",
                group_size, number_of_matches, number_of_trials, percent));
        }
    }

	static void random() {
		float success = (float) ((Math.random() % 100) / 10);
		System.out.println("Number one: " + success);
	}

	static int nCr(int n, int r) {

		if (r > n / 2)
			r = n - r;

		int answer = 1;
		for (int i = 1; i <= r; i++) {
			answer *= (n - r + i);
			answer /= i;
		}

		return answer;
	}

	// function to calculate binomial r.v. probability
	static float binomialProbability(int n, int k, float p) {
		return nCr(n, k) * (float) Math.pow(p, k) * (float) Math.pow(1 - p, n - k);
	}

	// Driver code
	public static void main(String[] args) {
		System.out.println();
		System.out.println("Random Number");
		random();
		System.out.println();
		System.out.println("Coin Flip");
		 flip();
			System.out.println();
			System.out.println("Bday probability");
		bday();

	}

	static void flip() {
		int heads = 0;
		int tails = 0;
		int loop = 0;
		double skew;
		int counter = 1;
		double randNum = 0.0;
		Scanner sc = new Scanner(System.in);

		System.out.println("How many times will the coin be flipped? ");
		loop = sc.nextInt();
		System.out.println("How biased is heads? (Input an integer from 0-100): ");
		skew = sc.nextInt();

		skew = skew * 0.01;

		while (loop > 0) {
			randNum = Math.random();
			System.out.print(counter + "\t" + randNum);

			if (randNum < skew) {
				heads++;
				System.out.println("\t heads");
			} else {
				tails++;
				System.out.println("\t tails");
			}
			loop--;
			counter++;
		}
		System.out.println();
		System.out.println("Number of Heads = " + heads);
		System.out.println("Number of Tails = " + tails);
	}
	static void bday()
	{
        for (int group_size = 10; group_size < 100; ++group_size) {
            run_trials(group_size, trials_size);
        }
	}

	
}
