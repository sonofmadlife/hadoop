package com.jike.Invert;


import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class InvertMapper2 extends Mapper<LongWritable, Text, Text, Text> {

	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, Text>.Context context)
			throws IOException, InterruptedException {

		String line = value.toString();
		String[] arr = line.split("\\:");	
		System.out.println(arr[0]+"=========="+arr[1]);
		context.write(new Text(arr[0]), new Text(arr[1]));
		
	}
}
