package Indexoperation;

import java.util.ArrayList;
import java.util.StringTokenizer;

import xmlhandler.xmlparser;

import dto.urlinfo;
import xmlhandler.xmlparser;

public class Search {

	private xmlparser itsxmlparser;
	private Dataentry itsDataentry;

	public ArrayList<urlinfo> Search(String keyword, String path) {

		String path1 = path;

		ArrayList<urlinfo> finalresult = new ArrayList<urlinfo>();

		StringTokenizer tokener = new StringTokenizer(keyword);
		String token = new String();

		int count = tokener.countTokens();

		for (int j = 0; j < count; j++) {//
			token = tokener.nextToken();
			finalresult.addAll(singlesearch(token, path1));
		}

		operation op = new operation();
		finalresult = op.removeDuplicateurl(finalresult);

		return finalresult;

	}

	public ArrayList<urlinfo> singlesearch(String keyword, String path) {

		String path2 = path;

		operation op = new operation();
		Dataentry data = new Dataentry();
		data.setPath(path2);
		ArrayList<Integer> resulturl = new ArrayList<Integer>();
		ArrayList<urlinfo> result = new ArrayList<urlinfo>();
		resulturl = data.singlesearchresult(keyword);
		resulturl = op.removeDuplicate(resulturl);
		xmlparser parser = new xmlparser();
		for (int i = 0; i < resulturl.size(); i++) {
			urlinfo info = new urlinfo();
			int id = resulturl.get(i);
			info = parser.search(path2 + "urlinfo.db", id);

			result.add(info);

		}
		return result;
	}

}
