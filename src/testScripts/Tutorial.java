package testScripts;

import java.io.IOException;
import java.util.HashMap;
import utilities.XMLParser;

public class Tutorial {

	public static void main(String[] args) throws IOException {
			
		 HashMap<String, String> t = XMLParser.ReadAndReturnXML();
		 System.out.println(t.get("username"));
	  }
}
