package WSPackage;


//Importing libraries 
import java.io.IOException; 
import org.apache.hadoop.conf.Configured; 
import org.apache.hadoop.fs.Path; 
import org.apache.hadoop.io.IntWritable; 
import org.apache.hadoop.io.Text; 
import org.apache.hadoop.mapred.FileInputFormat; 
import org.apache.hadoop.mapred.FileOutputFormat; 
import org.apache.hadoop.mapred.JobClient; 
import org.apache.hadoop.mapred.JobConf; 
import org.apache.hadoop.util.Tool; 
import org.apache.hadoop.util.ToolRunner; 

public class WSDriver extends Configured implements Tool { 

	public int run(String args[]) throws IOException 
	{ 
	   if (args.length < 3) 
	   { 
	       System.out.println("Please give valid inputs"); 
	       return -1; 
	   } 
	
	   JobConf conf = new JobConf(WSDriver.class); 
	   FileInputFormat.setInputPaths(conf, new Path(args[0])); 
	   FileOutputFormat.setOutputPath(conf, new Path(args[1]));
	   conf.set("wordToSearch", args[2]);
	   conf.setMapperClass(WSMapper.class); 
	   conf.setReducerClass(WSReducer.class); 
	   conf.setMapOutputKeyClass(Text.class); 
	   conf.setMapOutputValueClass(IntWritable.class); 
	   conf.setOutputKeyClass(Text.class); 
	   conf.setOutputValueClass(IntWritable.class); 
	   JobClient.runJob(conf); 
	   return 0; 
	} 
	
	// Main Method 
	public static void main(String args[]) throws Exception 
	{ 
	   int exitCode = ToolRunner.run(new WSDriver(), args); 
	   System.out.println(exitCode); 
	} 
} 
