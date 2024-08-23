package gameController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import gameModel.GameData;
import gameView.GameWindow;

public class GameController implements ActionListener
{
	private GameData gameData;
	private GameWindow gameWindow;
	public GameController(GameData gameData, GameWindow gameWindow)
	{
		this.gameData = gameData;
		this.gameWindow = gameWindow;
		
		
		addListeners();
		
	}
	
	public void startGame()
	{
		gameWindow.getWindow().showFrame();
	}
	public void addListener(JButton button, ActionListener listener)
	{
		button.addActionListener(listener);
	}
	
	public void addListeners()
	{
		addListener(gameWindow.getWindow().getStartBtn(), this);
		addListener(gameWindow.getWindow().getLoadBtn(), this);
		addListener(gameWindow.getWindow().getOptionBtn(), this);
		addListener(gameWindow.getWindow().getExitBtn(), this);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(source == gameWindow.getWindow().getStartBtn())
		{
			gameWindow.getWindow().hideFrame();
			gameWindow.getCharWindow().showWindow();
		}
		else if(source == gameWindow.getWindow().getLoadBtn())
		{
			System.out.println("Load Game");
		}
		else if(source == gameWindow.getWindow().getOptionBtn())
		{
			System.out.println("Options");
		}
		else if(source == gameWindow.getWindow().getExitBtn())
		{
			System.out.println("Exit Game");
		}
		
	}
}
