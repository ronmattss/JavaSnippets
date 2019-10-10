/*Addition of Linked list numbers
 * Author: Rivera, Ron Matthew R.
 * 
 * */
package machineProblems;

import java.util.Scanner;

public class AdditionOfLinkedList {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean choice = true;
		while(choice) {	
		System.out.println("Addition of LinkedList digits");
		System.out.print("Enter First number: ");
		String i = sc.next();
		System.out.print("Enter Second number: ");
		String j = sc.next();
		LinkedList list1 = new LinkedList();
		LinkedList list2 = new LinkedList();
		
		
		// check if the length of i > j
		if(i.length() > j.length())
		{
		 list1 = parseInput(i);
		 list2 = parseInput(j);
		}
		else
		{
			list1 = parseInput(j);
			list2 = parseInput(i);
		}

		
		
		LinkedList list3 = addLists(list1,list2);
		System.out.print("\nThe Sum is: ");
		LinkedList.printList(list3);
		
		System.out.println("\nAgain (y/n): ");
		
		String a = sc.next();
		
		if(a.equalsIgnoreCase("y"))
			choice = true;
		else
			choice = false;
		
		}
		
		sc.close();
	}
	
	// Make the String input convertible to a linkedlist of digits
    static LinkedList parseInput(String input)
    {
    	LinkedList list = new LinkedList();
    	
    	
   // 	System.out.print("\nParsed: "+input.length() +"\n");
    	
    	// This will be in reverse order 
    	// which means in a string of "123" 3 will be the head and 1 will be the tail
    	for(int i = input.length() - 1; i>= 0; i--)
    	{
 //   		System.out.print("i = "+ i+" ");
    		list = LinkedList.insert(list,(int) input.charAt(i) - '0');
    	}
    	
    	return list;
    	
    }
    
    static LinkedList addLists(LinkedList first,LinkedList second)
    {

    	int carry = 0;
    	StringBuilder sb = new StringBuilder();
    	String sum;

    	for(int i = 1; i<=first.length();i++)
    	{
    		int q;
    		int w;
    		int e;
    		if(i > second.length())
    		{
    			 q = LinkedList.queryList(first, i);
     		 	if(carry + q  > 9) {
    		 		e = (carry + q  ) %10;
    		 		carry = (carry + q ) / 10;
    		 		}
     		 	else
     		 	{
    			 e = carry + q;
    			 carry = 0;
     		 	}
    			 sb.append(e);
    			 
    		}
    		
    		else {
    		 q = LinkedList.queryList(first, i);
    		 w = LinkedList.queryList(second, i);
    		 
    		 	if(carry + q + w > 9) {
    		 		e = (carry + q + w) %10;
    		 		carry = (carry + q + w) / 10;

    		 		}
    		 	else
    		 	{
    		 		e = q + w;
    		 	}
    		 	
    		 	sb.append(e);    		 	
    		}
//    		System.out.print(" "+e +" ");
    	}
    	
    	if(carry > 0)
    		sb.append(carry);
    	
    	sum = sb.toString();
    	
   // 	System.out.println(sum);
    	
    	LinkedList sumOfAll = parseInput(sum);
    	
    	return sumOfAll;    	
    }

}
