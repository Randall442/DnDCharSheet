package views;

import java.awt.BorderLayout;

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
		characterInfoLbls(charName, charLevel, charBackground, charRace);
		
		
		
		showCharacterWindow();
		
	}

	
	public void characterInfoLbls(String text, int num, String textTwo, String textThree)
	{
		JPanel panel = new JPanel();
		
		JLabel name = new JLabel("Name: " + text);
		
		JLabel charClass = new JLabel ("Class: " + text);
		JLabel charLevel = new JLabel ("Level: " + num);
		JLabel charBackground = new JLabel ("Background: " + textTwo);
		JLabel charRace = new JLabel("Race: " + textThree);
		
	
		
		panel.add(name);
		
		characterFrame.add(panel);
	}
	public JPanel characterStatLbls() 
	{
		JPanel panel = new JPanel();
		
		return panel;
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
