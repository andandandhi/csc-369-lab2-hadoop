package csc369;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

public class HadoopApp {

    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
        Configuration conf = new Configuration();
        Job job = new Job(conf, "Hadoop example");
        String[] otherArgs = new GenericOptionsParser(conf, args).getRemainingArgs();

	if (otherArgs.length < 3) {
	    System.out.println("Expected parameters: <job class> <input dir> <output dir>");
	    System.exit(-1);
	} else if ("WordCount".equalsIgnoreCase(otherArgs[0])) {
	    job.setReducerClass(WordCount.ReducerImpl.class);
	    job.setMapperClass(WordCount.MapperImpl.class);
	    job.setOutputKeyClass(WordCount.OUTPUT_KEY_CLASS);
	    job.setOutputValueClass(WordCount.OUTPUT_VALUE_CLASS);
	} else if ("AccessLog".equalsIgnoreCase(otherArgs[0])) {
	    job.setReducerClass(AccessLog.ReducerImpl.class);
	    job.setMapperClass(AccessLog.MapperImpl.class);
	    job.setOutputKeyClass(AccessLog.OUTPUT_KEY_CLASS);
	    job.setOutputValueClass(AccessLog.OUTPUT_VALUE_CLASS);
	} else if ("AccessLog2".equalsIgnoreCase(otherArgs[0])) {
	    job.setReducerClass(AccessLog2.ReducerImpl.class);
	    job.setMapperClass(AccessLog2.MapperImpl.class);
	    job.setOutputKeyClass(AccessLog2.OUTPUT_KEY_CLASS);
	    job.setOutputValueClass(AccessLog2.OUTPUT_VALUE_CLASS);
	} else if ("UrlCount".equalsIgnoreCase(otherArgs[0])) {
		job.setReducerClass(UrlCount.ReducerImpl.class);
		job.setMapperClass(UrlCount.MapperImpl.class);
		job.setOutputKeyClass(UrlCount.OUTPUT_KEY_CLASS);
		job.setOutputValueClass(UrlCount.OUTPUT_VALUE_CLASS);
	} else if ("UrlCount2".equalsIgnoreCase(otherArgs[0])) {
		job.setReducerClass(UrlCount2.ReducerImpl.class);
		job.setMapperClass(UrlCount2.MapperImpl.class);
		job.setOutputKeyClass(UrlCount2.OUTPUT_KEY_CLASS);
		job.setOutputValueClass(UrlCount2.OUTPUT_VALUE_CLASS);
	} else if ("CodeCount".equalsIgnoreCase(otherArgs[0])) {
		job.setReducerClass(CodeCount.ReducerImpl.class);
		job.setMapperClass(CodeCount.MapperImpl.class);
		job.setOutputKeyClass(CodeCount.OUTPUT_KEY_CLASS);
		job.setOutputValueClass(CodeCount.OUTPUT_VALUE_CLASS);
	} else if ("IpBytes".equalsIgnoreCase(otherArgs[0])) {
		job.setReducerClass(IpBytes.ReducerImpl.class);
		job.setMapperClass(IpBytes.MapperImpl.class);
		job.setOutputKeyClass(IpBytes.OUTPUT_KEY_CLASS);
		job.setOutputValueClass(IpBytes.OUTPUT_VALUE_CLASS);
	} else if ("IpCount".equalsIgnoreCase(otherArgs[0])) {
		job.setReducerClass(IpCount.ReducerImpl.class);
		job.setMapperClass(IpCount.MapperImpl.class);
		job.setOutputKeyClass(IpCount.OUTPUT_KEY_CLASS);
		job.setOutputValueClass(IpCount.OUTPUT_VALUE_CLASS);
	} else if ("IpCount2".equalsIgnoreCase(otherArgs[0])) {
		job.setReducerClass(IpCount2.ReducerImpl.class);
		job.setMapperClass(IpCount2.MapperImpl.class);
		job.setOutputKeyClass(IpCount2.OUTPUT_KEY_CLASS);
		job.setOutputValueClass(IpCount2.OUTPUT_VALUE_CLASS);
	} else if ("MonthCount".equalsIgnoreCase(otherArgs[0])) {
		job.setReducerClass(MonthCount.ReducerImpl.class);
		job.setMapperClass(MonthCount.MapperImpl.class);
		job.setOutputKeyClass(MonthCount.OUTPUT_KEY_CLASS);
		job.setOutputValueClass(MonthCount.OUTPUT_VALUE_CLASS);
	} else if ("MonthCount2".equalsIgnoreCase(otherArgs[0])) {
		job.setReducerClass(MonthCount2.ReducerImpl.class);
		job.setMapperClass(MonthCount2.MapperImpl.class);
		job.setOutputKeyClass(MonthCount2.OUTPUT_KEY_CLASS);
		job.setOutputValueClass(MonthCount2.OUTPUT_VALUE_CLASS);
	} else if ("DayBytes".equalsIgnoreCase(otherArgs[0])) {
		job.setReducerClass(DayBytes.ReducerImpl.class);
		job.setMapperClass(DayBytes.MapperImpl.class);
		job.setOutputKeyClass(DayBytes.OUTPUT_KEY_CLASS);
		job.setOutputValueClass(DayBytes.OUTPUT_VALUE_CLASS);
	} else if ("DayBytes2".equalsIgnoreCase(otherArgs[0])) {
		job.setReducerClass(DayBytes2.ReducerImpl.class);
		job.setMapperClass(DayBytes2.MapperImpl.class);
		job.setOutputKeyClass(DayBytes2.OUTPUT_KEY_CLASS);
		job.setOutputValueClass(DayBytes2.OUTPUT_VALUE_CLASS);
	} else {
	    System.out.println("Unrecognized job: " + otherArgs[0]);
	    System.exit(-1);
	}

        FileInputFormat.addInputPath(job, new Path(otherArgs[1]));
        FileOutputFormat.setOutputPath(job, new Path(otherArgs[2]));

        System.exit(job.waitForCompletion(true) ? 0: 1);
    }

}
