package machineProblems;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BinaryTreeTraversals {

	public static void main(String[] args) {
		//test file input
		Tree t = new Tree();
		int counter = 0;
		//fucking regex
//		Pattern p = Pattern.compile("[a-zA-Z]");
//		Matcher m;
//		String name = "";
		String filename = "C:\\Users\\ronma\\Downloads\\mp7input02.txt";
		List<String> newString = new ArrayList<String>();
		try {
			List<String> lines = Files.readAllLines(Paths.get(filename));
			for(int i = 0; i <lines.size();i++)
			{
			  newString.add(lines.get(i).replaceAll("([)(,])",""));
			  newString.set(i, newString.get(i).replaceAll("(null)", "^"));
			}
	//		System.out.println(newString);
			// ask what is the root, then 

			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i = 0; i<newString.size(); i++)
		{
			for(int j = 0; j <newString.get(i).length(); j++)
			{	//System.out.print(Character.toString(newString.get(i).charAt(j)));	
				String x =Character.toString(newString.get(i).charAt(j));
				String root = Character.toString(newString.get(i).charAt(0)); // get root 
				System.out.println(x);
				t.insert(x,root,j,counter);
	
				counter++;				
			}
			
		}
		
	
		
		t.inorder();
		System.out.println();
		t.preOrder();
		System.out.println();
		t.postOrder();
		t.root = t.Search(t.root,"");
//		System.out.println("\nHELLO: "+ t.root.keyS);


	}

}
