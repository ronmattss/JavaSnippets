/*
 * Author: Rivera, Ron Matthew R. BSCS 2-2
 * Evalution of Arithmetic Expression Solution
 * */

package machineProblems;

import java.util.*;

public class ArithmeticExpression {

	public static void main(String[] args) {
		System.out.println("Enter an Expression: ");
		Scanner sc = new Scanner(System.in);
		boolean choice = true;
		while(choice) {	
			// postfix class has the stack inplementation
		Postfix pf = new Postfix();
		String s = sc.nextLine();
		
	//	System.out.println(pf.infixToPostfix(s));
		System.out.println(pf.evaluate(s));
		
		System.out.println("\nAgain (y/n): ");
		
		String a = sc.next();
		
		if(a.equalsIgnoreCase("y"))
			choice = true;
		else
			choice = false;
		
		}
		sc.close();
	}

}
