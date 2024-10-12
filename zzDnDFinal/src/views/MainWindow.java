package views;

import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainWindow {
	
	private JFrame mainWindow;

	private AttributePanel attributes;
	private InfoPanel information;
	private LoadCharacterPanel loadCharacterPanel;
	
	
	
	public MainWindow()
	{
		mainWindow = new JFrame("Main Window");
		mainWindow.setLayout(new BorderLayout());
		
		mainWindow.setSize(800, 600);
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		
		attributes = new AttributePanel();
		information = new InfoPanel();
		loadCharacterPanel = new LoadCharacterPanel();
		
		mainPanel.add(attributes.getAttributePanel(), BorderLayout.WEST);
		mainPanel.add(information.getInformationPanel(), BorderLayout.NORTH);
		mainPanel.add(loadCharacterPanel.getCharPanel(), BorderLayout.EAST);
		
		
		
		
	    mainWindow.add(mainPanel, BorderLayout.CENTER);
	        
		mainWindow.setResizable(false);
		mainWindow.setVisible(true);
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
	public String[] getStatNum()
	{
		return attributes.getStatNum();
	}
	public void setStatNum(String[] statNum)
	{
		
	}
	public String[] getStatModNum()
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
}
