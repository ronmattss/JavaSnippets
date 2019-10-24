package mp10;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MP10c {
	
	public static void main(String args[]) {
	Scanner keyboard = new Scanner(System.in);

	System.out.println("a - Addition");
	System.out.println("b - Changes Description");
	System.out.println("c - Changes Price");
	System.out.println("d - Deletion");
		
String menu = keyboard.next();

switch(menu) {
case "a" :
	try {	
		File input = new File("C:\\Users\\HP\\Desktop\\JAVA WORKSPACE\\MP10\\file.txt");
		BufferedReader br = new BufferedReader(new FileReader(input));
		FileWriter fw = new FileWriter("transac.txt");
		BufferedWriter bf = new BufferedWriter(fw);
		
		String tmp= " ";
		String partnum=" ";
		String partdesc=" ";
		String partprice=" ";
		while((tmp = br.readLine()) != null) {
			bf.write(tmp);
			bf.write(System.lineSeparator());
			
		}
			
		 char answer = 'y';
		while(answer == 'y') { 
			System.out.println("PartNum: ");
			 partnum = keyboard.next();
			 System.out.println("PartDesc: ");
			 partdesc = keyboard.next();
			 System.out.println("PartPrice");
			 partprice = keyboard.next(); 
			 
			 bf.newLine();
			 bf.write(partnum + "	" + partdesc + "	" + partprice); 
			bf.newLine();
		
	 	System.out.println("Update Code: a");
	 	System.out.println("Part Number: "+ partnum);
	 	System.out.println("Part Description: "+ partdesc);
	 	System.out.println("Part Price: "+ partprice);
	System.out.println("Another? Y/N");
	 answer = keyboard.next().charAt(0);
		 }

		 bf.close();	
	 }
	 catch(IOException e) {
		 e.printStackTrace();
	 }
		
		 break;
case "b":
		System.out.print("Enter change: ");
		String change = keyboard.next();
		File changeData = new File("transac.txt");
		
	try {
		BufferedReader br = new BufferedReader(new FileReader(changeData));
		try {
			while(br.readLine() != null) {
				try {
					if(change.contains(br.readLine())) {
						System.out.print("It contains!");
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
case "c":
		 break;
case "d":
		break;
		}//switch
	
	}//main

}//class
