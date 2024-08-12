package zDndVersionOne;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import build.BtnBuilder;

public class CharacterCreationWindow implements ActionListener
{
	private JPanel mainPanel, statPanel;
	private JButton backBtn;
	private WindowStateMachine stateMachine;
	
	CharacterCreationWindow(WindowStateMachine stateMachine)
	{
		this.stateMachine = stateMachine;
		
		mainPanel = new JPanel();
		mainPanel.setLayout(null);
		mainPanel.setSize(1200, 900);
		
		statPanel = new JPanel();
		statPanel.setBounds(0, 200, 300,650);
		statPanel.setLayout(new GridLayout(6,1));
		
		for(int i = 0; i < 6; i++)
		{
			JPanel rowPanel = new JPanel(new BorderLayout());
			JButton addButton = new BtnBuilder().setText("+").buildBtn();
			JButton subButton = new BtnBuilder().setText("-").buildBtn();
			JLabel numberLabel1 = new JLabel("Number " + (2 * i + 1), SwingConstants.CENTER);
			JLabel numberLabel2 = new JLabel("Number " + (2 * i + 1), SwingConstants.CENTER);
			
			JPanel numbersPanel = new JPanel(new GridLayout(2,1));
			numbersPanel.add(numberLabel1);
			numbersPanel.add(numberLabel2);
			
			rowPanel.add(addButton, BorderLayout.WEST);
			rowPanel.add(numbersPanel, BorderLayout.CENTER);
			rowPanel.add(subButton, BorderLayout.EAST);
			
			statPanel.add(rowPanel);
		}
		mainPanel.add(statPanel);
		backBtn = new BtnBuilder().btnHelper("Back", 550, 800, 100, 25, this);
		mainPanel.add(backBtn);
		
	}
	
	
	public JPanel getMainPanel()
	{
		return mainPanel;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(source == backBtn)
		{
			stateMachine.showStartWindow();
		}
		
	}
}
