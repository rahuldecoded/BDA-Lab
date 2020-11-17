package WDMPackage;


// Importing libraries 
import java.io.IOException;

import org.apache.hadoop.io.IntWritable; 
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text; 
import org.apache.hadoop.mapred.MapReduceBase; 
import org.apache.hadoop.mapred.Mapper; 
import org.apache.hadoop.mapred.OutputCollector; 
import org.apache.hadoop.mapred.Reporter; 


public class WDMMapper extends MapReduceBase implements Mapper<LongWritable, 
                                       Text, Text, IntWritable> {
	
	// Map function 
	public void map(LongWritable key, Text value, OutputCollector<Text, IntWritable> output, Reporter rep) throws IOException 
	{ 
	   String line = value.toString();
	   String year = line.substring(15, 19);
	   String month = line.substring(19, 21);
	   int temperature = Integer.parseInt(line.substring(87,92)) ;
	   output.collect(new Text(year), new IntWritable(temperature));
	   output.collect(new Text(year+month), new IntWritable(temperature));
	} 
} 