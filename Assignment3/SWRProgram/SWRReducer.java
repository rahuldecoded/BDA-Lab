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
                             Text, NullWritable, Text> { 
	
	
	//Reduce function 
	public void reduce(LongWritable key, Iterator<Text> value,  
	            OutputCollector<NullWritable, Text> output,  
	                     Reporter rep) throws IOException 
	{ 
		output.collect(null, value.next());   
	} 
} 