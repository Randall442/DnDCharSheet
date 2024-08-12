package zDndVersionOne;

import javax.swing.JFrame;

public class WindowStateMachine 
{
	private JFrame frame;
	private CharacterCreationWindow charCreateWindow;
	private StartWindow startWindow;
	WindowStateMachine()
	{
		
		frame = new JFrame();
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		
		startWindow = new StartWindow(this);
		charCreateWindow = new CharacterCreationWindow(this);
		
		showStartWindow();
		
		
	}
	public void showStartWindow()
	{
		frame.setSize(600,400);
		frame.setContentPane(startWindow.getMainPanel());
		frame.revalidate();
	}
	public void showCreateWindow()
	{
		frame.setSize(1200, 900);
		frame.setContentPane(charCreateWindow.getMainPanel());
		frame.revalidate();
	}
	public void start()
	{
		frame.setVisible(true);
	}

}
