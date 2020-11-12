package SWRPackage;


//Importing libraries 
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import org.apache.hadoop.io.LongWritable; 
import org.apache.hadoop.io.Text; 
import org.apache.hadoop.mapred.MapReduceBase; 
import org.apache.hadoop.mapred.Mapper; 
import org.apache.hadoop.mapred.OutputCollector; 
import org.apache.hadoop.mapred.Reporter; 


public class SWRMapper extends MapReduceBase implements Mapper<LongWritable, 
                                         Text, LongWritable, Text> {
	

	// Map function 
	public void map(LongWritable key, Text value, OutputCollector<LongWritable,  
			Text> output, Reporter rep) throws IOException 
	{ 
	   
		
	   String line = value.toString(); 
	
	   List<String> list = new ArrayList<String>();
	   
	   // Splitting the line on spaces 
	   for (String word : line.split(" "))  
	   { 
	       if (word.length() > 0) 
	       {
	    	   if (!SWRPackage.StopWord.isStopWord(word.toLowerCase())) {
					list.add(word);
				}
	       } 
	   }
	   output.collect(key, new Text(String.join(" ", list)));
	} 
} 
