package com.jike.telecom;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class Driver {
	public static void main(String[] args) throws Exception {
		Configuration conf=new Configuration();
		
		
		Job job=Job.getInstance(conf);
		job.setJarByClass(Driver.class);
		job.setMapperClass(TelecomMapper.class);
		job.setReducerClass(TelecomReducer.class);
		
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(Bean.class);
		
		job.setOutputKeyClass(Bean.class);
		job.setOutputValueClass(NullWritable.class);
		
	
		
		FileInputFormat.setInputPaths(
				job,new Path("hdfs://192.168.157.27:9000/Telecom"));
		FileOutputFormat.setOutputPath(
				job,new Path("hdfs://192.168.157.27:9000/Telecom/result"));
		
		job.waitForCompletion(true);
	}
}
