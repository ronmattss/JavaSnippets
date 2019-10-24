package mp10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.Scanner;

public class MP10 {

	public static void main(String args[]) {
		writeRecord();

	}

	public static void writeRecord() {
		Scanner input = new Scanner(System.in);
		String partnum = "";
		String partdesc = "";
		String partprice = "";
		// put the data in the list so that it can be sorted
		List<String> finalOut = new ArrayList<String>();

		String answer = "y";
		boolean exists;
		String file = "MasterRecord.dat";
		File path = new File("MasterRecord.dat");

		path.setWritable(true);
		path.setReadable(true);

		try {

			FileReader rw = new FileReader(path);
			BufferedReader br = new BufferedReader(rw);
			String line;
			while ((line = br.readLine()) != null) {
				finalOut.add(line);
				System.out.println(finalOut.get(finalOut.size() - 1));
			}
			// write data
			while (answer.equals("y")) {
				StringJoiner sj = new StringJoiner(",");
				System.out.println("PartNum: ");
				partnum = input.next();
				input.nextLine();
				System.out.println("PartDesc: ");
				partdesc = input.nextLine();
				System.out.println("PartPrice");
				partprice = input.next();
				sj.add(partnum);
				sj.add(partdesc);
				sj.add(partprice);
				System.out.println(sj.toString());
				finalOut.add(sj.toString());

				System.out.println("Another? y/n");
				answer = input.next();
				System.out.println(answer);
			}
			Collections.sort(finalOut);
			FileWriter fw = new FileWriter(path);
			BufferedWriter bf = new BufferedWriter(fw);
			for (String string : finalOut) {
				bf.write(string);
				bf.newLine();
			}
			System.out.println("Transaction SSaving to Master Record List...");
			bf.close();

		} catch (

		IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		input.close();

	}
}
