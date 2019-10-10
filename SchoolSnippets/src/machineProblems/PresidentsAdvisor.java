/*
 * Author: Rivera, Ron Matthew R.
 * */

package machineProblems;

import java.util.*;

public class PresidentsAdvisor {

	public static void main(String[] args) {

		int prompt = 1;
		while(prompt > 0) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Starting point [1-13] or 0 to exit: ");
		int sp = scanner.nextInt();
		
		if(sp == 0)
			break;
		else {
		System.out.println("Enter advisor Interval [1-100]: ");
		int interval = scanner.nextInt();
		//temporarily add it to a list
		List<Integer> list = new ArrayList<Integer>(); list = advisors(list,13);
		
		LinkedList cl = new LinkedList();
		for(int i =0; i <list.size();i++)
			LinkedList.insertCircularList(cl, list.get(i));
		
		System.out.println(cl.lengthOfCL());
		chooseAdvisors(sp,interval,cl);
		}
		
		
		}		
		// enter starting point
		// enter interval
		// display advisors
	}
	
	static List<Integer> advisors(List<Integer> list, int numOfAdvisors)
	{
		for (int i = 1; i <= numOfAdvisors; i++) {
			list.add(i);
		}
		return list;		
	}
	
	// This method handles the picking of the advisor
	// 
	static void chooseAdvisors(int startingPoint,int interval,LinkedList list)
	{
		//assign an array for the 5 chosen advisors
		int advisors[] = new int[5];
		int digit;
		LinkedList temp = list;
		temp.h = LinkedList.queryNode(temp, startingPoint);

//		System.out.println("Starting List");
		LinkedList.printCircularList(temp);
		
		for(int i = 0; i<advisors.length;i++)
		{
			temp.h = LinkedList.queryNode(temp, interval);
			digit = temp.h.digit;
			advisors[i] = digit;
			LinkedList.deleteNode(temp.h.digit, temp);
//			System.out.println("advisor: "+ advisors[i]);
//			System.out.print("removed "+advisors[i]+": \n\nNew List:");	
			LinkedList.printCircularList(temp);
			
			
		}System.out.println("Chosen Advisors:");
		for(int j =0; j<advisors.length;j++)
			System.out.print(" "+ advisors[j]);	
		System.out.println();
		
	}

}
