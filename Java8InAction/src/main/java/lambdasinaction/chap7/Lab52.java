package lambdasinaction.chap7;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.io.BufferedReader;
//import org.apache.commons.lang.StringUtils;

public class Lab52 {
	public static String listFilesForFolder(final File folder) {
		String s = "";
		String line = "";
		StringBuilder result = new StringBuilder();
		TreeMap<String,Integer> counter = new TreeMap<String,Integer>();
		for (final File fileEntry : folder.listFiles()) {

			try {
				BufferedReader br = new BufferedReader(new FileReader(fileEntry)); 
				while ((line=br.readLine())!=null) {
					s+=line;
				}
				s+=" ";
				br.close();

			} catch (Exception e) {
				e.printStackTrace();
			}

		}	    
		String[] s1 = s.split(" ");
		for (String i : s1) {
			String b = i.toLowerCase();
			if(counter.get(b)==null) {
				counter.put(b, 1);
			} else {
				counter.put(b, counter.get(b)+1);
			}
		}        
		//counter.forEach((k,v)-> result.append("<"+k+", "+v+">\n"));
		//return result.toString();
		return counter.toString();
	}


	public static String listFilesForFolderStream(final File folder) {
		//Map<String, Long> counter = new HashMap<String,Long>();
		
		return Arrays.stream(folder.listFiles()).parallel()
		.map(file -> {
			try {
				return Files.lines(file.toPath(), Charset.defaultCharset()).parallel()
						.flatMap(line -> Arrays.stream(line.toLowerCase().split(" ")));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		})
		.flatMap(Function.identity())
		.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).toString();
		
		//return counter.toString();
//		Stream<File> files = Arrays.stream(folder.listFiles());
//		files.map(i -> Files.lines(i.toPath(),Charset.defaultCharset())
//				.flatMap(line -> Arrays.stream(line.split(" "))
//						.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())))
//				.reduce(e -> e.entrySet {if (counter.get(e.getKey())==null) { counter.put(e.getKey(), e.getValue());} else {counter.put(e.getKey(),counter.get(e.getKey)+e.getValue);}});
		
	}



	public static void main(String[] args) {
		final File folder = new File(args[0]);

		long startTimeTrad = System.currentTimeMillis();
		String result = listFilesForFolder(folder);
		long stopTimeTrad = System.currentTimeMillis();
		long elapsedTimeTrad = stopTimeTrad - startTimeTrad;
		System.out.println(result+"\n"+elapsedTimeTrad);

		long startTimeStream = System.currentTimeMillis();
		String resultStream = listFilesForFolderStream(folder);
		long stopTimeStream = System.currentTimeMillis();
		long elapsedTimeStream = stopTimeStream - startTimeStream;
		System.out.println(resultStream+"\n"+elapsedTimeStream);


	}

}
