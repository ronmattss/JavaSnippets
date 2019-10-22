package machineProblems;

import java.util.*;
import java.util.Scanner;

public class GraphProblem {
	static class Node {
		String nodeName;
		List<Node> nodes = new ArrayList<Node>();

		Node() {
		}

	}

	// generate a function to create a node without nodes: 0
	// generate a function to create a node then connect to prev. Nodes: 1
	// generate a function to delete nodes with degrees m >1: m>1

	public static void main(String[] args) {
		List<GraphProblem.Node> mainNodes = new ArrayList<GraphProblem.Node>();
		Scanner sc = new Scanner(System.in);
		int x = 0;

		while (x != -1) {
			x = sc.nextInt();
			System.out.println();

			if (x == 0) {

				mainNodes.add(new GraphProblem.Node());
				System.out.println("Enter Node Name:");
				String n = sc.next();
				mainNodes.get(mainNodes.size() - 1).nodeName = n;
				System.out.println(mainNodes.get(mainNodes.size() - 1).nodeName);
			} else if (x == 1) {
				mainNodes.add(new GraphProblem.Node());
				int i = mainNodes.size();
				System.out.println("Enter Node Name:");
				String n = sc.next();
				mainNodes.get(mainNodes.size() - 1).nodeName = n;
				// traverse the previous nodes then add it the nodes
				for (int j = (i - 2); j >= 0; j--) {
					mainNodes.get(mainNodes.size() - 1).nodes.add(mainNodes.get(j));
					for (int k = 0; k < mainNodes.get(mainNodes.size() - 1).nodes.size(); k++) {
						mainNodes.get(mainNodes.size() - 1).nodes.get(k).nodes.add(mainNodes.get(mainNodes.size() - 1));
					}

				}

				System.out.println(mainNodes.get(mainNodes.size() - 1).nodeName);
			} else if (x > 1) {

			}

		}
		for (int i = mainNodes.size() - 1; i >= 0; i--) {
			System.out.println();
			if (mainNodes.get(i).nodes != null)
				System.out.println(mainNodes.get(i).nodeName);
			for (int j = 0; j < mainNodes.get(i).nodes.size(); j++) {
				System.out.print(mainNodes.get(i).nodes.get(j).nodeName);
			}
		}

	}

	
	

}
