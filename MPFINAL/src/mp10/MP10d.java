package mp10;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MP10d {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static void update() {
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
		} catch (Exception e) {

		}
	}

}
