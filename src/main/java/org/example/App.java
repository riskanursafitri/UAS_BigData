package org.example;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.MultipleInputs;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args ) throws IOException, InterruptedException, ClassNotFoundException
    {
        Configuration conf = new Configuration();
        Job job = new Job(conf , "UAS Job");
        job.setMapperClass(AthleteMapper.class);


        MultipleInputs.addInputPath(job , new Path(args[0]) , TextInputFormat.class , AthleteMapper.class);
        //MultipleInputs.addInputPath(job , new Path(args[1]) , TextInputFormat.class , Glossary.class);
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(Text.class);
        job.setReducerClass(AthleteReducer.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);
        FileOutputFormat.setOutputPath(job , new Path(args[1]));
        System.out.println("Test2");

        System.exit(job.waitForCompletion(true)? 0 : 1);
    }
}