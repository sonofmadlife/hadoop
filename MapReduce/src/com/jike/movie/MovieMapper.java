package com.jike.movie;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class MovieMapper extends Mapper<LongWritable, Text, Movie, NullWritable>{

	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Movie, NullWritable>.Context context)
			throws IOException, InterruptedException {
		String line = value.toString();
		String[] arr = line.split(" ");
		Movie movie = new Movie();
		movie.setName(arr[0]);
		movie.setHot(Integer.parseInt(arr[1]));
		context.write(movie, NullWritable.get());
	}
}
