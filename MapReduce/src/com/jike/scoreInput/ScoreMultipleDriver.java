package com.jike.scoreInput;


import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.MultipleInputs;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import outputformat.AuthOutputFormat;


public class ScoreMultipleDriver {
	
	public static void main(String[] args) throws Exception {
		Configuration conf=new Configuration();
		Job job=Job.getInstance(conf);
		
		job.setJarByClass(ScoreMultipleDriver.class);
		
		//--多输入源机制，通过指定Mapper和InputFormat组件类来处理指定的格式文件
		MultipleInputs
		.addInputPath(job,
				new Path("hdfs://192.168.157.27:9000/input/result/part-r-00000"), 
				TextInputFormat.class,ScoreDefaultMapper.class);
		
		MultipleInputs
		.addInputPath(job,new Path("hdfs://192.168.157.27:9000/input/input.txt"),
				ScoreInputFormat.class,ScoreMapper.class);
		
		//--多输入源机制，多个mapper输出的kv类型一致
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(Text.class);
		
		//--设置自定义的格式输出组件。
		//--如果不设定，默认的TextOutputFormat
		job.setOutputFormatClass(AuthOutputFormat.class);
		
		FileOutputFormat.setOutputPath(job,
				new Path("hdfs://192.168.150.137:9000/scoreinput/result"));
		
		job.waitForCompletion(true);
	}

}
