package school;


import java.io.*;
import java.util.*;


public class Search {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean choice = true;
		while(choice)
		{
			System.out.print("Enter full filename: ");
			
			String path = sc.next();
			String fullText = getFileText(path);
			
			System.out.println("TEXT\n"+fullText); 
			
			System.out.print("Enter PATTERN: ");			
			String enterPattern = sc.next();			
			KMPSearch(enterPattern, fullText);
			
			
			// Ask the user if they want to search again
			System.out.println("Again (y/n): ");
			
			String a = sc.next();
			
			if(a.equalsIgnoreCase("y"))
				choice = true;
			else
				choice = false;
			
		}
		sc.close();

		
		

	}
	
	// Function to get a file containing a randomly generated text pattern
	static String getFileText(String pathName) {
		List<String> stringList = new ArrayList<>(); //using a List to store each line of string
		
		try {
			String a = null;
			  FileReader fileReader = new FileReader(pathName);
			  BufferedReader br = new BufferedReader(fileReader);
			  
			  while((a = br.readLine())!= null)
			  {
				  stringList.add(a);   // add string to the list
			  }
			  br.close();
			  
		} 
		// catchers for errors
		// catch File Not Found
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		catch(IOException e){
			e.printStackTrace();
		}
		
		StringBuilder stringBuilder = new StringBuilder();       //builds a new string from the list of string
		for (String string : stringList) {
			stringBuilder.append(string);
		}
		
		// Return the string from the file
		return stringBuilder.toString();
	}
	
	// parameters for this function is the pattern itself and 
	static void preProcessPattern (String pattern, int k, int subPattern[])
	{
		// k is the pattern length
		// length of the previous LPS (Longest Prefix suffix)
		int len = 0;
		int i = 1;  // calculates lps[i], for i=1 to  k-1

		subPattern[0] = 0; // will always be zero since first char doesn't have any previous chars
		
		while(i< k)
		{
			if(pattern.charAt(i) == pattern.charAt(len))
			{
				len++;
				subPattern[i] = len;
				i++;
			}
			else //pat[i] != pat[len]
			{ 
				if(len != 0)
				{
					len = subPattern[len - 1];
				}
				else { // if len == 0
					subPattern[i] = len;
					i++;
				}
			}
		}
	}
	
	static void KMPSearch(String pattern, String text)
	{
		int patternLength = pattern.length();
		int textLength = text.length();

		int subPatLen[] = new int[patternLength]; // will hold the subpatterns or LPS

		
		int foundPatterns = 0; // increment when a pattern is found
		preProcessPattern(pattern, patternLength, subPatLen);
		
		int j = 0; //index for pattern[]
		int i = 0; //index for text[]
		
		while(i< textLength)
		{
			if(pattern.charAt(j) == text.charAt(i)) //if pattern[j] matches text[i]
			{
				j++;
				i++;
			}
			// pattern ended with a match
			if(j == patternLength)
			{
				 //System.out.println("Found pattern " + "at index: " + (i - j)); 
				 foundPatterns++;
				 j = subPatLen[j-1];
			}
			
			//mismatch after a match
			else if(i < textLength && pattern.charAt(j)!= text.charAt(i))
			{
				if(j !=0)
				{
					j = subPatLen[j-1];
				}
				else
					i= i+1;
			}
		}
		
		if(foundPatterns > 0)
			System.out.println("Total number of matches: " + foundPatterns);
		else
			System.out.println("No matches found!");
	}
}
