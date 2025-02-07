package com.jike.guanxi;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class GuanxiMapper extends Mapper<LongWritable, Text, Text, Text>{

	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, Text>.Context context)
			throws IOException, InterruptedException {
		
		String line = value.toString();
		String[] res = line.split(" ");
		
		context.write(new Text(res[0]), new Text("+"+res[1]));
		context.write(new Text(res[1]), new Text("-"+res[0]));

	}
}
