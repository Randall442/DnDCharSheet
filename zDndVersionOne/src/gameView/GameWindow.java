package gameView;

import gameModel.GameData;

public class GameWindow 
{
	private StartWindow startWindow;
	private CharacterWindow charWindow;
	private GameData gameData;
	public GameWindow(GameData gameData)
	{
		this.gameData = gameData;
		startWindow = new StartWindow();
		charWindow = new CharacterWindow(gameData);
	}
	
	
	public StartWindow getWindow()
	{
		return startWindow;
	}
	public CharacterWindow getCharWindow()
	{
		return charWindow;
	}
	
}
