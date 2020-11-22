package WSPackage;


//Importing libraries 
import java.io.IOException; 
import org.apache.hadoop.io.IntWritable; 
import org.apache.hadoop.io.LongWritable; 
import org.apache.hadoop.io.Text; 
import org.apache.hadoop.mapred.JobConf; 
import org.apache.hadoop.mapred.MapReduceBase; 
import org.apache.hadoop.mapred.Mapper; 
import org.apache.hadoop.mapred.OutputCollector; 
import org.apache.hadoop.mapred.Reporter; 


public class WSMapper extends MapReduceBase implements Mapper<LongWritable, 
                                           Text, Text, IntWritable> {
  
  String wordToSearch;
  public void configure(JobConf conf) {
    wordToSearch = conf.get("wordToSearch");
     }

  // Map function 
  public void map(LongWritable key, Text value, OutputCollector<Text,  
              IntWritable> output, Reporter rep) throws IOException 
  { 
     
    
     String line = value.toString(); 
  
     // Splitting the line on spaces 
     for (String word : line.split(" "))  
     { 
         if (word.length() > 0) 
         {
           if (word.compareTo(wordToSearch) == 0) {
             output.collect(new Text(word), new IntWritable(1));
           }
           
         } 
     } 
  } 
} 
