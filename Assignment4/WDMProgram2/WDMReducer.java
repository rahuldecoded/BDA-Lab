package WDMPackage2;


// Importing libraries
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator; 
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text; 
import org.apache.hadoop.mapred.MapReduceBase; 
import org.apache.hadoop.mapred.OutputCollector; 
import org.apache.hadoop.mapred.Reducer; 
import org.apache.hadoop.mapred.Reporter;


public class WDMReducer extends MapReduceBase implements Reducer<IntWritable, 
							Text, NullWritable, NullWritable> { 
	
	static String outputFile = "C:\\hadoop\\lab_data\\WDM-Data\\output.txt";
	
	// Function To Insert a clean line in a File
	// Clean Line: Line without stop words
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
	


	
	//Reduce function 
	public void reduce(IntWritable key, Iterator<Text> value,  
	            OutputCollector<NullWritable, NullWritable> output,  
	                     Reporter rep) throws IOException 
	{ 
		while(value.hasNext()) {
			insertToFile(value.next().toString());
		}
		output.collect(null, null);
	} 
} 