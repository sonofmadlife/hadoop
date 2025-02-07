package com.jike.wordcount;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

//<ƫ�������ı����ݣ����ʣ�����>
public class WordCountMapper extends Mapper<LongWritable,Text,Text,LongWritable>{

	@Override
	protected void map(LongWritable key, Text value, 
			Mapper<LongWritable, Text, Text, LongWritable>.Context context)
			throws IOException, InterruptedException {
		String line = value.toString();

		char[] arr = line.toCharArray();
//		String[] arr = line.split("");

		for(char word : arr){

			context.write(new Text(word+""), new LongWritable(1));
		}
	}
}
