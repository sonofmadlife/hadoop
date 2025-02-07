package com.jike.sortprofit;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class SortProfitMapper extends Mapper<LongWritable, Text, IntWritable, IntWritable>{
	@Override
	protected void map(LongWritable key, Text value,
			Mapper<LongWritable, Text, IntWritable, IntWritable>.Context context)
					throws IOException, InterruptedException {
		String line = value.toString();
		String[] arr = line.split(" ");
		int month=Integer.parseInt(arr[0]);
		int profit=Integer.parseInt(arr[2])-Integer.parseInt(arr[1]);

		context.write(new IntWritable(month), new IntWritable(profit));
		
	}

}
