package zDndVersionOne;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import build.BtnBuilder;

public class StartWindow implements ActionListener
{
	
	private WindowStateMachine stateMachine;
	private JPanel mainPanel;
	private JButton startBtn, optionBtn, exitBtn;
	
	StartWindow(WindowStateMachine stateMachine)
	{
		this.stateMachine = stateMachine;
		
		mainPanel = new JPanel();
		mainPanel.setLayout(null);
		
		startBtn = new BtnBuilder().btnHelper("Start", 225, 50, 100, 30, this);
		optionBtn = new BtnBuilder().btnHelper("Options", 225, 150, 100, 30, this);
		exitBtn = new BtnBuilder().btnHelper("Exit", 225, 250, 100, 30, this);
		
		mainPanel.add(startBtn);
		mainPanel.add(optionBtn);
		mainPanel.add(exitBtn);
		
	}
	
	
	
	public JPanel getMainPanel()
	{
		return mainPanel;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		Object source = e.getSource();
		
		if(source == startBtn)
		{
			stateMachine.showCreateWindow();
		} else if(source == optionBtn)
		{
			
		} else if(source == exitBtn)
		{
			System.exit(0);
		}
		
	}

}
