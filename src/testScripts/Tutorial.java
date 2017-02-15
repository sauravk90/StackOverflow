package testScripts;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;

import utilities.ReadWriteExcel;
import utilities.XMLParser;

public class Tutorial {

	public static void main(String[] args) throws IOException {
		 LinkedHashMap<Integer,String> hm = new LinkedHashMap<Integer,String>();  
		  
		  hm.put(100,"Saurav");  
		  hm.put(102,"Tushar");  
		  hm.put(101,"Sneh");  
		  hm.put(103,"Avinash");  
		  
		  for(Map.Entry m:hm.entrySet()){  
		   System.out.println(m.getKey()+" "+m.getValue());  
		  }  
		  
	  }
}
