package SWRPackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;



public class StopWord {
	public static boolean isStopWord(String word) {
		Set<String> stopWords = new HashSet<String>();
		Scanner sc = null;
		try {
			// pass the path to the file as a parameter 
		    sc = new Scanner(new File("C:\\hadoop\\lab_data\\StopWords.txt")); 
		  
		    while (sc.hasNextLine()) 
		    	stopWords.add(sc.nextLine());
		}
		catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
		    e.printStackTrace();
		}
		finally {
			if (sc != null)
				sc.close();
		}
		return stopWords.contains(word);
	}
}
