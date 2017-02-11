package utilities;

import java.io.File;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLParser {

	public static HashMap<String,String> ReadAndReturnXML(){
	
	HashMap<String,String> map = new HashMap<String,String>();
		
	try{
    URL url = new URL("http://www.qastuff.com/Demo.xml");
	URLConnection connection = url.openConnection();

	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	Document doc =dBuilder.parse(connection.getInputStream());
	
	doc.getDocumentElement().normalize();
	
	System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
	NodeList nList = doc.getElementsByTagName("credentials");

	System.out.println("----------------------------");
	
	for (int temp = 0; temp < nList.getLength(); temp++) {

		Node nNode = nList.item(temp);
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			Element eElement = (Element) nNode;
			map.put("username", eElement.getElementsByTagName("username").item(0).getTextContent());
			map.put("password", eElement.getElementsByTagName("password").item(0).getTextContent());		
		}	
	}
	}

	catch(Exception e){
		e.printStackTrace();
	}
	return map;

	}	
}
