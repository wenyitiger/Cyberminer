package xmlhandler;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import dto.urlinfo;
import Indexoperation.Dataentry;

public class xmlgen {

	private Dataentry itsDataentry;

	public void addindex(urlinfo urlinfo, String location) {

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder;
		try {
			docBuilder = dbf.newDocumentBuilder();

			Document doc = docBuilder.parse(location);
			doc.normalize();

			Element urlinfomation = doc.createElement("urlinfo");

			doc.getDocumentElement().appendChild(urlinfomation);
			Element urlid = doc.createElement("urlid");

			urlinfomation.appendChild(urlid);
			urlid.appendChild(doc.createTextNode(Integer.toString(urlinfo
					.getUrlid())));

			Element url = doc.createElement("url");
			urlinfomation.appendChild(url);
			url.appendChild(doc.createTextNode(urlinfo.getUrl()));

			Element descritption = doc.createElement("description");
			urlinfomation.appendChild(descritption);
			descritption.appendChild(doc.createTextNode(urlinfo
					.getDescription()));

			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer transformer = tf.newTransformer();
			DOMSource source = new DOMSource(doc);
			//	        Result resultStr = new StreamResult(writerStr);  

			StreamResult xmlResult = new StreamResult(
					new java.io.File(location));
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.transform(source, xmlResult);
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void deleteindex(int id, String location) {

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder;
		try {
			docBuilder = dbf.newDocumentBuilder();

			Document doc = docBuilder.parse(location);
			doc.normalize();

			Element root = doc.getDocumentElement();
			NodeList urlinformation = root.getElementsByTagName("urlinfo");
			for (int i = 0; i < urlinformation.getLength(); i++) {

				//	   System.out.println("???");
				NodeList list = urlinformation.item(i).getChildNodes();
				int temp = Integer.parseInt(list.item(1).getTextContent());
				Node nd = urlinformation.item(i);
				if (id == temp) {
					System.out.println("here");
					Node catParent = nd.getParentNode();
					catParent.removeChild(nd);

				}

				TransformerFactory tf = TransformerFactory.newInstance();
				Transformer transformer = tf.newTransformer();
				DOMSource source = new DOMSource(doc);
				//	        Result resultStr = new StreamResult(writerStr);  

				StreamResult xmlResult = new StreamResult(new java.io.File(
						location));
				transformer.setOutputProperty(OutputKeys.INDENT, "yes");
				transformer.transform(source, xmlResult);
			}
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String createindex(urlinfo urlinfo, String location) {
		Document doc = null;
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		String x = null;
		try {
			DocumentBuilder docBuilder = dbf.newDocumentBuilder();
			doc = docBuilder.newDocument();
			Element indexs = doc.createElement("indexs");
			doc.appendChild(indexs);
			Element urlinfomation = doc.createElement("urlinfo");

			indexs.appendChild(urlinfomation);
			Element urlid = doc.createElement("urlid");

			urlinfomation.appendChild(urlid);
			urlid.appendChild(doc.createTextNode(Integer.toString(urlinfo
					.getUrlid())));

			Element url = doc.createElement("url");
			urlinfomation.appendChild(url);
			url.appendChild(doc.createTextNode(urlinfo.getUrl()));

			Element descritption = doc.createElement("description");
			urlinfomation.appendChild(descritption);
			descritption.appendChild(doc.createTextNode(urlinfo
					.getDescription()));

			//	operation.appendChild(doc.createTextNode("/n        "));
			doc.normalize();

			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer transformer = tf.newTransformer();
			DOMSource domsource = new DOMSource(doc);

			FileOutputStream out = new FileOutputStream(new File(location));

			StreamResult xmlResult = new StreamResult(out);

			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.transform(domsource, xmlResult);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
		return x;
	}
}