package gameView;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import gameModel.GameData;

public class GameWindow 
{
	private GameData gameData;
	private JFrame frame;
	private JPanel mainContent;
	private JPanel gameScreen;
	private JPanel textWindow;
	private JPanel controlWindow;
	private CardLayout cardLayout;
	
	public GameWindow(GameData gameData)
	{
		this.gameData = gameData;
		cardLayout = new CardLayout();
		
		initializeFrame();
		initializePanels();
	}
	
	private void initializeFrame()
	{
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setLayout(null);
		frame.setSize(800, 600);
	}
	
	private void initializePanels()
	{
		mainContent = new JPanel();
		mainContent.setLayout(null);
		frame.setContentPane(mainContent);
		
		gameScreen = new JPanel();
		gameScreen.setBounds(0,0,800,300);
		gameScreen.setLayout(cardLayout);
		gameScreen.setBackground(Color.red);
		
		textWindow = new JPanel();
		textWindow.setBackground(Color.blue);
		textWindow.setBounds(0,300,800,100);
		controlWindow = new JPanel();
		controlWindow.setBackground(Color.green);
		controlWindow.setBounds(0, 400, 900, 200);
		
		
		mainContent.add(gameScreen);
		mainContent.add(textWindow);
		mainContent.add(controlWindow);
	}
	
	public void showFrame()
	{
		frame.setVisible(true);
	}
	public void hideFrame() 
	{
		frame.setVisible(false);
	}
}
