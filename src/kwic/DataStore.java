package kwic;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataStore {
	private ArrayList<String> list;
	private String line="";
	
	protected void Store(ArrayList<String> kwicList,BufferedReader br) {
		list = kwicList;
		while (line!= null)
		{
			readline(br);
		
			list.add(line);
		  } 
	}

private void readline(BufferedReader br) {
	try {
		line = br.readLine();
		Pattern p = Pattern.compile("[.,\"\\[\\]?!:'~@#$%^*()`_+-={};/><|\\\\]");  
        Matcher m = p.matcher(line);  
          
        line = m.replaceAll(" ");   
	} catch (Exception e) {
		e.getStackTrace();
	}
}
}

