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
			System.out
					.println("enter 0 for new disconnected node, 1 for new connected node, x > 1 to remove -1 to exit");
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
				// traverse to the subnodes of the latest node and add the latest mainNode
				for (int k = 0; k < mainNodes.get(mainNodes.size() - 1).nodes.size(); k++) {
					mainNodes.get(mainNodes.size() - 1).nodes.get(k).nodes.add(mainNodes.get(mainNodes.size() - 1));

				}

				System.out.println(mainNodes.get(mainNodes.size() - 1).nodeName);
				// Remove nodes where x is divisible by it's degree or if it's remainder is 0
			}
			// weird part
			else if (x > 1) {
				int counterx = 0;
				while(counterx < mainNodes.size())
				{		// delete nodes
					if ((mainNodes.get(counterx).nodes.size()) == x/* ||(mainNodes.get(counterx).nodes.size()) == 0 */ ) {
						System.out.println("removing: " + mainNodes.get(counterx).nodeName);
						
						// remove subnodes that contain the mainNode to be removed
						// case if neighboring nodes is considered 
						/*
						 * for(int w = 0; w<mainNodes.size();w++) { for(int y = 0;
						 * y<mainNodes.get(w).nodes.size();y++) {
						 * if(mainNodes.get(w).nodes.get(y).nodeName ==
						 * mainNodes.get(counterx).nodeName) { mainNodes.get(w).nodes.remove(y); } } }
						 */
						mainNodes.remove(counterx);
					//	counterx = 0;
					}
					else
					{
						counterx++;
					}
					
				}


			} // || (x / (mainNodes.get(l).nodes.size()-1)) == 1 || (x %
				// (mainNodes.get(l).nodes.size()-1)) == 0

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

}
