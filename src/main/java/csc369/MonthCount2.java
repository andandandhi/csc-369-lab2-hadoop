package csc369;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

public class MonthCount2 {

    public static final Class OUTPUT_KEY_CLASS = LongWritable.class;
    public static final Class OUTPUT_VALUE_CLASS = Text.class;

    public static final HashMap<String, Integer> monthConvert;
    static{
        monthConvert = new HashMap<>();
        monthConvert.put("Jan", 1);
        monthConvert.put("Feb", 2);
        monthConvert.put("Mar", 3);
        monthConvert.put("Apr", 4);
        monthConvert.put("May", 5);
        monthConvert.put("Jun", 6);
        monthConvert.put("Jul", 7);
        monthConvert.put("Aug", 8);
        monthConvert.put("Sep", 9);
        monthConvert.put("Oct", 10);
        monthConvert.put("Nov", 11);
        monthConvert.put("Dec", 12);
    }

    public static class MapperImpl extends Mapper<LongWritable, Text, LongWritable, Text> {

        @Override
	protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
	    String[] sa = value.toString().split("\t");

	    Text date = new Text();
            date.set(sa[0] + "\\" + sa[1]);
            LongWritable chronoKey = new LongWritable(Integer.parseInt(sa[1]) * 10 +
                    monthConvert.get(sa[0]));
	    context.write(chronoKey, date);
        }
    }

    
    public static class ReducerImpl extends Reducer<LongWritable, Text, Text, LongWritable> {
	
        @Override
	protected void reduce(LongWritable count, Iterable<Text> hostnames,
			      Context context) throws IOException, InterruptedException {
            
            Iterator<Text> itr = hostnames.iterator();
            while (itr.hasNext()){
                context.write(itr.next(), null);
            }
        }
    }

}
