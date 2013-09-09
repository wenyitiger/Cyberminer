package Indexoperation;

import java.util.ArrayList;

import xmlhandler.xmlgen;

import dto.Urlhistory;
import dto.urlinfo;
import xmlhandler.xmlgen;

public class Addurl {

	private xmlgen itsxmlgen;

	public void Add(String url, String description, String path) {

		//	String relativelyPath=System.getProperty("user.dir"); 

		xmlgen gen = new xmlgen();
		Dataentry data = new Dataentry();
		data.setPath(path);
		urlinfo info = new urlinfo();
		int id = data.geturlid();
		info.setUrlid(id);
		info.setUrl(url);
		info.setDescription(description);
		data.writeurlinfo(info);
		data.writeurlhits(info);
		operation cal = new operation();
		ArrayList<Shiftlines> newdata = new ArrayList<Shiftlines>();
		ArrayList<Shiftlines> olddata = new ArrayList<Shiftlines>();
		newdata = cal.calindex(description, id);
		olddata = data.readindex();
		if (olddata == null) {

			data.writeindex(newdata);
		} else {
			System.out.println("hahaha");
			newdata = cal.resort(olddata, newdata);
			data.writeindex(newdata);
		}
	}

	public void urlhitsupdate(String url, String path) {
		Dataentry data = new Dataentry();
		data.setPath(path);
		ArrayList<Urlhistory> hits = new ArrayList<Urlhistory>();
		hits = data.updatehits(url);

		data.rewritehits(hits);

	}
}
