//MACHINE PROBLEM : RECURSION

//Author: RIVERA, RON MATTHEW R.

//Date : 29-08-19

package school;

import java.util.Scanner;



public class Recursion {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean choice = true;
		while (choice) {
	
			int i = 0;
			int j = 0;
			int k = 0;
			System.out.println("Choose a function: ");
			System.out.println("1. Exponent of a positive integer\n2. nth Fibonacci\n3. GCD of two numbers");
			i = sc.nextInt();
			switch (i) {
			case 1:
				System.out.println("Enter a positive base and power: ");
				System.out.print("Base: ");
				j = sc.nextInt();
				System.out.print("Power: ");
				k = sc.nextInt();
				System.out.println(j+ " ^ " +k +" = "+ power(j, k));
				break;
			case 2:
				System.out.println("Enter a positive Integer: ");
				System.out.println("The nth Fibonacci number: "+fib(sc.nextInt()));
				break;
			case 3:
				System.out.println("Enter two positive Integer: ");
				System.out.print("first Integer: ");
				j = sc.nextInt();
				System.out.print("Second Integer: ");
				k = sc.nextInt();
				System.out.println("GCD of the two integers: "+gcd(j, k));
				break;

			default:
				break;
			}
			
			System.out.println("\nAgain (y/n): ");
			String ab = sc.next();
			if(ab.equalsIgnoreCase("y"))
				choice = true;
			else
				choice = false;
				
		}
		sc.close();
		System.out.println("Good Bye!");

	}

	public static long power(int base, int powerRaised) {
		if (powerRaised != 0)
			return (base * power(base, powerRaised - 1));
		else
			return 1;
	}

	public static long fib(int n) {
		if (n <= 1)
			return n;
		return fib(n - 1) + fib(n - 2);
	}

	public static long gcd(int a, int b) {

		if (b == 0)
			return a;
		else
			return gcd(b, a % b);
	}

}
