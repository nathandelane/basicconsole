package org.lane.console.properties;

import java.awt.*;
import java.util.*;

public class ConsoleProperties {
	
	// List of default properties - these can be changed
	private static String prompt = "> ";
	private static String buffer = "";
	private static boolean graphicsEnabled = true;
	
	// List of default Window properties - these can be changed
	public static int consoleWidth = 500;
	public static int consoleHeight = 400;
	public static String consoleFontName = "Verdana";
	public static int consoleFontStyle = Font.PLAIN;
	public static int consoleFontSize = 10;
	public static Font consoleFont = new Font(consoleFontName, consoleFontStyle, consoleFontSize);
	public static Color consoleForeground = new Color(0, 0, 0);
	public static Color consoleBackground = new Color(255, 255, 255);
	
	// Collections for the Console - usually private
	private static ArrayList<String> bufferHistory = new ArrayList<String>();
	
	/**
	 * loadUserProperties loads the properties defined in
	 * the default user properties location.
	 */
	public static void loadUserProperties() {
		
	}
	
	/**
	 * loadUserProperties loads the properties defined by
	 * a custom path string.
	 * 
	 * @param location
	 */
	public static void loadUserProperties(String location) {
		
	}
	
	public static String getPrompt() {
		return prompt;
	}
	
	public static void setPrompt(String newPrompt) {
		prompt = newPrompt;
	}
	
	public static void clearBuffer() {
		buffer = "";
	}
	
	public static String getBuffer() {
		return buffer;
	}
	
	public static void addToBuffer(String str) {
		buffer += str;
	}
	
	public static void addToBuffer(char chr) {
		buffer += chr;
	}
	
	public static void setBuffer(String str) {
		buffer = str;
	}
	
	public static void addToBufferHistory(String commandline) {
		bufferHistory.add(commandline);
	}
	
	public static boolean areGraphicsEnabled() {
		return graphicsEnabled;
	}

}
