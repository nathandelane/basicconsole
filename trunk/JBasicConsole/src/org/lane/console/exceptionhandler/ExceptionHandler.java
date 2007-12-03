package org.lane.console.exceptionhandler;

import javax.swing.*;

import org.lane.console.properties.*;

public class ExceptionHandler {
	
	public static void logException(Exception e) {
		if(ConsoleProperties.areGraphicsEnabled()) {
			showErrorInDialog(e);
		} else {
			showErrorInConsole(e);
		}
	}
	
	private static void showErrorInDialog(Exception e) {
		String formattedException = formatStackTrace(e.getStackTrace());
		
		JOptionPane.showMessageDialog(null, "Exception Occurred!\n" + formattedException);
	}
	
	private static void showErrorInConsole(Exception e) {
		e.printStackTrace();
	}

	private static String formatStackTrace(StackTraceElement ste[]) {
		String stackTrace = "";
		
		for(int i = 0; i < ste.length; ++i) {
			stackTrace += (ste[i].toString() + "\n");
		}
		
		return stackTrace;
	}
	
}
