package WDMPackage;


// Importing libraries 
import java.io.IOException; 
import java.util.Iterator; 
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text; 
import org.apache.hadoop.mapred.MapReduceBase; 
import org.apache.hadoop.mapred.OutputCollector; 
import org.apache.hadoop.mapred.Reducer; 
import org.apache.hadoop.mapred.Reporter;

import java.text.DateFormatSymbols;

public class WDMReducer extends MapReduceBase implements Reducer<Text, 
							IntWritable, Text, Text> { 
	
	//Reduce function 
	public void reduce(Text key, Iterator<IntWritable> value,  
	            OutputCollector<Text, Text> output,  
	                     Reporter rep) throws IOException 
	{ 
		String keyString = key.toString();
		int maxTemperature = Integer.MIN_VALUE;
		int minTemperature = Integer.MAX_VALUE;
		int count = 0;
		double average = 0.0;
		long sum = 0;
		
		while (value.hasNext()) {
			int temperature = value.next().get();
			maxTemperature = Math.max(maxTemperature, temperature);
			minTemperature = Math.min(minTemperature, temperature);
			sum += temperature;
			count += 1;
		}
		
		if (count != 0) {
			average = sum / count;
		}
		
		if (keyString.length() == 6) {
			int month = Integer.parseInt(keyString.substring(4, 6));
			String monthString = new DateFormatSymbols().getMonths()[month-1];
			String yearString = keyString.substring(0,4);
			
			output.collect(new Text(yearString + "-" + monthString + "_MIN:"), new Text(Double.toString(minTemperature / (double) 10)));
			output.collect(new Text(yearString + "-" + monthString + "_MAX:"), new Text(Double.toString(maxTemperature / (double) 10)));
			output.collect(new Text(yearString + "-" + monthString + "_AVG:"), new Text(Double.toString(average)));
			output.collect(new Text(""), new Text(""));
		}
		else {
			output.collect(new Text(key.toString() + "_MIN:"), new Text(Double.toString(minTemperature / (double) 10)));
			output.collect(new Text(key.toString() + "_MAX:"), new Text(Double.toString(maxTemperature / (double) 10)));
			output.collect(new Text(key.toString() + "_AVG:"), new Text(Double.toString(average)));
			output.collect(new Text(""), new Text(""));
		}
	} 
} 