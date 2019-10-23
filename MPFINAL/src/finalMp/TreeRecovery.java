package finalMp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class TreeRecovery {

	static char preOrd[];
	static char inOrd[];
	static int j;

	static void postOrder(int FChar, int LChar) {
		int i;

		if (FChar > LChar)
			return;

		for (i = 0; i < LChar; i++) {

			if (preOrd[j] == inOrd[i])

				break;

		}

		j++;

		postOrder(FChar, i - 1);

		postOrder(i + 1, LChar);

		System.out.print(inOrd[i]);

	}

	public static void main(String[] args) {
		int length;
//	System.out.println("enter path: ");
		// Scanner sc = new Scanner(System.in);
		// String path2 = sc.next();
		String path = "C:\\Users\\ronma\\Documents\\Programming_Stuff\\JavaSnippets\\MPFINAL\\src\\finalMp\\mp8input01.txt";
		String line;
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(path));
			while ((line = reader.readLine()) !=null) {
				String[] t = line.split(" ");
				preOrd = t[0].toCharArray();
				inOrd = t[1].toCharArray();
				j = 0;
				System.out.println(line);
				length = inOrd.length;
				postOrder(0, length - 1);
				System.out.println();
				line = reader.readLine();

			}
		} catch (Exception e) {

		}

	}

}
