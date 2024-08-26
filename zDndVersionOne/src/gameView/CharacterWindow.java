package gameView;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import gameModel.GameData;
import guiBuilder.BuildBtn;
import guiBuilder.BuildLbl;

public class CharacterWindow 
{
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
	
	
	
	public CharacterWindow(GameData gameData)
	{
		attributeLbls = new JLabel[6];
		attributeMods = new JLabel[6];
		addStats = new JButton[statNames.length];
		subStats = new JButton[statNames.length];
		
		initializeFrame();
		initializeBtns();
		initializeLbls();
		initializeTextBox();
		initializeComboBox();
	}
	
	private void initializeFrame()
	{
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setSize(1200, 900);
		frame.setLayout(null);
	}
	private void initializeBtns()
	{
		startGameBtn = buildBtnHelper("Start Game", 200, 800, 100, 30);
		saveBtn = buildBtnHelper("Save Character", 400, 800, 100, 30);
		loadBtn = buildBtnHelper("Load Character", 600, 800, 100, 30);
		backBtn = buildBtnHelper("Back", 800, 800, 100, 30);
		
		for(int i = 0; i < statNames.length; i++) {
			addStats[i]  = buildBtnHelper("add" + statNames[i], 50, 100 + (i * 100), 75, 30);
			frame.add(addStats[i]);
		}
		for(int j = 0; j < statNames.length; j++)
		{
			
			subStats[j] = buildBtnHelper("sub" + statNames[j], 200, 100 + + (j * 100), 75, 30);
			
			frame.add(subStats[j]);
		}
		
		frame.add(startGameBtn);
		frame.add(saveBtn);
		frame.add(backBtn);
		frame.add(loadBtn);
		
	}
	private void initializeLbls()
	{
		
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
	}
	private void initializeTextBox()
	{
		
	}
	private void initializeComboBox()
	{
		
	}
	
	
	
	private JButton buildBtnHelper(String text, int x, int y, int width, int height)
	{
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
				attributeMods[0].setText("+ " + String.valueOf(stat));
			}
			else
				attributeMods[0].setText(String.valueOf(stat));
			break;
		case 2:
			if(stat > 0)
			{
				attributeMods[0].setText("+ " + String.valueOf(stat));
			}
			else
				attributeMods[0].setText(String.valueOf(stat));
			break;
		case 3:
			if(stat > 0)
			{
				attributeMods[0].setText("+ " + String.valueOf(stat));
			}
			else
				attributeMods[0].setText(String.valueOf(stat));
			break;
		case 4:
			if(stat > 0)
			{
				attributeMods[0].setText("+ " + String.valueOf(stat));
			}
			else
				attributeMods[0].setText(String.valueOf(stat));
			break;
		case 5:
			if(stat > 0)
			{
				attributeMods[0].setText("+ " + String.valueOf(stat));
			}
			else
				attributeMods[0].setText(String.valueOf(stat));
			break;
		}
	}
	public void showWindow()
	{
		frame.setVisible(true);
	}
	public void hideWindow()
	{
		frame.setVisible(false);
	}

	
}
