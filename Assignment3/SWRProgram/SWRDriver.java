package SWRPackage;

//Importing libraries 
import java.io.IOException; 
import org.apache.hadoop.conf.Configured; 
import org.apache.hadoop.fs.Path; 
import org.apache.hadoop.io.LongWritable; 
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.FileInputFormat; 
import org.apache.hadoop.mapred.FileOutputFormat; 
import org.apache.hadoop.mapred.JobClient; 
import org.apache.hadoop.mapred.JobConf; 
import org.apache.hadoop.util.Tool; 
import org.apache.hadoop.util.ToolRunner; 

public class SWRDriver extends Configured implements Tool { 

	public int run(String args[]) throws IOException 
	{ 
	   if (args.length < 2) 
	   { 
	       System.out.println("Please give valid inputs"); 
	       return -1; 
	   } 
	
	   JobConf conf = new JobConf(SWRDriver.class); 
	   FileInputFormat.setInputPaths(conf, new Path(args[0])); 
	   FileOutputFormat.setOutputPath(conf, new Path(args[1]));
	   conf.setMapperClass(SWRMapper.class); 
	   conf.setReducerClass(SWRReducer.class); 
	   conf.setMapOutputKeyClass(LongWritable.class); 
	   conf.setMapOutputValueClass(Text.class); 
	   conf.setOutputKeyClass(NullWritable.class); 
	   conf.setOutputValueClass(Text.class);
	   JobClient.runJob(conf); 
	   return 0; 
	} 
	
	// Main Method 
	public static void main(String args[]) throws Exception 
	{ 
	   int exitCode = ToolRunner.run(new SWRDriver(), args); 
	   System.out.println(exitCode); 
	} 
} 