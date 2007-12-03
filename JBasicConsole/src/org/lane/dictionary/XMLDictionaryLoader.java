package org.lane.dictionary;

/**
 * XMLDictionaryLoader
 * 
 * This class will load a Dictionary XML definition file.
 *  
 * @author nathanl
 *
 */

import java.io.*;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;

public class XMLDictionaryLoader {
	
	private static DocumentBuilderFactory builderFactory;
	private static DocumentBuilder builder;

	public static Dictionary loadDictionary(String xmlFilePath, String xmlFileName, boolean isResource) {
		Dictionary newDictionary = new Dictionary();
		
		builderFactory = DocumentBuilderFactory.newInstance();
		
		try {
			builder = builderFactory.newDocumentBuilder();

			InputStream in;
		
			in = new FileInputStream("");
		
			Document response;
		
			response = builder.parse(in);
			in.close();
			
			NodeList doubles = response.getElementsByTagName("double");
			Node datum = doubles.item(0);
			Text result = (Text) datum.getFirstChild();
			System.out.println(result.getNodeValue());
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return newDictionary;
	}

}
