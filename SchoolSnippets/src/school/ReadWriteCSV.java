package school;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

public class ReadWriteCSV {

	public static void main(String[] args) {

		readDataLineByLine("C:\\Users\\ronma\\Documents\\Programming Stuff\\Java\\Java\\SchoolSnippets\\src\\TestFiles\\CSVREAD.txt");
		writeDataLineByLine("C:\\Users\\ronma\\Documents\\Programming Stuff\\Java\\Java\\SchoolSnippets\\src\\TestFiles\\CSVWRITE.txt");
	}
	
	public static void readDataLineByLine(String file) 
	{ 
	  
	    try { 
	  
	        // Create an object of filereader 
	        // class with CSV file as a parameter. 
	        FileReader filereader = new FileReader(file); 
	  
	        // create csvReader object passing 
	        // file reader as a parameter 
	        CSVReader csvReader = new CSVReader(filereader); 
	        String[] nextRecord; 
	  
	        // we are going to read data line by line 
	        while ((nextRecord = csvReader.readNext()) != null) { 
	            for (String cell : nextRecord) { 
	                System.out.print(cell + "\t"); 
	            } 
	            System.out.println(); 
	        } 
	    } 
	    catch (Exception e) { 
	        e.printStackTrace(); 
	    } 
	} 
	

public static void writeDataLineByLine(String filePath) 
{ 
    // first create file object for file placed at location 
    // specified by filepath 
    File file = new File(filePath); 
    try { 
        // create FileWriter object with file as parameter 
        FileWriter outputfile = new FileWriter(file); 
  
        // create CSVWriter object filewriter object as parameter 
        CSVWriter writer = new CSVWriter(outputfile); 
  
        // adding header to csv 
        String[] header = { "Name", "Class", "Marks" }; 
        writer.writeNext(header); 
  
        // add data to csv 
        String[] data1 = { "Aman", "10", "620" }; 
        writer.writeNext(data1); 
        String[] data2 = { "Suraj", "10", "630" }; 
        String[] data3 = { "Rivera", "20", "700" }; 
        writer.writeNext(data2); 
        writer.writeNext(data3); 
  
        // closing writer connection 
        writer.close(); 
    } 
    catch (IOException e) { 
        // TODO Auto-generated catch block 
        e.printStackTrace(); 
    } 
} 

	
	

}
