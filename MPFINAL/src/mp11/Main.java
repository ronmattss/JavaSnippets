package mp11;
/*
 * Authors:
 * Rivera, Ron Matthew
 * Canja, Jason
 * Jacolbia, Patrick
 * BSCS 2-2
 * */
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		Anagram anag = new Anagram();
		Scanner input = new Scanner(System.in);

		try {
			System.out.print("Enter dictionary file name: ");
			anag.getHashMap(input.nextLine());
		} catch (FileNotFoundException e) {
			System.err.println("Dictionary not found!");
			System.exit(-1);
		} catch (IOException e) {
			System.err.println("Error reading!");
			System.exit(-1);
		}

		try {
			System.out.print("Enter input file name: ");
			anag.findAnagrams(input.nextLine());
		} catch (FileNotFoundException e) {
			System.err.println("File not found!");
			System.exit(-1);
		} catch (IOException e) {
			System.err.println("Error reading/writing file!");
			System.exit(-1);
		}

		input.close();
	}

}
