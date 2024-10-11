package views;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.List;
import java.awt.GridBagConstraints;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InfoPanel {
	
	private JPanel infoPanel;
	private JTextField playerNameInput;
	
	private JComboBox<String> playerClassSelect;
	private JComboBox<String> playerBackgroundSelect;
	private JComboBox<String> playerRaceSelect;
	private JComboBox<String> playerAlignmentSelect;
	private JComboBox<String> playerLevelSelect;
	
	public InfoPanel()
	{
		infoPanel = new JPanel();
		infoPanel.setLayout(new GridBagLayout());
		InfoTextFields();
	}
	
	public void InfoTextFields()
	{
		
		GridBagConstraints gbcName = new GridBagConstraints();
		
		JLabel playerNameLbl = gbcLabelHelper(0, 1, "Player Name");
		
		playerNameInput = new JTextField();
		playerNameInput.setPreferredSize(new Dimension(100,25));
		gbcName.gridx = 0;
		gbcName.gridy = 0;
		infoPanel.add(playerNameInput, gbcName);
		
		JLabel classSelectLbl = gbcLabelHelper(1, 1, "Class");
		playerClassSelect = gbcHelper(1,0);
		playerClassSelect.setPreferredSize(new Dimension(100, 25));
		
		JLabel backgroundSelectLbl = gbcLabelHelper( 2, 1, "Background");
		playerBackgroundSelect = gbcHelper(2,0);
		playerBackgroundSelect.setPreferredSize(new Dimension(100, 25));
		
		JLabel raceSelectLbl = gbcLabelHelper( 0, 3, "Race");
		playerRaceSelect = gbcHelper(0, 2);
		playerRaceSelect.setPreferredSize(new Dimension(100, 25));
		
		JLabel alignmentSelectLbl = gbcLabelHelper( 1, 3, "Alignment");
		playerAlignmentSelect = gbcHelper(1, 2);
		playerAlignmentSelect.setPreferredSize(new Dimension(100, 25));
		
		JLabel levelSelectLbl = gbcLabelHelper(2, 3, "Level");
		playerLevelSelect = gbcHelper(2, 2);
		playerLevelSelect.setPreferredSize(new Dimension(100,25));
		
		
	}
	private JLabel gbcLabelHelper(int x, int y, String text)
	{
		GridBagConstraints gbc = new GridBagConstraints();
		JLabel label = new JLabel(text);
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.insets = new Insets(5, 5, 5, 5);
		infoPanel.add(label, gbc);
		return label;
	}
	
	private JComboBox<String> gbcHelper(int x, int y)
	{
		GridBagConstraints gbc = new GridBagConstraints();
		JComboBox<String> comboBox = new JComboBox<String>();
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.insets = new Insets(5, 5, 5, 5);
		infoPanel.add(comboBox, gbc);
		return comboBox;
	}
	public JPanel getInformationPanel()
	{
		return infoPanel;
	}
	public JComboBox<String> getPlayerBackgroundSelect() {
		return playerBackgroundSelect;
	}

	public void setPlayerBackgroundSelect(List<String> backgrounds) {
		for(String background : backgrounds)
		{
			playerBackgroundSelect.addItem(background);
		}
	}

	public JComboBox<String> getPlayerRaceSelect() {
		return playerRaceSelect;
	}

	public void setPlayerRaceSelect(List<String > races) {
		for(String race : races)
		{
			playerRaceSelect.addItem(race);
		}
	}

	public JComboBox<String> getPlayerAlignmentSelect() {
		return playerAlignmentSelect;
	}

	public void setPlayerAlignmentSelect(List<String> alignments) {
		
		for(String alignment : alignments)
		{
			playerAlignmentSelect.addItem(alignment);
		}
		
	}
	public void setPlayerClassSelect(List<String> playerClasses) {
		for(String playerClass : playerClasses)
		{
			playerClassSelect.addItem(playerClass);
		}
	}
	public JComboBox<String> getPlayerLevelSelect() {
		return playerLevelSelect;
	}

	public void setPlayerLevelSelect(JComboBox<String> playerLevelSelect) {
		this.playerLevelSelect = playerLevelSelect;
	}

	public void setPlayerNameInput(JTextField playerNameInput) {
		this.playerNameInput = playerNameInput;
	}

	
	
}
