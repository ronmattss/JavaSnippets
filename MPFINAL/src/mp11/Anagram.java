package mp11;
import java.io.*;
import java.util.*;


public class Anagram {

  private HashMap<String, String> dictionary = new HashMap<String, String>();

  public void getHashMap(String file) throws FileNotFoundException, IOException {
    long start = System.currentTimeMillis();
    FileReader src = new FileReader(file);
    BufferedReader reader = new BufferedReader(src);
    String line = "";

    while ((line = reader.readLine()) != null) {
      if (line.equals(""))
        continue;

      char[] arr = line.toLowerCase().toCharArray();
      Arrays.sort(arr);
      dictionary.add(new String(arr), line);
    }

    reader.close();

    System.out.println(
        "Dictionary parsed! (" + ((System.currentTimeMillis() - start) / 1000F) + " seconds)\n");
  }

  public void findAnagrams(String file) throws FileNotFoundException, IOException {
    long start = System.currentTimeMillis();
    BufferedReader reader = new BufferedReader(new FileReader(file));
    BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
    String word;

    while ((word = reader.readLine()) != null) {

      if (word.equals("")) {
        continue;
      }

      char[] arr = word.toLowerCase().toCharArray();
      Arrays.sort(arr);


      Node<String, String> match = dictionary.get(new String(arr));
      List<String> result = new List<>();

      
      if (match != null) {
        if (!match.value().equals(word))
          result.add(match.value());

        while (match.hasNext()) {
          match = match.next();


          if (match.key().equals(new String(arr)) && !match.value().equals(word))
            result.add(match.value());
        }


        writer.write(word + " " + result.size());


        for (String anagram : result)
          writer.write(" " + anagram);
      } else {

        writer.write(word + "0");
      }

      writer.newLine();
    }

    reader.close();
    writer.close();

    System.out.println(
        "Output file created! (" + ((System.currentTimeMillis() - start) / 1000F) + " seconds)");
  }

}
