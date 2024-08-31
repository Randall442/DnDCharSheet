package gameView;

import gameModel.GameData;

public class GameView 
{
	private StartWindow startWindow;
	private CharacterWindow charWindow;
	private GameWindow game;
	private GameData gameData;
	
	public GameView(GameData gameData)
	{
		this.gameData = gameData;
		startWindow = new StartWindow();
		charWindow = new CharacterWindow(gameData);
		game = new GameWindow(gameData);
	}
	
	
	public StartWindow getWindow()
	{
		return startWindow;
	}
	public CharacterWindow getCharWindow()
	{
		return charWindow;
	}
	public GameWindow getGameWindow()
	{
		return game;
	}
}
