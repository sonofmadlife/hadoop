package com.jike.join;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class Driver {

	public static void main(String[] args) throws Exception {
		//1.����һ����ҵ
		Configuration conf = new Configuration();
		Job job = Job.getInstance(conf);
		//2.������ҵ�����
		job.setJarByClass(Driver.class);
		//3.����mapper
		job.setMapperClass(JoinMapper.class);
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(Item.class);
		//4.����reducer
		job.setReducerClass(JoinReducer.class);
		job.setOutputKeyClass(IntWritable.class);
		job.setOutputValueClass(Item.class);
		//5.��������λ��
		FileInputFormat.setInputPaths(job,new Path("hdfs://192.168.157.27:9000/join"));
		//6.�������λ��
		FileOutputFormat.setOutputPath(job,new Path("hdfs://192.168.157.27:9000/join/result"));
		//7.������ҵ
		if(!job.waitForCompletion(true)){
			return;
		}
	}
}
