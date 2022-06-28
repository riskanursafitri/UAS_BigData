package org.example;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapreduce.Reducer;
import java.io.IOException;
public class AthleteReducer  extends Reducer<Text , Text , Text , Text>{
    public void reduce(Text key , Iterable<Text> values , Context context) throws IOException , InterruptedException {
        System.out.println("--------------");
        System.out.println(key.toString());
        System.out.println("--------------");

        int count = 0;
        for (Text val : values){
            count++;
        }
        context.write(key , new Text(String.valueOf(count)));
    }
}