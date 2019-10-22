package finalMp;
// Author: Rivera, Ron Matthew R. 
// BSCS 2-2
import java.util.*;

public class Graph {
	static class Node {
		char nodeName;
		List<Node> nodes = new ArrayList<Node>();

		Node() {
		}

	}

	/*
	 * Directive 0: Add a new disconnected node. Directive 1: Add a new node, and
	 * connect it to every existing node. Directive m > 1: Remove all nodes whose
	 * degree (number of neighbors) is divisible by m. Note that 0 is divisible by
	 * all m, so disconnected nodes are always removed.
	 */

	public static void main(String[] args) {
		List<Graph.Node> mainNodes = new ArrayList<Graph.Node>();
		Scanner sc = new Scanner(System.in);
		char n = 'A';
		int x = 0;
		int counter = 0;
		while (x != -1) {
			System.out.println("enter 0 for new disconnected node, 1 for new connected node, x > 1 to remove -1 to exit");
			x = sc.nextInt();
			System.out.println();
			
			// ADD NEW DISCONNECTED NODE NAME IT as n;
			if (x == 0) {

				mainNodes.add(new Graph.Node());
				mainNodes.get(mainNodes.size() - 1).nodeName = n;
				System.out.println(mainNodes.get(mainNodes.size() - 1).nodeName);
				n += 1;
				// ADD NEW CONNECTED (to prev. nodes) NODE NAME IT as n;
			} else if (x == 1) {
				mainNodes.add(new Graph.Node());
				int i = mainNodes.size();
				mainNodes.get(mainNodes.size() - 1).nodeName = n;
				n += 1;
				// traverse the previous nodes then add it the nodes
				for (int j = (i - 2); j >= 0; j--) {
					mainNodes.get(mainNodes.size() - 1).nodes.add(mainNodes.get(j));
				}
				for (int k = 0; k < mainNodes.get(mainNodes.size() - 1).nodes.size(); k++) {
					mainNodes.get(mainNodes.size() - 1).nodes.get(k).nodes.add(mainNodes.get(mainNodes.size() - 1));
				}

				System.out.println(mainNodes.get(mainNodes.size() - 1).nodeName);
				// Remove nodes where x is divisible by it's degree or if it's remainder is 0
			} 
			// weird part
			else if (x >1) {
				for (int l = 0; l<mainNodes.size(); l++) {
					try {
						if ( x == (mainNodes.get(l).nodes.size() ) ) {
						    System.out.println("removing: "+mainNodes.get(l).nodeName);
							mainNodes.remove(l);
					}
					} catch (ArithmeticException e) {
						System.out.println("dividing by zero is illegal");
						mainNodes.remove(l);
					}
					
				}

			}// ||  (x / (mainNodes.get(l).nodes.size()-1)) == 1 || (x % (mainNodes.get(l).nodes.size()-1)) == 0

		}
		for (int i = mainNodes.size() - 1; i >= 0; i--) {
			System.out.println();
			if (mainNodes.get(i).nodes != null)
				System.out.println("Main Node: " + mainNodes.get(i).nodeName);
				System.out.println("Sub Nodes: " + mainNodes.get(i).nodes.size());

		}
		// graph count
		for (int q = 0; q < mainNodes.size(); q++) {
			if (mainNodes.get(q).nodes.size() > 0) {
				counter++;
			}
		}
		System.out.println("Graph counter: " + counter);

	}
	/*

Test cases   
5 0	   
0 0 0 11  0	   
0 1 0 1 0 1 3 -> 4	   
0 0 0 1 1 1 -> 6	  
0 0 1 1 0 0 1 1 2 5 7 0 1 -> 6
0 0 1 1 1 1 5 1 4 3 1 0 0 0 1 2 -> 6     
0 0 1 1 0 0 1 1 5 2 3 0 0 1 1 0 0 1 1 3 4 0 0 1 1 2 1 1 -> 8      
0 0 1 1 0 0 1 1 2 5 7 0 1 1 1 1 1 0 1 1 1 1 1 1 1 1 8 -> 14
	 * 
	 * */

}
/*		for (int i = mainNodes.size() - 1; i >= 0; i--) {
			System.out.println();
			if (mainNodes.get(i).nodes != null)
				System.out.println("Main Node: " + mainNodes.get(i).nodeName);
			for (int j = 0; j < mainNodes.get(i).nodes.size(); j++) {
				System.out.print("Sub Nodes: " + mainNodes.get(i).nodes.get(j).nodeName);
			}
		}*/