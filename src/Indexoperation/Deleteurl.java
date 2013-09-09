package Indexoperation;

import java.util.ArrayList;

import xmlhandler.xmlgen;
import xmlhandler.xmlparser;
import dto.Urlhistory;
import dto.urlinfo;
import xmlhandler.xmlgen;

public class Deleteurl {

	private xmlgen itsxmlgen;

	public void deleteurl(String url, String path) {

		xmlgen gen = new xmlgen();
		xmlparser parser = new xmlparser();
		Dataentry data = new Dataentry();
		data.setPath(path);
		urlinfo info = new urlinfo();
		info = parser.returninfo(path + "urlinfo.db", url);

		ArrayList<Shiftlines> newdata = new ArrayList<Shiftlines>();

		newdata = data.deleteindex(info.getUrlid());

		data.writeindex(newdata);
		gen.deleteindex(info.getUrlid(), path + "urlinfo.db");
		ArrayList<Urlhistory> hits = new ArrayList<Urlhistory>();
		hits = data.deletehits(url);

		data.rewritehits(hits);

	}
}
