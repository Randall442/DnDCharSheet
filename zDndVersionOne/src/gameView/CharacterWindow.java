package gameView;

import javax.swing.JButton;
import javax.swing.JFrame;

public class CharacterWindow 
{
	private JFrame frame;
	private JButton[] addStats;
	private JButton[] subStats;
	private String[] statNames= {"Str", "Dex", "Con", "Intel", "Wis", "Cha"};
	public CharacterWindow()
	{
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setSize(1200, 900);
		frame.setLayout(null);
	}
	
	private void initializeFrame()
	{
		
	}
	private void InitializeBtns()
	{
		
	}
	private void initializeLbls()
	{
		
	}
	private void initializeTextBox()
	{
		
	}
	private void initializeComboBox()
	{
		
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
