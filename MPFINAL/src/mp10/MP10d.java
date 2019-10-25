package mp10;

/*
 * Authors:
 * Rivera, Ron Matthew
 * Canja, Jason
 * Jacolbia, Patrick
 * BSCS 2-2
 * */


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MP10d {
	private static char ch;
	private static Scanner sc;
	private static File file;
	private static BufferedWriter br;
	
	public static void main(String[] args) throws Exception{
		
		do{
			sc = new Scanner(System.in);
			System.out.print("Choose: ");
			ch = sc.nextLine().charAt(0);
			
			switch(ch) {
				case 'A':
					file = new File("Master.dat");
					if(!file.exists()) {
						br = new BufferedWriter(new FileWriter("Master.txt"));
						br.write("PartNumber	" + " Part Description	" + " Part Price");
						br.write(System.lineSeparator());
						br.close();
					}
					MP10a.main(null);
					break;
				case 'B':
					MP10b.main(null);
					break;
				case 'C':
					MP10c.main(null);
					break;
				case 'D':
					break;
			}
		}while(ch != 'N');
		
	}

}
