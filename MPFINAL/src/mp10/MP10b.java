package mp10;


/*
 * Authors:
 * Rivera, Ron Matthew
 * Canja, Jason
 * Jacolbia, Patrick
 * BSCS 2-2
 * */
import java.util.Scanner;
import java.io.*;

public class MP10b {
	public static BufferedWriter bw;
	public static BufferedReader br;
	public static File input;
	
	public static void main(String args[]) throws IOException {
		
		Scanner keyboard = new Scanner(System.in);
		String text;
		System.out.println("Enter Source File: ");
		text = keyboard.next();
		  
		
		char ans='y';
		 while(ans=='y') {
		System.out.println("1 - Screen");
		System.out.println("2 - Printer");
		System.out.println("3 - File");
	
		
		int menu = keyboard.nextInt();
		
		input = new File(text);
		br = new BufferedReader(new FileReader(input));				
		String tmp;
		
		switch(menu) {
			case 1:
			
		           while((tmp = br.readLine()) != null) {
						System.out.print(tmp);
						System.out.print(System.lineSeparator());
					}
			
		
				break;
		case 2:
				System.out.println("File Printed!");
				break;
		case 3:
				System.out.println("Enter target file");
				text = keyboard.next();
				bw = new BufferedWriter(new FileWriter(text,true));
				String tmpText;
				while((tmpText = br.readLine()) != null) {
					bw.write(tmpText);
					bw.write(System.lineSeparator());
				}
				bw.close();
				System.out.println("File saved in " + text);
				break;
		} 
		
		br.close();
		System.out.println("Another? Y/N");
		 ans = keyboard.next().charAt(0);
			 
		 }//while
		
	}
	
}
