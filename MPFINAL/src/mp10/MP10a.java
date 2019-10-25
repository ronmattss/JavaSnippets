package mp10;

/*
 * Authors:
 * Rivera, Ron Matthew
 * Canja, Jason
 * Jacolbia, Patrick
 * BSCS 2-2
 * */
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class MP10a {

	public static void main(String args[]) {
		 
		Scanner keyboard = new Scanner(System.in);
		String partnum= " ";
		String partdesc=" ";
		String partprice=" ";
		char answer = 'y';
	
		
		try {
			 
			 BufferedWriter bf = new BufferedWriter(new FileWriter("Master.txt",true));
			 
			 while(answer == 'y') { 
				 System.out.println("PartNum: ");
				 partnum = keyboard.next();
				 partnum += keyboard.nextLine();
				 System.out.println("PartDesc: ");
				 partdesc = keyboard.next();
				 partdesc += keyboard.nextLine();
				 System.out.println("PartPrice");
				 partprice = keyboard.next(); 
				 partprice += keyboard.nextLine();
			 
		 bf.append(partnum + "\t" + partdesc + "\t" + partprice);
		 bf.write(System.lineSeparator());
		 
		
		
		System.out.println("Another? y/n");
		 answer = keyboard.next().charAt(0);
			 }
			 
			 bf.close();
		
		 }
		 catch(IOException e) {
			 e.printStackTrace();
		 }
			
		
		
	}
	
}
