package outputformat;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapreduce.RecordWriter;
import org.apache.hadoop.mapreduce.TaskAttemptContext;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
//自定义格式输出器
//k v不确定,所以用泛型
public class AuthOutputFormat<K, V> extends FileOutputFormat<K, V>{

	@Override
	public RecordWriter<K, V> getRecordWriter(TaskAttemptContext job) throws IOException, InterruptedException {
		//获取输出结果文件的路劲
		Path path=super.getDefaultWorkFile(job, "");
		//获取环境变量
		Configuration conf = job.getConfiguration();
		//获取HDFS对象
		FileSystem system = path.getFileSystem(conf);
		//获取输出文件的输出流
		FSDataOutputStream out = system.create(path);
		
		
		return new AuthRecordWriter<K,V>(out);
		
	}

}
