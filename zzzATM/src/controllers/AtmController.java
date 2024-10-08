package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import models.AtmData;
import models.Database;
import views.AtmWindow;
import views.AtmWindow;

public class AtmController implements ActionListener {
	private AtmWindow window;
	private AtmWindow atmWindow;
	private AtmData data;
	private Database db;
	public AtmController(AtmWindow window, AtmData data)
	{
		this.window = window;
		this.data = data;
		
		db = new Database(window);
		getSubmitBtn();
		getCreateBtn();
	}
	
	public void atmWindow()
	{
		window.getWindow();
	}
	
	public void getSubmitBtn() {
		addListener(window.getSubmit(), this);
	}
	
	public void getCreateBtn() {
		addListener(window.getCreate(), this);
	}
	
	public void addListener(JButton button, ActionListener listener)
	{
		button.addActionListener(listener);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
	    
	    if (source == window.getSubmit()) {
	        String userNum = window.getUser();
	        String userPin = window.getPin();
	        
	      
	        if (userNum == null || userPin == null || userNum.isEmpty() || userPin.isEmpty()) {
	            JOptionPane.showMessageDialog(window.getFrame(), "Please fill in both fields.", "Input Error", JOptionPane.ERROR_MESSAGE);
	            return; 
	        }

	        try {
	            
	            int numValue = Integer.parseInt(userNum);
	            int pinValue = Integer.parseInt(userPin);

	            if (db.authenticate(numValue, pinValue)) {
	            	
	            } else {
	            	JOptionPane.showMessageDialog(window.getFrame(), "User Num and Pin do not match!", "Input Error", JOptionPane.ERROR_MESSAGE);
	            }

	        } catch (NumberFormatException ex) {
	         
	            JOptionPane.showMessageDialog(window.getFrame(), "Please enter a valid integer.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
	        }
	    }
	    else if (source == window.getCreate()) 
	    {
	    	String userNum = window.getUser();
	        String userPin = window.getPin();
	        
	      
	        if (userNum == null || userPin == null || userNum.isEmpty() || userPin.isEmpty()) {
	            JOptionPane.showMessageDialog(window.getFrame(), "Please fill in both fields.", "Input Error", JOptionPane.ERROR_MESSAGE);
	            return; 
	        }

	        try {
	            
	            int numValue = Integer.parseInt(userNum);
	            int pinValue = Integer.parseInt(userPin);

	            db.createUser(numValue, pinValue);

	        } catch (NumberFormatException ex) {
	         
	            JOptionPane.showMessageDialog(window.getFrame(), "Please enter a valid integer.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
	        }
	    }
	}
}
