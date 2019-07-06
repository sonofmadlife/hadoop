package com.jike.ip;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;



public class IpDriver {

	public static void main(String[] args) throws Exception {
		//1.声明一个作业
		Configuration conf = new Configuration();
		Job job = Job.getInstance(conf);
		//2.声明作业的入口
		job.setJarByClass(IpDriver.class);
		//3.声明mapper
		job.setMapperClass(IpMapper.class);
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(NullWritable.class);
		//4.声明reducer
		job.setReducerClass(IpReducer.class);
		job.setOutputKeyClass(Text.class);
		job.setMapOutputValueClass(NullWritable.class);
		//5.声明输入位置
		FileInputFormat.setInputPaths(job,new Path("hdfs://192.168.157.27:9000/ip.txt"));
		//6.声明输出位置
		FileOutputFormat.setOutputPath(job,new Path("hdfs://192.168.157.27:9000/ips"));
		//7.启动作业
		if(!job.waitForCompletion(true)){
			return;
		}
	}
}
