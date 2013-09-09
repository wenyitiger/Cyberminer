package xmlhandler;

import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import dto.urlinfo;
import Indexoperation.sortresult;
import Indexoperation.Dataentry;

public class xmlparser {
	private Dataentry itsDataentry;
	private xmlgen itsxmlgen;

	public urlinfo search(String location, int urlid) {

		urlinfo info = new urlinfo();

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = null;
		try {
			db = dbf.newDocumentBuilder();
		} catch (ParserConfigurationException pce) {
			System.err.println(pce);
			System.exit(1);
		}
		Document doc = null;
		try {
			doc = db.parse(location);
		} catch (Exception e) {
			System.err.println(e);
			System.exit(1);
		}

		Element root = doc.getDocumentElement();
		NodeList urlinformation = root.getElementsByTagName("urlinfo");
		for (int i = 0; i < urlinformation.getLength(); i++) {

			//	   System.out.println("???");
			NodeList list = urlinformation.item(i).getChildNodes();
			int temp = Integer.parseInt(list.item(1).getTextContent());

			if (urlid == temp) {

				info.setUrlid(urlid);
				info.setUrl(list.item(3).getTextContent());
				info.setDescription(list.item(5).getTextContent());
			}

		}

		return info;

	}

	public urlinfo returninfo(String location, String url) {

		urlinfo info = new urlinfo();

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = null;
		try {
			db = dbf.newDocumentBuilder();
		} catch (ParserConfigurationException pce) {
			System.err.println(pce);
			System.exit(1);
		}
		Document doc = null;
		try {
			doc = db.parse(location);
		} catch (Exception e) {
			System.err.println(e);
			System.exit(1);
		}

		Element root = doc.getDocumentElement();
		NodeList urlinformation = root.getElementsByTagName("urlinfo");
		for (int i = 0; i < urlinformation.getLength(); i++) {

			NodeList list = urlinformation.item(i).getChildNodes();
			String temp = list.item(3).getTextContent();
			System.out.println(info.getUrlid() + "?????");

			if (url.equals(temp)) {
				System.out.println(info.getUrlid() + "?????");

				info.setUrlid(Integer.parseInt(list.item(1).getTextContent()));
				info.setUrl(temp);
				info.setDescription(list.item(5).getTextContent());
			}

		}

		return info;

	}

	public int maxnum(String location) {

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = null;
		try {
			db = dbf.newDocumentBuilder();
		} catch (ParserConfigurationException pce) {
			System.err.println(pce);
			System.exit(1);
		}
		Document doc = null;
		try {
			doc = db.parse(location);
		} catch (Exception e) {
			System.err.println(e);
			System.exit(1);
		}

		Element root = doc.getDocumentElement();
		NodeList urlinformation = root.getElementsByTagName("urlinfo");
		int max = 0;
		int i = urlinformation.getLength() - 1;

		NodeList list = urlinformation.item(i).getChildNodes();
		max = Integer.parseInt(list.item(1).getTextContent());

		return max;

	}

}