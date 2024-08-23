package gameView;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import guiBuilder.BuildBtn;

public class StartWindow
{
	private JFrame frame;
	private JButton startBtn;
	private JButton loadBtn;
	private JButton optionBtn;
	private JButton exitBtn;
	public StartWindow()
	{
		
		initializeFrame();
		initializeUI();
		
	}
	
	public void initializeFrame()
	{
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new FlowLayout());
		frame.setSize(150, 250);
	}
	
	public void initializeUI()
	{
		startBtn = BuildBtnHelper("Start Game", 50, 50, 60, 20);
		loadBtn = BuildBtnHelper("Load Game", 50, 50, 60, 20);
		optionBtn = BuildBtnHelper("Options", 50, 50, 60, 20);
		exitBtn = BuildBtnHelper("Exit", 50, 50, 60, 20);
		
		frame.add(startBtn);
		frame.add(loadBtn);
		frame.add(optionBtn);
		frame.add(exitBtn);
	}
	//set up buttons with listeners
	public void addStartListener(ActionListener listener)
	{
		startBtn.addActionListener(listener);
	}
	public JButton getStartBtn()
	{
		return startBtn;
	}
	public void addLoadListener(ActionListener listener)
	{
		loadBtn.addActionListener(listener);
	}
	public JButton getLoadBtn()
	{
		return loadBtn;
	}
	public void addOptionListener(ActionListener listener)
	{
		optionBtn.addActionListener(listener);
	}
	public JButton getOptionBtn()
	{
		return optionBtn;
	}
	public void addExitListener(ActionListener listener)
	{
		exitBtn.addActionListener(listener);
	}
	public JButton getExitBtn()
	{
		return exitBtn;
	}
	
	
	//show frame
	public void showFrame()
	{
		frame.setVisible(true);
	}
	
	public void hideFrame()
	{
		frame.setVisible(false);
	}
	
	private JButton BuildBtnHelper(String text, int x, int y, int width, int height)
	{
		JButton button = new BuildBtn().setText(text).setX(x).setY(y).setWidth(width).setHeight(height).buildBtn();
		return button;
	}
}
