package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;

import models.Database;
import views.LoadCharacterPanel;
import views.MainWindow;

public class SaveLoadController implements ActionListener{

	private Database db;
	private MainWindow window;
	private JButton saveBtn;
	private JButton loadBtn;
	private LoadCharacterPanel loadCharacterPanel;
	
	private String charName;
	private int charLevel;
	private int charBackground;
	private int charRace;
	private int charAlignment;
	private int charClass;
	private int charStrength;
	private int charDexterity;
	private int charConstitution;
	private int charIntelligence;
	private int charWisdom;
	private int charCharisma;
	private int charHitPoints;
	private int charArmorClass;
	private int charSpeed;
	private int charInitiative;
	
	public SaveLoadController(Database db, MainWindow window)
	{
		this.db = db;
		this.window = window;
		this.loadCharacterPanel = window.loadCharacterPanel();
		
		saveBtn = window.getSaveCharBtn();
		loadBtn = window.getLoadCharBtn();
		
		saveBtn.addActionListener(this);
		loadBtn.addActionListener(this);
		
		String text = db.getOneName(1);
		
		
		
		
		
		window.loadCharacterPanel().setListModel(0, text);
	}
	
	public void getDatabaseNames()
	{
		db.getCharacterNames();
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(source == loadBtn) {
			
			
			
		}
		else if (source == saveBtn)
		{
			db.createCharacter(charName, charLevel, charBackground, charRace, charAlignment, 
					charClass, charStrength, charDexterity, charConstitution, charIntelligence, 
					charWisdom, charCharisma, charHitPoints, charArmorClass, charSpeed, charInitiative);
			
			
		}
	}
}
