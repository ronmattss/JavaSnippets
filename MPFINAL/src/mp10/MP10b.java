package mp10;
import java.util.Scanner;
import java.io.*;

public class MP10b {

	public static void main(String args[]) {
		
		Scanner keyboard = new Scanner(System.in);
		String text;
		System.out.println("Enter Source: ");
		text = keyboard.next();
		  
		
		char ans='y';
		 while(ans=='y') {
		System.out.println("1 - Screen");
		System.out.println("2 - Printer");
		System.out.println("3 - File");
		
		int menu = keyboard.nextInt();
		switch(menu) {
			case 1:
				try {
				File input = new File(text);
				BufferedReader br = new BufferedReader(new FileReader(input));				
				String tmp;
				try {
					while((tmp = br.readLine()) != null) {
						System.out.print(tmp);
						System.out.print(System.lineSeparator());
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				break;
		case 2: System.out.println("File Printed!");
				break;
		case 3: System.out.println(text);
				break;
		} 
		System.out.println("Another? Y/N");
		 ans = keyboard.next().charAt(0);
			 
		 }//while
		
	}
	
}
