package SDMPackage3;


//Importing libraries 
import java.io.IOException;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text; 
import org.apache.hadoop.mapred.MapReduceBase; 
import org.apache.hadoop.mapred.Mapper; 
import org.apache.hadoop.mapred.OutputCollector; 
import org.apache.hadoop.mapred.Reporter; 


public class SDMMapper extends MapReduceBase implements Mapper<LongWritable, 
                                 Text, Text, DoubleWritable> {
	
	// Map function 
	public void map(LongWritable key, Text value, OutputCollector<Text, DoubleWritable> output, Reporter rep) throws IOException 
	{ 
		String data[] = value.toString().split("\t");
		output.collect(new Text(data[2]), new DoubleWritable(Double.parseDouble(data[4])));
	} 
} 