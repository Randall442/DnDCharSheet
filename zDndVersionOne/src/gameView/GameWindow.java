package gameView;

public class GameWindow 
{
	private StartWindow startWindow;
	private CharacterWindow charWindow;
	public GameWindow()
	{
		startWindow = new StartWindow();
		charWindow = new CharacterWindow();
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
