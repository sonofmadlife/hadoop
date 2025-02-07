package com.jike.shop;



import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;


//先分区再按key合并
public class Driver {

	public static void main(String[] args) throws Exception {
		//1.����һ����ҵ
		Configuration conf = new Configuration();
		Job job = Job.getInstance(conf);
		//2.������ҵ�����
		job.setJarByClass(Driver.class);
		//3.����mapper
		job.setMapperClass(ShopMapper.class);
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(ShopBean.class);
		//4.����reducer
		job.setReducerClass(ShopReducer.class);
		job.setOutputKeyClass(Text.class);
		job.setMapOutputValueClass(ShopBean.class);
		//设置自定义分区
		job.setNumReduceTasks(3);
		job.setPartitionerClass(ShopPartitioner.class);
		
		
		FileInputFormat.setInputPaths(job,new Path("hdfs://192.168.157.27:9000/shop.txt"));
		//6.�������λ��
		FileOutputFormat.setOutputPath(job,new Path("hdfs://192.168.157.27:9000/shop"));
		//7.������ҵ
		if(!job.waitForCompletion(true)){
			return;
		}
	}
}
