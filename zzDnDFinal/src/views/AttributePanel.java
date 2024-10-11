package views;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AttributePanel 
{
	
	private JPanel attributePanel;
	
	private String[] statNum = {"8", "8",  "8", "8", "8", "8"};
	private String[] statModNum = {"0", "0", "0", "0", "0", "0"};
	private int totalStatPoints;
	private JButton[] addBtns = new JButton[6];
	private JButton[] subBtns  = new JButton[6];
	private Map<String, JLabel> statLblMap = new HashMap<>();
	private Map<String, Integer> statValueMap = new HashMap<>();
	private JLabel totalStats;
	
	
	public AttributePanel()
	{
		attributePanel = new JPanel();
		attributePanel.setLayout(new GridBagLayout());
		
		totalStatPoints = 27;
		
		String[] attributeNames = {"Strength", "Dexterity", "Constitution", "Intelligence", "Wisdom", "Charisma"};
		createStatLbls(attributeNames);
		createStatBtns(attributeNames);
		
		
	}
	
	public void createStatLbls(String[] stats)
	{
		
		totalStats = new JLabel();
		GridBagConstraints gbc = new GridBagConstraints();
		GridBagConstraints gbcTwo = new GridBagConstraints();
		GridBagConstraints gbcThree = new GridBagConstraints();
		GridBagConstraints gbcTotal = new GridBagConstraints();
		for(int i = 0; i < stats.length; i++) 
		{
			String statName = stats[i];
			
			
			JLabel stat = new JLabel(statName);
		
			JLabel statMod = new JLabel(statModNum[i]);
			JLabel statLbl = new JLabel(statNum[i]);
			
			getStatLblMap().put(statName, statLbl);
			statValueMap.put(statName, 0);
			
			
			gbc.gridx = 2;
			gbc.gridy = i * 3;
			
			
			gbcTwo.gridx = 2;
			gbcTwo.gridy = i * 3 + 1;
			
			gbcThree.gridx = 2;
			gbcThree.gridy = i * 3 + 2;
			
			
			attributePanel.add(stat, gbc);
			attributePanel.add(statLbl, gbcTwo);
			attributePanel.add(statMod, gbcThree);
			
		}
		
		gbcTotal.gridx = 2;
		gbcTotal.gridy = 19;
		totalStats = new JLabel("Total Points: " + String.valueOf(totalStatPoints));
		attributePanel.add(totalStats, gbcTotal);
	}
	
	public void createStatBtns(String[] stats)
	{
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		for(int i = 0; i < addBtns.length; i++)
		{
			addBtns[i] = new JButton("+");
			
			gbc.gridx = 3;
			gbc.gridy = i * 3;
			gbc.insets = new Insets(5, 5, 5, 5);
			
			attributePanel.add(addBtns[i], gbc);
		}
		
		for(int i = 0; i < subBtns.length; i++)
		{
			subBtns[i] = new JButton("-");
			
			gbc.gridx = 0;
			gbc.gridy = i * 3;
			gbc.insets = new Insets(5, 5, 5, 5);
			
			attributePanel.add(subBtns[i], gbc);
		}
	}
	
	public String[] getStatNum()
	{
		return statNum;
	}
	public void setStatNum(String[] statNum)
	{
		this.statNum = statNum;
	}
	public String[] getStatModNum()
	{
		return statModNum;
	}
	public JPanel getAttributePanel()
	{
		return attributePanel;
	}
	
	public JButton[] getAddBtns()
	{
		return addBtns;
	}
	public JButton[] getSubBtns()
	{
		return subBtns;
	}
	public JLabel getTotalStats()
	{
		return totalStats;
	}
	public void setTotalStats(JLabel totalStats)
	{
		this.totalStats = totalStats;
	}
	public Map<String, JLabel> getStatLblMap() {
		return statLblMap;
	}

	public void setStatLblMap(Map<String, JLabel> statLblMap) {
		this.statLblMap = statLblMap;
	}
	public int getTotalStatPoints()
	{
		return totalStatPoints;
	}
	public void setTotalStatPoints(int totalStatPoints)
	{
		this.totalStatPoints = totalStatPoints;
	}
}
