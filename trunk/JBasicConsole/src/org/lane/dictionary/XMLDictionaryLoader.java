package org.lane.dictionary;

/**
 * XMLDictionaryLoader
 * 
 * This class will load a Dictionary based on given
 * criteria:
 * 
 * String classpath
 * String classname
 * boolean isResource, tells whether to look in the current
 * jar or not
 * 
 * @author nathanl
 *
 */

import java.io.*;
import org.w3c.dom.*;
import javax.xml.parsers.*;

public class XMLDictionaryLoader {
	
	public XMLDictionaryLoader(String classPath, String className, boolean isResource) {
		try {
			DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = builderFactory.newDocumentBuilder();

			InputStream in = new FileInputStream("");
			Document response = builder.parse(in);
			in.close();
			
			NodeList doubles = response.getElementsByTagName("double");
			Node datum = doubles.item(0);
			Text result = (Text) datum.getFirstChild();
			System.out.println(result.getNodeValue());
		} catch(Exception e) {
			
		}
	}

}
