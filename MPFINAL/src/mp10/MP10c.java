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
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MP10c {
	public static File input;
	public static File transaction;
	public static File isTransacExist;
	public static BufferedReader br;
	public static BufferedWriter bf;
	public static BufferedWriter transacWrite;
	public static void main(String args[]) throws IOException {
		
	
		
	Scanner keyboard = new Scanner(System.in);
	String verify;
	System.out.println("A - Addition");
	System.out.println("C - Change");
	System.out.println("D - Deletion");
		
System.out.print("Update code: ");	
String menu = keyboard.next();


input = new File("Master.txt");
transaction = new File("transac.txt");
isTransacExist = new File("Error.txt");
br = new BufferedReader(new FileReader(input));

if(!isTransacExist.exists()) {
	transacWrite = new BufferedWriter(new FileWriter("Error.txt",true));
	transacWrite.write("UpdateCode" + "\t" + "PartNumber" + "\t" + "ErrorMessage" + "\t" + "Remarks");
	transacWrite.close();
}

switch(menu) {
case "A" :
		
		String tmp= " ";
		String partnum=" ";
		String partdesc=" ";
		String partprice=" ";
		
		if(!transaction.exists()) {
			bf = new BufferedWriter(new FileWriter("transac.txt",true));
			while((tmp = br.readLine()) != null) {
					bf.write(tmp);
					bf.write(System.lineSeparator());	
			}
			bf.close();
		}
		
			bf = new BufferedWriter(new FileWriter("transac.txt",true));
			
		 char answer = 'y';
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
			 
			 bf.write(partnum + "\t" + partdesc + "\t" + partprice); 
			 bf.write(System.lineSeparator());
		
	 	System.out.println("Update Code: a");
	 	System.out.println("Part Number: "+ partnum);
	 	System.out.println("Part Description: "+ partdesc);
	 	System.out.println("Part Price: "+ partprice);
		System.out.println("Another? Y/N");
		answer = keyboard.next().charAt(0);
		 }

		 bf.close();	
	 	
		 break;
case "C":
		System.out.print("Enter part number you want to change:");
		verify = keyboard.next();
		verify += keyboard.nextLine();
	try {
		BufferedReader br = new BufferedReader(new FileReader("transac.txt"));
		bf = new BufferedWriter(new FileWriter("transac2.txt",true));
		String tmpText;
		String putData;
		try {
			while((tmpText = br.readLine()) != null) {
				if(!tmpText.contains(verify)) {
					bf.write(tmpText);		
					bf.write(System.lineSeparator());
				}else{
					String[] store = tmpText.split("\t");
					char changeID;
					System.out.print("Chande ID: ");
					changeID = keyboard.next().charAt(0);
					
					 if(changeID == 'D') {
						 System.out.println("new PartDesc: ");
						 partdesc = keyboard.next();
						 
						 bf.write(store[0] + "\t" + partdesc + "\t" + store[2]);
						 bf.write(System.lineSeparator());
					 }else if(changeID == 'P') {
						 
						 System.out.println("new Price: ");
						 partprice = keyboard.next();
			
						 bf.write(store[0] + "\t" + store[1] + "\t" + partprice);
						 bf.write(System.lineSeparator());
					 }
				}
					
			}
			br.close();
			bf.close();
			
			input = new File("transac.txt");
			input.delete();
			transaction = new File("transac2.txt");
			transaction.renameTo(new File("transac.txt"));
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	
		 break;
case "D":
	
	System.out.print("Enter partnum you want to delete: ");
	verify = keyboard.next();
	verify += keyboard.nextLine();
	
	BufferedReader br = new BufferedReader(new FileReader("transac.txt"));
	bf = new BufferedWriter(new FileWriter("transac2.txt",true));
	String tmpText;
	String putData;
	
		while((tmpText = br.readLine()) != null) {
			if(!tmpText.contains(verify)) {
				bf.write(tmpText);		
				bf.write(System.lineSeparator());	
			}
		}
			

		br.close();
		bf.close();
		
		input = new File("transac.dat");
		input.delete();
		transaction = new File("transac2.dat");
		transaction.renameTo(new File("transac.dat"));

	
	
	
		break;
		}//switch
	
	}//main

}//class
