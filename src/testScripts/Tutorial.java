package testScripts;

import java.io.IOException;
import java.util.HashMap;

import utilities.ReadWriteExcel;
import utilities.XMLParser;

public class Tutorial {

	public static void main(String[] args) throws IOException {
			
		ReadWriteExcel.WriteExcelByColAndRow(6, 1, "trial");
		System.out.println(XMLParser.ReadAndReturnXML().get("password"));
	  }
}
