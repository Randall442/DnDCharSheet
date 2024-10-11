package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import models.Database;
import views.AttributePanel;
import views.MainWindow;

public class AttributeController implements ActionListener
{
	private Database db;
	private MainWindow window;
	private AttributePanel attribute;
	private JButton[] addBtns;
	private JButton[] subBtns;
	private String[] statNum;
	private String[] statModNum;
	
	public AttributeController(Database db, MainWindow window)
	{
		this.db = db;
		this.window = window;
		this.attribute = window.getAttributePanel();
		
		
		addStatBtns();
		subStatBtns();
	}
	
	
	public void addStatBtns()
	{
		addBtns = window.addBtns();
		
		for(JButton btns : addBtns)
		{
			btns.addActionListener(this);
		}
		
	}
	public void subStatBtns()
	{
		subBtns = window.subBtns();
		
		for(JButton btns : subBtns)
		{
			btns.addActionListener(this);
		}
	}


	@Override
	public void actionPerformed(ActionEvent e) 
	{
		Object source = e.getSource();
		
		if(source == addBtns[0])
		{
			
		} 
		else if(source == addBtns[1])
		{
			System.out.println("dex");
			
		} 
		else if(source == addBtns[2])
		{
			System.out.println("con");
			
		} 
		else if(source == addBtns[3])
		{
			System.out.println("intel");
			
		} 
		else if(source == addBtns[4])
		{
			System.out.println("wis");
			
		} 
		else if(source == addBtns[5])
		{
			System.out.println("cha");
		} 
		
		
		if(source == subBtns[0])
		{
			System.out.println("str");
			
		} 
		else if(source == subBtns[1])
		{
			System.out.println("dex");
			
		} 
		else if(source == subBtns[2])
		{
			System.out.println("con");
			
		} 
		else if(source == addBtns[3])
		{
			System.out.println("intel");
			
		} 
		else if(source == subBtns[4])
		{
			System.out.println("wis");
			
		} 
		else if(source == subBtns[5])
		{
			System.out.println("cha");
		}
		
	}
	
	
}
