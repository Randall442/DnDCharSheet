package views;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class CharacterWindow {

	
	private JFrame characterFrame;
	private JLabel characterName;
	
	
	public CharacterWindow()
	{
		
		
	}
	public void populateWindow(String charName, int charLevel, String charBackground, String charRace, String charAlignment, 
			String charClass, int charStrength, int charDexterity, int charConstitution, int charIntelligence, 
			int charWisdom, int charCharisma, int charHitPoints, int charArmorClass, int charSpeed, int charInitiative)
	{
		characterFrame = new JFrame();
		characterFrame.setSize(600,400);
		characterFrame.setLayout(new BorderLayout());
		characterInfoLbls(charName, charLevel, charBackground, charRace, charAlignment, charClass, charStrength, charDexterity,
				          charConstitution, charIntelligence, charWisdom, charCharisma, charHitPoints, charArmorClass,
				          charSpeed, charInitiative);
		
		
		
		showCharacterWindow();
		
	}

	
	public void characterInfoLbls(String nameText, int level, String backgroundText, String raceText, String alignmentText, String classText,
								  int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma,
								  int hitPoints, int armorClass, int speed, int initiative)
	{
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0, 2));
		JLabel name = new JLabel("Name: " + nameText);
		
		
		JLabel charLevel = new JLabel ("Level: " + level);
		JLabel charBackground = new JLabel ("Background: " + backgroundText);
		JLabel charRace = new JLabel("Race: " + raceText);
		JLabel charAlignment = new JLabel("Alignment: " + alignmentText);
		JLabel charClass = new JLabel ("Class: " + classText);
		JLabel charStrength = new JLabel("Strength: " + strength);
		JLabel charDexterity = new JLabel("Dexterity: " + dexterity);
		JLabel charConstitution = new JLabel("Constitution: " + constitution);
		JLabel charIntelligence = new JLabel("Intelligence: " + intelligence);
		JLabel charWisdom = new JLabel("Wisdom: " + wisdom);
		JLabel charCharisma = new JLabel("Charisma: " + charisma);
		
		
		panel.add(name);
		
		panel.add(charLevel);
		panel.add(charBackground);
		panel.add(charRace);
		panel.add(charAlignment);
		panel.add(charClass);
		panel.add(charStrength);
		panel.add(charDexterity);
		panel.add(charConstitution);
		panel.add(charIntelligence);
		panel.add(charWisdom);
		panel.add(charCharisma);
		
		
		characterFrame.add(panel);
	}
	
	public JFrame characterFrame()
	{
		return characterFrame;
	}
	public void hideCharacterWindow()
	{
		characterFrame.setVisible(false);
	}
	public void showCharacterWindow()
	{
		characterFrame.setVisible(true);
	}
	
	public void setCharacterName(String text)
	{
		characterName.setText(text);
	}
	
	
}
