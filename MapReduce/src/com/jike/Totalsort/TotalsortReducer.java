package com.jike.Totalsort;

import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.IntWritable;

import org.apache.hadoop.mapreduce.Reducer;

public class TotalsortReducer extends Reducer<IntWritable,IntWritable,IntWritable,IntWritable>{
	@Override
	protected void reduce(IntWritable key, Iterable<IntWritable> value,
			Reducer<IntWritable, IntWritable, IntWritable, IntWritable>.Context context) 
					throws IOException, InterruptedException {
		int count = 0;
		Iterator<IntWritable> it = value.iterator();
		while(it.hasNext()){
			count = count + it.next().get();
		}
		context.write(key, new IntWritable(count));
	}
}

