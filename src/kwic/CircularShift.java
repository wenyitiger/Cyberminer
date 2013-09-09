package kwic;

import java.io.BufferedReader;
import java.util.*;


public class CircularShift{
	
	private ArrayList<String> list;
	private String line="";
	private String result="";
	private ArrayList<String> list2;

	protected void shift(ArrayList<String> kwicList,ArrayList<String> Outset) {
		list = kwicList;
		list2 = Outset;
		for(int i=0;i<list.size();i++)
		{
			line = list.get(i);
			if (line !=null)
			{
			//	line =line.toLowerCase();
				parseLine(line,list2);
			
			}
		 
	}
	
	}
	
	private void parseLine(String temp,ArrayList<String> Outset) {
		StringTokenizer tokener = new StringTokenizer(temp);
		String token = new String();
		int index;
		String line = new String();
		
		ArrayList<String> tokens = new ArrayList<String>();
		int count = tokener.countTokens();
		
		for (int j = 0; j < count; j++) {//
			token = tokener.nextToken();
			if(!token.equals("a")&&!token.equals("an")&&!token.equals("or")&&!token.equals("of")&&!token.equals("the")&&!token.equals("and")&&!token.equals("but"))
			{
				tokens.add(token);
			
			}else{
				tokens.add("");
			}
		}
		
		//shift
		for (int i = 0; i < count; i++) {
			index=i;
			StringBuffer linebuffer = new StringBuffer();
			for (int j = 0; j < count; j++) {
				
				if (index >= count)
			          index = 0;

			        linebuffer.append ( tokens.get(index)  );
			        linebuffer.append (" ");
			        index++;
			}
			line =  linebuffer.toString();
			
			Outset.add(line);
		}
	}
}