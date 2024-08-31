package gameView;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import gameModel.GameData;
import guiBuilder.BuildBtn;
import guiBuilder.BuildCombo;
import guiBuilder.BuildLbl;
import guiBuilder.BuildTextBox;

public class CharacterWindow 
{
	//variables
	private JFrame frame;
	private JButton saveBtn;
	private JButton startGameBtn;
	private JButton backBtn;
	private JButton loadBtn;
	private JButton[] addStats;
	private JButton[] subStats;
	private String[] statNames = {"Str", "Dex", "Con", "Intel", "Wis", "Cha"};
	private JLabel[] attributeLbls;
	private JLabel[] attributeMods; 
	private String[] attributeNames = {"Strength", "Dexterity", "Constitution", "Intelligence", "Wisdom", "Charisma"};
	
	private JComboBox<String> dndClass;
	private JComboBox<String> dndBackground;
	private JComboBox<String> dndRace;
	private JComboBox<String> dndAlignment;
	private JComboBox<String> dndLevel;
	
	private JLabel nameDisplay;
	private JLabel dndClassDisplay;
	private JLabel playerBackgroundDisplay;
	private JLabel playerRaceDisplay;
	private JLabel playerAlignmentDisplay;
	private JLabel playerLevelDisplay;
	
	private JTextField playerName;
	
	
	public CharacterWindow(GameData gameData)
	{
		//initializing 
		attributeLbls = new JLabel[6];
		attributeMods = new JLabel[6];
		addStats = new JButton[statNames.length];
		subStats = new JButton[statNames.length];
		//methods for creating and adding to the window
		initializeFrame();
		initializeBtns();
		initializeLbls();
		initializeTextBox();
		initializeComboBox();
	}
	
	private void initializeFrame()
	{
		//initializes a new frame
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setSize(1200, 900);
		frame.setLayout(null);
	}
	private void initializeBtns()
	{
		//creates buttons using a helper method
		startGameBtn = buildBtnHelper("Start Game", 200, 700, 100, 30);
		saveBtn = buildBtnHelper("Save Character", 400, 700, 100, 30);
		loadBtn = buildBtnHelper("Load Character", 600, 700, 100, 30);
		backBtn = buildBtnHelper("Back", 800, 800, 100, 30);
		
		// using a loop and the helper method to make a set of buttons and add them to the frame
		for(int i = 0; i < statNames.length; i++) {
			addStats[i]  = buildBtnHelper("add" + statNames[i], 50, 100 + (i * 100), 75, 30);
			frame.add(addStats[i]);
		}
		for(int j = 0; j < statNames.length; j++)
		{
			
			subStats[j] = buildBtnHelper("sub" + statNames[j], 200, 100 + + (j * 100), 75, 30);
			
			frame.add(subStats[j]);
		}
		// adds buttons to the frame
		frame.add(startGameBtn);
		frame.add(saveBtn);
		frame.add(backBtn);
		frame.add(loadBtn);
		
	}
	private void initializeLbls()
	{	//dndClass, playerBackground, playerRace, playerAlignment, playerExperience;
		nameDisplay = buildLblHelper("Name: ", 400, 50, 100, 30);
		dndClassDisplay = buildLblHelper("Class", 550, 50, 100, 30);
		playerBackgroundDisplay = buildLblHelper("Background", 700, 50, 100, 30);
		playerRaceDisplay = buildLblHelper("Race", 400, 150, 100, 30);
		playerAlignmentDisplay = buildLblHelper("Alignment", 550, 150, 100, 30);
		playerLevelDisplay = buildLblHelper("Level", 700, 150, 100, 30);
		
		
		
		for(int i = 0; i < attributeNames.length; i++)
		{
			JLabel label = buildLblHelper(attributeNames[i], 140, 60 + (i * 100), 60, 30); 
			frame.add(label);
		}
		
		for(int i = 0; i < attributeLbls.length; i++)
		{
			
			attributeLbls[i] = buildLblHelper("8", 160, 100+(i*100), 60,30);
			frame.add(attributeLbls[i]);
		}
		
		for(int i = 0; i < attributeMods.length; i++)
		{
			attributeMods[i] = buildLblHelper("-1", 160, 120 + (i * 100), 60, 30);
			frame.add(attributeMods[i]);
		}
		//dndClass, playerBackground, playerRace, playerAlignment, playerExperience;
		frame.add(nameDisplay);
		frame.add(dndClassDisplay);
		frame.add(playerBackgroundDisplay);
		frame.add(playerRaceDisplay);
		frame.add(playerAlignmentDisplay);
		frame.add(playerLevelDisplay);
	}
	private void initializeTextBox()
	{
		playerName = buildTextHelper(400, 30, 100, 30);
		frame.add(playerName);
	}
	private void initializeComboBox()
	{
		//dndClass, playerBackground, playerRace, playerAlignment, playerLevel;
		
		dndClass = buildComboHelper(550, 30, 100, 30);
		dndBackground = buildComboHelper(700, 30, 100, 30);
		dndRace = buildComboHelper(400, 130, 100, 30);
		dndAlignment = buildComboHelper(550, 130, 100, 30);
		dndLevel = buildComboHelper(700, 130, 100, 30);
		
		frame.add(dndClass);
		frame.add(dndBackground);
		frame.add(dndRace);
		frame.add(dndAlignment);
		frame.add(dndLevel);
		
	}
	
	
	// button helper method
	private JButton buildBtnHelper(String text, int x, int y, int width, int height)
	{
		//builder pattern
		JButton button = new BuildBtn().setText(text)
				.setX(x)
				.setY(y)
				.setWidth(width)
				.setHeight(height)
				.build();
		return button;
	}
	
	private JLabel buildLblHelper(String text, int x, int y, int width, int height)
	{
		JLabel label = new BuildLbl().setText(text)
				.setX(x)
				.setY(y)
				.setWidth(width)
				.setHeight(height)
				.build();
		return label;
	}
	
	private JTextField buildTextHelper(int x, int y, int width, int height)
	{
		JTextField textField = new BuildTextBox().setX(x)
				.setY(y)
				.setWidth(width)
				.setHeight(height)
				.build();
		return textField;
	}
	
	private JComboBox<String> buildComboHelper(int x, int y, int width, int height)
	{
		JComboBox<String> comboBox = new BuildCombo().setX(x)
				.setY(y)
				.setWidth(width)
				.setHeight(height)
				.build();
		return comboBox;
	}
	public JButton getStartGameBtn()
	{
		return startGameBtn;
	}
	public JButton getSaveBtn()
	{
		return saveBtn;
	}
	public JButton getLoadBtn()
	{
		return loadBtn;
	}
	public JButton getBackBtn()
	{
		return backBtn;
	}
	public void setClassArray(String[] array)
	{
		for(String arr : array)
		{
			dndClass.addItem(arr);
		}
	}
	//dndClass, playerBackground, playerRace, playerAlignment, playerLevel;
	public void setDndBackground(String[] array)
	{
		for(String arr: array)
		{
			dndBackground.addItem(arr);
		}
	}
	
	public void setDndRace(String[] array)
	{
		for(String arr: array)
		{
			dndRace.addItem(arr);
		}
	}
	public void setDndAlignment(String[] array)
	{
		for(String arr : array)
		{
			dndAlignment.addItem(arr);
		}
	}
	public void setDndLevel(String[] array)
	{
		for(String arr : array)
		{
			dndLevel.addItem(arr);
		}
	}
	public JButton getAddStat(int num)
	{
		if(num >= 0 && num <= 5)
		{
			return addStats[num];
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Error");
			return null;
		}
		
		
	}
	public JButton getSubStat(int num)
	{
		if(num >= 0 && num <= 5)
		{
			return subStats[num];
			
		}
		else {
			JOptionPane.showMessageDialog(null, "Error");
			return null;
		}
	}
	
	
	//switch case getting a label from the array and updating it
	public void updateLbl(int stat, int num)
	{
		switch(num)
		{
		case 0:
			attributeLbls[0].setText(String.valueOf(stat).toString());
			break;
		case 1:
			attributeLbls[1].setText(String.valueOf(stat).toString());
			break;
		case 2:
			attributeLbls[2].setText(String.valueOf(stat).toString());
			break;
		case 3:
			attributeLbls[3].setText(String.valueOf(stat).toString());
			break;
		case 4:
			attributeLbls[4].setText(String.valueOf(stat).toString());
			break;
		case 5:
			attributeLbls[5].setText(String.valueOf(stat).toString());
			break;
		}
	}
	//switch statement getting the attribute modifier from the array and updating it 
	public void updateModLbl(int stat, int num)
	{
		switch(num)
		{
		case 0:
			if(stat > 0)
			{
				attributeMods[0].setText("+ " + String.valueOf(stat));
			}
			else
				attributeMods[0].setText(String.valueOf(stat));
			break;
		case 1:
			if(stat > 0)
			{
				attributeMods[1].setText("+ " + String.valueOf(stat));
			}
			else
				attributeMods[1].setText(String.valueOf(stat));
			break;
		case 2:
			if(stat > 0)
			{
				attributeMods[2].setText("+ " + String.valueOf(stat));
			}
			else
				attributeMods[2].setText(String.valueOf(stat));
			break;
		case 3:
			if(stat > 0)
			{
				attributeMods[3].setText("+ " + String.valueOf(stat));
			}
			else
				attributeMods[3].setText(String.valueOf(stat));
			break;
		case 4:
			if(stat > 0)
			{
				attributeMods[4].setText("+ " + String.valueOf(stat));
			}
			else
				attributeMods[4].setText(String.valueOf(stat));
			break;
		case 5:
			if(stat > 0)
			{
				attributeMods[5].setText("+ " + String.valueOf(stat));
			}
			else
				attributeMods[5].setText(String.valueOf(stat));
			break;
		}
	}
	// method to show the window
	public void showWindow()
	{
		frame.setVisible(true);
	}
	//method to hide the window
	public void hideWindow()
	{
		frame.setVisible(false);
	}

	
}
