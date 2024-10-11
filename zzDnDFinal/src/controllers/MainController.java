package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import models.Database;
import views.MainWindow;

public class MainController implements ActionListener {
	
	private Database db;
	private MainWindow window;
	private JButton[] addBtns;
	public MainController(Database db, MainWindow window)
	{
		this.db = db;
		this.window = window;
		
		
	}
	
	public JFrame getWindow()
	{
		return window.getWindow();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	
}
