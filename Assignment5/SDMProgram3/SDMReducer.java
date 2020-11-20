package SDMPackage3;


//Importing libraries
import java.io.IOException;
import java.util.Iterator;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text; 
import org.apache.hadoop.mapred.MapReduceBase; 
import org.apache.hadoop.mapred.OutputCollector; 
import org.apache.hadoop.mapred.Reducer; 
import org.apache.hadoop.mapred.Reporter;


public class SDMReducer extends MapReduceBase implements Reducer<Text, 
							DoubleWritable, NullWritable, NullWritable> { 

	
	//Reduce function 
	public void reduce(Text key, Iterator<DoubleWritable> value,  
	            OutputCollector<NullWritable, NullWritable> output,  
	                     Reporter rep) throws IOException 
	{ 
		
		double max = Integer.MIN_VALUE;
		while(value.hasNext()) {
			max = Math.max(max, value.next().get());
		}
		SDMPackage3.WriteOutput.insertToFile(key + ":\t" + max);
		output.collect(null, null);
	} 
} 