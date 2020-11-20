package SDMPackage3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteOutput {
	// Function To Insert a clean line in a File
	// Clean Line: Line without stop words
	static String outputFile = "C:\\hadoop\\lab_data\\SDM-Data\\output3.txt";
	
	public static void insertToFile(String args) {
		File fileObj = null;
		try {
			fileObj = new File(outputFile);
			if (fileObj.createNewFile()) {
				System.out.println("File created");
		    }
		}
		catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
			
		BufferedWriter bw = null;
		try {

			bw = new BufferedWriter(new FileWriter(fileObj, true));
			bw.write(args + "\n");
				
				
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		} finally {
			try {
				if (bw != null) {
					bw.close();
				}
			} 
			catch (IOException e) {
				System.out.println("An error occurred.");
				e.printStackTrace();
			};
		}
	}	
}
