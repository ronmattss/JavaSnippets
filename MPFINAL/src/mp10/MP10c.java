package mp10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class MP10c {

	public static void main(String args[]) {
		char upCode, chngID, ans = ' ';
		String prtNum, prtDes;
		float prtpri;
	      Format f = new SimpleDateFormat("MM/dd/yy");
	      String strDate = f.format(new Date());
		Scanner input = new Scanner(System.in);

		try {
			FileWriter fw = new FileWriter("TRANSAC.txt", true);
			BufferedWriter bf = new BufferedWriter(fw);
			// String header1 = "Update Code " + " PartNumber ";

			do {
				System.out.println("UPDATE CODE: A - ADD, C - CHANGE, D - DELETE");
				System.out.println(" ");
				System.out.print("Update Code: ");
				upCode = input.next().toUpperCase().charAt(0);
				input.nextLine();
				System.out.print("Part Number: ");
				prtNum = input.nextLine();

				if (upCode == 'A') {
					// bf.append(header1 + " Part Description " + " Part Price " + " Entry Date");
					System.out.print("Part Desc: ");
					prtDes = input.nextLine();
					System.out.print("Part Price: ");
					prtpri = input.nextFloat();
					//bf.newLine();
					bf.append(upCode + "," + prtNum + "," + prtDes + "," + prtpri + "," +strDate );
					bf.newLine();

				} // UPDATE CODE - A - ADDING NEW RECORD

				if (upCode == 'C') {
					System.out.println(" ");
					System.out.println("CHANGE ID: D - DESCRIPTION, P - PRICE");
					System.out.println(" ");
					System.out.print("Change ID: ");
					chngID = input.next().toUpperCase().charAt(0);
					input.nextLine();

					if (chngID == 'D') {
						System.out.print("New Desc: ");
						prtDes = input.nextLine();

						// bf.append(header1 + " Change ID " + " New Description " + " Entry Date");
						//bf.newLine();
						bf.append(upCode + "," + prtNum + "," + chngID + "," + prtDes + "," + strDate);
					}

					else if (chngID == 'P') {
						System.out.print("New Price: ");
						prtpri = input.nextFloat();

						// bf.append(header1 + " Change ID " + " New Price " + " Entry Date");
					//	bf.newLine();
						bf.append(upCode + "," + prtNum + "," + chngID + "," + prtpri + "," + strDate);
						bf.newLine();

					}

					else {
						System.out.println("Error!!! Invalid ID Code");
					}

				} // UPDATE CODE - C - CHANGE RECORD

				if (upCode == 'D') {
					bf.newLine();
					// bf.append(header1 + " Entry Date");
				//	bf.newLine();
					bf.append(upCode + "," + prtNum + "," + strDate);
					bf.newLine();

				} // UPDATE CODE - D - DELETE RECORD

				System.out.println(" ");
				System.out.print("Again y/n : ");
				ans = input.next().toUpperCase().charAt(0);
				input.nextLine();
				System.out.println(" ");

			} while (ans == 'Y');

			bf.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		input.close();

	}// class
}
