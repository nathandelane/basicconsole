package org.lane.dictionary;

import java.net.*;

public class Dictionary {
	
	private Class dictionaryEngineClass;
	
	public Dictionary(String jarFilePath, String className) 
		throws 
			MalformedURLException, 
			ClassNotFoundException {
		
		URL[] engineJarPath = new URL[1];
		engineJarPath[0] = new URL(jarFilePath);
		
		URLClassLoader urlClassLoader = new URLClassLoader(engineJarPath);
		dictionaryEngineClass = urlClassLoader.loadClass(className);
		
	}
	
}
