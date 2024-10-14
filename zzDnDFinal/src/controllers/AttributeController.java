package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import models.Database;
import models.ModelLogic;
import views.AttributePanel;
import views.MainWindow;

public class AttributeController implements ActionListener
{
	private Database db;
	private ModelLogic logic;
	private MainWindow window;
	private AttributePanel attribute;
	private JButton[] addBtns;
	private JButton[] subBtns;
	private int statPoints;
	
	private int[] attributes;
	
	public AttributeController(Database db, MainWindow window, ModelLogic logic)
	{
		this.db = db;
		this.window = window;
		this.logic = logic;
		this.attribute = window.getAttributePanel();
		
		logic.setTotalStatPoints(27);
		statPoints = logic.getTotalStatPoints();
		
		logic.setCharStrength(8);
		logic.setCharDexterity(8);
		logic.setCharConstitution(8);
		logic.setCharIntelligence(8);
		logic.setCharWisdom(8);
		logic.setCharCharisma(8);
		
		attributes = attribute.getStatNum();
		
		attributes[0] = logic.getCharStrength();
		attributes[1] = logic.getCharDexterity();
		attributes[2] = logic.getCharConstitution();
		attributes[3] = logic.getCharIntelligence();
		attributes[4] = logic.getCharWisdom();
		attributes[5] = logic.getCharCharisma();
		
		attribute.setStatNum(attributes);
		
		
		window.getAttributePanel().setTotalStatPoints(statPoints);
		
		
		
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
		int totalPoints = logic.getTotalStatPoints();
		if(source == addBtns[0])
		{
			addStats(0);
		} 
		else if(source == addBtns[1])
		{
			addStats(1);
		} 
		else if(source == addBtns[2])
		{
			addStats(2);
		} 
		else if(source == addBtns[3])
		{
			addStats(3);
		} 
		else if(source == addBtns[4])
		{
			addStats(4);
		} 
		else if(source == addBtns[5])
		{
			addStats(5);
		} 
		
		
		if(source == subBtns[0])
		{
			subStats(0);
		} 
		else if(source == subBtns[1])
		{
			subStats(1);
		} 
		else if(source == subBtns[2])
		{
			subStats(2);
			
		} 
		else if(source == subBtns[3])
		{
			subStats(3);
		} 
		else if(source == subBtns[4])
		{
			subStats(4);
		} 
		else if(source == subBtns[5])
		{
			subStats(5);
		}
		
	}
	private void addStats(int index)
	{
		if (statPoints > 0 && attributes[index] < 15)
		{
			int cost = (attributes[index] >= 13) ? 2 : 1;
			
			if(statPoints >= cost)
			{
				attributes[index]++;
				statPoints -= cost;
				
				updateModel(index);
				
			}
			
			
		}
	}
	private void subStats(int index)
	{
		if(attributes[index] > 8)
		{
			int cost = (attributes[index] > 13) ? 2 : 1;
			attributes[index]--;
			statPoints += cost;
			
			updateModel(index);
			
		}
	}
	private void updateModel(int index) {
	    switch (index) {
	        case 0:
	            logic.setCharStrength(attributes[index]);
	            break;
	        case 1:
	            logic.setCharDexterity(attributes[index]);
	            break;
	        case 2:
	            logic.setCharConstitution(attributes[index]);
	            break;
	        case 3:
	            logic.setCharIntelligence(attributes[index]);
	            break;
	        case 4:
	            logic.setCharWisdom(attributes[index]);
	            break;
	        case 5:
	            logic.setCharCharisma(attributes[index]);
	            break;
	    }
	    updateLabels();
	}
	private void updateLabels() {
		attribute.setStatNum(attributes);  
		attribute.setTotalStatPoints(statPoints);  

		attribute.getAttributePanel().revalidate();
		attribute.getAttributePanel().repaint();
    }
	
}
