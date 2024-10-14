package views;

import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class MainWindow {
	
	private JFrame mainWindow;

	private AttributePanel attributes;
	private InfoPanel information;
	private LoadCharacterPanel loadCharacterPanel;
	private CharacterWindow characterWindow;
	
	
	public MainWindow()
	{
		mainWindow = new JFrame("Main Window");
		mainWindow.setLayout(new BorderLayout());
		
		mainWindow.setSize(1000, 1000);
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel mainPanel = new JPanel();
		JPanel bugPanel = knownBugs();
		mainPanel.setLayout(new BorderLayout());
		
		attributes = new AttributePanel();
		information = new InfoPanel();
		loadCharacterPanel = new LoadCharacterPanel();
		characterWindow = new CharacterWindow();
		
		mainPanel.add(attributes.getAttributePanel(), BorderLayout.WEST);
		mainPanel.add(information.getInformationPanel(), BorderLayout.NORTH);
		mainPanel.add(loadCharacterPanel.getCharPanel(), BorderLayout.SOUTH);
		mainPanel.add(bugPanel, BorderLayout.EAST);
		
		
		
	    mainWindow.add(mainPanel, BorderLayout.CENTER);
	        
		mainWindow.setResizable(false);
		mainWindow.setVisible(true);
	}
	
	private JPanel knownBugs()
	{
		JPanel panel = new JPanel();
		JTextArea area = new JTextArea();
		area.setText("BUG LIST \n"
				+ "1. Modifiers do not work atm.\n 2. Saving a character requires a "
				+ "restart to show the newly created character in the window list. \n"
				+ "3. Can enter an empty character name. "
				+ "4. Levels are not implemented.");
		
						
								
		panel.add(area);
	
		return panel;
	}
	
	public JFrame getWindow()
	{
		return mainWindow;
	}
	public JButton[] addBtns()
	{
		return attributes.getAddBtns();
	}
	public JButton[] subBtns()
	{
		return attributes.getSubBtns();
	}
	public int[] getStatNum()
	{
		return attributes.getStatNum();
	}
	public void setStatNum(String[] statNum)
	{
		
	}
	public int[] getStatModNum()
	{
		return attributes.getStatModNum();
	}
	public AttributePanel getAttributePanel() {
		return attributes;
	}
	public InfoPanel getInfoPanel()
	{
		return information;
	}
	public LoadCharacterPanel loadCharacterPanel()
	{
		return loadCharacterPanel;
	}
	public JButton getSaveCharBtn()
	{
		return loadCharacterPanel.getSaveBtn();
	}
	public JButton getLoadCharBtn()
	{
		return loadCharacterPanel.getLoadBtn();
	}
	public CharacterWindow getCharacterWindow()
	{
		return characterWindow;
	}
}
