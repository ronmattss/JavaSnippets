/*Author: Rivera, Ron Matthew R.
 * 
 * 
 * */

package machineProblems;


import java.util.*;

public class NQueens {


public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter board size: ");
    NQueensSolver s = new NQueensSolver(sc.nextInt());
    s.printSolutions();
    sc.close();
	}

}

