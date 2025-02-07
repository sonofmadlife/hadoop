package com.jike.join;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;

public class JoinMapper extends Mapper<LongWritable, Text, Text, Item> {

	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, Item>.Context context)
			throws IOException, InterruptedException {
		String line = value.toString();
		String[] arr = line.split(" ");
		Item item = new Item();

		FileSplit fs = (FileSplit) context.getInputSplit();
		String fileName = fs.getPath().getName();
		if (fileName.startsWith("order")) {
			item.setOrderId(arr[0]);
			item.setDate(Integer.parseInt(arr[1]));
			item.setGoodId(arr[2]);
			item.setNum(Integer.parseInt(arr[3]));
			 item.setKind("");
			 item.setPrice(0);
		}
		if(fileName.startsWith("product_phone")){
			item.setGoodId(arr[0]);
			item.setKind(arr[1]);
			item.setPrice(Integer.parseInt(arr[2]));
			 item.setNum(0);
			 item.setOrderId("");
			 item.setDate(0);
		}
//		System.out.println(item);
		context.write(new Text(item.getGoodId()), item);
	}
}
