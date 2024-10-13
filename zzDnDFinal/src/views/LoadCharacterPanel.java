package views;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import models.Database;

public class LoadCharacterPanel {

	private JList<String> characterList;
	private JButton loadBtn;
	private JButton saveBtn;
	private DefaultListModel<String> listModel;
	private JPanel loadCharPanel;
	
	public LoadCharacterPanel()
	{
		loadCharPanel = new JPanel();
		
		listModel = new DefaultListModel<>();
		
		loadBtn = new JButton("Load Character");
		saveBtn = new JButton("Save Character");
		
		characterList = new JList<>(listModel);
	
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		GridBagConstraints gbcTwo = new GridBagConstraints();
		gbcTwo.gridx = 0;
		gbcTwo.gridy = 1;
		GridBagConstraints gbcThree = new GridBagConstraints();
		gbcThree.gridx = 0;
		gbcThree.gridy = 2;
		
		JScrollPane characters = new JScrollPane (characterList);
		characters.setPreferredSize(new Dimension(200, 150));
		
		loadCharPanel.setLayout(new GridBagLayout());
		
		loadCharPanel.add(characters, gbc);
		loadCharPanel.add(saveBtn, gbcTwo);
		loadCharPanel.add(loadBtn, gbcThree);
		
	}
	
	public JPanel getCharPanel()
	{
		return loadCharPanel;
	}
	public JButton getLoadBtn()
	{
		return loadBtn;
	}
	public JButton getSaveBtn()
	{
		return saveBtn;
	}
	public DefaultListModel<String> getListModel()
	{
		return listModel;
	}
	public void setListModel(int index, String text)
	{
		listModel.add(index, text);
	}
	
	public JList<String> getCharacterList()
	{
		return characterList;
	}

	public int getListIndex()
	{
		return characterList.getSelectedIndex();
	}
	
}

