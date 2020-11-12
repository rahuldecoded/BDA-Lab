package SWRPackage;


import java.io.BufferedWriter;
//Importing libraries 
import java.io.File;
import java.io.FileWriter;
import java.io.IOException; 
import java.util.Iterator; 
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text; 
import org.apache.hadoop.mapred.MapReduceBase; 
import org.apache.hadoop.mapred.OutputCollector; 
import org.apache.hadoop.mapred.Reducer; 
import org.apache.hadoop.mapred.Reporter;
import org.apache.hadoop.mapred.JobConf; 

public class SWRReducer extends MapReduceBase implements Reducer<LongWritable, 
                             Text, Text, NullWritable> { 
	
	static String outputFile;
	public void configure(JobConf job) {
		outputFile = job.get("outputFile");
//		outputFile = "hdfs://localhost:9000" + outputFile;
//		System.out.println(outputFile);
	}
	
	
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
	public void reduce(LongWritable key, Iterator<Text> value,  
	            OutputCollector<Text, NullWritable> output,  
	                     Reporter rep) throws IOException 
	{ 
		
		while (value.hasNext()) {
			insertToFile(value.next().toString());
		}
		
		output.collect(new Text("Output File Created"), null);  
	} 
} 