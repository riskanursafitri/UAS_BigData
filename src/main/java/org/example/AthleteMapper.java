package org.example;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
public class AthleteMapper extends Mapper<Object , Text, Text , Text> {
    protected void map(Object key , Text value , Context context) throws IOException, InterruptedException {
        String txt = value.toString();
        String[] tokens = txt.split(",");

        if(tokens[0].compareTo("id") != 0){
            context.write(new Text(tokens[2].trim()) , new Text(tokens[8].trim()));
        }
    }
}
