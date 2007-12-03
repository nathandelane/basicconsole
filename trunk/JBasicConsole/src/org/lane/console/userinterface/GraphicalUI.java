package org.lane.console.userinterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import org.lane.console.properties.*;
import org.lane.console.exceptionhandler.*;

public class GraphicalUI extends JFrame implements KeyListener {
	
	public static final long serialVersionUID = 1L;
	
	private JTextArea ta;
	
	public GraphicalUI() {
		super("Console");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout());

		ConsoleProperties.loadUserProperties();
		setSize(ConsoleProperties.consoleWidth, ConsoleProperties.consoleHeight);
		
		ta = new JTextArea();
		ta.setFont(ConsoleProperties.consoleFont);
		ta.setForeground(ConsoleProperties.consoleForeground);
		ta.setBackground(ConsoleProperties.consoleBackground);
		ta.setEditable(false);
		getContentPane().add(ta, BorderLayout.CENTER);		
		
		setVisible(true);
		append(ConsoleProperties.getPrompt());
		
		if(ta.getCaret().isVisible()) {
			ta.getCaret().setVisible(false);
		}
		
		ta.addKeyListener(this);
	}
	
	public void keyPressed(KeyEvent ke) {
		if(ke.getKeyCode() == KeyEvent.VK_ENTER) {
			append("" + ke.getKeyChar());
			
			if(getBuffer().length() > 0) {
				append("" + getBuffer() + "\n");
				
				handleCommand(getBuffer());
				
				clearBuffer();
			}
			append(ConsoleProperties.getPrompt());
			
			ke.consume();
		} else
		if(ke.getKeyCode() == KeyEvent.VK_UP ||	ke.getKeyCode() == KeyEvent.VK_DOWN) {
			ke.consume();
		} else
		if(ke.getKeyCode() == KeyEvent.VK_LEFT) {
			ke.consume();
		} else
		if(ke.getKeyCode() == KeyEvent.VK_RIGHT) {
			ke.consume();
		} else
		if(ke.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
			forwardBackspace();
			ke.consume();
		} else {
			if(!ke.isAltDown() && !ke.isControlDown() && !ke.isMetaDown()) {
				if(ke.getKeyCode() != 16) {
					addToBuffer(ke.getKeyChar());
					append("" + ke.getKeyChar());
				}
			} else {
				// Ctrl+D exits the command prompt
				if(ke.getModifiers() == KeyEvent.CTRL_MASK && ke.getKeyCode() == KeyEvent.VK_D) {
					System.exit(0);
				}
			}
		}
	}
	
	protected void forwardBackspace() {
		if(getBuffer().length() > 0) {
			try {
				int bufferLength = getBuffer().length();
				String newBuffer = getBuffer().substring(0, (bufferLength - 1));
	
				int wordPosition = (getText()).lastIndexOf(getBuffer());
				String leftoverText = (getText()).substring(0, wordPosition);
				
				setBuffer(newBuffer);
				setText(leftoverText + getBuffer());
			} catch(Exception e) {
				ExceptionHandler.logException(e);
			}
		}
	}
	
	protected String getText() {
		String returnText = ta.getText();
		
		return returnText;
	}
	
	protected void setText(String text) {
		ta.setText(text);
	}
	
	protected void append(String text) {
		ta.append(text);
	}
	
	protected void addToBufferHistory(String command) {
		ConsoleProperties.addToBufferHistory(command);
	}
	
	protected void clearBuffer() {
		ConsoleProperties.clearBuffer();
	}
	
	protected String getBuffer() {
		String tempBuffer = ConsoleProperties.getBuffer();
		
		return tempBuffer;
	}
	
	protected void setBuffer(String str) {
		ConsoleProperties.setBuffer(str);
	}
	
	protected void addToBuffer(String str) {
		ConsoleProperties.addToBuffer(str);
	}
	
	protected void addToBuffer(char chr) {
		ConsoleProperties.addToBuffer(chr);
	}
	
	protected void handleCommand(String buffer) {
		/* TODO: I need to do something to handle the command,
		 *
		 * 1. Check command in dictionary
		 * 2. Do something related to the command
		 * 3. return to the Console
		 */
	}
	
	/*
	 * These methods belong to the KeyListener interface,
	 * but are not used by this program.
	 */
	public void keyReleased(KeyEvent ke) {}
	public void keyTyped(KeyEvent ke) {}
	
}
