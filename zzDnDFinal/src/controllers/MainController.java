package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import models.Database;
import models.ModelLogic;
import views.MainWindow;

public class MainController implements ActionListener {
	
	private Database db;
	private ModelLogic logic;
	private MainWindow window;
	private JButton[] addBtns;
	public MainController(Database db, MainWindow window, ModelLogic logic)
	{
		this.db = db;
		this.logic = logic;
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
