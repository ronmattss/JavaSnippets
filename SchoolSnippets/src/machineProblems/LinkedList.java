/*
 * Author: Rivera, Ron Matthew R. BSCS 2-2
 * Linked list class for Addition and advisor
 * */

package machineProblems;


// This class handles the creation and some methods for the LinkedList
// the class contains two static class which is added in the list via the insert methods.
public class LinkedList {
	// The Position of the nodes starts at 1;
	SinglyNode head;	
	CircularNode h;
	CircularNode t;

	// this static node is used in the Linked List addition
    static class SinglyNode{
	int digit;
	SinglyNode next;
	
	SinglyNode (int d){
		digit = d;
		next = null;
	}
   }
    
    // this static node is used in the advisors
    static class CircularNode{
    	int digit;
    	CircularNode next;
    	
    	CircularNode(int d){
    		digit = d;
    		next = null;
    	}
    }
	
    //insert a new Node in the SinglyList
	public static LinkedList insert(LinkedList list, int data)
	{
		SinglyNode newNode = new SinglyNode(data);
		newNode.next = null;
		
		//if list is empty
		if(list.head == null)
			list.head = newNode;
		
		else
		{
			SinglyNode last = list.head;
		while(last.next != null)
		 {
			last = last.next;
		 }
		
		last.next = newNode;
		 }
		return list;
	}
	
	//insert a new Node in the CircularList
	public static LinkedList insertCircularList(LinkedList list, int data)
	{
		CircularNode newNode = new CircularNode(data);
		newNode.next = null;
		
		//if list is empty
		if(list.h == null) {
			list.h = newNode;
			list.t = newNode;
			newNode.next = list.h;
		}			
		
		else
		{
			list.t.next = newNode;
			list.t = newNode;
			list.t.next = list.h;

		 }
		return list;
	}
	
	// method to print each digit in the list
	public static void printList(LinkedList list) 
    { 
		SinglyNode currNode = list.head; 
   
//        System.out.print(": "); 
   
        // Traverse through the LinkedList 
        while (currNode != null) { 
            // Print the data at current node 
            System.out.print(currNode.digit); 
   
            // Go to next node 
            currNode = currNode.next; 
        } 
    } 
	
	public static void printCircularList(LinkedList list) 
    { 
		CircularNode currNode = list.h; 
   
//        System.out.print(": "); 
   
        // Traverse through the LinkedList 
        while (currNode != null) { 
            // Print the data at current node 
            System.out.print(" "+currNode.digit); 
   
            // Go to next node 
            if(currNode.next == list.h) {
             //   System.out.print(currNode.next.digit); 
            	break;}
            else
            currNode = currNode.next; 
        } 
        System.out.println();
    }
	
	// This method searches the list digit
	public static int queryCircularList(LinkedList list, int element)
	{
		CircularNode currNode = list.h;
		int counter = 0;
		
		
		while(counter != element )
		{
			if(currNode == null)
				break;
			else {
				currNode = currNode.next;
				counter++;
				}
		}
		//print the digit in that node
//		System.out.println("queried: "+currNode.digit);
		return currNode.digit;
	}
	
	// A method to delete a Node 
	// Note that this method is only for CircularNode
	public static void deleteNode(int digit, LinkedList list)
	{
        if (list.h == null) 
            return; 
  
        int pos = findDigit(list,digit ).digit;
        CircularNode curr = list.h;
        CircularNode prev = new CircularNode(0); // placeholder value
        
        while(curr.digit != pos)
        {
        	if(curr.next == list.h)
        		break;
            prev = curr;
            curr = curr.next;
        }
        // check if no other nodes         
        if(curr == list.h) {
        	prev = list.h;
        	while (prev.next != list.h)
        		prev = prev.next;
        	list.h = curr.next;
        	prev.next = list.h;
        }
        
        if(curr.next == list.h && curr == list.h)
        {
        	list.h= null;
        	return;
        }
        
        else if (curr.next == list.h)
        {
        	prev.next = list.h;
        }
        else
        	prev.next = curr.next;        
  	}
	
	// Go to the corresponding element then return the currentNode 
	// return the digit in that element
	public static int queryList(LinkedList list, int element)
	{
		//Node currNode = list.head;
		//int counter = 1;
		SinglyNode currNode = list.head;
		int counter = 1;
		
		
		while(counter != element )
		{
			if(currNode == null)
				break;
			else {
				currNode = currNode.next;
				counter++;
				}
		}
		//print the digit in that node
//		System.out.println("queried: "+currNode.digit);
		return currNode.digit;
	}
	public static CircularNode queryNode(LinkedList list, int element)
	{
		CircularNode currNode = list.h;
		int counter = 1;
		
		while(counter != element )
		{
			if(currNode == null)
				break;
			else {
				currNode = currNode.next;
				counter++;
				}
		}
		//print the digit in that node
//		System.out.println("queried: "+currNode.digit);
		return currNode;
	}
	
	static CircularNode findDigit(LinkedList list, int digit)
	{
		CircularNode currNode = list.h;
		while(digit != currNode.digit)
		{
			currNode = currNode.next;
		}
		return currNode;
	}
	
	public  int length()
	{
		SinglyNode currNode = this.head;
	  int l = 0;
	  while(currNode != null)
	  {
		  currNode = currNode.next;
		  l++;
	  }
	  return l;
	}
	
	public int lengthOfCL()
	{
		CircularNode currNode = this.h;
		int i = 1;
		while(currNode != null)
		{
			if(currNode.next != this.h)
			{
				currNode = currNode.next;
				i++;
			}
			else {
				break;
			}			
		} return i;
	}
	
	
	
	
}

