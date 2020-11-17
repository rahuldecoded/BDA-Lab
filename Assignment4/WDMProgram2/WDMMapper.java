package WDMPackage2;

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
                                     Text, IntWritable, Text> {
	

	// Map function 
	public void map(LongWritable key, Text value, OutputCollector<IntWritable, Text> output, Reporter rep) throws IOException 
	{ 
	   String line = value.toString();
	   double temperature = Integer.parseInt(line.substring(87,92)) / (double) 10;
	   if (temperature > 30.0) {
		   output.collect(new IntWritable(1), value);
	   }
	   
	} 
} 