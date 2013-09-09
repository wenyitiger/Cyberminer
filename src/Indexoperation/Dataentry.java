package Indexoperation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import xmlhandler.xmlgen;
import xmlhandler.xmlparser;

import dto.Urlhistory;
import dto.urlinfo;
import xmlhandler.xmlparser;

public class Dataentry {

	private xmlparser itsxmlparser;
	private operation itsoperation;
	String path;

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public ArrayList<Integer> singlesearchresult(String keyword) {

		BufferedReader br = null;
		ArrayList<Integer> data = new ArrayList<Integer>();

		try {
			br = new BufferedReader(new FileReader(path + "index.db"));
			String line = "";
			while ((line = br.readLine()) != null) {

				//	line =line.toLowerCase();

				int index = line.indexOf("@");

				int urlid = Integer.parseInt(line.substring(0, index));
				String linet = line.substring(index + 1);
				int firstword = linet.indexOf(" ");
				if (linet.substring(0, firstword).equals(keyword)) {
					data.add(urlid);
				}

			}

			br.close();
			//		 String out ="";
			//   	  for (int count = 0; count < data.size(); count++) {
			//	  System.out.println(data.get(count).getLine()+"???");
			//			  out+=(data.get(count).getLine()+"\r\n");

			//		}
			// 	  System.out.println("Processed ok?"+"\n"+out);

		} catch (IOException e) {
			System.err.println(("File not open" + e.toString()));
			System.exit(1);
		}

		operation op = new operation();
		data = op.removeDuplicate(data);
		return data;

	}

	public ArrayList<Shiftlines> readindex()

	{

		BufferedReader br = null;
		ArrayList<Shiftlines> data = new ArrayList<Shiftlines>();

		try {
			br = new BufferedReader(new FileReader(path + "index.db"));
			String line = "";
			while ((line = br.readLine()) != null) {

				//	line =line.toLowerCase();
				Shiftlines shift = new Shiftlines();
				int index = line.indexOf("@");

				int urlid = Integer.parseInt(line.substring(0, index));
				String linet = line.substring(index + 1);
				shift.setUrlId(urlid);
				shift.setLine(linet);
				data.add(shift);
			}

			//		 String out ="";
			//   	  for (int count = 0; count < data.size(); count++) {
			//	  System.out.println(data.get(count).getLine()+"???");
			//			  out+=(data.get(count).getLine()+"\r\n");

			//		}
			// 	  System.out.println("Processed ok?"+"\n"+out);
			br.close();
		} catch (IOException e) {
			System.err.println(("File not open" + e.toString()));
			System.exit(1);
		}

		return data;

	}

	public int geturlid() {
		int id = 0;
		xmlparser parser = new xmlparser();
		try {

			FileReader fr = new FileReader(path + "urlinfo.db");
			if (fr.read() == -1) {
				id = 1;

			} else {
				id = parser.maxnum(path + "urlinfo.db");
				id++;

			}
			fr.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;

	}

	public void writeurlinfo(urlinfo info) {

		xmlgen gen = new xmlgen();

		if (info.getUrlid() > 1) {
			gen.addindex(info, path + "urlinfo.db");
		} else {
			gen.createindex(info, path + "urlinfo.db");
		}

	}

	public ArrayList<Shiftlines> deleteindex(int id) {

		ArrayList<Shiftlines> olddata = new ArrayList<Shiftlines>();

		olddata = readindex();
		for (int i = 0; i < olddata.size(); i++) {

			if (olddata.get(i).getUrlId() == id) {

				olddata.remove(i);

			}

		}
		return olddata;

	}

	public ArrayList<Urlhistory> deletehits(String url) {
		BufferedReader br = null;
		ArrayList<Urlhistory> data = new ArrayList<Urlhistory>();

		try {
			br = new BufferedReader(new FileReader(path + "hits.db"));

			String line = "";
			while ((line = br.readLine()) != null) {
				SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
				//	line =line.toLowerCase();
				Urlhistory history = new Urlhistory();
				int index1 = line.indexOf("@");
				int index2 = line.lastIndexOf("@");
				int hits = Integer.parseInt(line.substring(0, index1));

				String date = line.substring(index1 + 1, index2);
				String url1 = line.substring(index2 + 1);
				if (!url.equals(url1)) {
					history.setHits(hits);
					history.setDate(date);

					history.setUrl(url1);

					data.add(history);
				}

			}
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return data;
	}

	public int gethits(String url) {

		BufferedReader br = null;
		int result = -1;

		try {
			br = new BufferedReader(new FileReader(path + "hits.db"));
			String line = "";
			while ((line = br.readLine()) != null) {

				//	line =line.toLowerCase();

				int index1 = line.indexOf("@");
				int index2 = line.lastIndexOf("@");
				int hits = Integer.parseInt(line.substring(0, index1));

				String date = line.substring(index1 + 1, index2);
				String url1 = line.substring(index2 + 1);

				if (url.equals(url1)) {
					result = hits;
				}

			}
		} catch (FileNotFoundException e) {
			System.err.println(("File not open" + e.toString()));
			System.exit(1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println("Processed Finished");
		return result;

	}

	public void rewritehits(ArrayList<Urlhistory> data) {

		PrintWriter pw = null;

		try {
			pw = new PrintWriter(new FileWriter(new File(path + "hits.db")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (int i = 0; i < data.size(); i++) {
			Urlhistory history1 = new Urlhistory();
			history1 = data.get(i);

			pw.write(Integer.toString(history1.getHits()));
			pw.write("@");

			pw.write(history1.getDate());
			pw.write("@");
			pw.write(history1.getUrl());
			pw.write("\r\n");
			pw.flush();
		}

		pw.close();
	}

	//System.out.println("Processed Finished");

	public ArrayList<Urlhistory> updatehits(String url) {
		BufferedReader br = null;
		ArrayList<Urlhistory> data = new ArrayList<Urlhistory>();

		try {
			br = new BufferedReader(new FileReader(path + "hits.db"));
			String line = "";
			while ((line = br.readLine()) != null) {
				SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
				//	line =line.toLowerCase();
				Urlhistory history = new Urlhistory();
				int index1 = line.indexOf("@");
				int index2 = line.lastIndexOf("@");
				int hits = Integer.parseInt(line.substring(0, index1));

				String date = line.substring(index1 + 1, index2);
				String url1 = line.substring(index2 + 1);
				history.setUrl(url1);

				history.setDate(date);
				if (url.equals(url1)) {
					history.setHits(hits + 1);
				} else {
					history.setHits(hits);
				}
				data.add(history);
			}
		} catch (FileNotFoundException e) {
			System.err.println(("File not open" + e.toString()));
			System.exit(1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println("Processed Finished");
		return data;

	}

	public void writeurlhits(urlinfo info) {

		PrintWriter pw = null;
		try {

			pw = new PrintWriter(new FileWriter(new File(path + "hits.db"),
					true));
		} catch (FileNotFoundException e) {
			System.err.println(("File not open" + e.toString()));
			System.exit(1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		pw.write("0@");

		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
		pw.write(sdf.format(new Date()));
		pw.write("@");
		pw.write(info.getUrl());
		pw.write("\r\n");

		pw.flush();
		pw.close();
		//System.out.println("Processed Finished");
	}

	public void writeindex(ArrayList<Shiftlines> newdata) {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(
					new FileWriter(new File(path + "index.db")));
		} catch (FileNotFoundException e) {
			System.err.println(("File not open" + e.toString()));
			System.exit(1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (int count = 0; count < newdata.size(); count++) {

			pw.write(Integer.toString(newdata.get(count).getUrlId()));
			pw.write("@");
			pw.write(newdata.get(count).getLine());
			pw.write("\r\n");
		}

		pw.flush();
		pw.close();

	}

}
