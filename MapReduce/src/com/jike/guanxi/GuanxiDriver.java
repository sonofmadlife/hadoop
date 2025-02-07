package com.jike.guanxi;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;



public class GuanxiDriver {

	public static void main(String[] args) throws Exception {
		Configuration conf = new Configuration();
		Job job = Job.getInstance(conf);
		job.setJarByClass(GuanxiDriver.class);
		
		job.setMapperClass(GuanxiMapper.class);
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(Text.class);
		
		job.setReducerClass(GuanxiReducer.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(NullWritable.class);
		FileInputFormat.setInputPaths(job,new Path("hdfs://192.168.157.27:9000/yesun.txt"));

		FileOutputFormat.setOutputPath(job,new Path("hdfs://192.168.157.27:9000/yesun"));
		if(!job.waitForCompletion(true)){
			return;
		}
	}
}
