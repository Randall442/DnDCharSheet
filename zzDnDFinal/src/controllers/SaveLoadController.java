package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import models.Database;
import models.ModelLogic;
import views.LoadCharacterPanel;
import views.MainWindow;

public class SaveLoadController implements ActionListener{

	private Database db;
	
	private MainWindow window;
	private JButton saveBtn;
	private JButton loadBtn;
	private LoadCharacterPanel loadCharacterPanel;
	private ModelLogic logic;
	private JFrame errorFrame;
	private String charName;
	private int charLevel;
	private int charBackground;
	private String charBackgroundString;
	private int charRace;
	private String charRaceString;
	private int charAlignment;
	private String charAlignmentString;
	private int charClass;
	private String charClassString;
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
	
	public SaveLoadController(Database db, MainWindow window, ModelLogic logic)
	{
		this.db = db;
		this.window = window;
		this.loadCharacterPanel = window.loadCharacterPanel();
		this.logic = logic;
		
		
		saveBtn = window.getSaveCharBtn();
		loadBtn = window.getLoadCharBtn();
		
		saveBtn.addActionListener(this);
		loadBtn.addActionListener(this);
		
		
		for(int i = 0; i < 100; i++)
		{
			String text = db.getOneName(i);
			window.loadCharacterPanel().setListModel(i, text);
		}
		
	}
	
	public void getDatabaseNames()
	{
		db.getCharacterNames();
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(source == loadBtn) {
			
			int selectedIndex = window.loadCharacterPanel().getListIndex();
	            db.getCharInfo(selectedIndex);  
	            
	            System.out.println(selectedIndex);
	       
	            
	            
	       
	            charName = db.getName();
	            charLevel = 1;
	            charBackgroundString = db.getBackground();
	            charRaceString = db.getRace();
	            charAlignmentString = db.getAlignment();
	            charClassString = db.getClassName();
	            charStrength = db.getStrength();
	            charDexterity = db.getDexterity();
	            charConstitution = db.getConstitution();
	            charIntelligence = db.getIntelligence();
	            charWisdom = db.getWisdom();
	            charCharisma = db.getCharisma();
	            charHitPoints = 1;
	            charArmorClass = 1;
	            charSpeed = 1;
	            charInitiative = 1;
	            
	   
	            window.getCharacterWindow().populateWindow(charName, charLevel, charBackgroundString, charRaceString, charAlignmentString,
	                    charClassString, charStrength, charDexterity, charConstitution, charIntelligence,
	                    charWisdom, charCharisma, charHitPoints, charArmorClass, charSpeed, charInitiative);
			
			
	        
		}
		else if (source == saveBtn)
		{
			
            	charName = window.getInfoPanel().getPlayerNameInput();
    			logic.setCharName(charName);
    			
    			charLevel = 1;
    			logic.setCharLevel(charLevel);
    			
    			charBackground = window.getInfoPanel().getPlayerBackgroundSelect() + 1;
    			logic.setCharBackground(charBackground);
    			
    			charRace = window.getInfoPanel().getPlayerRaceSelect() + 1;
    			logic.setCharRace(charRace);
    			
    			charAlignment = window.getInfoPanel().getPlayerAlignmentSelect() + 1;
    			logic.setCharAlignment(charAlignment);
    			
    			charClass = window.getInfoPanel().getPlayerClassSelect() + 1;
    			logic.setCharClass(charClass);
    			
    			int[] statNum = window.getAttributePanel().getStatNum();
    			
    			
    			charStrength = statNum[0];
    			logic.setCharStrength(charStrength);
    			
    			charDexterity = statNum[1];
    			logic.setCharStrength(charDexterity);
    			
    			charConstitution = statNum[2];
    			logic.setCharStrength(charConstitution);
    			
    			charIntelligence = statNum[3];
    			logic.setCharStrength(charIntelligence);
    			
    			charWisdom = statNum[4];
    			logic.setCharStrength(charWisdom);
    			
    			charCharisma = statNum[5];
    			logic.setCharStrength(charCharisma);
    			
    			charHitPoints = 8;
    			logic.setCharHitPoints(charHitPoints);
    			
    			charArmorClass = 11;
    			logic.setCharArmorClass(charArmorClass);
    			
    			charSpeed = 1;
    			logic.setCharSpeed(charSpeed);
    			
    			charInitiative = 1;
    			logic.setCharInitiative(charInitiative);
    			
    			db.createCharacter(charName, charLevel, charBackground, charRace, charAlignment, 
    					charClass, charStrength, charDexterity, charConstitution, charIntelligence, 
    					charWisdom, charCharisma, charHitPoints, charArmorClass, charSpeed, charInitiative);
    			
          
			
			
		}
			
			
	}
		
}
