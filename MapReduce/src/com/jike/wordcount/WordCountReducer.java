package com.jike.wordcount;


import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

//<单词，数量组成的数组当中元素的类型，单词，总数量>
public class WordCountReducer extends Reducer<Text,LongWritable,Text,LongWritable>{
	@Override
	protected void reduce(Text key, Iterable<LongWritable> value,
			Reducer<Text, LongWritable, Text, LongWritable>.Context context) 
					throws IOException, InterruptedException {
		//定义一个count变量，用来做记录总数
		long count = 0;
		//获取迭代器
		Iterator<LongWritable> it = value.iterator();
		//循环遍历做叠加
		while(it.hasNext()){
			count = count + it.next().get();
		}
		context.write(key, new LongWritable(count));
	}
}
